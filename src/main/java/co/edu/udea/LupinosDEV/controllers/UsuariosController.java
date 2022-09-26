package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.entities.Empresa;
import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.repositories.UsuariosRepository;
import co.edu.udea.LupinosDEV.services.EmpresaServices;
import co.edu.udea.LupinosDEV.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;
    @Autowired
    EmpresaServices empresaServices;
    //muestra todos los empleados

    @GetMapping ("/")
    public String index(){
        return "index";
    }
    @GetMapping ("/users")
    public String viewEmpleados(Model model, @ModelAttribute("alert") String alert){
        List<Empleado> listaEmpleados=usuariosService.getAllUsers();
        model.addAttribute("listaDeEmpleados",listaEmpleados);
        model.addAttribute("alert",alert);
        return "listAllEmployees";
    }

    //añade un Empleado
    @GetMapping ("/addEmployee")
    public String addEmployee(Model model,@ModelAttribute("alert") String alert){
        Empleado empleado= new Empleado();
        model.addAttribute("newEmpleado",empleado);
        model.addAttribute("alert",alert);
        List<Empresa> listaEmpresas= empresaServices.getAllEnterprises();
        model.addAttribute("listEmpresas",listaEmpresas);
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Empleado empleado, RedirectAttributes redirectAttributes){
        String encryptPassword = passwordEncoder().encode(empleado.getPassword());
        empleado.setPassword(encryptPassword);
        if(usuariosService.saveOrUpdateEmployee(empleado)){
            redirectAttributes.addFlashAttribute("alert","saveOK");
            return "redirect:/users";
        }
        redirectAttributes.addFlashAttribute("alert","saveError");
        return "redirect:/users";
    }

    @GetMapping("/EditEmployee/{id}")
    public String editEmployee(Model model, @PathVariable Long id, @ModelAttribute("alert") String alert){
        Empleado employee=usuariosService.getEmpleadoById(id).get();
        model.addAttribute("empleado",employee);
        model.addAttribute("alert", alert);
        List<Empresa> EnterpriseList= empresaServices.getAllEnterprises();
        model.addAttribute("listEmpresas",EnterpriseList);
        return "editEmployee";
    }
    @PostMapping("/UpdateEmployee")
    public String updateEmployee(@ModelAttribute("empleado") Empleado empleado, RedirectAttributes redirectAttributes){
        Long id = empleado.getId();
        String oldPassword = usuariosService.getEmpleadoById(id).get().getPassword();

        if(!empleado.getPassword().equals(oldPassword)){
            String passwordEncrypt = passwordEncoder().encode(empleado.getPassword());
            empleado.setPassword(passwordEncrypt);
        }
        if(usuariosService.saveOrUpdateEmployee(empleado)){
            redirectAttributes.addFlashAttribute("alert","updateOK");
            return "redirect:/users";
        }
        redirectAttributes.addFlashAttribute("alert","updateError");
        return "redirect:/EditEmployee/"+empleado.getId();

    }

    //Controlador que me lleva al template de No autorizado
    @RequestMapping(value="/Denied")
    public String accessDenied(){
        return "accessDenied";
    }
    //Metodo para encriptar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
