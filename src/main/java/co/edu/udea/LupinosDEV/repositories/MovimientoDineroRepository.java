package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long>{
    @Query(value="select * from movimiento_dinero where empleado_id in (select id from Empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEnterprise(Long id);
}
