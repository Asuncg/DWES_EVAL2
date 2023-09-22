package Laboral;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AgregarEmpleados {
    public static void main(String[] args) throws IOException {

        FileWriter listaEmpleados = null;
        PrintWriter incluye = null;
        Scanner sc = new Scanner(System.in);

        try {
            listaEmpleados = new FileWriter("listaEmpleados.txt", true); // Abre el archivo en modo de apertura para añadir
            incluye = new PrintWriter(listaEmpleados);

            while (true) {
                System.out.println("Ingrese los datos del empleado (nombre, dni, sexo, categoría, años) o escriba 'salir' para terminar:");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("salir")) {
                    break;
                }
                incluye.println(input);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (listaEmpleados != null) {
                listaEmpleados.close();
            }
        }

    }
}
