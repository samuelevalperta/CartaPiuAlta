package it.unibs.ing.fp.lab.cartaalta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CartaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareToItalianeReMaggioreCavallo() {
		Carta re = new Carta("SPADE", ValoreCarteItaliane.RE);
		Carta cavallo = new Carta("SPADE", ValoreCarteItaliane.CAVALLO);
		assertTrue(re.compareTo(cavallo) > 0);
	}
	

	@Test
	public void testCompareToFrancesiDonnaMinoreJack() {
		Carta donna = new Carta("PICCHE", ValoreCarteFrancesi.DONNA);
		Carta jack = new Carta("PICCHE", ValoreCarteFrancesi.JACK);
		assertTrue(donna.compareTo(jack) > 0);
	}
}
