package listaenlazada;

public class Lista {
    int length; //Variable para el largo de la lista
    Nodo head; //Variable para el primer nodo de la lista
    
    public Lista (){
        this.length = 0; //inicializa el largo de la lista en 0
        this.head = null; //Comienza sin ningun nodo dentro de la lista
    }
    
    public int getLength (){ //Retorna el largo de la lista
        return this.length;
    }
    
    public void add (Object valor){ //Agrega un nodo al final de la lista
        if (this.head == null){ //En caso de que la lista esté vacía
            this.head = new Nodo (valor); //Crea un nodo con el valor indicado
        }else{
            Nodo temp = this.head; //Crea una variable temporal para recorrer la lista
            while (temp.next != null){ //Recorre la lista buscando un nodo que no tenga next (el ultimo)
                temp = temp.next; //Avanza un nodo
            }
            temp.next = new Nodo (valor); //Enlazada el ultimo nodo con el nuevo nodo creado
            temp.next.pos = this.length; //Le cambia la posicion al nodo
        }
        this.length++; //aumenta el largo de la lista
    }
    
    public void show (){ //Muesta la lista en la consola, en un formato similar a una lista de Python
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
