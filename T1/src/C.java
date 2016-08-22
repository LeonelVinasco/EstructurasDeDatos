import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws FileNotFoundException {

		C problemaC= new C(); //if methods outside main are created
		Scanner scan;
		File file = new File("D_1.in");
		if(file.exists()){
			scan = new Scanner(file);
		}else{
			scan = new Scanner(System.in);
		}
		String str_casos[];
		str_casos=scan.nextLine().split(" ");
		int casos=Integer.parseInt(str_casos[0]);
		String str_letras;
		char[] char_letras;
		char letraFija='a';
		for(int contCasos=0;contCasos<casos;contCasos++){
			str_letras=scan.nextLine();
			char_letras=str_letras.toCharArray();
		    
			int nAct=char_letras.length;
			
		
			//String elementosOrdenados = builder.toString();
			for( int lugarLetraFija=0; lugarLetraFija<char_letras.length-1;lugarLetraFija++){
				letraFija=char_letras[lugarLetraFija];
				for(int letraDos=0; letraDos<char_letras.length-1;letraDos++){
					if (lugarLetraFija==letraDos)
						continue;
					
				}
				
				
				
			}
			
			
		
		}

	}
	
	public static void permutacion(String[] elem, String act, int n, int r){
		if(n==0){
			System.out.println(act);
			
		}else{
			for(int i=0;i<r;i++){
				if (!act.contains(elem[i])){
					permutacion(elem, act+elem[i]+", ", n-1,r);
				}
				
				
			}
		}
		
		
		
		
	}

}
