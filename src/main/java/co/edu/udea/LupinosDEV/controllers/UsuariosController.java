package co.edu.udea.LupinosDEV.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class UsuariosController {

    @GetMapping("/users")
    public void getUsuarios(){

    }

    @PostMapping("/users")
    public void postUsuarios(){

    }

    @GetMapping("/user/[id]")
    public void getUsuariosById(){

    }

    @PatchMapping("/user/[id]")
    public void patchUsuarios(){

    }

    @DeleteMapping("/user/[id]")
    public void deleteUsuarios(){

    }
}
