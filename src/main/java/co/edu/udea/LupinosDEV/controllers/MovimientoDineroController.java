package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.services.MovimientoDineroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroServices movimientoDineroServices;

    @GetMapping()
    public void getMovimientoDinero(){
        //logica
    }

    @PostMapping("/enterprises/{id}/movements")
    public void postMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        //logica
    }

    @PatchMapping("/enterprises/{id}/movements")
    public void patchMovimientoDinero(@PathVariable("id") Integer id, MovimientoDinero movimientoDinero){
        //logica
    }

    @DeleteMapping ("/enterprises/{id}/movements")
    public void deleteMovimientoDinero(@PathVariable("id") Integer id){
        //logica
    }
}
