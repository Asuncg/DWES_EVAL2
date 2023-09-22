package Laboral;

import java.io.*;

public class CalculaNominas {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("listaempleados.txt"));
            String line;

            while ((line = reader.readLine()) != null) {

                Empleado empleado = parseEmpleado(line);
                escribe(empleado);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }
    }

    private static Empleado parseEmpleado(String input) throws DatosNoCorrectosException {
        // Separar la línea en partes (nombre, dni, sexo, categoría, años)
        String[] partes = input.split(",");
        if (partes.length < 5) {
            throw new DatosNoCorrectosException("La línea no tiene suficientes datos.");
        }

        String nombre = partes[0].trim();
        String dni = partes[1].trim();
        char sexo = partes[2].trim().charAt(0);
        int categoria = Integer.parseInt(partes[3].trim());
        int anyos = Integer.parseInt(partes[4].trim());

        // Crear y retornar una instancia de Empleado
        return new Empleado(nombre, dni, sexo, categoria, anyos);
    }

    private static void escribe(Empleado empleado) {
        Nomina nomina = new Nomina();

        empleado.imprime();
        System.out.println("Sueldo: " + nomina.sueldo(empleado.getCategoria(), empleado.anyos) + "€");
    }
}
