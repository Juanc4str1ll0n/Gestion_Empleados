import java.util.ArrayList;
import java.util.Scanner;

public class Gestion_Empleados {
    static Scanner input = new Scanner(System.in);
    public static ArrayList<Empleado> array = new ArrayList<>();

    public static void Agregar_Empleado(){
        System.out.println("Ingresa el nombre del empleado: ");
        String nombre = input.nextLine();

        System.out.println("Ingresa la edad del empleado: ");
        String edadstr = input.nextLine();

        System.out.println("Ingresa el departamento del empleado: ");
        String departamento = input.nextLine();

        System.out.println("Ingresa su salario: ");
        String salariostr = input.nextLine();

        if(nombre.isEmpty() || edadstr.isEmpty() || departamento.isEmpty()){
            System.out.println("Error al crear empleado, ingresa campos obligatorios de nombre, edad y departamento");
            return;
        }else{

            int edad;
            try{
                edad = Integer.parseInt(edadstr);
            }catch (NumberFormatException e){
                System.out.println("Error, la edad debe de ser un numero valido. Intenta de nuevo por favor");
                return;
            }

            double salario;
            try {
                salario = Double.parseDouble(salariostr);
            } catch (NumberFormatException e) {
                System.out.println("Error: El salario debe ser un número válido. Intenta de nuevo por favor");
                return;
            }

            Empleado nuevo = new Empleado(nombre, edad, departamento, salario);
            array.add(nuevo);
            System.out.println("Empleado agregado con exito! ");
        }
    }

    public static void Eliminar_Empleado(){
        System.out.println("Ingresa el nombre del empleado a eliminar: ");
        String emple = input.nextLine().trim();
        boolean isEncontrado = false;

        for(int i = 0; i<array.size(); i++) {
            if (array.get(i).getNombre().equalsIgnoreCase(emple)) {
                array.remove(i);
                System.out.println("El empleado se elimino con exito");
                isEncontrado = true;
                Empleado.contador--;
                break;
            }
        }
        if (!isEncontrado) {
            System.out.println("El empleado no fue encontrado. Por favor, intenta de nuevo.");
        }
    }

    public static void Editar_Salario() {
        System.out.println("Ingresa el nombre del empleado a editar salario: ");
        String nombre = input.nextLine().trim();
        boolean isencontrado = false;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ingresa el nuevo salario para " + array.get(i).getNombre() +
                        "Su salario actual es de: " + array.get(i).getSalario());

                try{
                    double nuevoSalario = Double.parseDouble(input.nextLine());
                    if(nuevoSalario<0){
                        System.out.println("ERROR, el salario no puede ser negativo");
                        return;
                    }

                    array.get(i).setSalario(nuevoSalario);
                    System.out.println("El salario ha sido actualizado con exito");
                    isencontrado = true;
                    break;


                }catch (NumberFormatException e){
                    System.out.println("Error, debes ingresar un numero valido para el salario");
                    return;
                }
            }
        }
        if(!isencontrado){
            System.out.println("El empleado no fue encontrado en la lista, intenta nuevamente");
        }
    }

    public static void Listar_Personal(){
        for(int i = 0; i< array.size(); i++){
            System.out.println(array.get(i));
        }
    }
    public static void Generar_Reporte(){
        if(array.isEmpty()){
            System.out.println("ERROR - No hay empleados registrados, intenta de nuevo");
            return;
        }else{
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println("                  REPORTE GENERAL                ");
            System.out.println("Total de empleados registrados-----> "+Empleado.contador);

            //calcular salario promedio, salario maximo, minimo y empleados con salario mayor al promedio
            double salario = 0;
            for(int i = 0; i<array.size(); i++){
                salario += array.get(i).getSalario();
            }
            salario = salario/ array.size();

            System.out.println("Promedio general de salario -> "+salario);

            //Calculando el salario maximo
            double salarioMax = Double.NEGATIVE_INFINITY;

            for(Empleado emple : array){
                if(emple.getSalario()>salarioMax){
                    salarioMax = emple.getSalario();
                }
            }
            System.out.println("El salario maximo es de: --> "+salarioMax);

            //Calculando el salario minimo
            double salarioMin = Double.MAX_VALUE;
            for(Empleado emple: array){
                if(emple.getSalario()<salarioMin){
                    salarioMin = emple.getSalario();
                }
            }
            System.out.println("El salario minimo es de: --> "+salarioMin);

            //Numero de empleados con el salario mayor al promedio
            int cuenta = 0;

            for(Empleado emple: array){
                if(emple.getSalario()>salario){
                    cuenta++;
                }
            }

            System.out.println(cuenta+" empleados tienen salario mayor al promedio");

            //Promedio de edad
            double age = 0;
            for(int i = 0; i<array.size(); i++){
                age += array.get(i).getEdad();
            }
            age = age / array.size();
            System.out.println("Promedio de edad de empleados --> "+age);
            System.out.println("-------------- Distribucion de edades -------------");

            //calcular jovenes
            int cuentajovenes = 0;

            for(Empleado emple: array){
                if(emple.getEdad() <= 28){
                    cuentajovenes += 1;
                }
            }
            System.out.println("El numero de jovenes hasta 28 años es de: "+ cuentajovenes);

            //Calcular adultos
            int cuentaAdultos = 0;

            for(Empleado emple: array){
                if(emple.getEdad() <= 50 && emple.getEdad()>=29){
                    cuentaAdultos += 1;
                }
            }
            System.out.println("El numero de empleados entre 30 y 50 años es de: "+cuentaAdultos);

            //calcular ancianos
            int cuentaAncianos = 0;
            for(Empleado emple: array){
                if(emple.getEdad() > 50){
                    cuentaAncianos += 1;
                }
            }
            System.out.println("El numero de empleados mayor a 50 años es de: "+cuentaAncianos);
        }
    }

    public static void Menu(){
        boolean isEncendido = true;

        while(isEncendido){

            System.out.println("\n------------------------------------------------");
            System.out.println("----- Bienvenido a la gestión de empleados -----");
            System.out.println("------------------------------------------------");
            System.out.println("Que quieres hacer?. ");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Editar salario de empleado");
            System.out.println("4. Listar empleados ");
            System.out.println("5. Ver contador de empleados");
            System.out.println("6. Generar reporte general");
            System.out.println("7. Salir");

            String opcion = input.nextLine();

            switch (opcion){
                case "1":
                    Agregar_Empleado();
                    break;
                case "2":
                    Eliminar_Empleado();
                    break;
                case "3":
                    Editar_Salario();
                    break;
                case "4":
                    Listar_Personal();
                    break;
                case "5":
                    System.out.println();
                    System.out.println("El contador de empleados es de: "+ Empleado.contador);
                    System.out.println();
                    break;
                case "6":
                    Generar_Reporte();
                    break;
                case "7":
                    System.out.println("Gracias por usar el software, adios! ");
                    isEncendido = false;
                    break;
                default:
                    System.out.println("Ingresaste una opcion no valida intenta nuevamente");
                    break;
            }
        }

    }
}
