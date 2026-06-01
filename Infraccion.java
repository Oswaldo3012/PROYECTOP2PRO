package modelo;

public class Infraccion {
    private int idInfraccion;
    private int numeroPuesto;
    private String descripcion; // Ej: Falta de higiene, Puesto cerrado sin permiso
    private String gravedad;    // Leve, Grave, Crítica
    private double multa;

    public Infraccion(int idInfraccion, int numeroPuesto, String descripcion, String gravedad, double multa) {
        this.idInfraccion = idInfraccion;
        this.numeroPuesto = numeroPuesto;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "ID: " + idInfraccion + " | Puesto: " + numeroPuesto + " | Gravedad: " + gravedad + " | Motivo: " + descripcion + " | Multa: $" + multa;
    }
}