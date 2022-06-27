package edu.aluismarte.diplomado.project.week12;

/**
 * A veces el DEBUG no es suficiente, necesitamos saber que ocurre con un proceso con ciertos eventos
 * <p>
 * Por lo que haremos un follo que permitirá hacer nuevamente el proceso con tal de replicar paso a paso
 *
 * @author aluis on 6/26/2022.
 */
public class ReplicateEventsInMicroServices {

    public void step1(int number) {
    }

    public void step2(String data) {
    }

    public void step3(int number, String data) {
    }

    public static void main(String[] args) {
        ReplicateEventsInMicroServices replicateEventsInMicroServices = new ReplicateEventsInMicroServices();
        replicateEventsInMicroServices.step1(1);
        replicateEventsInMicroServices.step2("Hola");
        replicateEventsInMicroServices.step3(5, "Mundo");
    }
}
