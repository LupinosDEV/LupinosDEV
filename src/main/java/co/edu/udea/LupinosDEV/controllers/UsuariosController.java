package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.entities.Empresa;
import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.repositories.UsuariosRepository;
import co.edu.udea.LupinosDEV.services.EmpresaServices;
import co.edu.udea.LupinosDEV.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;
    @Autowired
    EmpresaServices empresaServices;
    //muestra todos los empleados
    @GetMapping ("/users")
    public String viewEmpleados(Model model, @ModelAttribute("alert") String alert){
        List<Empleado> listaEmpleados=usuariosService.getAllUsers();
        model.addAttribute("listaDeEmpleados",listaEmpleados);
        model.addAttribute("alert",alert);
        return "listAllEmployees";
    }

    //añade un Empleado
    @GetMapping ("/addEmployee")
    public String addEmployee(Model model,@ModelAttribute("alert") String alert){
        Empleado empleado= new Empleado();
        model.addAttribute("newEmpleado",empleado);
        model.addAttribute("alert",alert);
        List<Empresa> listaEmpresas= empresaServices.getAllEnterprises();
        model.addAttribute("listEmpresas",listaEmpresas);
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Empleado empleado, RedirectAttributes redirectAttributes){
        if(usuariosService.saveOrUpdateEmployee(empleado)){
            redirectAttributes.addFlashAttribute("alert","saveOK");
            return "redirect:/users";
        }
        redirectAttributes.addFlashAttribute("alert","saveError");
        return "redirect:/users";
    }
}
