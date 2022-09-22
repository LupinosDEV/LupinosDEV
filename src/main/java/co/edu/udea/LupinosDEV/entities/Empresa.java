package co.edu.udea.LupinosDEV.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
//test
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa", nullable = false, unique = true)
    private Long idEmpresa;
    @Column(name = "nombreEmpresa", nullable = false, unique = true, length = 50)
    private String nombreEmpresa;
    @Column(name = "telefonoEmpresa", length = 15)
    private String telefonoEmpresa;
    @Column(name = "NIT", nullable = false, unique = true, length = 15)
    private String NIT;

    @Column(name = "direccionEmpresa", nullable = false, length = 50)
    private String direccionEmpresa;

    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<Empleado> usuario= new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<MovimientoDinero> movimiento = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updatedAt;

    public Empresa(){}

    public Empresa(String nombreEmpresa, String telefonoEmpresa, String NIT, String direccionEmpresa, List<Empleado> usuario, List<MovimientoDinero> movimiento, Date createdAt, Date updatedAt) {
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.NIT = NIT;
        this.direccionEmpresa = direccionEmpresa;
        this.usuario = usuario;
        this.movimiento = movimiento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public List<Empleado> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Empleado> usuario) {
        this.usuario = usuario;
    }

    public List<MovimientoDinero> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(List<MovimientoDinero> movimiento) {
        this.movimiento = movimiento;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
