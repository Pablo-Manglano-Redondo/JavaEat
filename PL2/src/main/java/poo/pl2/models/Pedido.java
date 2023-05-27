package poo.pl2.models;
import java.util.List;

public class Pedido {

    private int id;
    private Usuario usuario;
    private List<Comida_m> comidas;
    private boolean entregado;

    public Pedido(int id, Usuario usuario, List<Comida_m> comidas) {
        this.id = id;
        this.usuario = usuario;
        this.comidas = comidas;
        this.entregado = false;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Comida_m> getComidas() {
        return comidas;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public float calcularTotal() {
        float total = 0;
        for (Comida_m comida : comidas) {
            total += comida.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " - Usuario: " + usuario.getNombre() + " - Total: $" + calcularTotal();
    }
}

