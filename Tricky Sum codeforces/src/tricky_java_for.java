import java.math.BigInteger;

public class tricky_java_for {

	public static void main(String[] args) {
		
		
		int n=10;
		BigInteger t;
		t=new BigInteger("0");
		
		int suma=0;
		float division=0;
		for(int i=1;i<=n;i++){
			
			division=(float) (Math.log(i)/Math.log(2));
			
			if(division%1==0){
				
				suma=suma-i;
				
			}else{
					
				suma=suma+i;
				
			}
			//System.out.println(division);
			//System.out.println(Math.ceil((Math.log(i)/Math.log(2))));
			
		}
		System.out.println(suma);
	}

}
