# Primer Parcial Práctico – Programación I

## Versión B

**Lenguaje:** Java  
**Modalidad:** Individual  
**Duración total:** 60 minutos  
**Valor:** 100 puntos  
**Temas:** arreglos unidimensionales, arreglos bidimensionales, ciclos, condicionales, contadores y acumuladores.

---

## Indicaciones generales

- Desarrolle los dos ejercicios en Java y desde consola.
- Cada ejercicio debe resolverse en un archivo independiente.
- Toda la solución debe estar dentro del método `main`.
- Puede utilizar `Scanner`, arreglos, matrices, ciclos y condicionales.
- No se permite utilizar `ArrayList`, colecciones, `Stream`, métodos de ordenamiento automático ni métodos creados por el estudiante.
- Los datos deben ser solicitados al usuario; no deben quedar escritos directamente en el código.
- Los resultados deben mostrarse de forma clara e identificable.
- Si se presenta un empate, debe reportarse la primera posición encontrada.

---

# Ejercicio 1 – Paquetes procesados por hora

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Un centro de distribución registró la cantidad de paquetes procesados durante **10 horas consecutivas**. Los valores son enteros y deben almacenarse en un arreglo unidimensional.

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

## Aclaraciones

- Las horas se numeran del 1 al 10, aunque las posiciones del arreglo comiencen en 0.
- Una racha es una secuencia de posiciones consecutivas. Por ejemplo, si las horas 5, 6 y 7 están por debajo del promedio, existe una racha de longitud 3.
- Para determinar cuáles valores están por debajo del promedio será necesario recorrer nuevamente el arreglo después de calcularlo.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de los 10 valores | 10 |
| Cálculo correcto del total y del promedio | 10 |
| Identificación de la hora con menor producción | 10 |
| Conteo de horas por debajo del promedio | 8 |
| Cálculo correcto de la racha más larga | 8 |
| Claridad de la salida y organización del código | 4 |

---

# Ejercicio 2 – Registro de ventas de sucursales

**Tiempo sugerido:** 30 minutos  
**Valor:** 50 puntos

Una empresa tiene **4 sucursales** y desea analizar las unidades vendidas de **5 productos** durante una jornada. La información debe almacenarse en una matriz de 4 filas por 5 columnas:

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

## Aclaraciones

- Las sucursales se numeran del 1 al 4 y los productos del 1 al 5.
- Si dos sucursales tienen el mismo total mínimo, se reporta la primera.
- Si dos productos tienen el mismo total máximo, se reporta el primero.
- No es necesario crear arreglos adicionales para resolver el ejercicio, aunque puede utilizarlos si lo considera conveniente.

## Criterios de evaluación

| Criterio | Puntaje |
|---|---:|
| Lectura, almacenamiento y validación de la matriz | 10 |
| Cálculo del total de cada sucursal | 10 |
| Cálculo del total de cada producto | 10 |
| Identificación de la sucursal menor y el producto mayor | 10 |
| Conteo de registros superiores a 30 | 6 |
| Presentación de la matriz y organización del código | 4 |

---

## Entrega

Entregue los dos archivos `.java`, debidamente nombrados y capaces de compilar y ejecutarse sin errores.

**Analice primero y programe después. Java ejecuta exactamente lo escrito, incluso cuando la idea iba por otro camino.**
-------------------------------------------------------------------------------------------------------------------------

# Análisis del problema 1

## Descripción general

Realicé un programa en Java que permite ingresar la cantidad de paquetes recibidos durante 10 horas. Con estos datos el programa calcula el total, el promedio, la hora con menos paquetes, las horas que estuvieron por debajo del promedio y la racha más larga de horas inferiores al promedio.

## Entradas

La entrada principal es la cantidad de paquetes recibidos en cada una de las 10 horas.

Utilicé `Scanner` para recibir los datos:

`Scanner sc = new Scanner(System.in);`

Los valores se almacenan en el arreglo:

`int[] paquetesHoras = new int[10];`

También validé que la cantidad de paquetes no fuera negativa.

## Variables y constante

