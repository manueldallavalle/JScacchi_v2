package tests;
import scacchiera.*;
import org.junit.*;

/**
 * <p>Title: TestImmagini</p>
 * <p>Description: Classe Test che verifica le corrette immagini dei pezzi posizionati</p>
 * @author Dalla Valle Manuel, Leone Davide, Benedetti Gianmarco
 * @version 1.0
 */

public class TestImmagini {
	
	StrutturaScacchiera scacchiera = new StrutturaScacchiera();
	Pezzo[][] tavolo = scacchiera.getTavolo();
	/**
	 * metodo che controlla che le varie icone corrispondano alle pedine
	 */
	@org.junit.Test
	public void testIcone() {
		Assert.assertEquals("immagini/torre_nera.gif", (tavolo[0][0].getIcon()).toString());
		Assert.assertEquals("immagini/cavallo_nera.gif", (tavolo[0][1].getIcon()).toString());
		Assert.assertEquals("immagini/alfiere_nera.gif", (tavolo[0][2].getIcon()).toString());
		Assert.assertEquals("immagini/regina_nera.gif", (tavolo[0][3].getIcon()).toString());
		Assert.assertEquals("immagini/re_nera.gif", (tavolo[0][4].getIcon()).toString());
		Assert.assertEquals("immagini/alfiere_nera.gif", (tavolo[0][5].getIcon()).toString());
		Assert.assertEquals("immagini/cavallo_nera.gif", (tavolo[0][6].getIcon()).toString());
		Assert.assertEquals("immagini/torre_nera.gif", (tavolo[0][7].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][0].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][1].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][2].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][3].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][4].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][5].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][6].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_nera.gif", (tavolo[1][7].getIcon()).toString());

		Assert.assertEquals("immagini/torre_bianca.gif", (tavolo[7][0].getIcon()).toString());
		Assert.assertEquals("immagini/cavallo_bianca.gif", (tavolo[7][1].getIcon()).toString());
		Assert.assertEquals("immagini/alfiere_bianca.gif", (tavolo[7][2].getIcon()).toString());
		Assert.assertEquals("immagini/regina_bianca.gif", (tavolo[7][3].getIcon()).toString());
		Assert.assertEquals("immagini/re_bianca.gif", (tavolo[7][4].getIcon()).toString());
		Assert.assertEquals("immagini/alfiere_bianca.gif", (tavolo[7][5].getIcon()).toString());
		Assert.assertEquals("immagini/cavallo_bianca.gif", (tavolo[7][6].getIcon()).toString());
		Assert.assertEquals("immagini/torre_bianca.gif", (tavolo[7][7].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][0].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][1].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][2].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][3].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][4].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][5].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][6].getIcon()).toString());
		Assert.assertEquals("immagini/pedone_bianca.gif", (tavolo[6][7].getIcon()).toString());
	}
}