package charada_java.models;

import java.util.ArrayList;

public class Charada {
	private int Numero;
	private String Texto;
	private ArrayList<Resposta> Respostas;
	private String RespostaCorreta;
	
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	public ArrayList<Resposta> getRespostas() {
		return Respostas;
	}
	public void setRespostas(ArrayList<Resposta> respostas) {
		Respostas = respostas;
	} 
	public String getRespostaCorreta() {
		return RespostaCorreta;
	}
	public void setRespostaCorreta(String respostaCorreta) {
		RespostaCorreta = respostaCorreta;
	}
	
}
