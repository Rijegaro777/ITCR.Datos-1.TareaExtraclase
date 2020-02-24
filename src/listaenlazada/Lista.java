package listaenlazada;
/**
 * Clase Lista
 * 
 * Crea una lista enlazada.
 * 
 * @author gatge
 */
public class Lista {
    int length; 
    Nodo head;
    
    public Lista (){
        this.length = 0; 
        this.head = null;
    }
    
    /**
     * @return un int con el largo que tenga la lista.
     */
    public int getLength (){ 
        return this.length;
    }
    
    /**
     * Añade el objeto que reciba como parámetro a la lista.
     * @param valor El objeto que se agregará.
     */
    public void add (Object valor){
        if (this.head == null){ 
            this.head = new Nodo (valor); 
        }else{
            Nodo temp = this.head; 
            while (temp.next != null){ 
                temp = temp.next;
            }
            temp.next = new Nodo (valor);
            temp.next.pos = this.length; 
        }
        this.length++; 
    }
    
    /**
     * Imprime la lista en la consola.
     */
    public void show (){
        if (this.head != null){
            if (this.length == 1){
                System.out.println ("[" + String.valueOf(this.head.getValor ()) + "]");
            }else{
                Nodo temp = this.head;
                String result = "[";
                    while (temp.next != null){
                        result += String.valueOf(temp.getValor()) + ", ";
                        temp = temp.next;
                    }
                    result += String.valueOf(temp.getValor()) + "]";
                    System.out.println (result);
            }
        }else{
            System.out.println ("[]");
        }
    }
    
    /**
     * Elimina el objeto que se encuentre en 
     * la posición indicada de la lista.
     * @param pos la posición de la lista que se desea eliminar; Comienza en 0.
     */
    public void delete (int pos){
        Nodo temp = this.head;
        boolean cambiado = false;
        if (pos >= this.length){
            System.out.println ("Indice fuera de rango");            
        }
        else if (pos == 0){
            this.head = this.head.next;
            this.length--;
            while (temp.next != null){
                temp.next.pos--;
                temp = temp.next;
            }
        }else{
            while (temp.next != null){
                if (cambiado == true){
                    while (temp.next.pos != pos + 1){
                        temp = temp.next;
                    }
                    while (temp.next != null){
                        temp.next.pos--;
                        temp = temp.next;
                    }
                }
                else if (temp.next.pos == pos){
                    temp.next = temp.next.next;
                    this.length--;
                    cambiado = true;
                }else{
                    temp = temp.next;
                }
            }
        }

    }
    
    /**
     * @param pos la posición de la lista que se desea consultar; Comienza en 0.
     * @return devuelve el objeto que esté en la posicion indicada de la lista.
     */
    public Object getPos (int pos){
        Nodo temp = this.head;
        if (pos == 0){
            return this.head.getValor();
        }else{
            while (temp.next.pos != pos){
                temp = temp.next;
            }
        }
        return temp.next.getValor();
    }
    /**
     * Cambia el objeto en la posicion de la 
     * lista indicada por el objeto que se reciba como parámetro.
     * @param pos la posicion de la lista que se desea cambiar; Comienza en 0.
     * @param valor el objeto que se desea colocar en dicha posición.
     */
    public void setPos (int pos, Object valor){
        Nodo temp = this.head;
        if (pos == 0){
            this.head.setValor(valor);
        }else{
            while (temp.next.pos != pos){
                temp = temp.next;
            }
            temp.next.setValor(valor);
        }
    }
}
