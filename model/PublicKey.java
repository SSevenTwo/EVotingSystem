package model;
import java.math.BigInteger;
import java.security.SecureRandom;

public class PublicKey {
	
	private BigInteger n;
	private BigInteger g;
	private BigInteger r;
	private BigInteger nSquared;
	
	public PublicKey(BigInteger n, BigInteger g) {
		this.n = n;
		this.g = g;
		this.nSquared = n.multiply(n);
	}
	
	public BigInteger getNSquared() {
		return nSquared;
	}
	
	public BigInteger encrypt(BigInteger m) {
		
		//Generating r
		while(true) {
			r = new BigInteger(1024,new SecureRandom());
			if (r.compareTo(n) == -1) {
				break;
			}
		}
		
		BigInteger x = g.modPow(m, nSquared);

		BigInteger y = r.modPow(n, nSquared);
		
		BigInteger multiplyValues = x.multiply(y);
		
		BigInteger result = multiplyValues.mod(nSquared);
		
		return result;
		
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getG() {
		return g;
	}
	
	

}
