package co.edu.udea.LupinosDEV.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimientoDinero")
public class MovimientoDinero {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "montoMovimiento", nullable = false)
    private long montoMovimiento;
    @Column(name = "conceptoMovimiento", nullable = false, length = 50)
    private String conceptoMovimiento;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date uptadeAt;
    //Constructor
    public MovimientoDinero(){}

    public MovimientoDinero(long montoMovimiento, String conceptoMovimiento, Empleado empleado, Empresa empresa, Date createAt, Date uptadeAt) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleado = empleado;
        this.empresa = empresa;
        this.createAt = createAt;
        this.uptadeAt = uptadeAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(long montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUptadeAt() {
        return uptadeAt;
    }

    public void setUptadeAt(Date uptadeAt) {
        this.uptadeAt = uptadeAt;
    }
}
