package co.edu.udea.LupinosDEV.repositories;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Long>{
}
