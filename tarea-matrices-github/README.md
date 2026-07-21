# Ejercicios de Matrices y Ciclos Anidados

Solución en **Java** de dos ejercicios sobre matrices bidimensionales, recorridos con
ciclos anidados y análisis de complejidad (Big-O).

## Estructura

```
tarea-matrices/
├── src/
│   ├── Ejercicio1_PromedioEstudiantes.java
│   └── Ejercicio2_MatrizMaxMin.java
└── README.md
```

## Cómo compilar y ejecutar

Requiere JDK 11 o superior.

```bash
# Compilar ambos
javac -d out src/*.java

# Ejecutar
java -cp out Ejercicio1_PromedioEstudiantes
java -cp out Ejercicio2_MatrizMaxMin
```

---

## Ejercicio 1 — Promedio de estudiantes

Una escuela registra las calificaciones de **4 estudiantes** en **3 asignaturas**.
El programa calcula el promedio de cada estudiante (por fila) y el promedio de cada
asignatura (por columna).

### Análisis del algoritmo

| Aspecto  | Descripción |
|----------|-------------|
| **Entradas** | 12 calificaciones (4 estudiantes × 3 asignaturas), ingresadas por teclado y validadas en el rango 0–100. |
| **Procesos** | Se recorre la matriz con dos ciclos anidados. Por cada fila se acumula la suma del estudiante; simultáneamente se acumula la suma de cada columna (asignatura). Luego se divide cada suma entre la cantidad correspondiente. |
| **Salidas** | Tabla con las calificaciones, el promedio de cada estudiante y una fila final con el promedio de cada asignatura. |

### Complejidad (Big-O)

Sea `n = filas (estudiantes)` y `m = columnas (asignaturas)`.

- **Temporal:** `O(n · m)` — un único recorrido con ciclos anidados; cada celda se visita
  una sola vez. Con las dimensiones fijas (4×3) es de hecho constante, pero la fórmula
  general del algoritmo es `O(n · m)`.
- **Espacial:** `O(n · m)` por la matriz de calificaciones, más `O(m)` del arreglo
  auxiliar de sumas por columna → domina `O(n · m)`.

---

## Ejercicio 2 — Almacenar y procesar información (mayor y menor)

El programa pide las dimensiones de una matriz, la llena por teclado, la muestra en forma
tabular y busca el valor **mayor** y **menor** con su posición (fila, columna).

### Análisis del algoritmo

| Aspecto  | Descripción |
|----------|-------------|
| **Entradas** | Número de filas y columnas (enteros positivos) y los `filas × columnas` valores enteros de la matriz, ingresados por teclado. |
| **Procesos** | Se crea la matriz con las dimensiones dadas. Se muestra con ciclos anidados en formato tabular. Se inicializan mayor y menor con el primer elemento `[0][0]`; luego se recorre toda la matriz con ciclos anidados comparando cada elemento y actualizando el valor y la posición cuando corresponde. |
| **Salidas** | La matriz completa en forma tabular y, por separado, el valor mayor y el menor indicando su posición `[fila][columna]`. |

### Complejidad (Big-O)

Sea `n = filas` y `m = columnas`.

- **Temporal:** `O(n · m)` — la lectura, la impresión y la búsqueda del mayor/menor son
  cada una un recorrido de ciclos anidados sobre las `n · m` celdas. La búsqueda es de una
  sola pasada, por lo que el mejor y el peor caso coinciden en `O(n · m)`.
- **Espacial:** `O(n · m)` por la matriz almacenada. Las variables de mayor, menor y sus
  posiciones son `O(1)` (no dependen del tamaño de la entrada).

---

## Resumen de complejidad

| Ejercicio | Tiempo | Espacio |
|-----------|--------|---------|
| 1 — Promedios | `O(n · m)` | `O(n · m)` |
| 2 — Mayor y menor | `O(n · m)` | `O(n · m)` |
