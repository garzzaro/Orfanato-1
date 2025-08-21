public class Edificio {
    public String getNombreOrfanato() {
        return nombreOrfanato;
    }

    public String getUbicacionOrfanato() {
        return ubicacionOrfanato;
    }

    public int getNumeroNinos() {
        return numeroNinos;
    }

    public int getPisos() {
        return pisos;
    }
    //Atributos
    private String nombreOrfanato;
    private int numeroNinos;
    private int pisos;
    private String ubicacionOrfanato;
    //Constructor
    public Edificio(String nombreOrfanato, String ubicacionOrfanato, int numeroNinos, int pisos) {
        this.nombreOrfanato = nombreOrfanato;
        this.ubicacionOrfanato = ubicacionOrfanato;
        this.numeroNinos = numeroNinos;
        this.pisos = pisos;
    }
    //Metodos
    public void verDatos() {
        System.out.println("Nombre del orfanato: " + nombreOrfanato);
        System.out.println("Ubicación: " + ubicacionOrfanato);
    }

}
