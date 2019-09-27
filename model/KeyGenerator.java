package model;
import java.math.BigInteger;
import java.security.SecureRandom;

public class KeyGenerator {
	private BigInteger p; // 1st  prime  number
	private BigInteger q; // 2nd  prime  number
	
	private BigInteger n; //   Key  parameter  "n"
	private BigInteger g; // Chosen  Integer
	
	private BigInteger lambda;//Private  Key  parameter  
	private BigInteger u;
	private BigInteger k;
	
	private BigInteger meu; //   Private  Key  parameter  
	private BigInteger r; // Random  Integer
	
	private SecureRandom randomGenerator;
	
	private int bitLength;
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	public KeyGenerator() {
		bitLength = 1024;
		randomGenerator = new SecureRandom();
		
		int lengthOfPQ = bitLength/2;
		//Generate p and q
		p = BigInteger.probablePrime(lengthOfPQ, randomGenerator);
		q = BigInteger.probablePrime(lengthOfPQ, randomGenerator);
		
		System.out.println("P = " + p + "\nQ = " + q);
		
		//Calculate n and n^2
		n = p.multiply(q);
		BigInteger nSquared = n.multiply(n);
		
		//Calculate lambda
		BigInteger pMinusOne = p.subtract(new BigInteger("1"));

		BigInteger qMinusOne = q.subtract(new BigInteger("1"));
		
		lambda = pMinusOne.multiply(qMinusOne.divide(pMinusOne.gcd(qMinusOne)));
		System.out.println("Lambda = " + lambda);
		
		//Generate g
		while(true) {
			g = new BigInteger(bitLength, randomGenerator);
			if(g.gcd(nSquared).equals(new BigInteger("1")) 
					&& calculateL(g.modPow(lambda, nSquared)).gcd(n).equals(new BigInteger("1"))){
				u = g.modPow(lambda, nSquared);
				break;
			}
		}
		
		System.out.println("g = " + g);
		
		//Calculate k
		k = calculateL(u);
		System.out.println("k = " + k);
		
		//Calculate meu
		meu = k.modInverse(n);
		System.out.println("Meu = " + meu);
		
		publicKey = new PublicKey(n,g);
		privateKey = new PrivateKey(lambda,meu, n);
	}
	
	private BigInteger calculateL(BigInteger u) {
		BigInteger L1 = u.subtract(new BigInteger("1"));
		return L1.divide(n);
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	
	public String toString() {
		String message = String.format("---------------------------\n"
				+ "Key Generated:\n"
				+ "***********************\n"
				+ "p = %s \n"
				+ "q = %s \n"
				+ "n = %s \n"
				+ "lambda = %s \n"
				+ "g = %s \n"
				+ "k = %s \n"
				+ "meu = %s \n"
				+ "Public Key(%s,%s) \n"
				+ "Private Key(%s,%s)\n", p,q,n,lambda,g,k,meu,n,g,lambda,meu);
	return message;
	}
	
}
