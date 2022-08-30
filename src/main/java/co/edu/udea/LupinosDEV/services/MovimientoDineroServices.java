package co.edu.udea.LupinosDEV.services;

import co.edu.udea.LupinosDEV.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoDineroServices {
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;
}
