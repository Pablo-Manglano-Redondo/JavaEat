package poo.pl2.models;

import java.io.Serializable;

/**
 * La clase TarjetaCredito representa una tarjeta de crédito.
 * Contiene información sobre el número de tarjeta, el titular y la fecha de expiración.
 */
public class TarjetaCredito implements Serializable {
    private String numero;
    private String titular;
    private String fechaExpiracion;
    
    /**
     * Crea una nueva instancia de TarjetaCredito con el número, titular y fecha de expiración especificados.
     * 
     * @param numero el número de la tarjeta de crédito
     * @param titular el titular de la tarjeta de crédito
     * @param fechaExpiracion la fecha de expiración de la tarjeta de crédito
     */
    public TarjetaCredito(String numero, String titular, String fechaExpiracion) {
        this.numero = numero;
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
    }
    
    /**
     * Obtiene el número de la tarjeta de crédito.
     * 
     * @return el número de la tarjeta de crédito
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * Establece el número de la tarjeta de crédito.
     * 
     * @param numero el número de la tarjeta de crédito a establecer
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    /**
     * Obtiene el titular de la tarjeta de crédito.
     * 
     * @return el titular de la tarjeta de crédito
     */
    public String getTitular() {
        return titular;
    }
    
    /**
     * Establece el titular de la tarjeta de crédito.
     * 
     * @param titular el titular de la tarjeta de crédito a establecer
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    /**
     * Obtiene la fecha de expiración de la tarjeta de crédito.
     * 
     * @return la fecha de expiración de la tarjeta de crédito
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    /**
     * Establece la fecha de expiración de la tarjeta de crédito.
     * 
     * @param fechaExpiracion la fecha de expiración de la tarjeta de crédito a establecer
     */
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
