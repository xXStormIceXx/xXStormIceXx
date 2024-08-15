package Carrera;

class Atleta implements Runnable {
    private String nombre;
    private static int siguienteAtleta = 1;
    private int id;

    public Atleta(String nombre) {
        this.nombre = nombre;
        this.id = siguienteAtleta++;
    }

    @Override
    public void run() {
        synchronized (Carrera.testigo) {
            try {
                // Esperar turno
                while (id != siguienteAtleta - 1) {
                    Carrera.testigo.wait();
                }

                // Iniciar carrera
                System.out.println(nombre + " ha comenzado a correr.");
                long tiempoInicio = System.currentTimeMillis();
                Thread.sleep((long) (9000 + Math.random() * 2000));
                long tiempoFinal = System.currentTimeMillis();

                System.out.println(nombre + " ha terminado en " + (tiempoFinal - tiempoInicio) / 1000.0 + " segundos.");

                // Notificar al siguiente atleta
                Carrera.testigo.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
