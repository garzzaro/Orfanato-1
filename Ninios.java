public class Ninios {
    //Atributos
    private String nombre; 
    private int edad; 
    private String nacionalidad; 

    // Constructor
    public Ninios(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = "";
    }

    public Ninios(String nombre, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    // Métodos
    public void verUbicacion() {
        System.out.println(nombre + " está en el patio del orfanato.");
    }

    public void caminarrapido() {
        System.out.println(nombre + " está caminando rápido.");
    }

    public void caminarlento() {
        System.out.println(nombre + " está caminando lento.");
    }
    public void presentarse() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }
    

}
