package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import utilidades.CompararPasajero;

/**
 * Clase descriptiva del avion
 * 
 * @author JJSC
 */
public class Avion implements Serializable{
    private String vuelo;
    private String aerolinea;
    private Map<Asiento, Pasajero> asientos;
    private List<Pasajero> pasajeros;

    public Avion() {
        inicializa();
    }

    public Avion(String vuelo, String aerolinea) {
        this.vuelo = vuelo;
        this.aerolinea = aerolinea;
        inicializa();
    }
    
    /**
     * LLena la lista con los asientos 
     */
    private void inicializa() {
        pasajeros = new ArrayList();
        asientos = new TreeMap();
        for (int i = 1; i <= 15; i++) {
            for (int j = 65; j <= 70; j++) {
                asientos.put(new Asiento(i, (char) j), null);
            }
        }
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }
        

    public Map<Asiento, Pasajero> getAsientos() {
        return asientos;
    }
    
    /**
     * Devuelve la lista de asientos disponibles
     * 
     * @param categoria
     * @param ubicacion
     * @return lista de asientos
     */
    public List<Asiento> getAsientosDisponibles(String categoria, String ubicacion) {
        List<Asiento> resultado = new ArrayList();
        for (Asiento asiento: asientos.keySet()) {
            Pasajero pasajero = asientos.get(asiento);
            if ((pasajero == null) && 
                    asiento.getUbicacion().equals(ubicacion) && 
                    asiento.getClase().equals(categoria)) {
                resultado.add(asiento);
            }
        }
        Collections.sort(resultado);
        return resultado;
    }

    /**
     * Reserva un asiento a un pasajero
     * 
     * @param asiento
     * @param pasajero
     * @return verdadero si la reserva se realizo correctamente
     * @throws Error 
     */
    public boolean reservaAsiento(Asiento asiento, Pasajero pasajero) throws Error {
        if ((asiento == null) || (!asientos.containsKey(asiento))) {
            throw new Error("Asiento no existe en el avion");
        }
        if ((pasajero != null)) {
            if (Collections.binarySearch(pasajeros, pasajero, new CompararPasajero()) >= 0) {
                throw new Error("Pasajero ya existe en la lista de reserva");
            }
        } else {
            throw new Error("Pasajero esta en blanco");
        }

        if ((asientos.get(asiento) == null)) {
            asientos.put(asiento, pasajero);
            pasajeros.add(pasajero);
            return true;
        } else {
            throw new Error("Asiento esta ocupado");
        }
    }
    
    /**
     * Calcula estadisticas de pasajeros  
     * @return un map con varios datos
     */
    public Map<String, Integer> getEstadisticaPasajeros() {
        Map resultado = new LinkedHashMap<String, Integer>() {
            {
                put("VENTANA",0);
                put("PASILLO",0);
                put("MENORES EDAD",0);
                put("MAYORES EDAD",0);
                put("TERCERA EDAD",0);
            }
        };
        for (Asiento asiento: asientos.keySet()) {
            Pasajero pasajero = asientos.get(asiento);
            if (pasajero != null) {
                resultado.put(asiento.getUbicacion(), ((int)resultado.get(asiento.getUbicacion()))+1);
                int edad = pasajero.getEdad();
                if (edad < 10) {
                    resultado.put("MENORES EDAD", ((int)resultado.get("MENORES EDAD"))+1);
                }
                if (edad >= 80) {
                    resultado.put("MAYORES EDAD", ((int)resultado.get("MAYORES EDAD"))+1);
                }
                if ((edad >= 60) && (edad < 80)) {
                    resultado.put("TERCERA EDAD", ((int)resultado.get("TERCERA EDAD"))+1);
                }
            }
        }
        return resultado;
    } 

}
