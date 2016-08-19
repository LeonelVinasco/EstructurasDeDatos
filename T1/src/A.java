import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		A problemaA= new A(); //if methods outside main are created
		Scanner scan;
		File file = new File("A.in");
		if(file.exists()){
			scan = new Scanner(file);
		}else{
			scan = new Scanner(System.in);
		}
		String str_cantNums[];
		String str_nums[];
		str_cantNums=scan.nextLine().split(" ");
		str_nums=scan.nextLine().split(" ");
		long long_nums[]= new long[Integer.parseInt(str_cantNums[0])];
		//Fill int_nums array with values of str_nums
		for (int contadorNums=0; contadorNums < Integer.parseInt(str_cantNums[0]);contadorNums++){
			long_nums[contadorNums]=Long.parseLong(str_nums[contadorNums]);
		}
		Arrays.sort(int_nums);//order the array with sort method
		//Multiply the last number with the previous one 
		long long_productoSuperior=long_nums[Integer.parseInt(str_cantNums[0])-1]*long_nums[Integer.parseInt(str_cantNums[0])-2];
		long long_productoInferior=long_nums[0]*long_nums[1];
		if (long_productoSuperior>=long_productoInferior){
			System.out.println(long_productoSuperior);	
		}else{
			System.out.println(long_productoInferior);	
		}
	}

}
