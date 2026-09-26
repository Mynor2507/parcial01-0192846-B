
import java.util.Scanner;



/*Un centro de distribución registró la cantidad de paquetes procesados durante **10 horas consecutivas**. Los valores son enteros y deben almacenarse en un arreglo unidimensional.

Construya un programa que:

1. Cree un arreglo de 10 posiciones.
2. Solicite la cantidad de paquetes procesados en cada hora y valide que no sea negativa. Si el dato es inválido, debe solicitarlo nuevamente.
3. Calcule y muestre:
   - El total de paquetes procesados.
   - El promedio de paquetes por hora.
   - El número de la hora con la menor cantidad procesada.
   - Cuántas horas tuvieron una producción inferior al promedio.
   - La racha más larga de horas consecutivas cuya producción fue inferior al promedio.
4. Muestre el listado final con el número de cada hora y su cantidad registrada.
 */

import java.util.Scanner;

public class Ejercicio1_Java {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // creacion del arreglo
        int[] paquetesHoras = new int[10];

        // constantes
        final int LONGITUD_PAQUETES = paquetesHoras.length;

        // solicitud de datos
        for (int i = 0; i < LONGITUD_PAQUETES; i++) {

            int paquetes;

            do {
                System.out.print("Ingrese la cantidad de paquetes recibidos en la hora "
                        + (i + 1) + ": ");
                paquetes = sc.nextInt();

                if (paquetes < 0) {
                    System.out.println("Dato invalido, vuelva a intentarlo");
                }

            } while (paquetes < 0);

            paquetesHoras[i] = paquetes;

            System.out.println("---------------------");
        }

        // Suma de todos los paquetes
        int suma = 0;

        for (int paquetes : paquetesHoras) {
            suma += paquetes;
        }

        System.out.println("Total de paquetes procesados: " + suma);
        System.out.println("-------------------");

        // promedio de paquetes por hora
        float promedio = suma / (float) LONGITUD_PAQUETES;

        System.out.println("El promedio de los paquetes por hora es: " + promedio);
        System.out.println("-------------------");

        // hora con menos paquetes
        int horaMenos = 0;

        for (int i = 0; i < LONGITUD_PAQUETES; i++) {
            if (paquetesHoras[i] < paquetesHoras[horaMenos]) {
                horaMenos = i;
            }
        }

        System.out.println("La hora con menor numero de paquetes es: "
                + (horaMenos + 1)
                + " con "
                + paquetesHoras[horaMenos]
                + " paquetes.");

        System.out.println("--------------------");

        // horas con produccion inferior al promedio
        int inferiores = 0;

        for (int i = 0; i < LONGITUD_PAQUETES; i++) {
            if (paquetesHoras[i] < promedio) {
                inferiores++;
            }
        }

        System.out.println("Cantidad de horas con produccion inferior al promedio: "
                + inferiores);

        System.out.println("--------------------");

        // racha mas larga inferior al promedio
        int rachaActual = 0;
        int rachaMayor = 0;

        for (int i = 0; i < LONGITUD_PAQUETES; i++) {

            if (paquetesHoras[i] < promedio) {
                rachaActual++;

                if (rachaActual > rachaMayor) {
                    rachaMayor = rachaActual;
                }

            } else {
                rachaActual = 0;
            }
        }

        System.out.println("La racha mas larga de horas inferiores al promedio es: "
                + rachaMayor);

        System.out.println("--------------------");

        // listado final
        System.out.println("LISTADO FINAL");

        for (int i = 0; i < LONGITUD_PAQUETES; i++) {
            System.out.println("Hora " + (i + 1) + ": "
                    + paquetesHoras[i] + " paquetes");
        }

        sc.close();
    }
}

