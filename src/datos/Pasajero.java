package datos;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Clase que describe al pasajero
 *
 * @author JJSC
 */
public class Pasajero implements Serializable {

    private String nombre;
    private String identificacion;
    private Date fechaNac;

    public Pasajero() {
    }

    public Pasajero(String nombre, String identificacion, String fechaNac) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        setFechaNac(fechaNac);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        try {
            this.fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
        } catch (ParseException ex) {
        }
    }

    /**
     * Devuelve la edad usando la fecha de nacimiento
     *
     * @return
     */
    public Integer getEdad() {
        Calendar fechaNac_ = Calendar.getInstance();
        fechaNac_.setTime(fechaNac);
        try {
            return Math.abs(Calendar.getInstance().get(Calendar.YEAR) - fechaNac_.get(Calendar.YEAR));
        } catch (ArithmeticException e) {
            return -1;
        }
    }

    @Override
    public String toString() {
        int edad = getEdad();
        if (edad > 0) {
            return "Pasajero{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", fechaNac=" + new SimpleDateFormat("dd/MM/yyyy").format(fechaNac) + ", edad=" + String.valueOf(edad) + "}";
        } else {
            return "ERROR: Datos invalidos";
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.identificacion);
        return hash;
    }

    /**
     * Compara los pasajeros por su identificacion
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pasajero) {
            final Pasajero pasajero = (Pasajero) obj;
            return identificacion.equals(pasajero.getIdentificacion());
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Pasajero pasajero = new Pasajero("Pasajero 1", "11111111", "11/11/1936");
        System.out.println(pasajero);
    }

}
