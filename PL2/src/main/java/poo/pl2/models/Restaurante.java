package poo.pl2.models;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import static poo.pl2.models.Usuario.usuarios;

public class Restaurante {

    private String cif;
    private String nombre;
    private Direccion direccion;
    private String especialidad;
    private double calificacion;
    private double gastosEnvio;
    private int tiempoMedioEnvio;
    private boolean cateringParaEmpresas;
    private List<Comida> comidas;

    public Restaurante(String cif, String nombre, Direccion direccion, String especialidad, double gastosEnvio, int tiempoMedioEnvio, boolean cateringParaEmpresas) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.calificacion = 0;
        this.gastosEnvio = gastosEnvio;
        this.tiempoMedioEnvio = tiempoMedioEnvio;
        this.cateringParaEmpresas = cateringParaEmpresas;
        this.comidas = new ArrayList<Comida>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoMedioEnvio() {
        return tiempoMedioEnvio;
    }

    public void setTiempoMedioEnvio(int tiempoMedioEnvio) {
        this.tiempoMedioEnvio = tiempoMedioEnvio;
    }

    public boolean isCateringParaEmpresas() {
        return cateringParaEmpresas;
    }

    public void setCateringParaEmpresas(boolean cateringParaEmpresas) {
        this.cateringParaEmpresas = cateringParaEmpresas;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void agregarComida(Comida comida) {
        this.comidas.add(comida);
    }

    public void eliminarComida(Comida comida) {
        this.comidas.remove(comida);
    }

    public double calcularPrecioCatering(List<Comida> comidas, List<Servicio> servicios, boolean espacioPrivado) {
        double totalComidas = 0;
        for (Comida comida : comidas) {
            totalComidas += comida.getPrecio();
        }

        double totalServicios = 0;
        for (Servicio servicio : servicios) {
            totalServicios += servicio.getPrecio();
        }

        double total = totalComidas + totalServicios;
        if (espacioPrivado) {
            total += 1000;
        }
        return total;
    }
}

