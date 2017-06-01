package taller5_20171;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
//Leonel Armando Vinasco Zapata Cod. 285869 Materia: Estructuras de datos

public class impresora {
	/*******************************************************************************************************
	************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/
		public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

			
			public Nodo(int prior) {
				//La clase binary heap es un minheap
				prioridad=prior;		
				}
				public int prioridad;
				
				public int compareTo(Nodo segundo) {
					if (this.prioridad==segundo.prioridad)
						return 0;
					//Para que la clase de heapsort ordene al reves los numero
					//es decir el mayor en la raiz, se juega con este metodo
					if (this.prioridad<segundo.prioridad)//normal= a<b->1
						return -1;
					if (this.prioridad>segundo.prioridad)//normal= a>b->1
						return 1;
				return -30;
				}
				
			}

		public static void main(String[] args) throws FileNotFoundException {



	Scanner scan;
	File f = new File("A_3.in");
	if(f.exists()){
		scan = new Scanner(f);
	}else{
		scan = new Scanner(System.in);
	}
    BinaryHeap<Nodo<Integer>> impresora=new BinaryHeap<Nodo<Integer>>();
	MyArrayList<Float> papas=new MyArrayList<Float>();
	String[] input;
	
	input=scan.nextLine().split(" ");
	int numTra= Integer.parseInt(input[0]);
	int pos= Integer.parseInt(input[1]);
	int prior=0;
	
	while(scan.hasNext()){
		input=scan.nextLine().split(" ");
		
		for(int k=0;k<numTra;k++){
			Nodo<Integer> trabajo=new Nodo<Integer>(Integer.parseInt(input[k]));
			impresora.insert(trabajo);
			if (k==pos){
				prior=Integer.parseInt(input[k]);
			}
		}
		
		for(int i=0;i<impresora.currentSize;){
			if(impresora.findMin().prioridad==prior){
				
				
			}
			
			
		}
		
		
		}
		
		
	}
	
	
	
	
	


		public static class BinaryHeap<AnyType extends Comparable<? super AnyType>>
		{
			
		    /**
		     * Construct the binary heap.
		     */
		    public BinaryHeap( )
		    {
		        this( DEFAULT_CAPACITY );
		        
		    }

		    /**
		     * Construct the binary heap.
		     * @param capacity the capacity of the binary heap.
		     */
		    public BinaryHeap( int capacity )
		    {
		        currentSize = 0;
		        array = (AnyType[]) new Comparable[ capacity + 1 ];
		    }
		    
		    /**
		     * Construct the binary heap given an array of items.
		     */
		    public BinaryHeap( AnyType [ ] items )
		    {
		            currentSize = items.length;
		            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

		            int i = 1;
		            for( AnyType item : items )
		                array[ i++ ] = item;
		            buildHeap( );
		    }

		    /**
		     * Insert into the priority queue, maintaining heap order.
		     * Duplicates are allowed.
		     * @param x the item to insert.
		     */
		    public void insert( AnyType x )
		    {
		        if( currentSize == array.length - 1 )
		            enlargeArray( array.length * 2 + 1 );

		            // Percolate up
		        int hole = ++currentSize;
		        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
		            array[ hole ] = array[ hole / 2 ];
		        array[ hole ] = x;
		    }
		 

		    private void enlargeArray( int newSize )
		    {
		            AnyType [] old = array;
		            array = (AnyType []) new Comparable[ newSize ];
		            for( int i = 0; i < old.length; i++ )
		                array[ i ] = old[ i ];        
		    }
		    
		    /**
		     * Find the smallest item in the priority queue.
		     * @return the smallest item, or throw an UnderflowException if empty.
		     */
		    public AnyType findMin( )
		    {
		        if( isEmpty( ) )
		            throw new InputMismatchException( );
		        return array[ 1 ];
		    }

		    /**
		     * Remove the smallest item from the priority queue.
		     * @return the smallest item, or throw an UnderflowException if empty.
		     */
		    public AnyType deleteMin( )
		    {
		        if( isEmpty( ) )
		            throw new InputMismatchException( );

		        AnyType minItem = findMin( );
		        array[ 1 ] = array[ currentSize-- ];
		        percolateDown( 1 );

		        return minItem;
		    }

