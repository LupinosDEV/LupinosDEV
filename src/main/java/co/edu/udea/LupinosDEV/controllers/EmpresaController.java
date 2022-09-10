package co.edu.udea.LupinosDEV.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {

    @GetMapping("/users")
    public void getEmpresa(){

    }

    @PostMapping("/users")
    public void postEmpresa(){

    }

    @GetMapping("/user/[id]")
    public void getEmpresaById(){

    }

    @PatchMapping("/user/[id]")
    public void patchEmpresa(){

    }

    @DeleteMapping("/user/[id]")
    public void deleteEmpresa(){

    }
}