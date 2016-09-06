import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {
static int cantidad=0;
static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {

		C problemaC= new C(); //if methods outside main are created
		Scanner scan;
		File file = new File("D_1.in");
		if(file.exists()){
			scan = new Scanner(file);
		}else{
			scan = new Scanner(System.in);
		}
		/*String str_casos[];
		str_casos=scan.nextLine().split(" ");
		int casos=Integer.parseInt(str_casos[0]);/*/
		
		String entrada = null;
		char[] char_letras;
		char letraFija='a';
		
		String str_casos[];
		str_casos=scan.nextLine().split(" ");
		int casos=Integer.parseInt(str_casos[0]);
		
		for(int contCasos=0;contCasos<casos;contCasos++){
			cantidad=0;
			//str_letras="a,b,c,d,e".split(",");
			entrada=scan.nextLine();
			char_letras=entrada.toCharArray();
			String str_letras[]=new String[char_letras.length];
			for(int i=0;i<char_letras.length;i++){
				str_letras[i]=Character.toString(char_letras[i]);	
			}
			
			int r=str_letras.length;
			
			for(String d : str_letras) 
			System.out.println(d);
			
			System.out.println(str_letras.length-1);
			
			permutacion(str_letras,"",r,r);	
				
			
			String[] elementos=builder.toString().split("");
			for(String e : elementos) 
				System.out.println(e);
			}
	}
	
	private static void permutacion(String[] elem, String act, int n, int r){
		if(n==0){
			System.out.println(act);
			cantidad++;
			 
				builder.append(act);
		}else{
			for(int i=0;i<r;i++){
				//if (!act.contains(elem[i])){
					permutacion(elem, act+elem[i]+"", n-1,r);
				//}
				
				
			}
		}
		
		
		
		
	}

}
