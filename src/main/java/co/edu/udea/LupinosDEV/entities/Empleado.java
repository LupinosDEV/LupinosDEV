package co.edu.udea.LupinosDEV.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//individual para cada entidad
    @Column(name = "nombreEmpleado", nullable = false, length = 50)
    private String nombreEmpleado;
    @Column(name = "correoEmpleado", nullable = false, length = 50)
    private String correoEmpleado;
    @OneToOne
    @JoinColumn(name="profile_id")
    private Profile profile;//id de la entidad Profile

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;//id de la entidad Empresa
    private  ArrayList<MovimientoDinero> movimientoDinero;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createdAt;
    private String rol;
    private String password;
    private Boolean condition;
    //Constructor
    public Empleado(){};

    public Empleado(String nombreEmpleado, String correoEmpleado, Profile profile, Empresa empresa, ArrayList<MovimientoDinero> movimientoDinero, Date updatedAt, Date createdAt, String rol, String password, Boolean condition) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.profile = profile;
        this.empresa = empresa;
        this.movimientoDinero = movimientoDinero;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.rol = rol;
        this.password = password;
        this.condition = condition;
    }

    //getters y setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<MovimientoDinero> getMovimientoDinero() {
        return movimientoDinero;
    }

    public void setMovimientoDinero(ArrayList<MovimientoDinero> movimientoDinero) {
        this.movimientoDinero = movimientoDinero;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }
}