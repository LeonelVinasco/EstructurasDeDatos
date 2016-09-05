import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class T2A_1 {
	/*******************************************************************************************************
	************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/
		public static class Nodo<AnyType> implements Comparable<Nodo<AnyType>>{

			public Nodo(AnyType ide, int prior/*, int valorNUm/*/) {
			id=ide;	
			prioridad=prior;
			//val123=valorNUm;
			}
			public int prioridad;
			public AnyType id;
			//public int val123;
			
			public int compareTo(Nodo segundo) {
				if (this.prioridad==segundo.prioridad)
					return 0;
				//Para que la clase de heapsort ordene al reves los numero
				//es decir el mayor en la raiz, se juega con este metodo
				if (this.prioridad>segundo.prioridad)//normal= a<b->1
					return 1;
				if (this.prioridad<segundo.prioridad)//normal= a>b->1
					return -1;
			return -30;
			}
			public static void main(String[] args) {
			}
		}
		/*******************************************************************************************************
		************CLASE AUXILIAR PARA RESOLVER EL PROBLEMA*************************************************/	
		public T2A_1() {
			// TODO Auto-generated constructor stub
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
		    
		    public static void main(String[] args) throws FileNotFoundException {
				// TODO Auto-generated method stub

				

				Scanner scan;
				File file = new File("D_1.in");
				if(file.exists()){
					scan = new Scanner(file);
				}else{
					scan = new Scanner(System.in);
				}
				
				
				while(scan.hasNext()){
					String str_cantNums[];
					str_cantNums=scan.nextLine().split(" ");
					int cantNums=Integer.parseInt(str_cantNums[0]);
					String str_nums[];
					str_nums=scan.nextLine().split(" ");
					String str_cantIndices[];
					str_cantIndices=scan.nextLine().split(" ");
					String str_indices[];
					str_indices=scan.nextLine().split(" ");
					
					
				BinaryHeap<Nodo<Integer>> procesos= new BinaryHeap<Nodo<Integer>>();
				
				
				for(int agregarNums=0;agregarNums<cantNums;agregarNums++){
					Nodo<Integer> myNodo = new Nodo<Integer>(Integer.parseInt(str_nums[agregarNums]),Integer.parseInt(str_indices[agregarNums]));
			        procesos.insert(myNodo);
			}
				for( int i = 0; i < cantNums; i++ ){
		            if( !procesos.isEmpty()){
		                System.out.println( procesos.deleteMin().id );}
				
				}
				}
		}
		    
		       
		}
		
	

}
