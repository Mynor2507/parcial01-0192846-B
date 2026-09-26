
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
        Scanner sc = new Scanner(System.in);

        //creacion el arreglo
        int[][] sucursalesProducto = new int[4][5];

        //constantes
        final int SUCURSALES_LONGITUD = sucursalesProducto.length;

        //solicitar productos vendidos
        for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
            for (int j = 0; j < sucursalesProducto[i].length; j++) {
                int paquetes;

                do {
                    System.out.print("Ingrese el numero de paquetes vendidos en la sucursal " + (i + 1) + " del producto " + (j + 1) + ":");
                    paquetes = sc.nextInt();

                    if (paquetes < 0) {
                        System.out.println("Dato invalido, vuelva a intentarlo... ");
                    }
                } while (paquetes < 0);

                sucursalesProducto[i][j] = paquetes;
            }

            System.out.println("-----------------------------------");
        }
        
        //total de unidades vendidas en cada sucursal
        for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
            int totalSucursal = 0;

            for (int j = 0; j < sucursalesProducto[i].length; j++) {
                totalSucursal += sucursalesProducto[i][j];
            }

            System.out.println("Total de unidades vendidas en la sucursal " + (i + 1) + ": " + totalSucursal);
            System.out.println("-----------------------------------");
        }
        
        //total vendido de cada producto, sumando las cuatro sucursales.
        for (int j = 0; j < sucursalesProducto[0].length; j++) {
            int totalProducto = 0;

            for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
                totalProducto += sucursalesProducto[i][j];
            }

            System.out.println("Total de unidades vendidas del producto " + (j + 1) + ": " + totalProducto);
            System.out.println("-----------------------------------");
        }
        
        //sucursal con la menor cantidad total de ventas.
        int sucursalMenor = 0;
        for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
            int totalSucursal = 0;

            for (int j = 0; j < sucursalesProducto[i].length; j++) {
                totalSucursal += sucursalesProducto[i][j];
            }

            if (totalSucursal < sucursalesProducto[sucursalMenor][0]) {
                sucursalMenor = i;
            }
        }
        System.out.println("La sucursal con menor cantidad de ventas es: " + (sucursalMenor + 1));
        System.out.println("-----------------------------------");
        
        //El producto con la mayor cantidad total de unidades vendidas.
        int productoMayor = 0;
        for (int j = 0; j < sucursalesProducto[0].length; j++) {
            int totalProducto = 0;

            for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
                totalProducto += sucursalesProducto[i][j];
            }

            if (totalProducto > sucursalesProducto[0][productoMayor]) {
                productoMayor = j;
            }
        }
        System.out.println("El producto con la mayor cantidad total de unidades vendidas es: " + (productoMayor + 1));
        System.out.println("-----------------------------------");

        //Cuántos registros de la matriz fueron superiores a 30 unidades.
        int registrosSuperiores = 0;
        for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
            for (int j = 0; j < sucursalesProducto[i].length; j++) {
                if (sucursalesProducto[i][j] > 30) {
                    registrosSuperiores++;
                }
            }
        }
        System.out.println("La cantidad de registros con ventas superiores a 30 unidades es: " + registrosSuperiores);
        System.out.println("-----------------------------------");

        //Mostrar la matriz completa, organizada por sucursales y productos.
        System.out.println("Matriz completa de ventas por sucursal y producto:");
        for (int i = 0; i < SUCURSALES_LONGITUD; i++) {
            for (int j = 0; j < sucursalesProducto[i].length; j++) {
                System.out.print(sucursalesProducto[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------");

    }

}