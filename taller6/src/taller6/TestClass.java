package taller6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


public class TestClass {

    private static int dijkstral(int source, int target) {
        
    	PriorityQueue<Pair> PQ = new PriorityQueue<Pair>();
        int dist[] = new int[grafo.length];
        Pair aux;
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PQ.add(new Pair(0, source));
        dist[source] = 0;
        
        while (!PQ.isEmpty()) {
            aux = PQ.remove();
            
            if (aux.peso > dist[aux.nodo])
                continue;
            if (aux.nodo == target)
                return aux.peso;
            
            for (Arco v : grafo[aux.nodo]) {
                if (dist[v.dest] > dist[aux.nodo] + v.costo) {
                    dist[v.dest] = dist[aux.nodo] + v.costo;
                    PQ.add(new Pair(dist[v.dest], v.dest));
                }
            }
        }
        
        
        return dist[target];
    }
    
    static class Pair implements Comparable<Pair>{
        int peso;
        int nodo;
        public Pair() {
        }
        public Pair(int peso, int nodo) {
            this.peso = peso;
            this.nodo = nodo;
        }

        public int compareTo(Pair o) {
            if (this.peso != o.peso)
                return this.peso - o.peso;
            return this.nodo - o.nodo;
        }
    }
    
    static class Arco {
        int ori, dest, costo;
        
        public Arco(){
            super();
        }
        public Arco(int ori, int dest, int cost){
            this.ori = ori;
            this.dest = dest;
            this.costo = cost;
        }
        
        public String toString() {
            return "[ ori: " + ori + ", dest: " + dest + ". costo=" + costo +"]";
        }
    }
    
    static ArrayList<Arco>[] grafo;
    static int[][] pesos;

    static boolean isValid(int x, int lim) {
        return x >= 0 && x < lim;
    }
    
    public static void main(String args[]) throws Exception{
    	Scanner scan=new Scanner(System.in);
        String[] entrada;
        entrada=scan.nextLine().split(" ");
        int casos=Integer.parseInt(entrada[0]);
        int numComps;
        int numCon;
        int origen;
        int destino;
        for (int cas = 0; cas < casos ; cas++) {
        	 System.out.println("Caso #"+cas+1+":");
        	entrada=scan.nextLine().split(" ");
        	numComps=Integer.parseInt(entrada[0]);
        	numCon=Integer.parseInt(entrada[1]);
        	origen=Integer.parseInt(entrada[2]);
        	destino=Integer.parseInt(entrada[3]);
        	HashMap<Integer,HashMap<Integer,Arco>> vertices = new HashMap<Integer,HashMap<Integer,Arco>>();//matriz
        	ArrayList<Integer> adj = new ArrayList<Integer>(); //lista adjacencia
        	
        	grafo = new ArrayList[numComps];
        	for (int i = 0 ; i < numComps; i++) {
                grafo[i] = new ArrayList<Arco>();
            }
        	
            for(int i=0; i< numCon;i++){//arma la matriz con los valores ingresados 
            	entrada=scan.nextLine().split(" ");
            	Integer nodoPrim=Integer.parseInt(entrada[0]);
            	Integer nodoSec=Integer.parseInt(entrada[1]);
            	Integer pesoCon=Integer.parseInt(entrada[2]);
            	grafo[nodoPrim].add(new Arco(nodoPrim, nodoSec, pesoCon));
            	grafo[nodoSec].add(new Arco(nodoSec, nodoPrim, pesoCon));
            	
            }
         if(dijkstral(origen, destino)<715827882){
        	 System.out.println(dijkstral(origen, destino));
        }else{
        	System.out.println("Inalcanzable");
        }
         
        }
    }
}
