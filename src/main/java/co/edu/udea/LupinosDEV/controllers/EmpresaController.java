package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.Empresa;
import co.edu.udea.LupinosDEV.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpresaController {
    @Autowired
    EmpresaServices empresaServices;

    @GetMapping("/enterprises/{id}/movements")
    public void getEmpresa() {
        //logica
    }

    @PostMapping("/enterprises/{id}/movements")
    public void postEmpresa(@RequestBody Empresa empresa){
        //logica
    }

    @PatchMapping("/enterprises/{id}/movements")
    public void patchEmpresa(@PathVariable("id") Integer id, Empresa empres){
        //logica
    }

    @DeleteMapping ("/enterprises/{id}/movements")
    public void deleteEmpresa(@PathVariable("id") Integer id){
        //logica
    }
}
