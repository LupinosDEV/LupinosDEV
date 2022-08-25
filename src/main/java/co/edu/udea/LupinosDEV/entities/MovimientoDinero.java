package co.edu.udea.LupinosDEV.entities;

public class MovimientoDinero {
    //Atributos
    private long montoMovimiento;
    private String conceptoMovimiento;
    private Empleado empleado;

    //Constructor
    public MovimientoDinero(long montoMovimiento, String conceptoMovimiento, Empleado empleado) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleado = empleado;
    }
    //Getters y setters
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
}
