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
			int int_longitudMensaje=char_mensaje.length;
			int int_cantBombas=0;
			boolean bool_explosionPendienteAdelante=false;
			int int_actualNumParedes=0;
			int int_cantParedesPorExplotarAdelante=0;
			int int_paredesDemolidas=0;
			for(int int_analizadorMensaje=0;int_analizadorMensaje<int_longitudMensaje;int_analizadorMensaje++){
							
					if(char_mensaje[int_analizadorMensaje]=='W' && int_cantBombas>=1){
						int_cantParedesPorExplotarAdelante--;
						int_actualNumParedes++;
						if(int_cantParedesPorExplotarAdelante<=0 && bool_explosionPendienteAdelante==true){//explodes forward walls
							int_paredesDemolidas=int_paredesDemolidas+1;
							bool_explosionPendienteAdelante=false;
							int_actualNumParedes=int_actualNumParedes-1;	
						}else if(int_cantParedesPorExplotarAdelante==1 && bool_explosionPendienteAdelante==true){
							int_paredesDemolidas=int_paredesDemolidas+1;
							int_actualNumParedes--;
						}
					}else if(char_mensaje[int_analizadorMensaje]=='W'){//Before first bomb appears
						int_actualNumParedes++;
					}else if(char_mensaje[int_analizadorMensaje]=='B' && int_cantBombas>=1){
						int_cantBombas++;
						bool_explosionPendienteAdelante=true;
						int_cantParedesPorExplotarAdelante=2;
						if(int_actualNumParedes<=2){//explodes backward walls
							int_paredesDemolidas=int_paredesDemolidas+int_actualNumParedes;
						}else if(int_actualNumParedes>2){
							int_paredesDemolidas=int_paredesDemolidas+2;
						}
						int_actualNumParedes=0;
					}else if(char_mensaje[int_analizadorMensaje]=='B'){//First bomb
						int_cantBombas++;
						if(int_actualNumParedes>0 && int_actualNumParedes<=2){
							int_paredesDemolidas=int_paredesDemolidas+int_actualNumParedes;
						}else if(int_actualNumParedes>2){
							int_paredesDemolidas=int_paredesDemolidas+2;
						}else{}
							int_actualNumParedes=0;
							int_cantParedesPorExplotarAdelante=2;
							bool_explosionPendienteAdelante=true;
					}		
			}
			System.out.println(int_paredesDemolidas);
		
		}
	}

}
