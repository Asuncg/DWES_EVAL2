package Laboral;

/**
 * @Author: Asun C.G
 * La clase CalculaNomias realiza los cálculos necesario para saber el valor de la nómina del empleado.
 */

public class CalculaNominas {

    /**
     * El método principal de la aplicación que demuestra el cálculo de nóminas para dos empleados.
     */
    public static void main(String[] args) {

        try {
            Empleado empleado1 = new Empleado("James Cosling", "dni=32000032G", 'M', 4, 7);
            Empleado empleado2 = new Empleado("Ada Lovelace", "32000031R", 'F');

            escribe(empleado1, empleado2);

            empleado2.incrAnyo();

            empleado1.setCategoria(9);

            escribe(empleado1, empleado2);

        } catch (DatosNoCorrectosException e) {
            System.out.println("Datos no correctos: " + e.getMessage());
        }
    }

    /**
     * Imprime la información del empleado y calcula sus respectivos sueldos sueldo.
     *
     * @param empleado1 El primer empleado.
     * @param empleado2 El segundo empleado.
     */
    private static void escribe(Empleado empleado1, Empleado empleado2) {

        Nomina nomina = new Nomina();

        empleado1.imprime();
        System.out.println("Sueldo: " + nomina.sueldo(empleado1.getCategoria(), empleado1.anyos) + "€");
        empleado2.imprime();
        System.out.println("Sueldo: " + nomina.sueldo(empleado2.getCategoria(), empleado2.anyos) + "€");
    }
}
