package taller6;

import java.util.*;

public class SalaChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Scanner scanner=new Scanner(System.in);
		String entrada;
		
		int temp;
		int casos;
		
		HashMap<String, Integer> tabla= new HashMap<String, Integer>();
		HashMap<String, Integer> tablaAux= new HashMap<String, Integer>();
		
		while(scanner.hasNextLine()){
			entrada=scanner.nextLine();
			casos=Integer.parseInt(entrada);
			
			for(int i=0;i<casos;i++){
				entrada=scanner.nextLine();
				
				if (tablaAux.containsKey(entrada)){
					
					
					
					temp=tablaAux.get(entrada);
					tablaAux.remove(entrada);
					tablaAux.put(entrada, temp+1);
					
					tabla.remove(entrada);
					tabla.put(entrada.concat(Integer.toString(temp+1)), temp+1);
					System.out.println(entrada.concat(Integer.toString(temp+1)));
					//System.out.println(entrada+tabla.get(entrada.concat(Integer.toString(temp+1))));
				}else{
					tabla.put(entrada, 0);
					tablaAux.put(entrada, 0);
					System.out.println("OK");
				}
		
		}
		}
	}

}
