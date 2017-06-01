package taller6;
//https://gist.github.com/LeonelVinasco/1403fd755f0711d94afeba05c97ed14e
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

import taller6.MainDijkstral.Arco;

//implementacion algortmo dikstra
public class TestClass1 {
	
	class Nodo implements Comparable<Nodo>
	{
	    public final String name;
	    public Arista[] adjacencies;
	    public double minDistance = Double.POSITIVE_INFINITY;
	    public Nodo previous;
	    public Nodo(String argName) { name = argName; }
	    public String toString() { return name; }
	    public int compareTo(Nodo other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
	    public void resetWeight() {
	        minDistance = Double.POSITIVE_INFINITY;
	    }
	}

	class Arista
	{
	    public final Nodo target;
	    public final double weight;
	    public Arista(Nodo argTarget, double argWeight)
	    { target = argTarget; weight = argWeight; }
	}
	
	public static class Dijkstra
	{
	    public static void computePaths(Nodo source)
	    {
	        System.out.println("-------------- SHORTEST PATH COMPUTE PHASE -----------");
	        source.minDistance = 0.;
	        PriorityQueue<Nodo> vertexQueue = new PriorityQueue<Nodo>();
	        vertexQueue.add(source);

	        while (!vertexQueue.isEmpty()) {
	            Nodo u = vertexQueue.poll(); 

	            System.out.println("visited at vertices " + u.name);
	            // Visit each edge exiting u
	            for (Arista e : u.adjacencies) 
	            {
	                Nodo v = e.target;
	                System.out.println("check at vertices " + v.name);
	                double weight = e.weight;
	                double distanceThroughU = u.minDistance + weight; 
	                if (distanceThroughU < v.minDistance) { 
	                    System.out.println("Path from vertices " + u.name + " is shorter than old path");
	                    vertexQueue.remove(v); 
	                    v.minDistance = distanceThroughU ; 
	                    v.previous = u; 
	                    vertexQueue.add(v); 
	                }
	            }
	        }
	    }
	    
	    public static List<Nodo> getShortestPathTo(Nodo target)
	    {
	        List<Nodo> path = new ArrayList<Nodo>();
	        for (Nodo Nodo = target; Nodo != null; Nodo = Nodo.previous) 
	        path.add(Nodo);
	        Collections.reverse(path);
	        return path;
	    }
	    

	    public static double getWeight(Nodo start, Nodo target){
	        double weight = .0;
	        for (Nodo Nodo = target; Nodo != null; Nodo = Nodo.previous){

	        }
	        return weight;
	    }
	    
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
        String[] entrada;
        entrada=scan.nextLine().split(" ");
        int casos=Integer.parseInt(entrada[0]);
        int numComps;
        int numCon;
        int origen;
        int destino;
        for (int cas = 0; cas < casos ; cas++) {
        	
        	entrada=scan.nextLine().split(" ");
        	numComps=Integer.parseInt(entrada[0]);
        	numCon=Integer.parseInt(entrada[1]);
        	origen=Integer.parseInt(entrada[2]);
        	destino=Integer.parseInt(entrada[3]);
        	TreeMap<Integer,TreeMap<Integer,Integer>> vertices = new TreeMap<Integer,TreeMap<Integer,Integer>>();//matriz
        	ArrayList<Integer> adj = new ArrayList<Integer>(); //lista adjacencia
        	
            for(int i=0; i< numCon;i++){//arma la matriz con los valores ingresados 
            	entrada=scan.nextLine().split(" ");
            	Integer nodoPrim=Integer.parseInt(entrada[0]);
            	Integer nodoSec=Integer.parseInt(entrada[1]);
            	Integer pesoCon=Integer.parseInt(entrada[2]);
            	
            	TreeMap<Integer,Integer> aux=new TreeMap<Integer,Integer>();
        		TreeMap<Integer,Integer> aux2=new TreeMap<Integer,Integer>();

            	if (!vertices.containsKey(nodoPrim)){
            		aux.put(nodoSec, pesoCon);
            		vertices.put(nodoPrim, aux);
            	}else{
            		aux=vertices.get(nodoPrim);
            		aux.put(nodoSec, pesoCon);
            		vertices.replace(nodoPrim, aux);
            	}
            	if (!vertices.containsKey(nodoSec)){
            		aux2.put(nodoPrim, pesoCon);
            		vertices.put(nodoSec, aux2);
            	}else{
            		aux2=vertices.get(nodoSec);
            		aux2.put(nodoPrim, pesoCon);
            		vertices.replace(nodoSec, aux2);
            	}	  
            }
            Integer[] arreglo= new Integer[vertices.size()];
          
           
           vertices.get(1).values().toArray(arreglo);
           
           for(Integer j=0;j<vertices.size();j++);
	}
	}
}
}