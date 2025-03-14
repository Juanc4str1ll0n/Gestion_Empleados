public class Empleado {
    private String nombre;
    private int edad;
    private String departamento;
    private int codigo;
    private double salario;
    static int contador = 0;

    public Empleado(String nombre, int edad,String departamento, double salario){
        contador++;
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
        this.salario = salario;
        this.codigo = contador;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario(){
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Nombre: "+ nombre + " |  Edad: " +edad +
                " |  Departamento: " + departamento + " |  Salario: " + salario + " |  Codigo: " + " |  EMP"+codigo;
    }
}
