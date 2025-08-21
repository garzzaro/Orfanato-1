public class Inventario {
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    //Atributos
    private String nombre;
    private int cantidad;
     //Constructor
    public Inventario(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    //Metodos
    public void existencia() {
        System.out.println("Hay " + cantidad + " unidades de " + nombre + ".");
    }

    public void donaciones() {
        System.out.println("No hay donaciones disponibles por el momento.");
    }
    public void getRopa() {
        System.out.println("El inventario contiene ropa.");
    }
}
