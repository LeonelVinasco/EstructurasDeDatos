package parcial2;

import java.math.*;
import java.util.*;
import java.io.*;

public class Main2 {
  /**
   * Complete la clase Proceso segun la descripcion del problema y 
   * para que pueda ser usada con el MonticuloMinimo.
   *
   * Recuerde que Proceso debe implementar la interfaz Comparable.
   */
  static class Proceso implements Comparable<Proceso>{
      // Definir atributos...
    
	 int im=0;
	   int id=0;

	public Proceso(int id, int im) {
    this.im=im;
    this.id=id;
    }
    
    public int compareTo(Proceso obj) {
      
      if(this.im<obj.im){
          return 1;
      }else if(this.im>obj.im){
          return -1;
      }else{
    	  
    	  if(this.id<obj.id){
              return -1;
          }else if(this.id>obj.id){
              return 1;
          }else{
    	  
    	  
      return 0;}}
    }
    
    
  }

  static class MonticuloMinimo {
    List<Proceso> datos;

    public MonticuloMinimo() {
      datos = new ArrayList<Proceso>();
    }

    public MonticuloMinimo(Proceso[] datos) {

      this.datos = new ArrayList<Proceso>(datos.length);
      
      for (int i = 0; i < datos.length; i++)
        this.datos.add(datos[i]);
      for (int i = padre(datos.length-1); i >= 0; i--)
        desplazarAbajo(i);
    }

    public int padre(int u) {
      return (u-1)/2;
    }

    public int izquierdo(int p) {
      return 2*p+1;
    }

    public int derecho(int p) {
      return 2*p+2;
    }
    
    public void desplazarAbajo(int p) {

      int izq = izquierdo(p);
      int der = derecho(p);
      int mini = p;

      if (izq < datos.size() && datos.get(izq).compareTo(datos.get(mini)) < 0)
        mini = izq;
      if (der < datos.size() && datos.get(der).compareTo(datos.get(mini)) < 0)
        mini = der;
      if (p != mini) {
        Collections.swap(datos, mini, p);
        desplazarAbajo(mini);
      }
    }
    
    public void desplazarArriba(int u) {
      
      int p = padre(u);
      
      if (p >= 0 && datos.get(u).compareTo(datos.get(p)) < 0) {
        Collections.swap(datos, u, p);
        desplazarArriba(p);
      }
    }
    
    public Proceso consultar() {
      
      if (datos.isEmpty())
        return null;
      return datos.get(0);
    }
  
    public void insertar(Proceso v) {
      
      datos.add(v);
      desplazarArriba(datos.size()-1);
    }
    
    public Proceso extraer() {
      
      if (datos.isEmpty())
        return null;
      Proceso v = datos.get(0);
      datos.set(0, datos.get(datos.size()-1));
      datos.remove(datos.size()-1);
      desplazarAbajo(0);
      return v;
    }

    /**
     * La logica de la operacion priorizar debe
     * implementarla aqui.
     */
    
    
    
    public void priorizar(int k) {
      
       int temp= this.consultar().im;
       this.datos.get(k).im=temp+1;
       desplazarArriba(k);
       
    }
   
    
  }
  
  public static void main(String args[]) throws FileNotFoundException {
	  Scanner scan;
	  int linea=1;
	  File f = new File("in01.txt");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
	   
    
    
    
    String prop[]; //procesos operaciones
    
	prop=scan.nextLine().split(" ");
	
	int numProcesos=Integer.parseInt(prop[0]);
	int numOpera=Integer.parseInt(prop[1]);
	
	String datos[];
	
	
	
	Proceso[] lista = new Proceso[numProcesos];
	Proceso[] aux = new Proceso[1000000];
	
	for(int i=0;i<numProcesos;i++){
		 
		datos=scan.nextLine().split(" ");	
		lista[i]=new Proceso(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
		aux[Integer.parseInt(datos[0])] = lista[i];
		
	}
	
	MonticuloMinimo maxheap = new MonticuloMinimo(lista);
	int priorRoot;
	int prior;
	int idTemp=-5;
	int idTempRoot=-45;
	for(int j=0;j<numOpera;j++){
		datos=scan.nextLine().split(" ");
		boolean mismo=false;
		String opcion = datos[0];
        Proceso tempPro=new Proceso(0,0);
        int idt;
        int size;
		if(opcion.compareTo("ejecutar")==0){
			
			System.out.println(maxheap.consultar().id);
			linea++;
			maxheap.extraer();
			//if(linea==1500)break;
		}else if(opcion.compareTo("priorizar")==0){
			            idt=Integer.parseInt(datos[1]);
						prior=maxheap.consultar().im;	
						size=maxheap.datos.size();
						for(int k=0;k<size;k++){
							if (maxheap.datos.get(k).id==idt){
								  maxheap.priorizar(k);
							break;
							}
							   
						}
						
						
					}
				   
			}
			
}
		
	}

