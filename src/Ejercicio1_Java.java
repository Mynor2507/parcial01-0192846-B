
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


public class Ejercicio1_Java {
    public static void main(String[] args) throws Exception {
       //creacion del arreglo
       int[] paquetesHoras = {10, 20, 30};

       //solicitar cantidad de paquetes recibidos por hora
       Scanner scanner = new Scanner(System.in);
       int paquete = scanner.nextInt();
       if (paquete > 0) {
           paquetesHoras[0] = paquete ;
           int longitudArray = 10;
           for (int i = 0; longitudArray < 10; i++) {
               System.out.println("paquete registrado como hora" + (i+1) +":" + paquetesHoras[0]);
           }
       } else {
         System.out.println("Numero invalido");
       }
       
    }
}