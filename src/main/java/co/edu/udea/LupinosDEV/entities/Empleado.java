package co.edu.udea.LupinosDEV.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombreEmpleado;
    private String correoEmpleado;
    @OneToOne
    @JoinColumn(name="usuario_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    @OneToMany
    @JoinColumn(name = "rol_id")
    private Enum_RoleName rolEmpleado;

    @OneToMany(mappedBy = "Empleado")
    private  ArrayList<MovimientoDinero> movimiento;

    private Date updatedAt;
    private Date createdAt;
    //Constructor
    public Empleado(long id, String nombreEmpleado, String correoEmpleado, Empresa empresa, Enum_RoleName rolEmpleado,
                    Profile profile, ArrayList<MovimientoDinero> movimiento, Date updatedAt, Date createdAt){

        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresa = empresa;
        this.rolEmpleado = rolEmpleado;

        this.id = id;
        this.profile = profile;
        this.movimiento = movimiento;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;


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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Enum_RoleName getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_RoleName rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public Profile getProfile(){return profile;}
    public void setProfile(Profile profile){this.profile=profile;}

    public ArrayList<MovimientoDinero> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(ArrayList<MovimientoDinero> movimiento) {
        this.movimiento = movimiento;
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
        this.createdAt = createdAt;}

}