package co.edu.udea.LupinosDEV.modelos;

public class Empresa {
    // Clase empresa
    private String nombre;
    private String telefono;
    private String NIT;
    private String direccion;

    public Empresa (String nombre, String telefono, String NIT, String direccion) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.NIT = NIT;
    this.direccion = direccion;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
