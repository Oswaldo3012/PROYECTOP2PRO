package modelo;

public class Contribuyente {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String tipoNegocio;

    public Contribuyente(String cedula, String nombres, String apellidos, String telefono, String tipoNegocio) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tipoNegocio = tipoNegocio;
    }

    public String getCedula() { return cedula; }
    public String getNombreCompleto() { return nombres + " " + apellidos; }

    @Override
    public String toString() {
        return "CI: " + cedula + " | " + nombres + " " + apellidos + " | Giro: " + tipoNegocio;
    }
}