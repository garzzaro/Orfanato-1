public class Habitaciones {
    // ...existing code...
    //Atributos
    private int numCuarto;
    private int personasHabitacion;
    private int camas;
     //Constructor
    public Habitaciones(int numCuarto, int personasHabitacion, int camas) {
        this.numCuarto = numCuarto;
        this.personasHabitacion = personasHabitacion;
        this.camas = camas;
    }
    //Metodos
    public int getNumCuarto() {
        return numCuarto;
    }
    public int getPersonasHabitacion() {
        return personasHabitacion;
    }
    public int getCamas() {
        return camas;
    }
}

