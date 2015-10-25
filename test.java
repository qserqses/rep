

import java.security.SecureRandom;

public class test {
	SecureRandom r = new SecureRandom();
	String key = "aa93e90e";
	String code = "00000001 10111100 10100110 11011101 10100111 10000011 10000111 00100001 11100111 11100110 10010101 10000111 00110101 00110010 00100011 01101011 11100011 00010101 00110000 11000001 11110100 00001001 11110100 10100101 00111111 00110010 11010111 11000100 11000111 01100110 10011001 01011111 00011110 10111111 ";
	byte[] K = new byte[128];
	int j = 0, h = 0, x, y, realcounter = 0;
	byte p;
	char[] test = key.toCharArray();
	byte[] d = new byte[16];
	byte[] c = new byte[8];
	char[] message = code.toCharArray();
	byte[] data = new byte[message.length];
	byte[] cipher = new byte[data.length];
	
	public void init(){
		for(int i = 0; i < 128; i++){
			K[i] = (byte)i;
		}
		int j = 0; 
		for(int i = 0; i < 128; i++){
			j = (j+K[i]+d[i%d.length])%128;
			if(j >= 0){
			p = K[i];
			K[i] = K[j];
			K[j] = p;
			//System.out.print((char)K[i]+ ""+ " ");
			}
		}
	}
	
	public void key(){
		r.nextBytes(c);
		for(int i = 0; i < 8; i++){
			d[i] = c[i];
		}
		for(int i = 8; i < 16; i++){
			
			d[i] = (byte)test[h];
			h = h + 1;
		}
}

	public byte pseudo(){
		x = (x+1) % 128;
		y = (y + K[x]) % 128;
		
		p = K[x];
		K[x] = K[y];
		K[y] = p;
		return(K[(K[y]+ K[x])%128]);
	}
	public void reset(){
		h = 0; j = 0; realcounter = 0;x = 0; y = 0;
	}
	public void decode(){
		for(int i = 0; i < realcounter; i++){
			cipher[i] = (byte)(data[i]^pseudo());
			if(Character.isLetter(cipher[i])||(char)cipher[i] == ',' ||(char)cipher[i] == ',' ||(char)cipher[i] == '?'||(char)cipher[i] == '!')
			System.out.print((char)cipher[i]+""+ " ");
		}
	}
	public void passdata(){
		for(int i = 0; i < message.length; i++){
			if(message[i] != ' '){
			data[i] = (byte) message[i];
			realcounter = realcounter + 1;
			}
			}
	}
	public static void main(String[] args){
		test r = new test();
		for(int i = 0; i < 8000; i++){
		r.key();
		r.init();
		r.passdata();
		r.decode();
		r.reset();
		System.out.println();System.out.println();
		
		}
	}
}
