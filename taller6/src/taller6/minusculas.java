package taller6;

import java.util.HashMap;

public class minusculas {

	public static void main(String[] args) {

		int temp;
		String tempStringNum;
		int tempNum;//number that we found on string
		int casos;
		String t;
		
		int lugarN=0;
		String realAlias;
		boolean numeric=false;
		
		String letra="hola0123";
		char[] l=letra.toCharArray();
		
		for(int j=0;j<letra.length();j++){
			
			if(l[j]=='0'||l[j]=='1'||l[j]=='2'||l[j]=='3'||l[j]=='4'||l[j]=='5'||l[j]=='6'||
					l[j]=='7'||l[j]=='8'||l[j]=='9'){
				lugarN=j;
				break;
			}
		}
		System.out.println(letra.substring(0,lugarN));
		System.out.println(letra.substring(lugarN,letra.length()));

	}

}
