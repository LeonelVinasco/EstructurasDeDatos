package taller6;

import java.util.*;

public class SalaChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Scanner scanner=new Scanner(System.in);
		String in;
		String entrada;
		
		int temp;
		String tempStringNum;
		int tempNum;//number that we found on string
		int casos;
		String t;
		TreeMap<String, Integer> tabla= new TreeMap<String, Integer>();
		TreeMap<String, Integer> tablaAux= new TreeMap<String, Integer>();
		int lugarN=0;
		String realAlias;
		boolean numeric=false;
		int start=0;
String out="sd";
		
		
		
		while(scanner.hasNext()){
			//System.out.print("\n");
			
			in=scanner.next();
			entrada=in;
			casos=Integer.parseInt(entrada);
			
			for(int i=0;i<casos;i++){
				in=scanner.next();
				entrada=in;
				
				//find if there is a numeric value on the input
				char[] l=entrada.toCharArray();
				
				for(int j=0;j<entrada.length();j++){
					
					if(l[j]=='0'||l[j]=='1'||l[j]=='2'||l[j]=='3'||l[j]=='4'||l[j]=='5'||l[j]=='6'||
							l[j]=='7'||l[j]=='8'||l[j]=='9'){
						lugarN=j;
						numeric=true;
					}
				}
				if (numeric){
					numeric=false;
					tempStringNum=entrada.substring(lugarN,entrada.length());
					entrada=entrada.substring(0,lugarN);
					
					//System.out.println(tempStringNum);
					tempNum=Integer.parseInt(tempStringNum);
					
					if (tabla.containsKey(entrada)){
						temp=tabla.get(entrada);
						tabla.remove(entrada);
						tabla.put(entrada, temp+1);
						tabla.put(entrada.concat(String.valueOf(tempNum+1)), tempNum+1);
						System.out.print(entrada.concat(String.valueOf(tempNum+1)));
						System.out.print("\n");
					}else{
						tabla.put(entrada.concat(String.valueOf(tempNum+1)), tempNum+1);
						System.out.print(entrada.concat(String.valueOf(tempNum+1)));
						System.out.print("OK");
						System.out.print("\n");
					}
					
				}else{
					if (tabla.containsKey(entrada)){
						temp=tabla.get(entrada);
						tabla.remove(entrada);
						tabla.put(entrada, temp+1);
						tabla.put(entrada.concat(Integer.toString(temp+1)), temp+1);
						System.out.print(entrada.concat(Integer.toString(temp+1)));
						System.out.print("\n");
					}else{
						tabla.put(entrada, 0);
						tablaAux.put(entrada, 0);
						System.out.print("OK");
						System.out.print("\n");
						
					}
					
				}
				
				
				
		
		}
		}
	}

}
