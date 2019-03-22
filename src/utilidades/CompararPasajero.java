/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import datos.Pasajero;
import java.util.Comparator;

/**
 * Clase para establecer ordenamiento segun comparacion de identificaciones
 * 
 * @author JJSC
 */
public class CompararPasajero implements Comparator<Pasajero> {
    @Override
    public int compare(Pasajero o1, Pasajero o2) {
        return o1.getIdentificacion().compareTo(o2.getIdentificacion());
    }

}
