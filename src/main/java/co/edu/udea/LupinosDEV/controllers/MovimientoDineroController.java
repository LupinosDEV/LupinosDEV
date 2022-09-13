package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.services.MovimientoDineroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroServices movimientoDineroServices;

    @GetMapping("/movements")
    public String getAllTransactions(Model model){
        List<MovimientoDinero> transactionList = movimientoDineroServices.getAllTransactions();
        model.addAttribute("transactionsList",transactionList);
        return "listAllTransactions";
    }
    @GetMapping("/movements/{id}")
    public String getTransactionById(Model model, @PathVariable Long id){
        MovimientoDinero transactionById = movimientoDineroServices.getTransactionById(id);
        model.addAttribute("transactionById",transactionById);
        return "transactionById";
    }
    @GetMapping("/enterprises/{id}/movements")
    public String transactionsByEnterprise(@PathVariable("id")Long id, Model model){
        List<MovimientoDinero> transactionList = movimientoDineroServices.getAllTransactionsEnterprise(id);
        model.addAttribute("transactionsList",transactionList);
        return "transactionListByEnterprise";
    }

    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero postTransactionEnterprise(@RequestBody MovimientoDinero transaction){
        return movimientoDineroServices.createOrEditTransaction(transaction);
    }
    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero patchTransactionEnterprise(@PathVariable("id")Long id,@RequestBody MovimientoDinero transaction){
        MovimientoDinero movement = movimientoDineroServices.getTransactionById(id);
        movement.setMontoMovimiento(transaction.getMontoMovimiento());
        movement.setConceptoMovimiento(transaction.getConceptoMovimiento());
        movement.setEmpleado(transaction.getEmpleado());
        movement.setEmpresa(transaction.getEmpresa());
        movement.setCreateAt(transaction.getCreateAt());
        movement.setUptadeAt(transaction.getUptadeAt());
        return movimientoDineroServices.createOrEditTransaction(movement);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    public void deleteTransactionEnterprise(@PathVariable("id") Long id){
        movimientoDineroServices.deleteTransactionById(id);
    }
}
