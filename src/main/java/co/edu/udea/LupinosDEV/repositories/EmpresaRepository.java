package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Long> {
}
