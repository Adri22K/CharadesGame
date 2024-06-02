package validador;

import charada_java.models.Charada;

public class CharadaValidador {
	
	public boolean respostaValida(Charada charada, String opcaoEscolhida) {
		
		if (charada.getRespostaCorreta().equals(opcaoEscolhida)) {
			return true;
		}
		
		return false;
	}
}
