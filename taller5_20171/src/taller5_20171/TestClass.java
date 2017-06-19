package taller5_20171;


import java.util.Scanner;

import static java.lang.Integer.max;
 
 
class TestClass {
    
	 public static void main(String args[] ) throws Exception {
	    	Scanner scan = new Scanner(System.in);
	        String[] input;	
	    	input=scan.nextLine().split(" ");
	    	int numComandos= Integer.parseInt(input[0]);
	    	Clases clase1 = new Clases();
	        
	        for (int contadorComandos = 1; contadorComandos <=numComandos; contadorComandos++) {
	            String[] comando = scan.nextLine().split(" ");
	                if("crear".equals(comando[0])){
	                	 TreeAvl arbol = new TreeAvl();
	                	long id = Long.parseLong(comando[1]);
	                    long x = Long.parseLong(comando[2]);
	                    arbol.add(x, 1);
	                    clase1.add(id, arbol);
	                }else if("insertar".equals(comando[0])){
	                    long id = Long.parseLong(comando[1]);
	                    boolean Aux = clase1.contiene(id);
	                    if(Aux == false){
	                        
	                    }else{
	                        long x = Long.parseLong(comando[2]);
	                        clase1.cambiar(id, x);
	                    }
	                }else if("unir".equals(comando[0])){
	                    long idx = Long.parseLong(comando[1]);
	                    long idy = Long.parseLong(comando[2]);
	                    clase1.unir(idx, idy);
	                }else if("ocurrencia".equals(comando[0])){
	                    long id = Long.parseLong(comando[1]);
	                    boolean Aux = clase1.contiene(id);
	                    if(Aux == false){
	                        
	                    }else{
	                        long x = Long.parseLong(comando[2]);
	                        int ocurrencia = clase1.ocurrencia(id, x);
	                        System.out.println("ocurrencia: "+ocurrencia);
	                    }
	                }
	                
	                
	    }
	    }
	
	
	
   static class TreeAvl {
    NodoAvl raiz;            
    int nNodos;              
    
     public class NodoAvl{
        int asist, height;
        long valor;
        NodoAvl izquierda, derecha;
        public NodoAvl(long valor, int asisten){
            this.valor = valor;
            this.asist = asisten;
            derecha = izquierda = null;
        }
    }
    public TreeAvl() {
	raiz = null;
	nNodos = 0;
    }
 
    /**
     * Metodo para dejar vacio un arbol 
     */
    public void vaciar() {
	raiz = null;
    }
 
    /**
     * Metodo para determinar si un arbol esta vacio.
     * @return true -- si el arbol esta vacio y false en otro caso.
     */
    public boolean estaVacio() {
	return raiz == null;
    }
 
    /**
     * Metodo para conocer el tamano de un arbol
     * @return int -- cantidad de elementos en el arbol
     */
    public int size() {
	return nNodos;
    }
 
 
    /**
     * Metodo para insertar un nodo en el arbol, ignorando los duplicados y 
     * balanceando  si es necesario.
     * @param id el elemento a insertar.
     * @param nasis
     */
    public void add(long id, int nasis) {
	raiz = add(id, raiz, nasis);
    }
    
    /*
     * Metodo interno, auxiliar, para add en un arbol.
     * @param dato -- elemento a add.
     * @param n -- nodo raiz del arbol.
     * @return NodoAvl -- la nueva raiz.
     */
    public NodoAvl add(long id, NodoAvl n, int nasis) {
	if(n == null) {
	    n = new NodoAvl(id,nasis);// estudiante id asistencias 0 
	    nNodos ++;
	}
	else if(id < n.valor)  {
	    n.izquierda = add(id, n.izquierda, nasis);
	    if(height(n.izquierda) - height(n.derecha) == 2)
		if(id < n.izquierda.valor )
		    n = rotarIzq(n);
		else {
		    n.izquierda = rotarDer(n.izquierda);
		    n = rotarIzq(n);
		}
	} else if (id > n.valor) {
	    n.derecha = add(id, n.derecha, nasis);
	    if(height(n.derecha) - height(n.izquierda) == 2)
		if(id > n.derecha.valor) 
		    n = rotarDer(n);
		else {
		    n.derecha = rotarIzq(n.derecha);
		    n = rotarDer(n);
		}
	}  else ;  // Encontro un duplicado y no hace nada.
 
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	return n;
    }
 
