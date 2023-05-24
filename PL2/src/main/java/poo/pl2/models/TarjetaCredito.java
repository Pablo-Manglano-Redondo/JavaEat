package poo.pl2.models;

public class TarjetaCredito {
    private String numero;
    private String titular;
    private String fechaExpiracion;
    
    public TarjetaCredito(String numero, String titular, String fechaExpiracion) {
        this.numero = numero;
        this.titular = titular;
        this.fechaExpiracion = fechaExpiracion;
    }
    
    // Getters y setters
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
