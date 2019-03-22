# Aerolinea
Tarea de Java Fundamental
(uso de entrada de datos por consola, NO Scanner)

Sistema de reservaciones de una aerolínea

Una pequeña aerolínea acaba de comprar una computadora para su nuevo sistema de reservaciones automatizado. Se le ha pedido a usted que desarrolle el nuevo sistema. Usted escribirá una aplicación para asignar asientos en cada vuelo del único avión de la aerolínea (capacidad; 90 asientos). 

Su aplicación debe mostrar las siguientes alternativas:

1 para Primera Clase
2 para Clase Económica

Si el usuario escribe 1, su aplicación debe asignarle un asiento en la sección de primera clase (asientos 1A al 5F, es decir, filas 1 ala 5, columnas A, B, C, D, E, y F).

Si el usuario escribe 2, su aplicación debe asignarle un asiento en la sección económica (asientos 6A al 15F, es decir, filas 6 a la 15, columnas A, B, C, D E, y F), en ambos casos - 1ra.Clase o Económica - se debe preguntar al usuario si desea su asiento con vista hacia la ventana (filas A o F) o en pasillos (filas B, C, Do E), en el caso de haber disponibilidad.

Su aplicación nunca deberá asignar un asiento que ya haya sido ocupado.

Cuando esté llena la sección económica, su programa deberá preguntar a la persona si acepta buscar otras alternativas (ej. ser colocada en la sección de primera clase o viceversa y/o cambiar la ubicacion del asiento, ésto es preferible hacerlo de forma automática).

Si la persona acepta, haga la asignación de asiento apropiada. Si no acepta, imprima el mensaje "El próximo vuelo sale en X horas".

Adicional Ud. debe guardar la identificacion, nombres, fecha de nacimiento y número de asiento asignado a este pasajero en listas, segun el avion se vaya llenando.

La implementación de esta información, nos permitirá conocer las siguientes estadísticas importantes para la aerolínea:

• Cuantas personas de la tercera edad viajan en el avión (personas mayores de 60 años y menores de 80).
• Cuantas personas ocupan asientos de ventana y cuantas de pasillo.
• Cuáles son las personas de mayor edad y de menor edad, que viaja en el avión, para prestarles especial atención/servicio (mayor edad > 80 años, y menor edad < 10 años).

Hay muchas soluciones, este ejemplo es solo una de ellas. 

ATENCION: Usualmente muchos docentes exigen a los estudiantes usar listas o matrices para el guardado de los datos, en este proyecto NO USAR ni arreglos ni matrices, primero porque el tratamiento es dinamico, por lo tanto hay que usar colecciones que hereden de Collection, tampoco tiene sentido usar matrices ya que conlleva a la creacion y manipulacion de objetos.

Si se quiere emplear arreglos para cualquier manipulacion, éstos deben usarse cuando ya las colecciones estén completamente llenas y hacer la conversion correspondiente.
