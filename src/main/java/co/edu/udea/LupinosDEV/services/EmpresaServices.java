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
        List<Empresa> enterprisesList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> enterprisesList.add(empresa));
        return enterprisesList;
    }
    //Trae una empresa
    public Empresa getEnterpriseById(Long id){
        return empresaRepository.findById(id).get();
    }

    //Crear y editar empresa
    public boolean createOrEditEnterprise(Empresa empresa){
        Empresa empresaNueva = empresaRepository.save(empresa);
        if (empresaRepository.findById(empresaNueva.getIdEmpresa())!=null){
            return true;
        }
        return false;
    }
    //Eliminar empresa
    public boolean deleteEnterpriseById(Long id){
        empresaRepository.deleteById(id);
        if(empresaRepository.findById(id).isPresent()){
            return false;
        }
        return true;
    }

}