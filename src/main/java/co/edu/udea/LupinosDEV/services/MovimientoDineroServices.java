package co.edu.udea.LupinosDEV.services;

import co.edu.udea.LupinosDEV.entities.MovimientoDinero;
import co.edu.udea.LupinosDEV.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroServices {
    @Autowired
    private MovimientoDineroRepository movimientoDineroRepository;

    public List<MovimientoDinero> getAllTransactions(){
        List<MovimientoDinero> transactionList = new ArrayList<>();
        movimientoDineroRepository.findAll().forEach(transaction -> transactionList.add(transaction));
        return transactionList;
    }
    public MovimientoDinero getTransactionById(Long id){
        return movimientoDineroRepository.findById(id).get();
    }
    public boolean createOrEditTransaction(MovimientoDinero transaction){
        MovimientoDinero movement = movimientoDineroRepository.save(transaction);
        if (movimientoDineroRepository.findById(movement.getId())!=null){
            return true;
        }
        return false;
    }
    public boolean deleteTransactionById(Long id){
        movimientoDineroRepository.deleteById(id);
        if(movimientoDineroRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> getAllTransactionsEnterprise(Long id){
        return movimientoDineroRepository.findByEnterprise(id);
    }

    public Long sumAllMovements(){
        return movimientoDineroRepository.sumMovements();
    }

}
