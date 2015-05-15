package struttura;

public enum Messaggi {
	ERR_PEZZONULL ("Seleziona una pedina valida!"),
	MSG_TRBIANCHI ("E' il turno dei bianchi!"),
	MSG_TRNERI ("E' il turno dei neri");
	

	private Messaggi(String msg){
		this.msg = msg;
	}
	private final String msg;
	public String getMsg(){return msg;};
}
