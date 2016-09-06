import java.util.Scanner;


public class C {
	
	public static class MyStackLink<E> implements Iterable<E>
	{
	private int theSize;
	private int modCount = 0;
	private Node<E> beginMarker;
	private Node<E> endMarker;

	private static class Node<E>{
		public Node (E d, Node<E> p, Node<E> n)
		{data=d; prev=p; next=n;}
			public E data;
			public Node<E> prev;
			public Node<E> next;
			
		}



		public void push(E data){
			
			addFirst(data);
		}
		public E top(){
			return get(0);
		}
		public E pop(){
			return remove(0);
		}
		public MyStackLink() {
		clear();	
		}
		
		public int size()
		{
			return theSize;
		}
	public void clear(){
		doClear();
	}
		public void doClear(){
			beginMarker= new Node<>(null, null, null);
			endMarker = new Node<> (null, beginMarker, null);
			beginMarker.next = endMarker;
			theSize=0;
			modCount++;
		}
		
		//public static void main(String[] args) {
			
		//}

		public boolean add(E x){
			add(size(),x); return true;
		}
		
		public void add(int idx, E x){
			addBefore(getNode(idx,0,size()),x);
			
		}
		public E get(int idx){
			return getNode(idx).data;
		}
		
		private Node <E> getNode (int idx){
			return getNode(idx,0,size()-1);
		}
		private Node<E> getNode (int idx, int lower, int upper)
		{
			Node<E> p;
			if (idx<lower || idx>upper){
				throw new IndexOutOfBoundsException("getNode index"+idx+";size:" + size());
			}
			if (idx < size()/2){
				p=beginMarker.next;
				for(int i=0; i<idx;i++)
					p=p.next;
			}
			else {
				p=endMarker;
				for(int i= size(); i>idx;i--)
					p=p.prev;
			}
			return p;
			
		}
		public E set(int idx, E newVal){
			Node<E> p= getNode(idx);
			E oldVal = p.data;
			p.data = newVal;
			return oldVal;	
		}

		
		public void addFirst(E p){
			add(0,p);	
		}
		public void addLast(E p){
			add(size(),p);	
		}
		public boolean remove (E dato){
			int i= find(dato);
			
			remove(i);
			
			return true;
		}
		
		public E remove(int idx){
			return remove(getNode(idx));
		}
		private E remove (Node<E> p){
			p.next.prev = p.prev;
			p.prev.next= p.next;
			theSize--;
			modCount++;
			return p.data;
		}
		public E removeLast(){
			return remove(getNode(size()-1));
		}
		
		public int find (E x){
			Node<E> p;
				
			for (int i=0;i<size();i++)
				{p= getNode(i);	
			if (p.data==x){
				return i;
			}}
			return 0;
			//Buscar solución Devuelve -40 cuando dato no se encuentra
			
		}
		
		private void addBefore(Node<E> p, E x){
			Node<E> newNode = new Node<>(x,p.prev,p);
			newNode.prev.next = newNode;
			p.prev = newNode;
			theSize++;
			modCount++;
		}
		
		
		 public String toString( )
		    {
		        StringBuilder sb = new StringBuilder( "[ " );

		        for( E x : this )
		            sb.append( x + " " );
		        sb.append( "]" );

		        return new String( sb );
		    }	
		@Override
		public java.util.Iterator<E> iterator()
	{
		return new LinkedListIterator();
		
	}

		private class LinkedListIterator implements java.util.Iterator<E>
	    {
	        private Node<E> current = beginMarker.next;
	        private int expectedModCount = modCount;
	        private boolean okToRemove = false;
	        
	        public boolean hasNext( )
	        {
	            return current != endMarker;
	        }
	        
	        public E next( )
	        {
	            if( modCount != expectedModCount )
	                throw new java.util.ConcurrentModificationException( );
	            if( !hasNext( ) )
	                throw new java.util.NoSuchElementException( ); 
	                   
	            E nextItem = current.data;
	            current = current.next;
	            okToRemove = true;
	            return nextItem;
	        }
	        
	        public void remove( )
	        {
	            if( modCount != expectedModCount )
	                throw new java.util.ConcurrentModificationException( );
	            if( !okToRemove )
	                throw new IllegalStateException( );
	                
	            MyStackLink.this.remove( current.prev );
	            expectedModCount++;
	            okToRemove = false;       
	        }
	    }
		
		



	}
	public static void main(String[] args) {
		
		Scanner scan;
		
		scan = new Scanner(System.in);
	    
		String str_casos[];
		str_casos=scan.nextLine().split(" ");
		String str_pregunta[];
		MyStackLink<Integer> pila= new MyStackLink<Integer>();
		int mayor=0;
	for(int contCasos=0;contCasos<Integer.parseInt(str_casos[0]);contCasos++){
		
		
		str_pregunta=scan.nextLine().split(" ");
		
		if (str_pregunta.length>1){
			
			pila.push(Integer.parseInt(str_pregunta[1]));
			if (Integer.parseInt(str_pregunta[1])>mayor){
		    	mayor=Integer.parseInt(str_pregunta[1]);
		    }
		}else if(Integer.parseInt(str_pregunta[0])==2){
			if (pila.top()==mayor){
				mayor=0;	
			}
			pila.pop();
		}else if(Integer.parseInt(str_pregunta[0])==3){
			System.out.println(mayor);
		}else{}
			
	}
		
		

	

	}
	

}
