        GESTIÓN DE EMPLEADOS CON MEMORIA ESTÁTICA Y DINÁMICA

-----DESCRIPCIÓN DEL PROYECTO----

Este proyecto fue desarrollado para la Gestión de Empleados 
con Memoria Estática y Dinámica, permitiendo registrar 
nuevos empleados, editar sus salarios, eliminarlos, visualizar 
la lista completa del personal y generar reportes estadísticos.
El diseño del sistema se basa en los principios de la 
programación orientada a objetos, aplicando conceptos como 
encapsulamiento, atributos estáticos, métodos de acceso y 
modificación (getters y setters), además del uso de estructuras
de control y manejo de excepciones.

-----FUNCIONAMIENTO-------

Permita gestionar empleados utilizando memoria dinámica 
(ArrayList) y memoria estática (contador global de empleados). 
La memoria dinámica se refleja en el uso del ArrayList para 
almacenar de forma flexible y escalable cada instancia de 
empleado creada por el usuario. La memoria estática se 
representa mediante un contador global que incrementa 
automáticamente cada vez que se crea un nuevo empleado, 
asignándole un código único.

Se utiliza la clase Empleado como modelo de datos que 
almacena los atributos de cada empleado: nombre, edad, 
departamento, salario y código único asignado automáticamente 
con el contador estático. Por otro lado, la clase 
Gestion_Empleados contiene todas las funcionalidades del 
sistema, organizadas en métodos específicos que se integran 
a través de un menú interactivo por consola.

La interacción con el usuario se realiza mediante un menú 
interactivo implementado con el método menu(), donde se 
presentan las diferentes opciones del sistema. La ejecución 
del programa se lleva a cabo desde la clase Main, la cual 
invoca el menú principal y da inicio al sistema.

-----INTEGRANTES DEL GRUPO-----

1. Johan Steven Briceño Layton
2. Daniel Esteban Contreras Motoa
3. Juan David Catrillon Varon