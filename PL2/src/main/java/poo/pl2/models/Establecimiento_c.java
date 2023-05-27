package poo.pl2.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import poo.pl2.views.Establecimiento;
import static poo.pl2.views.Establecimiento.jList2;
import poo.pl2.views.Menu;

public class Establecimiento_c {
    
    public static void cargarCatering() {
        
        if (getRestauranteFromItem().isCateringParaEmpresas()) {
            
            System.out.println("es visible");
            
        }
        else {
            
            Establecimiento.catering.setVisible(false);
            
        }
        
    }
    
    public static Double precioCatering() {
        
        System.out.println(Establecimiento.precioOpcionesCatering);
        return Establecimiento.precioOpcionesCatering;
        
    }
    
    public static void guardarDatosComentario() {
        try {
            FileOutputStream fileOut = new FileOutputStream("copiaSegComentarios.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Establecimiento.comentarios);
            out.close();
            fileOut.close();
            System.out.println("Los comentarios se han guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosComentario() {
        try {
            FileInputStream fileIn = new FileInputStream("copiaSegComentarios.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Establecimiento.comentarios = (List<Comentario>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Los comentarios se han cargado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            // Manejar el caso en que el archivo esté vacío
            System.out.println("tester 1");
            Establecimiento.comentarios = new ArrayList<>();
            System.out.println("No se encontraron comentarios existentes.");
        }
    }

    public static void agregarComentario(Comentario comentario) {
        if (Establecimiento.comentarios == null) {
            System.out.println("El objeto 'comentarios' es nulo.");
        }
        else {
            Establecimiento.comentarios.add(comentario); 
            System.out.println("Se ha agregado un nuevo comentario.");
            mostrarComentario();
        }
    }

    
   public static void mostrarComentario() {
    if (Establecimiento.comentarios != null) {
        StringBuilder sb = new StringBuilder();
        for (Comentario comentario : Establecimiento.comentarios) {
            sb.append("Autor: ").append(comentario.getAutor()).append("\n");
            sb.append("Fecha: ").append(comentario.getFecha()).append("\n");
            sb.append("Contenido: ").append(comentario.getContenido()).append("\n");
            sb.append("Calificación: ").append(comentario.getCalificacion()).append("\n");
            sb.append("----------------------\n");
        }
        Establecimiento.jTextArea1.setText(sb.toString());
    } else {
        Establecimiento.jTextArea1.setText("No hay comentarios disponibles.");
        }
    }

    
    
    public static Comida getComidaFromItem() {
    
        List<Comida> comidas = Restaurante.comidas;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return comidas.stream().filter((elem) -> {
        
            return elem.getNombre().equals(jList2.getSelectedValue());
            
        }).findAny().get();
        
    }

    public static void populateItemBox(JList jl, List<Comida> comidas) {
    
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for(Comida comida : comidas) {
        
            if (comida.getRestaurante().equals(getRestauranteFromItem())) {
            model.addElement(comida.getNombre());
        }
            
        }
        
        jl.setModel(model);
    
    }
    
    public static Restaurante getRestauranteFromItem() {
    
        List<Restaurante> restaurantes = Restaurante.restaurantes;
        // Desde un array con todos los restaurantes...
        // TODO: Revisar Java Streams!!!
        return restaurantes.stream().filter((elem) -> {
        
            return elem.getNombre().equals(Menu.jList1.getSelectedValue());
            
        }).findAny().get();
        
    }
    
}
