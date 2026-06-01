package modelo;

public class Puesto {
    private int numeroPuesto;
    private String sector; // Ej: Frutas, Carnes, etc.
    private String estado; // Disponible, Ocupado, Mantenimiento
    private Contribuyente contribuyenteAsignado;

    public Puesto(int numeroPuesto, String sector) {
        this.numeroPuesto = numeroPuesto;
        this.sector = sector;
        this.estado = "Disponible";
        this.contribuyenteAsignado = null;
    }

    public int getNumeroPuesto() { return numeroPuesto; }
    public String getEstado() { return estado; }

    public void asignarContribuyente(Contribuyente c) {
        this.contribuyenteAsignado = c;
        this.estado = "Ocupado";
    }

    @Override
    public String toString() {
        String infoC = (contribuyenteAsignado != null) ? contribuyenteAsignado.getNombreCompleto() : "Ninguno";
        return "Puesto N°: " + numeroPuesto + " (" + sector + ") | Estado: " + estado + " | Asignado a: " + infoC;
    }
}