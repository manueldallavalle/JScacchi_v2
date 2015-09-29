package tests;
import org.junit.*;

import java.awt.Point;

import scacchiera.*;
import struttura.*;

public class TestScaccoMatto {
	
	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	MonitorAzioni gestoreMovimenti = new MonitorAzioni(scacchiera);
	Pezzo[][] tavolo = scacchiera.getTavolo();
	
	@Test
	public void testSottoScacco(){
		
		Assert.assertEquals(scacchiera.isScaccoMatto(),Pezzi.PEDONE);
		
		gestoreMovimenti.spostaPedina(new Point(2, 6), new Point(2, 4));
		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[2][4].getPezzo());
		Assert.assertEquals(Pezzi.PEDONE, tavolo[3][1].getPezzo());
		
		gestoreMovimenti.spostaPedina(new Point(3, 1), new Point(3, 3));
		
		Assert.assertEquals(Pezzi.PEDONE, tavolo[3][3].getPezzo());
		
		gestoreMovimenti.spostaPedina(new Point(3, 7), new Point(4, 0));
		
		Assert.assertEquals(Pezzi.REGINA, tavolo[4][0].getPezzo());
		
		Assert.assertTrue(scacchiera.isScaccoMatto());
	}
	
	@Test
	public void testScaccoEReset(){
	
	
	Assert.assertTrue(!scacchiera.isScaccoMatto());
	Assert.assertTrue(!scacchiera.isScaccoMatto());	
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!((i == 0 && j == 4) || (i == 7 && j == 4) || (i == 7 && j == 7))) {
					gestoreMovimenti.spostaPedina(new Vuoto(),new Point(i, j), true);					
				}
			}
		}
		
	gestoreMovimenti.spostaPedina(new Point(7, 7), new Point(5, 0));
	gestoreMovimenti.spostaPedina(new Point(4, 7), new Point(4, 2));

	Assert.assertEquals(Pezzi.RE, tavolo[4][2].getPezzo());
	Assert.assertEquals(Colore.BIANCO, tavolo[4][2].getPezzo());
	Assert.assertEquals(Pezzi.TORRE, tavolo[5][0].getPezzo());
	Assert.assertEquals(Colore.BIANCO, tavolo[5][0].getPezzo());
	Assert.assertEquals(Pezzi.RE, tavolo[4][0].getPezzo());
	Assert.assertEquals(Colore.NERO, tavolo[4][0].getPezzo());
	
	Assert.assertTrue(scacchiera.isScaccoMatto());
	scacchiera.resetScacchiera();
		
	Assert.assertEquals(Pezzi.RE, tavolo[4][0].getPezzo());
	Assert.assertEquals(Pezzi.PEDONE, tavolo[4][1].getPezzo());
	Assert.assertEquals(Pezzi.VUOTO, tavolo[5][4].getPezzo());
	Assert.assertEquals(Pezzi.PEDONE, tavolo[2][6].getPezzo());
	Assert.assertEquals(Pezzi.CAVALLO, tavolo[6][7].getPezzo());
	
	}
	
	@Test
	public void testScacco(){
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!((i == 7 && j == 4) || (i == 0 && j == 4) || (i == 0 && j == 2) || (i == 0 && j == 5))) {
					gestoreMovimenti.spostaPedina(new Vuoto(),new Point(i, j), true);
				}
			}
		}
		
		gestoreMovimenti.spostaPedina(new Point(4, 7), new Point(7, 7));
		gestoreMovimenti.spostaPedina(new Point(4, 0), new Point(7, 5));
		gestoreMovimenti.spostaPedina(new Point(2, 0), new Point(5, 5));
		gestoreMovimenti.spostaPedina(new Point(5, 0), new Point(4, 3));
	
		Assert.assertEquals(Pezzi.RE, tavolo[7][7].getPezzo());
		Assert.assertEquals(Colore.BIANCO, tavolo[7][7].getPezzo());
		
		Assert.assertEquals(Pezzi.RE, tavolo[7][5].getPezzo());
		Assert.assertEquals(Colore.NERO, tavolo[7][5].getPezzo());
		
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[5][5].getPezzo());
		Assert.assertEquals(Colore.BIANCO, tavolo[5][5].getPezzo());
		
		Assert.assertEquals(Pezzi.ALFIERE, tavolo[3][4].getPezzo());
		Assert.assertEquals(Colore.NERO, tavolo[3][4].getPezzo());
		
		//Assert.assertTrue(scacchiera.isScaccoMatto());
	}
	
}
