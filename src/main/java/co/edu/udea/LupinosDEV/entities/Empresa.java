package co.edu.udea.LupinosDEV.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
//test
@Entity
@Table(name = "empresa")
public class Empresa {
    // Clase empresa
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;
    @Column(name = "telefono", length = 15)
    private String telefono;
    @Column(name = "NIT", nullable = false, unique = true, length = 15)
    private String NIT;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Empleado> usuario= new ArrayList<>();
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<MovimientoDinero> movimiento = new ArrayList<>();

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    public Empresa(){

    }

    @Autowired
    public Empresa(Long id, String nombre, String direccion, String NIT, String telefono, String , List<Empleado> usuario, List<MovimientoDinero> movimiento, Date createdAt, Date updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.NIT = NIT;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.movimiento = movimiento;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", NIT='" + NIT + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario=" + usuario +
                ", movimiento=" + movimiento +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
