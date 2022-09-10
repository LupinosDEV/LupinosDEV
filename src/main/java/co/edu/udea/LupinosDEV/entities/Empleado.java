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
    @JoinColumn(name="profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    private  ArrayList<MovimientoDinero> movimientoDinero;

    private Date updatedAt;
    private Date createdAt;
    //Constructor
    public Empleado(){};
    public Empleado(long id, String nombreEmpleado, String correoEmpleado, Empresa empresa,
                    Profile profile, ArrayList<MovimientoDinero> movimientoDinero, Date updatedAt, Date createdAt){

        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresa = empresa;

        this.id = id;
        this.profile = profile;
        this.movimientoDinero = movimientoDinero;
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


    public long getId(){return id;}
    public void setId(long id){this.id=id;}

    public Profile getProfile(){return profile;}
    public void setProfile(Profile profile){this.profile=profile;}

    public ArrayList<MovimientoDinero> getMovimiento() {
        return movimientoDinero;
    }

    public void setMovimiento(ArrayList<MovimientoDinero> movimiento) {
        this.movimientoDinero = movimiento;
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