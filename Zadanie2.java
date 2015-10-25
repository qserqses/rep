package zadanie;

import java.security.SecureRandom;
import java.util.Random;
import java.lang.Math;
//Zostaje odszyfrowac :P
public class Zadanie2 {

	public void decode(int generate){
		SecureRandom r = new SecureRandom();
		
		String key = "aa93e90e";
		String code = "00000001 10111100 10100110 11011101 10100111 10000011 10000111 00100001 11100111 11100110 10010101 10000111 00110101 00110010 00100011 01101011 11100011 00010101 00110000 11000001 11110100 00001001 11110100 10100101 00111111 00110010 11010111 11000100 11000111 01100110 10011001 01011111 00011110 10111111 ";
		
		char[] message = code.toCharArray();
		char[] changed = new char[message.length];
		char[] et = new char[34]; // bajty na zapis
		char[] swap = new char[8];
		char[] test = key.toCharArray();
		byte[] c = new byte[test.length];
		byte[] b = new byte[test.length];
		byte[] d = new byte[test.length*2]; //nasz klucz
		int a = b.length, u = 7, counter = 0, counter2 = 0;
		double value = 0;
		for(int ii = 0; ii < code.length(); ii++){
			if(message[ii] == ' '){
				ii = ii + 1;
				continue;
			}
			else{
				swap[counter] = message[ii];
				counter = counter + 1;
				if(counter == 8){
				//for(int rr = 0; rr < 8; rr++){
				//	System.out.print(swap[rr]);
				//}
				//System.out.println();
					counter = 0;
			for(int f = 0; f < 8; f++){
			//System.out.print(message[f]);
			if(swap[f] == '1'){
				value = value + Math.pow(2, u);
				u = u - 1;
			}else u = u - 1;
			}
			et[counter2] = (char)value;
			//System.out.println("   " + value+"" + "  "+ et[counter2]);
			counter2 = counter2 + 1;
		}
				
			u = 7;
			value = 0;
		}
	}
		
		for(int t = 0; t < generate; t++){
		r.nextBytes(c);
		for(int x = 0; x < b.length; x++){ //tworze pierwsz¹ po³owê klucza
			//if(d[x] < 0) d[x] = (byte) ~d[x];
			d[x] = c[x];
		}
		//System.out.println();
		for(int i = 0; i < b.length; i++){ //dopisujê podany klucz
			b[i] = (byte)test[i];
			d[a] = b[i];
			a = a + 1;
		//	System.out.print(b[i]+ " ");
		}
		a = b.length;
		System.out.println("Klucz "+t+""+": ");
		/*for(int i2 = 0; i2 < d.length; i2++){
			for(int j2 = 0; j2 < et.length; j2++){
				if(Character.isLetter((d[i2%16]^(byte)et[j2])) || (char)(d[i2%16]^(byte)et[j2]) == '.'||(char)(d[i2%16]^(byte)et[j2]) == ','||(char)(d[i2%16]^(byte)et[j2]) == '?'||(char)(d[i2%16]^(byte)et[j2]) == '!')
				System.out.print((char)(d[i2]^(byte)et[j2])+""+ " ");
			}
			System.out.println();
		}*/
		for(int i2 = 0; i2 < et.length; i2++){
			if(Character.isLetter((d[i2%16]^(byte)et[i2])) || (char)(d[i2%16]^(byte)et[i2]) == '.'||(char)(d[i2%16]^(byte)et[i2]) == ','||(char)(d[i2%16]^(byte)et[i2]) == '?'||(char)(d[i2%16]^(byte)et[i2]) == '!')
				System.out.print((char)(d[i2%16]^(byte)et[i2])+""+ " ");
		}
		System.out.println();
		}
	//	System.out.println(((d[0]^(byte)et[0]))+"");
}			
	public static void main(String[] args){
		Zadanie2 z = new Zadanie2();	
			z.decode(82000);
		}
}
