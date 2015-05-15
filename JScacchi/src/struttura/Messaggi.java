package struttura;

public enum Messaggi {
	ERR_PEZZONULL ("Seleziona una pedina valida!");
	

	private Messaggi(String msg){
		this.msg = msg;
	}
	private final String msg;
	public String getMsg(){return msg;};
}
