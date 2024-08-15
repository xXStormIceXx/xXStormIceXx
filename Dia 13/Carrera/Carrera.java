package Carrera;

public class Carrera {
    public static Object testigo = new Object();
    private static long tiempoTotal = 0;

    public static void main(String[] args) {
        // Crear los hilos para los atletas
        Thread atleta1 = new Thread(new Atleta("Atleta 1", 1));
        Thread atleta2 = new Thread(new Atleta("Atleta 2", 2));
        Thread atleta3 = new Thread(new Atleta("Atleta 3", 3));
        Thread atleta4 = new Thread(new Atleta("Atleta 4", 4));

        // Empezar la carrera
        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();

        // Esperar a que todos los atletas terminen
        try {
            atleta1.join();
            atleta2.join();
            atleta3.join();
            atleta4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el tiempo total de la carrera
        System.out.println("Tiempo total de la carrera: " + tiempoTotal / 1000.0 + " segundos.");
    }

    public static synchronized void agregarTiempo(long tiempo) {
        tiempoTotal += tiempo;
    }
}