    /*
     * Metodo privado para conocer height de un nodo
     * @param n -- Nodo del que se desea conocer height
     * @return int -- height del nodo
     */
    public int height (NodoAvl n) {
	return (n == null) ? -1 : n.height;
    }
    public void cambiar(long id, int nasis){
        boolean prueba = this.contiene(id);
        NodoAvl n = raiz;
        if(prueba == false){
            this.add(id,nasis);
        }else{
            while(n != null){
                if(id < n.valor){
                    n = n.izquierda;
                }else{
                    if(id>n.valor){
                        n = n.derecha;
                    }else{
                        n.asist=n.asist+nasis;
                        break;
                    }
                }
            }
        }
    }
    public int ocurrencia( long id){
        NodoAvl v = this.encontrar(id, raiz);
        return v.asist;
    }
 
 
    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public NodoAvl rotarIzq(NodoAvl n) {
	NodoAvl nraiz = n.izquierda;
	n.izquierda = nraiz.derecha;
	nraiz.derecha = n;
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	nraiz.height = max(height(nraiz.izquierda), n.height) + 1;
	return nraiz;
    }
 
    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public NodoAvl rotarDer(NodoAvl n) {
	NodoAvl nraiz = n.derecha;
	n.derecha = nraiz.izquierda;
	nraiz.izquierda = n;
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	nraiz.height = max(height(nraiz.derecha), n.height) + 1;
	return nraiz;
    }
    
    public int asisy(){
        return asisten(raiz);
    }
    
    public int asisten(NodoAvl n){
        if(n.izquierda == null && n.derecha == null){
            return n.asist;
        }else{
            if(n.derecha != null){
                return asisten(n.derecha);
            }else{
                return asisten(n.izquierda);
            }
        }
    }
    public long idy(){
        return id(raiz);
    }
    
    public void del(long id){
        delete(id,raiz);
    }
    public void delete(long id, NodoAvl n){
        NodoAvl p = n;
        NodoAvl q = n;
        boolean izder = true; 
        if(p.valor == id){
            this.vaciar();
        }else{
            if(id> p.valor){
                q = p.derecha;
            }else{
                q = p.izquierda;
                izder = false;
            }
            while(q != null){
                if(q.valor == id){
                    if(izder == true){
                        p.derecha = null;
                        break;
                    }else{
                        p.izquierda = null;
                        break;
                    }
                }else{
                    if(id>q.valor){
                        q = q.derecha;
                        if(izder == true){
                            p = p.derecha;
                        }else{
                            p = p.izquierda;
                        }
                        izder = true;
                    }else{
                        q = q.izquierda;
                        if(izder == true){
                            p = p.derecha;
                        }else{
                            p = p.izquierda;
                        }
                        izder = false;
                    }
                }
            }
        }
    }
    
    
    public long id(NodoAvl n){
        if(n.izquierda == null && n.derecha == null){
            
            long dev = n.valor;
            del(dev);
            return dev;
        }else{
            if(n.derecha != null){
                return id(n.derecha);
            }else{
                return id(n.izquierda);
            }
        }
    }
 
    /**
     * Metodo para encontrar un elemento en el arbol.
     * @param id -- el dato a buscar.
     * @return boolean -- true si el elemento se encontro o false si no esta.
     */
    public boolean contiene(long id) {
	return encontrar(id, raiz) != null;
    }
 
    /*
     * Metodo interno para encontrar un elemento en un subarbol
     * @param dato -- elemento buscado.
     * @param n -- raiz del arbol.
     * @return NodoAVL que contiene el elemento encontrado o null si no lo encontro.
      */
    public NodoAvl encontrar(long id, NodoAvl n) {
	while(n != null)
	    if(id < n.valor)
		n = n.izquierda;
	    else if(id>n.valor)
		n = n.derecha;
	    else
		return n;    
 
	return null;   
    } 
}
 
    static class Clases {
    NodoClas raiz;            
    int nNodos;              
    /**
     * Constructor a partir de un comparador
     * @param c
     */
    public class NodoClas{
        int height;// valor es id del estudiante
        long id;
        TreeAvl Clase;
        NodoClas izquierda, derecha;
        public NodoClas(long id, TreeAvl clase){
            this.Clase = clase;
            this.id = id;
            derecha = izquierda = null;
        }
    }
    
