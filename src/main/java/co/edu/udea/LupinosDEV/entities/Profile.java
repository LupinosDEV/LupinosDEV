package co.edu.udea.LupinosDEV.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Profile")

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fotografia", nullable = false, length = 50)

    private String fotografia;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @Column(name = "createdAt", nullable = false, length = 50)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 50)
    private Date updatedAt;

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Profile (){};
    public Profile(Long id, String fotografia, String telefono, Empleado empleado, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fotografia = fotografia;
        this.telefono = telefono;
        this.empleado = empleado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setUsuario(Empleado empleado) {
        this.empleado = empleado;
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
