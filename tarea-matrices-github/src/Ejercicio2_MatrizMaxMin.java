import java.util.Scanner;

/**
 * Ejercicio 2 — Almacenar y procesar informacion en una matriz.
 *
 *  - Solicita al usuario el numero de filas y columnas.
 *  - Crea la matriz y permite ingresar los valores por teclado.
 *  - Muestra la matriz en forma tabular.
 *  - Recorre la matriz con ciclos anidados para hallar el valor MAYOR y MENOR,
 *    junto con su posicion (fila, columna).
 */
public class Ejercicio2_MatrizMaxMin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- ENTRADA: dimensiones de la matriz ---
        System.out.println("=== Matriz de enteros: valor mayor y menor ===");
        int filas = leerEnteroPositivo(sc, "Ingrese el numero de filas: ");
        int columnas = leerEnteroPositivo(sc, "Ingrese el numero de columnas: ");

        int[][] matriz = new int[filas][columnas];

        // --- ENTRADA: valores de la matriz ---
        System.out.println("\nIngrese los valores de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = leerEntero(sc, "  [" + i + "][" + j + "]: ");
            }
        }

        // --- SALIDA: mostrar la matriz en forma tabular ---
        System.out.println("\n=== Matriz ingresada ===");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println();
        }

        // --- PROCESO: buscar mayor y menor con sus posiciones ---
        // Se inicializan con el primer elemento (posicion 0,0).
        int mayor = matriz[0][0], filaMayor = 0, colMayor = 0;
        int menor = matriz[0][0], filaMenor = 0, colMenor = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    filaMayor = i;
                    colMayor = j;
                }
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    filaMenor = i;
                    colMenor = j;
                }
            }
        }

        // --- SALIDA: resultados ---
        System.out.println("\n=== Resultados ===");
        System.out.printf("Valor MAYOR: %d  en la posicion [%d][%d]%n", mayor, filaMayor, colMayor);
        System.out.printf("Valor MENOR: %d  en la posicion [%d][%d]%n", menor, filaMenor, colMenor);

        sc.close();
    }

    /** Lee un entero mayor que cero (para las dimensiones). */
    static int leerEnteroPositivo(Scanner sc, String etiqueta) {
        int valor;
        while (true) {
            valor = leerEntero(sc, etiqueta);
            if (valor > 0) return valor;
            System.out.println("  Debe ser un numero mayor que cero.");
        }
    }

    /** Lee un entero cualquiera validando la entrada. */
    static int leerEntero(Scanner sc, String etiqueta) {
        System.out.print(etiqueta);
        while (!sc.hasNextInt()) {
            System.out.print("  Valor invalido. " + etiqueta);
            sc.next();
        }
        return sc.nextInt();
    }
}
