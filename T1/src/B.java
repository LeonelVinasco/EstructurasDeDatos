import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		B problemaB= new B(); //if methods outside main are created
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
		String str_mensaje;
		for(int contCasos=0;contCasos<casos;contCasos++){
			str_mensaje=scan.nextLine();
			char[] char_mensaje=str_mensaje.toCharArray();
			int int_cantInfo=char_mensaje.length;
			int int_bombas=0;
			int int_paredes=0;
			int int_tictac=0;
			int int_paredesDemolidas=0;
			for(int int_analizadorMensaje=0;int_analizadorMensaje<int_cantInfo;int_analizadorMensaje++){
							
					if(char_mensaje[int_analizadorMensaje]=='W' && int_bombas>=1 && int_tictac>0){
						int_tictac--;
						int_paredes++;
					}else if(char_mensaje[int_analizadorMensaje]=='W' && int_tictac==0 && int_paredes>0 && int_bombas>0){
						if(int_paredes<=2){
							int_paredesDemolidas=int_paredesDemolidas+int_paredes;
							int_paredes=1;
						}else{
							int_paredes++;
						}
						
					}else if(char_mensaje[int_analizadorMensaje]=='W'){
						int_paredes++;
						
					}else if(char_mensaje[int_analizadorMensaje]=='B' && int_bombas>=1){
						int_bombas++;
						int_tictac=2;
						if(int_paredes>0 && int_paredes<=2){
							int_paredesDemolidas=int_paredesDemolidas+int_paredes;
						}else if(int_paredes>0){
							
							int_paredesDemolidas=int_paredesDemolidas+2;
							
						}
						int_paredes=0;

					}else if(char_mensaje[int_analizadorMensaje]=='B'){
						int_bombas++;
						int_paredesDemolidas=int_paredesDemolidas+2;
						int_paredes=0;
						int_tictac=2;
					}	
					
					
					
					
					
					
				
			}
			System.out.println(int_paredesDemolidas);
		
		}
	}

}
