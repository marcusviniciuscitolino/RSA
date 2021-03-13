package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSAJava {

    private static Scanner sa = new Scanner(System.in);
	public static void main(String[] args) {
		RSA_Metodos rsa = new RSA_Metodos();
	    System.out.println("Digite a mensagem: ");
	    String textoCript = sa.nextLine();
		BigInteger n,d,e;
		String msgCifrada = null;
		
		
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(4096,100,r);
		BigInteger q = new BigInteger(4096,100,r);
		
		n= p.multiply(q);
		
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		e = new BigInteger("3");
		while(m.gcd(e).intValue()>1) e = e.add(new BigInteger("2"));
		
		d= e.modInverse(m);

		System.out.println("Valor de P - "+ p);
		System.out.println("Valor de Q - "+ q);
		
		msgCifrada = rsa.Encrypt(textoCript, e, n);
		System.out.println("mensagem criptografada - "+ msgCifrada);
		System.out.println("mensagem descriptografada - "+ rsa.Decrypt(msgCifrada, d, n));
	}

}
