package RSA;

import java.math.BigInteger;

public class RSA_Metodos {
	
	//Encripta a mensagem
	public String Encrypt(String textoCript, BigInteger e, BigInteger n){
		String msgCifrada = null;
		msgCifrada = new BigInteger(textoCript.getBytes()).modPow(e, n).toString();
		return msgCifrada;
	}
	
	public String Decrypt(String msgCifrada, BigInteger d, BigInteger n) {
		String  msgDecript = null; 
		msgDecript =  new String(new BigInteger(msgCifrada).modPow(d, n).toByteArray());
		return msgDecript;
	}
	
	
}
