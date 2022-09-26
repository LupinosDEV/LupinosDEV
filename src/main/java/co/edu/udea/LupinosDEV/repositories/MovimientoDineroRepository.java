package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long>{
    //Traer todos los movimientos de una empresa por su id
    @Query(value="select * from movimiento_dinero where empresa_id=1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEnterprise(Long id);

    //Metodo para ver la suma de TODOS LOS MOVIMIENTOS
    @Query(value="SELECT SUM(monto_movimiento) from movimiento_dinero", nativeQuery = true)
    public abstract Long sumMovements();

    //Metodo que me trae el id de un usuario cuando tengo su correo
    @Query(value="select id from empleado where correo_empleado=?1", nativeQuery = true)
    public abstract Long IdEmail(String email);
}
