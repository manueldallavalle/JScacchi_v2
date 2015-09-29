package struttura;
/**
 * classe che mi enuncia i possibili messaggi
 */
public enum Messaggi {
	ERR_PEZZONULL ("Seleziona una pedina valida!"),
	ERR_NOMOSSE ("Non ci sono mosse disponibili!"),
	ERR_MOSSAVALIDA ("Movimento non ammesso!"),
	MSG_TRBIANCHI ("E' il turno dei bianchi!"),
	MSG_TRNERI ("E' il turno dei neri");
	
	
	/**
	 * costruttore della classe Messaggi
	 * @param msg rappresenta il messaggio da visualizzare
	 */
	private Messaggi(String msg){
		this.msg = msg;
	}
	private final String msg;
	/**
	 * classe che mi ritorna il messaggio da stampare
	 * @return il messaggio da visualizzare
	 */
	public String getMsg(){
		return msg;
	};
}