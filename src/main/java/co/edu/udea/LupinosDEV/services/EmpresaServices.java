package co.edu.udea.LupinosDEV.services;
import co.edu.udea.LupinosDEV.entities.Empresa;
import co.edu.udea.LupinosDEV.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServices {
    @Autowired
    private EmpresaRepository empresaRepository;

    //Se crea lista de empresas
    public List<Empresa> getAllEnterprises(){
        List<Empresa> enterpricesList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> enterpricesList.add(empresa));
        return enterpricesList;
    }
    //Trae una empresa
    public Empresa getEmpresaById(Long id){
        return empresaRepository.findById(id).get();
    }

    //Crear y editar empresa
    public boolean createOrEditEnterprise(Empresa empresa){
        Empresa empresaNueva = empresaRepository.save(empresa);
        if (empresaRepository.findById(empresaNueva.getId())!=null){
            return true;
        }
        return false;
    }
    //Eliminar empresa
    public void deleteEnterpriseById(Long id){
        empresaRepository.deleteById(id);
    }

}