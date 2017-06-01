package taller6;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainDijkstral {

    private static int dijkstral(int source, int target) {
        
    	PriorityQueue<Pair> PQ = new PriorityQueue<Pair>();
        int dist[] = new int[grafo.length];
        Pair aux;
        
        Arrays.fill(dist, Integer.MAX_VALUE / 3);
        
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
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T =  Integer.parseInt(br.readLine());
        int n, m;
        
        for (int cas = 0; cas < T ; cas++) {
            n =  Integer.parseInt(br.readLine());
            m =  Integer.parseInt(br.readLine());
            
            pesos = new int[n][m];
            
            for (int i = 0; i < n ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    pesos[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int nNodos = n * m;
            int source = 0, target = n * m - 1, nodoU, nodoV;
            grafo = new ArrayList[nNodos];
            
            for (int i = 0 ; i < nNodos; i++) {
                grafo[i] = new ArrayList<Arco>();
            }
             
            int[] posX ={-1, 0, 1, 0};
            int[] posY ={0, 1, 0, -1};
            
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    nodoU = i * m + j;
                    for (int k = 0; k < 4; k++) {
                        if (!isValid((i + posX[k]), n) || !isValid((j + posY[k]), m)) {
                            continue;
                        }
                        int xAux = (i + posX[k]);
                        int yAux = (j + posY[k]);
                        nodoV = xAux * m + yAux;
                        grafo[nodoU].add(new Arco(nodoU, nodoV, pesos[xAux][yAux]));
                    }
                }
            }
            
//            for (int i = 0; i < n ; i++) {
//                System.out.println("Nodo " + i + "Vecinos" + grafo[i]);
//            }
            
            System.out.println(dijkstral(source, target));
        }
    }
}
