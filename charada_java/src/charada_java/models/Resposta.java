package charada_java.models;

public class Resposta {
	private String texto;
	private String letra;
	
	public Resposta(String letra,  String texto) {
		setTexto(texto);
		setLetra(letra);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	
}
