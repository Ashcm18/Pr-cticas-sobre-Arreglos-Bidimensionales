import java.util.Scanner;

/**
 * Ejercicio 1 — Promedio de estudiantes.
 *
 * Una escuela registra las calificaciones de 4 estudiantes en 3 asignaturas.
 *  - Calcula el promedio de cada estudiante (promedio por fila).
 *  - Calcula el promedio de cada asignatura (promedio por columna).
 *
 * Se usa una matriz bidimensional [estudiantes][asignaturas] y ciclos anidados.
 */
public class Ejercicio1_PromedioEstudiantes {

    // Dimensiones fijas del problema.
    static final int ESTUDIANTES = 4;
    static final int ASIGNATURAS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nombresAsignaturas = { "Matematica", "Lengua", "Ciencias" };
        double[][] calificaciones = new double[ESTUDIANTES][ASIGNATURAS];

        // --- ENTRADA: cargar calificaciones por teclado ---
        System.out.println("=== Registro de calificaciones (4 estudiantes x 3 asignaturas) ===");
        for (int i = 0; i < ESTUDIANTES; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            for (int j = 0; j < ASIGNATURAS; j++) {
                calificaciones[i][j] = leerNota(sc, "  " + nombresAsignaturas[j] + ": ");
            }
        }

        // --- SALIDA: tabla de calificaciones ---
        System.out.println("\n=== Calificaciones registradas ===");
        System.out.printf("%-14s", "Estudiante");
        for (String a : nombresAsignaturas) System.out.printf("%-12s", a);
        System.out.printf("%-12s%n", "Promedio");

        // Acumuladores para el promedio de cada asignatura (por columna).
        double[] sumaColumnas = new double[ASIGNATURAS];

        // Recorrido con ciclos anidados: fila = estudiante, columna = asignatura.
        for (int i = 0; i < ESTUDIANTES; i++) {
            double sumaFila = 0;
            for (int j = 0; j < ASIGNATURAS; j++) {
                sumaFila += calificaciones[i][j];   // acumula el total del estudiante
                sumaColumnas[j] += calificaciones[i][j]; // acumula el total de la asignatura
            }
            double promedioEstudiante = sumaFila / ASIGNATURAS;

            System.out.printf("%-14s", "Estudiante " + (i + 1));
            for (int j = 0; j < ASIGNATURAS; j++) System.out.printf("%-12.2f", calificaciones[i][j]);
            System.out.printf("%-12.2f%n", promedioEstudiante);
        }

        // --- SALIDA: promedio de cada asignatura (por columna) ---
        System.out.printf("%-14s", "Prom. asig.");
        for (int j = 0; j < ASIGNATURAS; j++) {
            double promedioAsignatura = sumaColumnas[j] / ESTUDIANTES;
            System.out.printf("%-12.2f", promedioAsignatura);
        }
        System.out.println();

        sc.close();
    }

    /** Lee una nota validando el rango 0..100. */
    static double leerNota(Scanner sc, String etiqueta) {
        double nota;
        while (true) {
            System.out.print(etiqueta);
            while (!sc.hasNextDouble()) {
                System.out.print("  Valor invalido. " + etiqueta);
                sc.next();
            }
            nota = sc.nextDouble();
            if (nota >= 0 && nota <= 100) return nota;
            System.out.println("  La nota debe estar entre 0 y 100.");
        }
    }
}
