package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.entities.Empresa;
import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class EmpresaController {

    @Autowired
    EmpresaServices empresaServices;

    //listá todos los empresas
    @GetMapping("/enterprises")
    public String getAllEnterprises(Model model) {
        List<Empresa> enterprisesList = empresaServices.getAllEnterprises();
        model.addAttribute("enterprisesList", enterprisesList);
        return "listAllEnterprises";
    }

    //listá las empresas por id
    @GetMapping("/enterprises/{id}")
    public String getEnterpriseById(Model model, @PathVariable Long id) {
        Empresa enterpriseById = empresaServices.getEnterpriseById(id);
        model.addAttribute("enterpriseById", enterpriseById);
        return "enterpriseById";
    }

    //añade una empresa
    @GetMapping("/addEnterprise")
    public String addEnterprise(Model model, @ModelAttribute("alert") String alert) {
        Empresa enterprise = new Empresa();
        model.addAttribute("newEnterprise", enterprise);
        model.addAttribute("alert", alert);
        return "newEnterprise";
    }

    @PostMapping("/saveEnterprise")
    public String saveEnterprise(Empresa enterprise, RedirectAttributes redirectAttributes) {
        if (empresaServices.createOrEditEnterprise(enterprise)) {
            redirectAttributes.addFlashAttribute("alert", "saveOK");
            return "redirect:/enterprises";
        }
        redirectAttributes.addFlashAttribute("alert", "saveError");
        return "redirect:/addEnterprise";
    }

    //Elimina una empresa
    @DeleteMapping("/deleteEnterprises/[id]")
    public String deleteEnterprise(Model model, @PathVariable Long idEmpresa, RedirectAttributes redirectAttributes) {
        if (empresaServices.deleteEnterpriseById(idEmpresa)){
            redirectAttributes.addFlashAttribute("alert","deleteOK");
            return "redirect:/listAllEnterprises";
        }
        redirectAttributes.addFlashAttribute("alert", "deleteError");
        return "redirect:/listAllEnterprises";
    }

}