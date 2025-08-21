public class Trabajadores {
    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public float getSalario() {
        return salario;
    }

    public int getEdad() {
        return edad;
    }
    //Atributos
    private String nombre;
    private String puesto;
    private float salario;
    private int edad;
     //Constructor
    public Trabajadores(String nombre, String puesto, float salario, int edad) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.edad = edad;
    }
    //Metodos
    public void verInfo() {
        System.out.println("Nombre: " + nombre + ", Puesto: " + puesto);
    }

    public void verSalario() {
        System.out.println("El salario de " + nombre + " es: " + salario+"Q");
    }
    public void verEdad(){
        System.out.println("La edad de "+ nombre +" es: "+edad);
    }
    public void verpresupuesto() {
        System.out.println("El presupuesto del orfanato es de 100,000 Q.");
    }
    public void hablarninio () {
        System.out.println(nombre + " está hablando con los niños.");
    }
}


