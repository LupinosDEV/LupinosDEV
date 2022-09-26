package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuariosRepository extends JpaRepository<Empleado, Long> {
    @Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)
    public abstract ArrayList<Empleado> findByEnterprise(Long id);
}