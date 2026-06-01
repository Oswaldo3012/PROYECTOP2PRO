package interfaz;

import java.util.Scanner;
import modelo.Contribuyente;
import modelo.Puesto;
import modelo.Infraccion;
import negocio.GestorMercado;

public class MenuConsola {

    public static void main(String[] args) {
        GestorMercado gestor = new GestorMercado();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=======================================================");
            System.out.println("  SISTEMA MUNICIPAL \"FERIAS LIBRES\" - MODO CONSOLA   ");
            System.out.println("=======================================================");
            System.out.println("1. [Módulo Contribuyentes] Registrar Comerciante");
            System.out.println("2. [Módulo Sectores] Visualizar Estado de Puestos");
            System.out.println("3. [Módulo Asignación] Asignar Puesto a Comerciante");
            System.out.println("4. [Módulo Infracciones] Registrar Infracción Sanitaria");
            System.out.println("5. [Módulo Reportes] Ver Historial de Infracciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- NUEVO CONTRIBUYENTE ---");
                    System.out.print("Cédula: ");
                    String ced = sc.nextLine();
                    if (gestor.buscarContribuyente(ced) != null) {
                        System.out.println("Esta cédula ya se encuentra registrada.");
                        break;
                    }
                    System.out.print("Nombres: ");
                    String nom = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String ape = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();
                    System.out.print("Giro del Negocio (Frutas/Carnes/Abarrotes): ");
                    String giro = sc.nextLine();

                    gestor.registrarContribuyente(new Contribuyente(ced, nom, ape, tel, giro));
                    System.out.println("Contribuyente guardado con éxito.");
                    break;

                case 2:
                    System.out.println("\n--- MAPA DE PUESTOS Y SECTORES ---");
                    for (Puesto p : gestor.getListaPuestos()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("\n--- ASIGNACIÓN DE PUESTOS ---");
                    System.out.print("Número de Puesto: ");
                    int numP = Integer.parseInt(sc.nextLine());
                    System.out.print("Cédula del Contribuyente: ");
                    String cedC = sc.nextLine();

                    if (gestor.asignarPuesto(numP, cedC)) {
                        System.out.println("Asignación completada correctamente.");
                    } else {
                        System.out.println("No se pudo asignar. Valide que el puesto exista/esté disponible y el usuario esté registrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REGISTRO DE INFRACCIONES / HIGIENE ---");
                    System.out.print("Número de Puesto infractor: ");
                    int pInfractor = Integer.parseInt(sc.nextLine());
                    if(gestor.buscarPuesto(pInfractor) == null) {
                        System.out.println("El puesto ingresado no existe.");
                        break;
                    }
                    System.out.print("Descripción de la falta (ej. Falta de limpieza): ");
                    String desc = sc.nextLine();
                    System.out.print("Gravedad (Leve / Grave / Crítica): ");
                    String grav = sc.nextLine();
                    System.out.print("Monto de la Multa ($): ");
                    double multa = Double.parseDouble(sc.nextLine());

                    gestor.registrarInfraccion(pInfractor, desc, grav, multa);
                    System.out.println("Infracción registrada en el sistema.");
                    break;

                case 5:
                    System.out.println("\n--- REPORTE GENERAL DE INFRACCIONES ---");
                    if (gestor.getListaInfracciones().isEmpty()) {
                        System.out.println("No se registran infracciones en este mercado.");
                    } else {
                        for (Infraccion i : gestor.getListaInfracciones()) {
                            System.out.println(i);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Cerrando la aplicación de control de Mercados. ¡Éxito en tu entrega!");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 6);
        sc.close();
    }
}