		    /**
		     * Establish heap order property from an arbitrary
		     * arrangement of items. Runs in linear time.
		     */
		    private void buildHeap( )
		    {
		        for( int i = currentSize / 2; i > 0; i-- )
		            percolateDown( i );
		    }

		    /**
		     * Test if the priority queue is logically empty.
		     * @return true if empty, false otherwise.
		     */
		    public boolean isEmpty( )
		    {
		        return currentSize == 0;
		    }

		    /**
		     * Make the priority queue logically empty.
		     */
		    public void makeEmpty( )
		    {
		        currentSize = 0;
		    }

		    private static final int DEFAULT_CAPACITY = 10;

		    private int currentSize;      // Number of elements in heap
		    private AnyType [ ] array; // The heap array

		    /**
		     * Internal method to percolate down in the heap.
		     * @param hole the index at which the percolate begins.
		     */
		    private void percolateDown( int hole )
		    {
		        int child;
		        AnyType tmp = array[ hole ];

		        for( ; hole * 2 <= currentSize; hole = child )
		        {
		            child = hole * 2;
		            if( child != currentSize &&
		                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
		                child++;
		            if( array[ child ].compareTo( tmp ) < 0 )
		                array[ hole ] = array[ child ];
		            else
		                break;
		        }
		        array[ hole ] = tmp;
		    }

		
		}
		public static class MyArrayList <E> implements Iterable<E> {

			
			private static final int DEFAULT_CAPACITY = 10;
			private int theSize;
			private E[] theItems;
			
			
			
			public MyArrayList() {
			
				clear();
			}
			
			public static void main(String[] args) {
				// TODO Auto-generated method stub

			}
			@Override
			public String toString(){
				String result = "[";
				for (int i=0; i<theSize-1; i++)
					result += theItems[i].toString() + ",";
				if(theSize>0){
					result += theItems[theSize-1].toString();
				}
				return result + "]";
			}
		public boolean add(E dato){

			add(size(),dato);
			
			return true;
		}

		public void add(int idx, E dato){
			
			if (theItems.length == size())
				ensureCapacity( size()*2+1);
			
			for (int i = theSize; i>idx; i--)
				{theItems[i] = theItems[i-1];}
			
			theItems[idx]=dato;
			theSize++;	
		}
			public void clear() {
				
				theSize = 0;
				ensureCapacity( DEFAULT_CAPACITY );

			}
			
			public E get(int idx){
				
				if (idx<0 || idx>=size())
					throw new ArrayIndexOutOfBoundsException("Index"
							+ idx+ ";size" + size());
				return theItems[idx];
			}
			
			public E set(int idx, E newVal){
				if (idx<0 || idx>=size())
					throw new ArrayIndexOutOfBoundsException("Index"
							+ idx+ ";size" + size());
				E old = theItems[idx];
				theItems[idx]=newVal;
				return old;
				
				
			}
			
		@SuppressWarnings("unchecked")
		public void ensureCapacity(int newCapacity){
			if (newCapacity < theSize)
				return;
			E [] old = theItems;
			theItems = (E[]) new Object [newCapacity];
			for( int i =0; i< size(); i++)
				theItems[i]= old[i];
		}
		public int size(){
			//theSize= theItems.length;
			return theSize;
		}
			public java.util.Iterator<E> iterator()
			{return new ArrayListIterator();}
			
			
		public E remove(int idx){
			
			E erased= theItems[idx];
			
			for (int i =idx; i< size()-1; i++){
				theItems[i]=theItems[i+1];
			}
			theSize--;
			return erased;
			
		}
			private class ArrayListIterator implements java.util.Iterator<E>{
				
				private int current=0;
				
				public boolean hasNext()
				{return current < size();}
				
				public E next(){
					if (!hasNext())
						throw new java.util.NoSuchElementException();
					return theItems[current++];
				}
				public void remove()
				{ MyArrayList.this.remove(--current);}

				
			
			}
			}
		

}

