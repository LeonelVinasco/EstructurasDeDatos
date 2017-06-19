package taller5_20171;

import java.util.*;

public class Primero {
    
    
    
    
    static class MaxHeap {

        List<Nodo> datos;

        public MaxHeap() {
            datos = new ArrayList<Nodo>();
        }

        public MaxHeap(Nodo[] datos) {

            this.datos = new ArrayList<Nodo>(datos.length);

            for (int i = 0; i < datos.length; i++) {
                this.datos.add(datos[i]);
            }
            for (int i = padre(datos.length - 1); i >= 0; i--) {
                desplazarAbajo(i);
            }
        }

        private int padre(int u) {
            return (u - 1) / 2;
        }

        private int izquierdo(int p) {
            return 2 * p + 1;
        }

        private int derecho(int p) {
            return 2 * p + 2;
        }

        private void desplazarAbajo(int p) {

            int izq = izquierdo(p);
            int der = derecho(p);
            int mini = p;

            if (izq < datos.size() && datos.get(izq).compareTo(datos.get(mini)) > 0) {
                mini = izq;
            }
            if (der < datos.size() && datos.get(der).compareTo(datos.get(mini)) > 0) {
                mini = der;
            }
            if (p != mini) {
                Collections.swap(datos, mini, p);
                desplazarAbajo(mini);
            }
        }

        private void desplazarArriba(int u) {

            int p = padre(u);
            if (p >= 0 && datos.get(u).compareTo(datos.get(p)) > 0) {
                Collections.swap(datos, u, p);
                desplazarArriba(p);
            }
        }

        
        public Nodo consultar() {

            if (datos.isEmpty()) {
                return null;
            }
            return datos.get(0);
        }

        
        public void insertar(Nodo v) {

            datos.add(v);
            desplazarArriba(datos.size() - 1);
        }

        
        public Nodo extraer() {

            if (datos.isEmpty()) {
                return null;
            }
            Nodo v = datos.get(0);
            datos.set(0, datos.get(datos.size() - 1));
            datos.remove(datos.size() - 1);
            desplazarAbajo(0);
            return v;
        }
    }

    static class Nodo implements Comparable<Nodo> {

        int prioridad;
        int indice;

        public Nodo(int t,int in) {
            this.prioridad = t;
                    this.indice= in;
        }

        
        public int compareTo(Nodo obj) {

            if (this.prioridad == obj.prioridad) {
                return 0;
            } else {
                if (this.prioridad < obj.prioridad) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
        String[] input;	
    	input=scan.nextLine().split(" ");
    	int numTra= Integer.parseInt(input[0]);
    	int pos= Integer.parseInt(input[1]);
 
        
        ArrayQueue<Nodo> cola = new ArrayQueue<>();
        MaxHeap impresora = new MaxHeap();
        Nodo trabajo;
        int dif = numTra-pos;
        for( int i = numTra-1; i >=0; i--){
            int valor = scan.nextInt();
            if( i == dif-1){
              trabajo = new Nodo(valor,1);  
            }else{
                trabajo= new Nodo(valor,0);
            }
            cola.put(trabajo);
            impresora.insertar(trabajo);
            
        }
 
        int t = 0;
        while( t>=0){
          Nodo salir = cola.remove(); 
            
          if(salir.prioridad == impresora.consultar().prioridad){
              impresora.extraer();
              t++;
              
              if(salir.indice==1)break;
          }else{
              cola.put(salir);
          }
          
        }
        System.out.println(t);
    }

}

interface Queue<T> {

    boolean isEmpty();

    T getFrontElement();

    T getRearElement();

    void put(T theObject);

    T remove();
}

class ArrayQueue<T> implements Queue<T> {

    int front;    // one counter clock wise from first element
    int rear;     // position of rear element of queue
    T[] queue;    // elemet array

    //constructors
    public ArrayQueue(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("initialCapacity must be >= 1");
        }
        queue = (T[]) new Object[initialCapacity + 1];
        front = rear = 0;
    }

    public ArrayQueue() {
        this(10);
    }

     //Methods
    public boolean isEmpty() {
        return front == rear;
    }

    public T getFrontElement() {
        if (isEmpty()) {
            return null;
        } else {
            return queue[(front + 1) % queue.length];
        }
    }

    public T getRearElement() {
        if (isEmpty()) {
            return null;
        } else {
            return queue[rear];
        }
    }

    public void put(T theElement) {
        if ((rear + 1) % queue.length == front) {
            T[] newQueue = (T[]) new Object[2 * queue.length];

            int start = (front + 1) % queue.length;
            if (start < 2) {
                System.arraycopy(queue, start, newQueue, 0, queue.length - 1);
            } else {
                System.arraycopy(queue, start, newQueue, 0, queue.length - start);
                System.arraycopy(queue, 0, newQueue, queue.length - start, rear + 1);

            }
            front = newQueue.length - 1;
            rear = queue.length - 2;
            queue = newQueue;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = theElement;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % queue.length;
        T frontElement = queue[front];
        queue[front] = null;
        return frontElement;
    }
}
class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private AnyType[] theItems;
    private int theSize;

    public MyArrayList() {
        clear();
    }


    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index" + idx + "; size" + size());
        }

        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index" + idx + "; size" + size());
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;

        return old;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
       
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }

        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
            
        }

        theItems[idx] = x;
        theSize++;
        
    }

    public AnyType remove(int idx) {
        AnyType removedItem = theItems[idx];

        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;

        return removedItem;
    }

    public java.util.Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<AnyType> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public AnyType next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}