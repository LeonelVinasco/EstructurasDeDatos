package taller6;
//https://gist.github.com/LeonelVinasco/1403fd755f0711d94afeba05c97ed14e
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import taller6.MainDijkstral.Arco;
import taller6.TestClass1.Arco;

//implementacion algortmo dikstra
public class TestClass1 {
	
	static class Nodo implements Comparable<Nodo>
	{
	    public final String name;
	    public Arco[] adjacencies;
	    public Integer minDistance = Integer.MAX_VALUE;
	    public Nodo previous;
	    public Nodo(String argName) { name = argName; }
	    public String toString() { return name; }
	    public int compareTo(Nodo other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
	    public void resetWeight() {
	        minDistance = Integer.MAX_VALUE;
	    }
	}

	static class Arco
	{
	    public final Nodo target;
	    public final Integer weight;
	    public Arco(Nodo argTarget, Integer argWeight)
	    { target = argTarget; weight = argWeight; }
	    public String toString() { return "Dest "+target +" peso "+String.valueOf(weight); }
	   //public void insertar(Nodo argTarget, double argWeight){target = argTarget; weight = argWeight;}
	}
	
	public static class Dijkstra
	{
		
		public static void buscaCaminos(Integer star,HashMap<Integer,HashMap<Integer,Arco>> vecinos)
	    {
	        System.out.println("-------------- SHORTEST PATH COMPUTE PHASE -----------");
	        vecinos.get(star).
	        source.minDistance = 0;
	        PriorityQueue<Nodo> vertexQueue = new PriorityQueue<Nodo>();
	        vertexQueue.add(source);

	        while (!vertexQueue.isEmpty()) {
	            Nodo u = vertexQueue.poll(); 

	            System.out.println("visited at vertices " + u.name);
	            // Visit each edge exiting u
	           int l=u.adjacencies.length;
	           // for (Arista e : u.adjacencies) {
	            	for(int k=0;k<u.adjacencies.length;k++){
	                Nodo v = u.adjacencies[k].target;
	                System.out.println("check at vertices " + v.name);
	                Integer weight = u.adjacencies[k].weight;
	                Integer distanceThroughU = u.minDistance + weight; 
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
	    public static void computePaths(Nodo source)
	    {
	        System.out.println("-------------- SHORTEST PATH COMPUTE PHASE -----------");
	        source.minDistance = 0;
	        PriorityQueue<Nodo> vertexQueue = new PriorityQueue<Nodo>();
	        vertexQueue.add(source);

	        while (!vertexQueue.isEmpty()) {
	            Nodo u = vertexQueue.poll(); 

	            System.out.println("visited at vertices " + u.name);
	            // Visit each edge exiting u
	           int l=u.adjacencies.length;
	           // for (Arista e : u.adjacencies) {
	            	for(int k=0;k<u.adjacencies.length;k++){
	                Nodo v = u.adjacencies[k].target;
	                System.out.println("check at vertices " + v.name);
	                Integer weight = u.adjacencies[k].weight;
	                Integer distanceThroughU = u.minDistance + weight; 
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
        	HashMap<Integer,HashMap<Integer,Arco>> vertices = new HashMap<Integer,HashMap<Integer,Arco>>();//matriz
        	ArrayList<Integer> adj = new ArrayList<Integer>(); //lista adjacencia
        	
            for(int i=0; i< numCon;i++){//arma la matriz con los valores ingresados 
            	entrada=scan.nextLine().split(" ");
            	Integer nodoPrim=Integer.parseInt(entrada[0]);
            	Integer nodoSec=Integer.parseInt(entrada[1]);
            	Integer pesoCon=Integer.parseInt(entrada[2]);
            	
            	HashMap<Integer,Arco> aux=new HashMap<Integer,Arco>();
            	HashMap<Integer,Arco> aux2=new HashMap<Integer,Arco>();
            	Nodo tempNod=new Nodo(entrada[1]);
            	Arco temp=new Arco(tempNod,pesoCon);
            	
            	Nodo tempNod2=new Nodo(entrada[0]);
            	Arco temp2=new Arco(tempNod2,pesoCon);

            	if (!vertices.containsKey(nodoPrim)){
            		 
            		aux.put(nodoSec, temp);
            		vertices.put(nodoPrim, aux);
            	}else{
            		aux=vertices.get(nodoPrim);
            		
            		aux.put(nodoSec, temp);
            		vertices.replace(nodoPrim, aux);
            	}
            	if (!vertices.containsKey(nodoSec)){
            		aux2.put(nodoPrim, temp2);
            		vertices.put(nodoSec, aux2);
            	}else{
            		aux2=vertices.get(nodoSec);
            		aux2.put(nodoPrim, temp2);
            		vertices.replace(nodoSec, aux2);
            	}	  
            }
          
          
           
          // vertices.get(1).values().toArray(arreglo);
            HashMap<String,Nodo> vertix = new HashMap<String,Nodo>();
           // Arista[] arreglo= new Arista[tree.size()];
            
            Set<Entry<Integer, HashMap<Integer, Arco>>> set = vertices.entrySet();
            
            // Get an iterator
            Iterator<Entry<Integer, HashMap<Integer, Arco>>> it = set.iterator();
         
            // Display elements
            while(it.hasNext()) {
              Map.Entry me = (Map.Entry)it.next();
              System.out.print("Key is: "+me.getKey() + " & ");
              System.out.println("Value is: "+me.getValue());  
              Arco[] arreglo= new Arco[vertices.get(me.getKey()).size()];
              vertices.get(me.getKey()).values().toArray(arreglo);
             
              //Arista nodT= me.getValue();
              Nodo tempNod3=new Nodo(String.valueOf(me.getKey()));
              tempNod3.adjacencies=arreglo;
              vertix.put(String.valueOf(me.getKey()),tempNod3);
            } 
            
           
    	
            Nodo start = vertix.get("0");
            Nodo target = vertix.get("1");
           
            computePaths(start); // กำหนดจุดเริ่มต้น
            System.out.println("Distance to " + target.name + ": " + target.minDistance);
            List<Nodo> path = getShortestPathTo(target);
            System.out.println("Path: " + path);
           
        }
	}
}
}