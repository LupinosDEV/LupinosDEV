package co.edu.udea.LupinosDEV.services;
import co.edu.udea.LupinosDEV.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServices {
    @Autowired
    private EmpresaRepository empresaRepository;
}