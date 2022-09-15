package co.edu.udea.LupinosDEV.services;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;

    public List<Empleado> getAllUsers(){
        List<Empleado> employeesList = new ArrayList<>();
        usuariosRepository.findAll().forEach(employee -> employeesList.add(employee));
        return employeesList;
    }
}
