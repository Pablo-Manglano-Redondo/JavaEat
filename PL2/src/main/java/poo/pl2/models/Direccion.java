package poo.pl2.models;

import java.io.Serializable;

/**
 * Esta clase representa una dirección con la calle, número, ciudad y código postal.
 */
public class Direccion implements Serializable {
    private String calle;
    private String numero;
    private String ciudad;
    private String codigoPostal;

    /**
     * Constructor de la clase Direccion.
     *
     * @param calle la calle de la dirección
     * @param numero el número de la dirección
     * @param ciudad la ciudad de la dirección
     * @param codigoPostal el código postal de la dirección
     */
    public Direccion(String calle, String numero, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene la calle de la dirección.
     *
     * @return la calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Obtiene el número de la dirección.
     *
     * @return el número de la dirección
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Obtiene la ciudad de la dirección.
     *
     * @return la ciudad de la dirección
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene el código postal de la dirección.
     *
     * @return el código postal de la dirección
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece la calle de la dirección.
     *
     * @param calle la calle de la dirección a establecer
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Establece el número de la dirección.
     *
     * @param numero el número de la dirección a establecer
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Establece la ciudad de la dirección.
     *
     * @param ciudad la ciudad de la dirección a establecer
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Establece el código postal de la dirección.
     *
     * @param codigoPostal el código postal de la dirección a establecer
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
