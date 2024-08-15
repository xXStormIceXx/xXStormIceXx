package Carrera;

class Atleta implements Runnable {
    private String nombre;
    private int id;
    private static int siguienteAtleta = 1;

    public Atleta(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (Carrera.testigo) {
            try {
                // Esperar turno
                while (id != siguienteAtleta) {
                    Carrera.testigo.wait();
                }

                // Iniciar carrera
                System.out.println(nombre + " ha comenzado a correr.");
                long tiempoInicio = System.currentTimeMillis();
                Thread.sleep((long) (9000 + Math.random() * 2000));  // Simular el tiempo de carrera
                long tiempoFinal = System.currentTimeMillis();

                long tiempoCarrera = tiempoFinal - tiempoInicio;
                System.out.println(nombre + " ha terminado en " + tiempoCarrera / 1000.0 + " segundos.");

                // Agregar el tiempo de carrera al tiempo total
                Carrera.agregarTiempo(tiempoCarrera);

                // Pasar el turno al siguiente atleta
                siguienteAtleta++;
                Carrera.testigo.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
