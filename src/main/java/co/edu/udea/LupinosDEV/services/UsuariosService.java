package co.edu.udea.LupinosDEV.services;

import co.edu.udea.LupinosDEV.entities.Empleado;
import co.edu.udea.LupinosDEV.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    UsuariosRepository usuariosRepository;
    //Metodo para ver todos los empleados registrados
    public List<Empleado> getAllUsers(){
        List<Empleado> employeesList = new ArrayList<>();
        usuariosRepository.findAll().forEach(employee -> employeesList.add(employee));
        return employeesList;
    }
    //Metodo para buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Long id){
        return usuariosRepository.findById(id);
    }
    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> getByEnterprise(Long id){
        return usuariosRepository.findByEnterprise(id);
    }

    //Metodo para guardar o actualizar Empleados
    public boolean saveOrUpdateEmployee(Empleado employee){
        Empleado empleado=usuariosRepository.save(employee);
        if (usuariosRepository.findById(empleado.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar un Empleado por Id
    public boolean deleteEmployeeById(Long id){
        usuariosRepository.deleteById(id);
        if(usuariosRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }
}
