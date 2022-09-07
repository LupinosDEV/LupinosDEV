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
        //Encuentra todos los movimientoDinero en la base de datos itera y la agrega a una lista
        movimientoDineroRepository.findAll().forEach(transaction -> transactionList.add(transaction));
        return transactionList;
    }
    public MovimientoDinero getTransactionById(Long id){
        return movimientoDineroRepository.findById(id).get();
    }
    public MovimientoDinero createOrEditTransaction(MovimientoDinero transaction){
        return movimientoDineroRepository.save(transaction);
    }
    public void deleteTransactionById(Long id){
        movimientoDineroRepository.deleteById(id);
    }

}