| Nombre             | Tipo        | Función                                          |
| ------------------ | ----------- | ------------------------------------------------ |
| `paquetesHoras`    | `int[]`     | Almacena los paquetes de cada hora               |
| `LONGITUD_PAQUETES`| `final int` | Guarda el tamaño del arreglo                     |
| `paquetes`         | `int`       | Guarda el dato ingresado                         |
| `suma`             | `int`       | Acumula el total de paquetes                     |
| `promedio`         | `float`     | Guarda el promedio                               |
| `horaMenos`        | `int`       | Guarda la posición de la hora con menos paquetes |
| `inferiores`       | `int`       | Cuenta las horas inferiores al promedio          |
| `rachaActual`      | `int`       | Cuenta la racha actual                           |
| `rachaMayor`       | `int`       | Guarda la racha más larga                        |
| `i`                | `int`       | Controla los ciclos                              |

La constante:

`final int longitudPaquetes = paquetesHoras.length;`

la utilicé para conocer el tamaño del arreglo sin tener que escribir el número 10 varias veces.

## Procesos

### Almacenamiento y validación

Utilicé un `for` para pedir los datos de las 10 horas.

Dentro utilicé un `do while` para validar que el usuario no ingresara números negativos. Elegí este ciclo porque permite solicitar el dato al menos una vez y repetirlo si es incorrecto.

### Suma y promedio

Utilicé un `for-each` para recorrer el arreglo y sumar todos los paquetes.

Después calculé el promedio dividiendo la suma entre la cantidad de horas:

**promedio = suma / número de horas**

Usé `float` porque el promedio puede tener decimales.

### Hora con menos paquetes

Utilicé un `for` y un `if` para comparar los valores del arreglo y encontrar la posición que contiene la menor cantidad de paquetes.

### Horas inferiores al promedio

Recorrí nuevamente el arreglo y utilicé un `if` para comprobar cuáles valores eran menores que el promedio. Cada vez que se cumple la condición, aumento `inferiores`.

### Racha más larga

Utilicé `rachaActual` para contar las horas consecutivas que están por debajo del promedio y `rachaMayor` para guardar la racha más larga encontrada.

Cuando una hora no está por debajo del promedio, reinicio `rachaActual` en cero porque la racha se terminó.

## Salidas

El programa muestra:

* Total de paquetes procesados.
* Promedio de paquetes por hora.
* Hora con menor cantidad de paquetes.
* Cantidad de paquetes de esa hora.
* Cantidad de horas inferiores al promedio.
* Racha más larga de horas inferiores al promedio.
* Listado final de paquetes por cada hora.

## ¿Por qué utilicé ciclos y validaciones?

Utilicé los ciclos porque necesitaba repetir procesos sobre las 10 horas. Cada `for` cumple una función diferente: ingresar datos, sumar, buscar el menor, contar valores inferiores, calcular la racha y mostrar los resultados.

Utilicé el `do while` para validar los datos ingresados y evitar cantidades negativas.

Los `if` los utilicé para realizar comparaciones y tomar decisiones según los valores almacenados.

## Conclusión

Con este programa pude aplicar conceptos de Java(aunque me costo un chingo) como arreglos, variables, constantes, ciclos, condiciones, contadores, acumuladores y validaciones. Además, pude utilizar los datos ingresados para realizar diferentes cálculos y obtener información sobre la cantidad de paquetes recibidos durante las 10 horas.
------------------------------------------------------------------------------------------------------------------------------------------------

# Análisis del problema 2

## Descripción general

Realicé un programa en Java que permite registrar las unidades vendidas de **5 productos en 4 sucursales**. Con estos datos puedo calcular las ventas totales por sucursal, las ventas totales por producto, identificar la sucursal y el producto con mayores o menores ventas y contar los registros superiores a 30 unidades.

## Entradas

La entrada principal son las unidades vendidas de cada producto en cada sucursal.

Utilicé `Scanner` para recibir los datos:

`Scanner sc = new Scanner(System.in);`

Los datos se almacenan en una matriz de 4 filas y 5 columnas:

`int[][] sucursalesProducto = new int[4][5];`

Las filas representan las sucursales y las columnas representan los productos.

