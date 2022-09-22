package co.edu.udea.LupinosDEV.entities;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    public Empresa(){}

    public Empresa(Long id, String nombre, String direccion, String NIT, String telefono, List<Empleado> usuario, List<MovimientoDinero> movimiento, Date createdAt, Date updatedAt) {
        this.idEmpresa = id;
        this.nombreEmpresa = nombre;
        this.NIT = NIT;
        this.telefonoEmpresa = telefono;
        this.direccionEmpresa = direccion;
        this.usuario = usuario;
        this.movimiento = movimiento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return idEmpresa;
    }

    public void setId(Long id) {
        this.idEmpresa = id;
    }

    public String getNombre() {
        return nombreEmpresa;
    }

    public void setNombre(String nombre) {
        this.nombreEmpresa = nombre;
    }

    public String getTelefono() {
        return telefonoEmpresa;
    }

    public void setTelefono(String telefono) {
        this.telefonoEmpresa = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccionEmpresa;
    }

    public void setDireccion(String direccion) {
        this.direccionEmpresa = direccion;
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
