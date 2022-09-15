package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Empleado, Long> {
}