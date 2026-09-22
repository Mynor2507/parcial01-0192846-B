
import java.util.Scanner;

/*Una empresa tiene **4 sucursales** y desea analizar las unidades vendidas de **5 productos** durante una jornada. La información debe almacenarse en una matriz de 4 filas por 5 columnas:

- Cada fila representa una sucursal.
- Cada columna representa un producto.

Construya un programa que:

1. Cree una matriz de `4 x 5`.
2. Solicite las unidades vendidas de cada producto en cada sucursal y valide que ningún valor sea negativo.
3. Calcule y muestre:
   - El total de unidades vendidas por cada sucursal.
   - El total vendido de cada producto, sumando las cuatro sucursales.
   - La sucursal con la menor cantidad total de ventas.
   - El producto con la mayor cantidad total de unidades vendidas.
   - Cuántos registros de la matriz fueron superiores a 30 unidades.
4. Muestre la matriz completa, organizada por sucursales y productos.
 */


public class Ejercicio2_Java {
    public static void main(String[] args) throws Exception {
        int[][] sucursaleProducto = new int[4][5];
        Scanner scanner = new Scanner(System.in);
        int unidades = scanner.nextInt();
        System.out.println(unidades);
    }
}