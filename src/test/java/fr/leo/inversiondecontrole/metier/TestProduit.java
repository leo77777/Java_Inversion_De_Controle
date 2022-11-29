package fr.leo.inversiondecontrole.metier;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestProduit {
	@Test
	public void test() {
		double a = 5;
		double b = 8;
		double expected = 40;
		Produit p = new Produit();
		double res = p.produit(a,b);
		assertEquals(expected, res, 0.001);
	}
}
