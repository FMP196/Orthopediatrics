package xyzt.orthopediatrics.client;

public class Sala
{
	/**
	 * @uml.property  name="numero"
	 */
	private int numero;
	/**
	 * @uml.property  name="amministratore"
	 */
	private String amministratore;
	
	public Sala() {	}
	
	/**
	 * Costruttore della classe
	 * @param numero - Numero della sala
	 */
	public Sala(int numero, String amministratore) {
		this.numero = numero;
		this.amministratore = amministratore;
	}

	// -- GET
	
	/**
	 * @return
	 * @uml.property  name="numero"
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * @return
	 * @uml.property  name="amministratore"
	 */
	public String getAmministratore() {
		return amministratore;
	}
	
	// -- SET
	
	/**
	 * @param numero
	 * @uml.property  name="numero"
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * @param amministratore
	 * @uml.property  name="amministratore"
	 */
	public void setAmministratore(String amministratore) {
		this.amministratore = amministratore;
	}
}