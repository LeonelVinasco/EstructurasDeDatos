import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws FileNotFoundException {
		D pd= new D();
		
		Scanner scan;
		File f = new File("D_8.txt");
		if(f.exists()){
			scan = new Scanner(f);
		}else{
			scan = new Scanner(System.in);
		}
		
		String input0;
		input0=scan.nextLine();
		short casos=Short.parseShort(input0);   
		StringTokenizer st = new StringTokenizer(input0);
		
		for(short r=0;r<casos;r++){
			
			
		input0=scan.nextLine();
		
		short N= Short.parseShort(input0);
		char[][] chocolate= new char [N][N];
		Short[][] chocoNum= new Short [N][N+1];
		short cerezas=0;
		short cerFila=0;
		Short[] cerColum= new Short[N];
		
		short contX=0;//suma gradual por filas
		short contY=0; //suma gradual por columnas
		short respuesta=0;
		
		
		
		//Ordena la matriz de Strings y crea una equivalente en numeros
		
		for(short k=0;k<N;k++){
			cerColum[k]=0;
			
		}
		
		//for aninado construye la matriz de string, de short, y suma cerezas por filas
		//y columnas
		
		
		for(short i=0;i<N;i++){
			
			input0=scan.nextLine();
			//System.out.println(input0);
			char[] input=input0.toCharArray();
			
	    for(short j=0;j<=N;j++){
	    
	    	if (j!=N){
	    	chocolate[i][j]= input[j];
	    	
	    if (input[j]=='#'){
	    		
	    chocoNum[i][j]=1;
	    cerColum[j]++;//El problema era que el valor de la fila no cambiaba 
	                   //estaba i en vez de j.
	    cerFila++;
	    cerezas++;}else{chocoNum[i][j]=0;}
	    	}
	        if(j==N){ 
	    chocoNum[i][j]=cerFila;
	    cerFila=0;
	    	}
	        
	    //System.out.print(chocoNum[i][j]+" ");
	    }
	    
	    }
		
		if (cerezas%2==1){
			respuesta=1;	
					
				}else{
		
		//System.out.print("\n");
		for (int l=0;l<N;l++){
		//System.out.print(cerColum[l]+" ");
		
		}
	
}
if (respuesta==1){
	System.out.print("NO"+"\n");
	
}else{//Siguiente algoritmo determina si el chocolate se puede dividir en
	  //dos partes con igual numero de cerezas
for(short p=0;p<N;p++){
	
	contX=(short) (chocoNum[p][N]+contX);//[P][N]}
	
	contY=(short) (cerColum[p]+contY);
	
	if(contX==cerezas/2 || contY==cerezas/2){
		respuesta=2; //Afirmativo
		break;
	}
	respuesta=3;//No
}

}
if(respuesta==2){		
System.out.print("YES");
System.out.print("\n");
}else if(respuesta==3){	
System.out.print("NO");
System.out.print("\n");}
	
//System.out.print("\n");
		}


}
		
		
		

	}

