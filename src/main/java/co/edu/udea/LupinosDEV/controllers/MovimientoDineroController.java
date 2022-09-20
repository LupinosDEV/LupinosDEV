package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.repositories.MovimientoDineroRepository;
import co.edu.udea.LupinosDEV.services.MovimientoDineroServices;
import co.edu.udea.LupinosDEV.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroServices movimientoDineroServices;
    @Autowired
    UsuariosService usuariosService;
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }

    //listá todos los movimientos
    @GetMapping("/movements")
    public String getAllTransactions(@RequestParam(value="page", required=false, defaultValue = "1") int pageNumber,
                                     @RequestParam(value="size", required=false, defaultValue = "7") int size,
                                     Model model,
                                     @ModelAttribute("alert") String alert){

        Page<MovimientoDinero> paginaMovimientos= movimientoDineroRepository.findAll(PageRequest.of(pageNumber,size));

        model.addAttribute("ListMovements",paginaMovimientos.getContent());
        model.addAttribute("allPages",new int[paginaMovimientos.getTotalPages()]);
        model.addAttribute("actualPage", pageNumber);
        model.addAttribute("alert",alert);
        Long sumMovements=movimientoDineroServices.sumAllMovements();
        model.addAttribute("sumAllMovements",sumMovements);
        return "listAllTransactions";
    }
    //listá los movimientos por id
    @GetMapping("/movements/{id}")
    public String getTransactionById(Model model, @PathVariable Long id){
        MovimientoDinero transactionById = movimientoDineroServices.getTransactionById(id);
        model.addAttribute("transactionById",transactionById);
        return "transactionById";
    }
    //listá los movimientos por empresa
    @GetMapping("/enterprises/{id}/movements")
    public String transactionsByEnterprise(@PathVariable("id")Long id, Model model){
        List<MovimientoDinero> transactionList = movimientoDineroServices.getAllTransactionsEnterprise(id);
        model.addAttribute("transactionsList",transactionList);
        return "transactionListByEnterprise";
    }
    //añade una transacción
    @GetMapping ("/addTransaction")
    public String addTransaction(Model model,@ModelAttribute("alert") String alert){
        MovimientoDinero transaction= new MovimientoDinero();
        model.addAttribute("newTransaction",transaction);
        model.addAttribute("alert",alert);
        List<Empleado> employeeList= usuariosService.getAllUsers();
        model.addAttribute("employeeslist",employeeList);
        return "newTransactions";
    }
    @PostMapping("/saveTransaction")
    public String saveTransaction(MovimientoDinero transaction, RedirectAttributes redirectAttributes){
        if(movimientoDineroServices.createOrEditTransaction(transaction)){
            redirectAttributes.addFlashAttribute("alert","saveOK");
            return "redirect:/movements";
        }
        redirectAttributes.addFlashAttribute("alert","saveError");
        return "redirect:/addTransaction";
    }
    //edita un movimiento
    //eliminar un movimiento
}
