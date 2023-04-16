package poo.pl2.models;

public class Mesa {
    
    private int numeroMesa;
    private boolean ocupada;
    
    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.ocupada = false;
    }
    
    public int getNumeroMesa() {
        return this.numeroMesa;
    }
    
    public boolean estaOcupada() {
        return this.ocupada;
    }
    
    public void ocuparMesa() {
        this.ocupada = true;
    }
    
    public void liberarMesa() {
        this.ocupada = false;
    }
}

