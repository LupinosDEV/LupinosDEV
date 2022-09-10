package co.edu.udea.LupinosDEV.controllers;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.services.MovimientoDineroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroServices movimientoDineroServices;


    @GetMapping("/movements")
    public List<MovimientoDinero> getAllTransactions(){
        return movimientoDineroServices.getAllTransactions();
    }
    @GetMapping("/movements/{id}")
    public MovimientoDinero getTransactionById(@PathVariable("id") Long id){
        return movimientoDineroServices.getTransactionById(id);
    }
    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> getTransactionsByEnterprise(@PathVariable("id") Long id){
        return movimientoDineroServices.getAllTransactionsEnterprise(id);
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
