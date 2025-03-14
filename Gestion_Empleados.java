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

}
