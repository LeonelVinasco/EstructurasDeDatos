package taller6;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class salaChar2 {

	public static void main(String[] args) {
		 TreeMap<String, Integer> H= new TreeMap<String, Integer>();
		 Scanner scanner=new Scanner(System.in);
			String in;
			String entrada;
			
			int temp;
			String tempStringNum;
			int tempNum;//number that we found on string
			int casos;
			String t;
			HashMap<String, Integer> tabla= new HashMap<String, Integer>();
			HashMap<String, Integer> tablaAux= new HashMap<String, Integer>();
			int lugarN=0;
			String realAlias;
			boolean numeric=false;
			int start=0;
	        String out="sd";
			
			
			
			while(true){
				//System.out.print("\n");
				
				in=scanner.next();
				entrada=in;
				casos=Integer.parseInt(entrada);
				int ult=0;
				for(int i=0;i<casos;i++){
					in=scanner.next();
					entrada=in;
					
						if (H.containsKey(entrada)){
							for (int k=1;k<H.currentSize+1;k++){
							
							if (H.containsKey(entrada.concat(String.valueOf(k)))){
								ult=k;
							}else{
								H. insert(entrada.concat(String.valueOf(k)));
								System.out.println(entrada.concat(String.valueOf(k)));
								break;
							}
							
							}
						
						}else{
							H.insert(entrada);
							System.out.println("OK");
						
							
						}
						
					
					
					
					
			
			}
			}    
	       
	}

}
