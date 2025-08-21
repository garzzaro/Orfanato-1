import java.util.Scanner;

public class Personas {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


        System.out.print("Ingrese el nombre del niño: ");
        String nombreNino = scanner.nextLine();
        System.out.print("Ingrese la edad del niño: ");
        int edadNino = scanner.nextInt();
        scanner.nextLine(); 

    Ninios nino = new Ninios(nombreNino, edadNino);

    System.out.print("Ingrese el nombre del trabajador: ");
    String nombreTrabajador = scanner.nextLine();
    System.out.print("Ingrese la edad del trabajador: ");
    int edadTrabajador = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Ingrese el puesto del trabajador: ");
    String puestoTrabajador = scanner.nextLine();
    System.out.print("Ingrese el salario del trabajador: ");
    float salarioTrabajador = scanner.nextFloat();
    scanner.nextLine();

    Trabajadores trabajador = new Trabajadores(nombreTrabajador, puestoTrabajador, salarioTrabajador, edadTrabajador);


        int opcion;
        do {
            System.out.println("\n Elige una opción: ");
            System.out.println("1. Ver ubicación del niño");
            System.out.println("2. Niño camina rápido");
            System.out.println("3. Niño camina lento");
            System.out.println("4. Ver información del trabajador");
            System.out.println("5. Ver salario del trabajador");
            System.out.println("6. Terminar");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    nino.verUbicacion();
                    break;
                case 2:
                    nino.caminarrapido();
                    break;
                case 3:
                    nino.caminarlento();
                    break;
                case 4:
                    trabajador.verInfo();
                    break;
                case 5:
                    trabajador.verSalario();
                    break;
                case 6:
                    System.out.println("Gracias por apollar al orfanato");
                    break;
                default:
                    System.out.println("Valor no reconocido");
            }

        } while (opcion != 6);
        }
    }
}

