package ClasesNormales;

import com.mycompany.ed_p1_grupo12_parcial2.MenuController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class BinaryTree<E> {
    private NodeBinaryTree<E> root;

    public BinaryTree() { //Este caso me sirve
        this.root = null;
    }

    public BinaryTree(E content) {
        this.root = new NodeBinaryTree<>(content);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        if (!this.isEmpty()) {
            return root.getLeft() == null && root.getRight() == null;
        }
        return false;
    }

    public NodeBinaryTree<E> getRoot() {
        return root;
    }

    public void setRoot(NodeBinaryTree<E> root) {
        this.root = root;
    }
    
    public boolean addPregunta(E contenido) {
        if (this.isEmpty()) {
            this.root = new NodeBinaryTree<>(contenido);
            return true;
        }

        Stack<NodeBinaryTree<E>> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            NodeBinaryTree<E> currentNode = stack.pop();

            if (currentNode.getLeft() == null) {
                currentNode.setLeft(new BinaryTree<>(contenido));
                return true;
            } else {
                stack.push(currentNode.getLeft().getRoot());
            }

            if (currentNode.getRight() == null) {
                currentNode.setRight(new BinaryTree<>(contenido));
                return true;
            } else {
                stack.push(currentNode.getRight().getRoot());
            }
        }

        return false; // En teoría, nunca se debería llegar aquí
    }

    
    public void crearArbol() throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ruta_de_tu_fxml.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        //String nombreArchivo = controller.getArchivoPreguntas();
        
        String nombre= ""; //En caso de no funcionar pon "Preguntas" nombreArchivo
        String direccion=LeerArchivo.texto;
        LeerArchivo archivo=new LeerArchivo(direccion+nombre+".txt");
        ArrayList<String> lineasPreguntas=archivo.leer();
        
        
        for (String pregunta : lineasPreguntas) {
            this.addPregunta((E) pregunta); 
        }
    }
    /*
    public void crearArbol() throws IOException { 
        // Cargar el archivo FXML y obtener el controlador
        FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/com.mycompany.ed_p1_grupo12_parcial2/Menu"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        String nombreArchivo = controller.getArchivoPreguntas();

        // Leer preguntas desde archivo
        String nombre = nombreArchivo; // En caso de no funcionar pon "Preguntas"
        String direccion = LeerArchivo.texto;
        LeerArchivo archivo = new LeerArchivo(direccion + nombre + ".txt");
        ArrayList<String> lineasPreguntas = archivo.leer();

        // Añadir preguntas al árbol
        for (String pregunta : lineasPreguntas) {
            this.addPregunta((E) pregunta); 
        }

        // Leer respuestas desde archivo
        String nombreRespuesta = controller.getArchivoRespuestas();
        LeerArchivo archivo2 = new LeerArchivo(direccion + nombreRespuesta + ".txt");
        ArrayList<String> lineasRespuestas = archivo2.leer();

        // Procesar respuestas
        for (String respuesta : lineasRespuestas) {
            String[] lineaDeRespuesta = respuesta.split(" ");
            Stack<BinaryTree<E>> s = new Stack<>();
            s.push(this);

            // Iterar sobre las respuestas
            for (int i = 0; i < lineaDeRespuesta.length; i++) {
                String contenido = lineaDeRespuesta[i];
                boolean esHijoIzquierdo = contenido.equals("si");
                boolean esHijoDerecho = contenido.equals("no");

                if (i > 0) { // Omite el primer elemento, ya que es el nombre del animal
                    BinaryTree<E> tope = s.peek(); //Para mi es pop

                    // Navegar en el árbol
                    if (esHijoIzquierdo) {
                        if (tope.getRoot().getLeft() != null) {
                            s.push(tope.getRoot().getLeft());
                        } else {
                            // Agregar el nodo en el caso de que sea el último paso
                            if (i == lineaDeRespuesta.length - 1) {
                                String animal = lineaDeRespuesta[0];
                                boolean ultimaIzquierda = lineaDeRespuesta[i].equals("si");
                                this.addNodeToSpecific(tope, (E) animal, ultimaIzquierda);
                            }
                        }
                    } else if (esHijoDerecho) {
                        if (tope.getRoot().getRight() != null) {
                            s.push(tope.getRoot().getRight());
                        } else {
                            // Agregar el nodo en el caso de que sea el último paso
                            if (i == lineaDeRespuesta.length - 1) {
                                String animal = lineaDeRespuesta[0];
                                boolean ultimaIzquierda = lineaDeRespuesta[i].equals("si");
                                this.addNodeToSpecific(tope, (E) animal, ultimaIzquierda);
                            }
                        }
                    }
                }
            }
            
        }
    }
    */
    
    /*
    public boolean addPregunta(E contenido) {
        // Caso base: Si el árbol está vacío, establece la raíz
        if (this.isEmpty()) {
            this.root = new NodeBinaryTree<>(contenido);
            
            return true;
        }

        // Usa una pila para recorrer el árbol en profundidad (DFS)
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            BinaryTree<E> currentNode = stack.pop();

            // Si el hijo izquierdo es nulo, agrega el nuevo nodo allí
            if (currentNode.getRoot().getLeft() == null) {
                BinaryTree<E> newNodeiz= new BinaryTree<>(contenido);

                currentNode.getRoot().setLeft(newNodeiz);
                currentNode.getRoot().setRight(newNodeiz);
                
                return true;
            } else {
                stack.push(currentNode.getRoot().getLeft());
            }

            // Si el hijo derecho es nulo, agrega el nuevo nodo allí
            if (currentNode.getRoot().getRight() == null) {
                BinaryTree<E> newNodeiz= new BinaryTree<>(contenido);
                
                currentNode.getRoot().setRight(newNodeiz);
                currentNode.getRoot().setLeft(newNodeiz);

                return true;
            } else {
                stack.push(currentNode.getRoot().getRight());
            }
        }

        return false; // En teoría, nunca se debería llegar aquí
    */
    
    //ta bien:)
    public boolean addNodeToSpecific(BinaryTree<E> parentNode, E contenido, boolean isLeft) {
        if (parentNode == null) {
            return false; // Nodo padre nulo, no se puede agregar
        }

        BinaryTree<E> newNode = new BinaryTree<>(contenido);

        if (isLeft) {
            if (parentNode.getRoot().getLeft() == null) {
                parentNode.getRoot().setLeft(newNode);
                return true;
            } else {
                return false; // El hijo izquierdo ya está ocupado
            }
        } else {
            if (parentNode.getRoot().getRight() == null) {
                parentNode.getRoot().setRight(newNode);
                return true;
            } else {
                return false; // El hijo derecho ya está ocupado
            }
        }
    }
    
}