    public Clases() {
	raiz = null;
	nNodos = 0;
    }
 
    /**
     * Metodo para dejar vacio un arbol 
     */
    public void vaciar() {
	raiz = null;
    }
 
    /**
     * Metodo para conocer el tamano de un arbol
     * @return int -- cantidad de elementos en el arbol
     */
    public int size() {
	return nNodos;
    }
 
   
 
    /**
     * Metodo para insertar un nodo en el arbol, ignorando los duplicados y 
     * balanceando  si es necesario.
     * @param id el elemento a insertar.
     */
    public void add(long id, TreeAvl n) {
	raiz = add(id, raiz,n);
    }
    
    /*
     * Metodo interno, auxiliar, para add en un arbol.
     * @param dato -- elemento a add.
     * @param n -- nodo raiz del arbol.
     * @return NodoAvl -- la nueva raiz.
     */
    public NodoClas add(long id, NodoClas n, TreeAvl v) {
	if(n == null) {
	    n = new NodoClas(id,v);
	    nNodos ++;
	}
	else if(id < n.id)  {
	    n.izquierda = add(id, n.izquierda,v);
	    if(height(n.izquierda) - height(n.derecha) == 2)
		if(id < n.izquierda.id )
		    n = rotarIzq(n);
		else {
		    n.izquierda = rotarDer(n.izquierda);
		    n = rotarIzq(n);
		}
	} else if (id > n.id) {
	    n.derecha = add(id, n.derecha,v);
	    if(height(n.derecha) - height(n.izquierda) == 2)
		if(id > n.derecha.id) 
		    n = rotarDer(n);
		else {
		    n.derecha = rotarIzq(n.derecha);
		    n = rotarDer(n);
		}
	}  else ; 
 
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	return n;
    }
    
    public void unir(long idx, long idy){
        NodoClas x = this.encontrar(idx, raiz);
        NodoClas y = this.encontrar(idy,raiz);
        for(int i = 0 ;i < y.Clase.nNodos ; i++){
            int asisy = y.Clase.asisy();
            long esty = y.Clase.idy();
            x.Clase.cambiar(esty, asisy);
        }
    }
    public void cambiar(long id, long x){
        NodoClas y = this.encontrar(id, raiz);
        y.Clase.cambiar(x,1);
    }
    public int ocurrencia(long id, long x){
        NodoClas y = this.encontrar(id, raiz);
        return y.Clase.ocurrencia(x);
    }
 
    /*
     * Metodo privado para conocer la height de un nodo
     * @param n -- Nodo del que se desea conocer height
     * @return int -- height del nodo
     */
    public int height (NodoClas n) {
	return (n == null) ? -1 : n.height;
    }
    
 
 
    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public NodoClas rotarIzq(NodoClas n) {
	NodoClas nraiz = n.izquierda;
	n.izquierda = nraiz.derecha;
	nraiz.derecha = n;
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	nraiz.height = max(height(nraiz.izquierda), n.height) + 1;
	return nraiz;
    }
 
    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    public NodoClas rotarDer(NodoClas n) {
	NodoClas nraiz = n.derecha;
	n.derecha = nraiz.izquierda;
	nraiz.izquierda = n;
	n.height = max(height(n.izquierda), height(n.derecha)) + 1;
	nraiz.height = max(height(nraiz.derecha), n.height) + 1;
	return nraiz;
    }
 
 
    /**
     * Metodo para encontrar un elemento en el arbol.
     * @param id -- el dato a buscar.
     * @return boolean -- true si el elemento se encontro o false si no esta.
     */
    public boolean contiene(long id) {
	return encontrar(id, raiz) != null;
    }
 
    /*
     * Metodo interno para encontrar un elemento en un subarbol
     * @param dato -- elemento buscado.
     * @param n -- raiz del arbol.
     * @return NodoAVL que contiene el elemento encontrado o null si no lo encontro.
      */
    public NodoClas encontrar(long id, NodoClas n) {
	while(n != null)
	    if(id < n.id)
		n = n.izquierda;
	    else if(id>n.id)
		n = n.derecha;
	    else
		return n;   
 
	return null;   
    } 
}

}