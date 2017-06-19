package taller5_20171;


	

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


	public class PAPAs {

	/*******************************************************************************************************
	************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/
		public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

			
			public Nodo(float prior) {
				
				prioridad=prior;		
				}
				public float prioridad;
				
				public int compareTo(Nodo segundo) {
					if (this.prioridad==segundo.prioridad)
						return 0;
					//Para que la clase de heapsort ordene al reves los numero
					//es decir el mayor en la raiz, se juega con este metodo
					if (this.prioridad<segundo.prioridad)//normal= a<b->1
						return 1;
					if (this.prioridad>segundo.prioridad)//normal= a>b->1
						return -1;
				return -30;
				}
				
			}
			
//			public Nodo(AnyType ide, int prior) {
//			id=ide;	
//			prioridad=prior;		
//			}
//			public int prioridad;
//			public AnyType id;
//			
//			public int compareTo(Nodo segundo) {
//				if (this.prioridad==segundo.prioridad)
//					return 0;
//				//Para que la clase de heapsort ordene al reves los numero
//				//es decir el mayor en la raiz, se juega con este metodo
//				if (this.prioridad<segundo.prioridad)//normal= a<b->1
//					return 1;
//				if (this.prioridad>segundo.prioridad)//normal= a>b->1
//					return -1;
//			return -30;
//			}
			
		
		/*******************************************************************************************************
		************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/	
		
		
		public PAPAs() {
			// TODO Auto-generated constructor stub
		}

		public static void main(String[] args) throws FileNotFoundException {

			PAPAs pa= new PAPAs();

	Scanner scan;
	File f = new File("A_3.in");
	if(f.exists()){
		scan = new Scanner(f);
	}else{
		scan = new Scanner(System.in);
	}

	MyArrayList<Float> papas=new MyArrayList<Float>();
	String[] input;
	input=scan.nextLine().split(" ");
	int numEstudiantes= Integer.parseInt(input[0]);
	int inicio;//=Integer.parseInt(input[1]);
	int fin;//=Integer.parseInt(input[1]);
	
	input=scan.nextLine().split(" ");
	//ingresa promedios en arraylist
	for (int contPapasEstu=0; contPapasEstu<numEstudiantes;contPapasEstu++){
			papas.add(Float.parseFloat(input[contPapasEstu]));
		
		}
	
	input=scan.nextLine().split(" ");
	int numOps= Integer.parseInt(input[0]);
	float suma;
	for (int j=0; j<numOps;j++){
		input=scan.nextLine().split(" ");
		if(input[0].equals("cambiar")){
			papas.remove(Integer.parseInt(input[1]));
			papas.add(Integer.parseInt(input[1]), Float.parseFloat(input[2]));
		}else if(input[0].equals("consultar")){
			BinaryHeap<Float> minheap=new BinaryHeap<Float>();
			BinaryHeap<Nodo<Float>> maxheap=new BinaryHeap<Nodo<Float>>();
			inicio=Integer.parseInt(input[1]);
			fin=Integer.parseInt(input[2]);
			suma=0;
			papas.set(idx, newVal)
			for(int k=inicio;k<=fin;k++){
				suma+=papas.get(k);
				minheap.insert(papas.get(k));
				Nodo<Float> nodo=new Nodo(papas.get(k));
				maxheap.insert(nodo);
			}
			String str = String.format(Locale.US,"%.1f", suma);
			String str1 = String.format(Locale.US,"%.1f", maxheap.findMin().prioridad);
			String str2 = String.format(Locale.US,"%.1f", minheap.findMin());
			
			System.out.println(str+" "+str1+" "+str2);
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

