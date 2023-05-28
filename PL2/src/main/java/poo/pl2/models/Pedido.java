package poo.pl2.models;

import java.util.List;

/**
 *
 * @author pablo
 */
public class Pedido {

    private int id;
    private Usuario usuario;
    private List<Comida_m> comidas;
    private boolean entregado;

    /**
     * Crea un objeto Pedido con el ID, usuario y lista de comidas proporcionados.
     *
     * @param id       el ID del pedido
     * @param usuario  el usuario que realiza el pedido
     * @param comidas  la lista de comidas del pedido
     */
    public Pedido(int id, Usuario usuario, List<Comida_m> comidas) {
        this.id = id;
        this.usuario = usuario;
        this.comidas = comidas;
        this.entregado = false;
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return el ID del pedido
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el usuario que realiza el pedido.
     *
     * @return el objeto Usuario que realiza el pedido
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Obtiene la lista de comidas del pedido.
     *
     * @return la lista de comidas del pedido
     */
    public List<Comida_m> getComidas() {
        return comidas;
    }

    /**
     * Verifica si el pedido ha sido entregado.
     *
     * @return true si el pedido ha sido entregado, false en caso contrario
     */
    public boolean isEntregado() {
        return entregado;
    }

    /**
     * Establece el estado de entrega del pedido.
     *
     * @param entregado true si el pedido ha sido entregado, false en caso contrario
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    /**
     * Calcula el total del pedido sumando los precios de todas las comidas.
     *
     * @return el total del pedido
     */
    public float calcularTotal() {
        float total = 0;
        for (Comida_m comida : comidas) {
            total += comida.getPrecio();
        }
        return total;
    }

    /**
     * Devuelve una representación en forma de cadena del pedido.
     *
     * @return una cadena que representa el pedido con su ID, nombre de usuario y total
     */
    @Override
    public String toString() {
        return "Pedido #" + id + " - Usuario: " + usuario.getNombre() + " - Total: $" + calcularTotal();
    }
}
