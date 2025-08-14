import java.util.Scanner;

public class Orfanato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear inventario
        System.out.print("Ingrese el nombre del producto: ");
        String nombreInventario = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidadInventario = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Inventario inventario = new Inventario(nombreInventario, cantidadInventario);

        // Crear habitación
        System.out.print("Ingrese el número de cuarto: ");
        int numCuarto = scanner.nextInt();
        System.out.print("Ingrese número de personas en la habitación: ");
        int personasHabitacion = scanner.nextInt();
        System.out.print("Ingrese número de camas: ");
        int camas = scanner.nextInt();
        scanner.nextLine();

        Habitaciones habitacion = new Habitaciones(numCuarto, personasHabitacion, camas);

        // Crear edificio
        System.out.print("Ingrese nombre del orfanato: ");
        String nombreOrfanato = scanner.nextLine();
        System.out.print("Ingrese ubicación del orfanato: ");
        String ubicacionOrfanato = scanner.nextLine();
        System.out.print("Ingrese número de niños: ");
        int numeroNinos = scanner.nextInt();
        scanner.nextLine();

        Edificio edificio = new Edificio(nombreOrfanato, ubicacionOrfanato, numeroNinos);

        //ARREGLO DE OBJETOS
        Ninios[] listaNinios = new Ninios[numeroNinos];
        for (int i = 0; i < numeroNinos; i++) {
            System.out.println("\n--- Datos del niño " + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombreN = scanner.nextLine();
            System.out.print("Edad: ");
            int edadN = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nacionalidad: ");
            String nacionalidadN = scanner.nextLine();

            listaNinios[i] = new Ninios(nombreN, edadN, nacionalidadN);
        }

        int opcion;
        do {
            System.out.println("\n Menu del orfanato");
            System.out.println("1. Ver existencia de inventario");
            System.out.println("2. Ver donaciones");
            System.out.println("3. Ver camas en la habitación");
            System.out.println("4. Ver personas en la habitación");
            System.out.println("5. Ver datos del edificio");
            System.out.println("6. Ver número de niños");
            System.out.println("7. Terminar");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    inventario.existencia();
                    break;
                case 2:
                    inventario.donaciones();
                    break;
                case 3:
                    habitacion.getCamas();
                    break;
                case 4:
                    habitacion.getPersonasHabitacion();
                    break;
                case 5:
                    edificio.verDatos();
                    break;
                case 6:
                    edificio.getNumeroNinos();
                    break;
                case 7:
                    System.out.println("Gracias por apollar al orfanato");
                    break;
                default:
                    System.out.println("Valor no reconocido");
            }

        } while (opcion != 7);

        scanner.close();
    }
}

