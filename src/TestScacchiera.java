import org.junit.*;

import struttura.Colore;
import struttura.Info;
import struttura.Pezzi;


public class TestScacchiera{


	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	Pezzo[][] tavolo = scacchiera.getTavolo();
	
	@Test
	public void testPosizione(){

		Assert.assertEquals(Pezzi.TORRE, tavolo[7][0].getPezzo());		
		Assert.assertEquals(Pezzi.CAVALLO, tavolo[7][1].getPezzo());
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[7][2].getPezzo());
		Assert.assertEquals(Pezzi.REGINA, tavolo[7][3].getPezzo());		
		Assert.assertEquals(Pezzi.RE, tavolo[7][4].getPezzo());
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[7][5].getPezzo());	
		Assert.assertEquals(Pezzi.CAVALLO, tavolo[7][6].getPezzo());
		Assert.assertEquals(Pezzi.TORRE, tavolo[7][7].getPezzo());		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][0].getPezzo());		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][1].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][2].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][3].getPezzo());		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][4].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][5].getPezzo());	
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][6].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[6][7].getPezzo());
		
		Assert.assertEquals(Pezzi.VUOTO, tavolo[3][1].getPezzo());	
		Assert.assertEquals(Pezzi.VUOTO, tavolo[5][2].getPezzo());
		Assert.assertEquals(Pezzi.VUOTO, tavolo[4][3].getPezzo());
		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][0].getPezzo());	
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][1].getPezzo());		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][2].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][3].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][4].getPezzo());		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][5].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][6].getPezzo());	
		Assert.assertEquals(Pezzi.PEDONE, tavolo[1][7].getPezzo());
		Assert.assertEquals(Pezzi.TORRE, tavolo[0][0].getPezzo());		
		Assert.assertEquals(Pezzi.CAVALLO, tavolo[0][1].getPezzo());
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[0][2].getPezzo());
		Assert.assertEquals(Pezzi.REGINA, tavolo[0][3].getPezzo());		
		Assert.assertEquals(Pezzi.RE, tavolo[0][4].getPezzo());
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[0][5].getPezzo());	
		Assert.assertEquals(Pezzi.CAVALLO, tavolo[0][6].getPezzo());
		Assert.assertEquals(Pezzi.TORRE, tavolo[0][7].getPezzo());
	}
	
	@Test
	public void testStato() {
		Assert.assertEquals(scacchiera.getStato(), Info.TURNO_BIANCHI);
	}
	
	@org.junit.Test
	public void testColore() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				Assert.assertEquals(Colore.NERO, tavolo[i][j].getColore());
			}
		}

		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				Assert.assertEquals(Colore.VUOTO, tavolo[i][j].getColore());
			}
		}

		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Assert.assertEquals(Colore.BIANCO, tavolo[i][j].getColore());
			}
		}
	}
	
	
}