También validé que las cantidades ingresadas no fueran negativas.

## Variables y constante

| Nombre                | Tipo        | Función                                          |
| --------------------- | ----------- | ------------------------------------------------ |
| `sc`                  | `Scanner`   | Recibir los datos                                |
| `sucursalesProducto`  | `int[][]`   | Almacenar las ventas                             |
| `SUCURSALES_LONGITUD` | `final int` | Guardar la cantidad de sucursales                |
| `i`                   | `int`       | Recorrer las sucursales                          |
| `j`                   | `int`       | Recorrer los productos                           |
| `paquetes`            | `int`       | Guardar temporalmente cada dato                  |
| `totalSucursal`       | `int`       | Acumular las ventas de una sucursal              |
| `totalProducto`       | `int`       | Acumular las ventas de un producto               |
| `sucursalMenor`       | `int`       | Guardar la sucursal con menor cantidad de ventas |
| `productoMayor`       | `int`       | Guardar el producto con mayor cantidad de ventas |
| `registrosSuperiores` | `int`       | Contar ventas superiores a 30                    |

La constante:

`final int SUCURSALES_LONGITUD = sucursalesProducto.length;`

la utilicé para obtener la cantidad de sucursales sin tener que escribir directamente el número 4 en los ciclos.

## Procesos

### Almacenamiento y validación

Utilicé dos ciclos `for` porque estoy trabajando con una matriz. El primer ciclo recorre las sucursales y el segundo los productos de cada sucursal.

Dentro utilicé un `do while` para validar que las cantidades ingresadas no fueran negativas.

Si el usuario introduce un número menor que cero, el programa muestra un mensaje de error y vuelve a pedir el dato.

### Total por sucursal

Recorrí cada fila de la matriz y sumé los productos correspondientes a cada sucursal.

Utilicé la variable `totalSucursal` como acumulador y la reinicio en cero para cada sucursal.

### Total por producto

En este caso recorrí las columnas de la matriz para sumar las ventas del mismo producto en las cuatro sucursales.

Utilicé `totalProducto` como acumulador.

### Sucursal con menor cantidad de ventas

Comparé los totales de las sucursales para encontrar cuál tenía la menor cantidad de unidades vendidas.

Utilicé `sucursalMenor` para guardar la posición de la sucursal encontrada.

### Producto con mayor cantidad de ventas

Sumé las ventas de cada producto en las cuatro sucursales y comparé los resultados para encontrar el producto con mayor cantidad de unidades vendidas.

Utilicé `productoMayor` para guardar la posición del producto.

### Registros superiores a 30

Recorrí toda la matriz y utilicé:

`if (sucursalesProducto[i][j] > 30)`

para identificar los registros que superan las 30 unidades.

Cada vez que se cumple la condición aumento:

`registrosSuperiores++;`

De esta manera obtengo la cantidad total de registros que superan las 30 unidades.

## ¿Por qué utilicé ciclos y validaciones?

Utilicé ciclos `for` porque necesitaba recorrer las filas y columnas de la matriz.

El `do while` lo utilicé para validar los datos y evitar cantidades negativas.

Los `if` los utilicé para comparar los valores, encontrar los mayores y menores y contar los registros superiores a 30.

Utilicé acumuladores como `totalSucursal` y `totalProducto` para sumar las ventas, y un contador como `registrosSuperiores` para contar los registros que cumplen una condición.

## Salidas

El programa muestra:

* Total de unidades vendidas en cada sucursal.
* Total de unidades vendidas de cada producto.
* Sucursal con menor cantidad de ventas.
* Producto con mayor cantidad de ventas.
* Cantidad de registros con ventas superiores a 30 unidades.
* Matriz completa de ventas organizada por sucursal y producto.

## Conclusión

Con este programa pude trabajar con una matriz bidimensional en Java y aplicar conceptos como arreglos, ciclos anidados, variables, constantes, acumuladores, contadores, condiciones y validaciones.

La matriz me permitió organizar las ventas relacionando cada sucursal con sus respectivos productos y posteriormente utilizar esos datos para realizar diferentes cálculos y comparaciones.
