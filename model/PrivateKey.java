package model;
import java.math.BigInteger;

public class PrivateKey {

	private BigInteger lambda;
	private BigInteger meu;
	private BigInteger n;
	private BigInteger nSquared;

	public PrivateKey(BigInteger lambda, BigInteger meu, BigInteger n) {
		this.lambda = lambda;
		this.meu = meu;
		this.n = n;
		this.nSquared = n.multiply(n);
	}
	
	// Decrypts
	public BigInteger decrypt(BigInteger c) {
		BigInteger u = c.modPow(lambda, nSquared);
		BigInteger a = calculateL(u);
		BigInteger results = a.multiply(meu).mod(n);
		return results;
	}

	public BigInteger getLambda() {
		return lambda;
	}

	public BigInteger getMeu() {
		return meu;
	}
	
	private BigInteger calculateL(BigInteger u) {
		BigInteger L1 = u.subtract(new BigInteger("1"));
		return L1.divide(n);
	}
	
	
}
