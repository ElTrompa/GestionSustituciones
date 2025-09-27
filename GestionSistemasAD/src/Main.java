import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            GestorSustituciones gestor = new GestorSustituciones("horarios.csv", "sustituciones.csv");
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce nombre del profesor ausente:");
            String ausente = sc.nextLine();
            System.out.println("Introduce día de la semana:");
            String dia = sc.nextLine();
            System.out.println("Introduce hora (ej: 2):");
            String hora = sc.nextLine();

            ArrayList<Profesor> sustitutos = gestor.buscarSustitutos(dia, hora);

            if (sustitutos.isEmpty()) {
                System.out.println("No hay profesores disponibles.");
            } else {
                System.out.println("Posibles sustitutos:");
                for (int i = 0; i < sustitutos.size(); i++) {
                    System.out.println((i + 1) + ". " + sustitutos.get(i));
                }

                System.out.println("Elige sustituto (número):");
                int opcion = sc.nextInt();
                Profesor elegido = sustitutos.get(opcion - 1);

                gestor.asignarSustituto(elegido, dia, hora);
                System.out.println("Sustituto asignado: " + elegido.getNombre());
            }

            System.out.println("\nRanking de sustituciones:");
            gestor.mostrarRanking();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}