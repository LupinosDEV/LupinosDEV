package co.edu.udea.LupinosDEV.security;

import co.edu.udea.LupinosDEV.handler.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    SuccessHandler successHandler;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select correo_empleado,password,condition from empleado where correo_empleado=?")
                .authoritiesByUsernameQuery("select correo_empleado, rol from empleado where correo_empleado=?");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/EditMovement/**","/DeleteMovement/**","/EditEmployee/**","/addEmployee","/addEnterprise").hasRole("ADMIN")

                .and().formLogin().successHandler(successHandler)
                .and().exceptionHandling().accessDeniedPage("/Denied")
                .and().logout().permitAll();
    }
}
