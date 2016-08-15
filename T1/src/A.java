import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		A pD= new A();
		Scanner scan;
		File file = new File("D_1.in");
		if(file.exists()){
			scan = new Scanner(file);
		}else{
			scan = new Scanner(System.in);
		}
		
		String str_Casos[];
				
		str_Casos=scan.nextLine().split(" ");
		
		
		for (int contadorCasos=0; contadorCasos < Integer.parseInt(str_Casos[0]);contadorCasos++){

			
		
		}
	}

}
