package listaenlazada;

public class Nodo {
    Object valor; // Variable para lo que sea que va a contener el nodo
    Nodo next; //Nodo siguiente
    int pos; //Posicion del nodo
    
    public Nodo (Object valor){
        this.valor = valor; //Toma el valor que se le indica
        this.next = null; // Como es un nodo nuevo, no enlaza con nada
        this.pos = 0; //Inicializa la posicion en 0
    }
    
    public Object getValor (){ //Retorna el valor del nodo
        return this.valor;
    }
    
    public void setValor (Object valor){ //Cambia el valor del nodo
        this.valor = valor;
    }
}
