package taller5_20171;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Double.max;
import static java.lang.Double.min;

class PAPASCONARBOLSEGMENTOS{
    
    static class ArbolDeSegmentosMin {
    int inicio, fin;
    double minValue;
    ArbolDeSegmentosMin izquierda, derecha;
    
    public ArbolDeSegmentosMin(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        if(inicio == fin) { 
            izquierda = derecha = null;
            return;
        }
        int mid = (inicio + fin) / 2;
        derecha = new ArbolDeSegmentosMin(mid + 1, fin);
        izquierda = new ArbolDeSegmentosMin(inicio, mid);
        
}
    
    public void set(int pos, double value) {
        if(inicio == fin) {
            minValue = value;
            return;
        }
        int mid = (inicio + fin) / 2;
        if(pos <= mid)
            izquierda.set(pos, value);
        else
            derecha.set(pos, value);
        minValue = min(izquierda.minValue, derecha.minValue);
}
    public double getMin(int bajo, int alto) {
        if(inicio == bajo && fin == alto)
            return minValue;
        int mid = (inicio + fin) / 2;
        if(alto <= mid)
            return izquierda.getMin(bajo, alto);
        if(bajo > mid)
            return derecha.getMin(bajo, alto);
        double izqMin = izquierda.getMin(bajo, mid);
        double derMin = derecha.getMin(mid+1, alto);
        return min(izqMin, derMin);
}
}

static class ArbolDeSegmentosMax {
    int inicio, fin;
    double maxValue;
    ArbolDeSegmentosMax izquierda, derecha;
    
    public ArbolDeSegmentosMax(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        if(inicio == fin) { 
            izquierda = derecha = null;
            return;
        }
        int mid = (inicio + fin) / 2;
        derecha = new ArbolDeSegmentosMax(mid + 1, fin);
        izquierda = new ArbolDeSegmentosMax(inicio, mid);
        
}
    public void set(int pos, double value) {
        if(inicio == fin) {
            maxValue = value;
            return;
        }
        int mid = (inicio + fin) / 2;
        if(pos <= mid)
            izquierda.set(pos, value);
        else
            derecha.set(pos, value);
        maxValue = max(izquierda.maxValue, derecha.maxValue);
}
    public double getMax(int bajo, int alto) {
        if(inicio == bajo && fin == alto)
            return maxValue;
        int mid = (inicio + fin) / 2;
        if(alto <= mid)
            return izquierda.getMax(bajo, alto);
        if(bajo > mid)
            return derecha.getMax(bajo, alto);
        double izqMin = izquierda.getMax(bajo, mid);
        double derMin = derecha.getMax(mid+1, alto);
        return max(izqMin, derMin);
}
}

static class ArbolDeSegmentosSum {
    int inicio, fin;
    double sumValue;
    ArbolDeSegmentosSum izquierda, derecha;
    
    public ArbolDeSegmentosSum(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        if(inicio == fin) { 
            izquierda = derecha = null;
            return;
        }
        int mid = (inicio + fin) / 2;
        derecha = new ArbolDeSegmentosSum(mid + 1, fin);
        izquierda = new ArbolDeSegmentosSum(inicio, mid);
        
}
    public void set(int pos, double value) {
        if(inicio == fin) {
            sumValue = value;
            return;
        }
        int mid = (inicio + fin) / 2;
        if(pos <= mid)
            izquierda.set(pos, value);
        else
            derecha.set(pos, value);
        sumValue = izquierda.sumValue + derecha.sumValue;
}
    public double getSum(int bajo, int alto) {
        if(inicio == bajo && fin == alto)
            return sumValue;
        int mid = (inicio + fin) / 2;
        if(alto <= mid)
            return izquierda.getSum(bajo, alto);
        if(bajo > mid)
            return derecha.getSum(bajo, alto);
        double izqSum = izquierda.getSum(bajo, mid);
        double derSum = derecha.getSum(mid+1, alto);
        return izqSum + derSum;
}
}


    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea = br.readLine();        
        int N = Integer.parseInt(linea);
        
        ArbolDeSegmentosMin min = new ArbolDeSegmentosMin(0, N-1);
        ArbolDeSegmentosSum arbolsuma = new ArbolDeSegmentosSum(0, N-1);
        ArbolDeSegmentosMax arbolMax = new ArbolDeSegmentosMax(0, N-1);
        
        String p = br.readLine();
        String[] pi = p.split(" ");
        
        for(int i =0; i<N ; i++){
            min.set(i, Double.parseDouble(pi[i]));
            arbolMax.set(i, Double.parseDouble(pi[i]));
            arbolsuma.set(i, Double.parseDouble(pi[i]));
        }
    
        String comandos = br.readLine();        
        String[] q = comandos.split(" ");
        int M = Integer.parseInt(q[0]);
        
        for(int i = 0; i<M; i++){
            String entrada = br.readLine();
                String[] comando = entrada.split(" ");
                
                if("cambiar".equals(comando[0])){
                    int Alum = Integer.parseInt(comando[1]);
                    double papa = Double.parseDouble(comando[2]);
                    min.set(Alum, papa);
                    arbolMax.set(Alum, papa);
                    arbolsuma.set(Alum, papa);
                }else if("consultar".equals(comando[0])){
                    int inicio = Integer.parseInt(comando[1]);
                    int fin = Integer.parseInt(comando[2]);
                    float suma = (float) arbolsuma.getSum(inicio, fin);
                    double minimo = min.getMin(inicio, fin);
                    double maximo = arbolMax.getMax(inicio, fin);
                    System.out.println(suma+" "+maximo+" "+minimo);
                }
        }
    }
}