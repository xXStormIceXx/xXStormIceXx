package Carrera;

public class Carrera {
    public static Object testigo = new Object();

    public static void main(String[] args) {
        // Crear y empezar los hilos para los atletas
        Thread atleta1 = new Thread(new Atleta("Atleta 1"));
        Thread atleta2 = new Thread(new Atleta("Atleta 2"));
        Thread atleta3 = new Thread(new Atleta("Atleta 3"));
        Thread atleta4 = new Thread(new Atleta("Atleta 4"));

        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
    }
}
