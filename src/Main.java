import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese altura (m): ");
        double altura = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Ingrese sexo (masculino/femenino): ");
        String sexo = scanner.nextLine();

        System.out.print("Ingrese nivel de actividad (ej. moderado): ");
        String actividad = scanner.nextLine();

        Persona persona = new Persona(nombre, edad, peso, altura, sexo, actividad);

        SistemaNutricional sistema = new SistemaNutricional(persona);


        InformacionNutricional infoPollo = new InformacionNutricional(165, 31, 0, 3.6, 0, 74);
        Alimento pollo = new Alimento("Pechuga de pollo", "Proteínas", infoPollo);

        InformacionNutricional infoArroz = new InformacionNutricional(130, 2.7, 28, 0.3, 0.4, 1);
        Alimento arroz = new Alimento("Arroz blanco", "Cereales", infoArroz);

        sistema.agregarAlimento(pollo);
        sistema.agregarAlimento(arroz);

        Comida almuerzo = new Comida("almuerzo");

        System.out.print("Ingrese gramos de pollo para almuerzo: ");
        double gramosPollo = scanner.nextDouble();

        System.out.print("Ingrese gramos de arroz para almuerzo: ");
        double gramosArroz = scanner.nextDouble();

        almuerzo.agregarPorcion(new Porcion(pollo, gramosPollo));
        almuerzo.agregarPorcion(new Porcion(arroz, gramosArroz));

        LocalDate hoy = LocalDate.now();
        sistema.registrarComida(hoy, almuerzo);

        System.out.println(sistema.generarReporteIMC());
        System.out.println(sistema.compararConRecomendaciones(hoy));

        scanner.close();
    }
}
