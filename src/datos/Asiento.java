package datos;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase descriptora del asiento 
 * 
 * @author JJSC
 */
public class Asiento implements Serializable, Comparable<Asiento> {

    private Integer numero;
    private Character seccion;

    public Asiento() {
    }

    public Asiento(Integer numero, Character seccion) {
        this.numero = numero;
        this.seccion = seccion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = Character.toUpperCase(seccion);
    }

    /**
     * Devuelve la categoria (clase) en la que se encuentra el asiento
     * 
     * @return
     * @throws Error 
     */
    public String getClase() throws Error {
        try {
            if ((numero.compareTo(1) >= 0) && (numero.compareTo(5) <= 0)) {
                return "PRIMERA CLASE";
            }
            if ((numero.compareTo(6) >= 0) && (numero.compareTo(15) <= 0)) {
                return "CLASE ECONOMICA";
            }
            throw new Error("No se pudo obtener la clase");
        } catch (NullPointerException | NumberFormatException e) {
            throw new Error("No se pudo obtener la clase");
        }

    }

    /**
     * Devuelve la ubicacion del asiento independiente de la categoria
     * 
     * @return PASILLO o VENTANA
     * @throws Error 
     */
    public String getUbicacion() throws Error {
        try {
            switch (seccion) {
                case 'A':
                case 'F':
                    return "VENTANA";
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                    return "PASILLO";
                default:
                    return null;
            }
        } catch (NullPointerException e) {
            throw new Error("No se pudo obtener la ubicacion");
        }
    }

    @Override
    public String toString() {
        try {
            return "Asiento{clase=" + getClase() + ", numero=" + numero + seccion + ", ubicacion=" + getUbicacion() + "}";
        } catch (Error e) {
            return "ERROR: Datos invalidos";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Asiento) {
            Asiento asiento = (Asiento) obj;
            return (numero.toString()+seccion.toString()).equals(asiento.getNumero().toString()+asiento.getSeccion());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.numero);
        hash = 23 * hash + Objects.hashCode(this.seccion);
        return hash;
    }
   
    /**
     * Compara los asientos concatenando el numero y la seccion
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Asiento o) {
        return (numero.toString() + seccion.toString()).compareTo(o.getNumero().toString() + o.getSeccion().toString());
    }

}
