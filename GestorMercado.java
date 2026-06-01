package negocio;

import java.util.ArrayList;
import modelo.Contribuyente;
import modelo.Puesto;
import modelo.Infraccion;

public class GestorMercado {
    private ArrayList<Contribuyente> listaContribuyentes;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Infraccion> listaInfracciones;
    private int contadorInfracciones;

    public GestorMercado() {
        this.listaContribuyentes = new ArrayList<>();
        this.listaPuestos = new ArrayList<>();
        this.listaInfracciones = new ArrayList<>();
        this.contadorInfracciones = 1;
        inicializarSectoresYPuestos();
    }

    // Configuración base de los sectores de las Ferias Libres
    private void inicializarSectoresYPuestos() {
        listaPuestos.add(new Puesto(101, "Sector Frutas"));
        listaPuestos.add(new Puesto(102, "Sector Frutas"));
        listaPuestos.add(new Puesto(201, "Sector Carnes"));
        listaPuestos.add(new Puesto(301, "Sector Abarrotes"));
    }

    // Métodos para Contribuyentes (Oswaldo)
    public void registrarContribuyente(Contribuyente c) {
        listaContribuyentes.add(c);
    }

    public Contribuyente buscarContribuyente(String cedula) {
        for (Contribuyente c : listaContribuyentes) {
            if (c.getCedula().equals(cedula)) return c;
        }
        return null;
    }

    // Métodos para Puestos y Sectores (Alexander)
    public Puesto buscarPuesto(int numero) {
        for (Puesto p : listaPuestos) {
            if (p.getNumeroPuesto() == numero) return p;
        }
        return null;
    }

    public boolean asignarPuesto(int numPuesto, String cedula) {
        Puesto p = buscarPuesto(numPuesto);
        Contribuyente c = buscarContribuyente(cedula);
        if (p != null && c != null && p.getEstado().equals("Disponible")) {
            p.asignarContribuyente(c);
            return true;
        }
        return false;
    }

    // Métodos para Infracciones (Emilio)
    public void registrarInfraccion(int numeroPuesto, String desc, String gravedad, double multa) {
        Infraccion nueva = new Infraccion(contadorInfracciones++, numeroPuesto, desc, gravedad, multa);
        listaInfracciones.add(nueva);
    }

    // Getters para las listas
    public ArrayList<Puesto> getListaPuestos() { return listaPuestos; }
    public ArrayList<Contribuyente> getListaContribuyentes() { return listaContribuyentes; }
    public ArrayList<Infraccion> getListaInfracciones() { return listaInfracciones; }
}