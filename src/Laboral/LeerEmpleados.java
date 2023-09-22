package Laboral;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeerEmpleados {
    public static void main(String[] args) throws IOException {

        FileWriter listaEmpleados = null;
        PrintWriter incluye = null;

        try {
            listaEmpleados = new FileWriter("listaEmpleados.txt");
            incluye = new PrintWriter(listaEmpleados);

            incluye.println("Asun");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            listaEmpleados.close();
        }

    }


}
