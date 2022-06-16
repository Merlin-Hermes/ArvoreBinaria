package arvoreBinaria;

import arvoreBinaria.service.ArvoreBinaria;

public class Laboratorio {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();

		arvore.insereValor(arvore.getRaiz(), 5);
		arvore.insereValor(arvore.getRaiz(), 10);
		arvore.insereValor(arvore.getRaiz(), 15);
		arvore.insereValor(arvore.getRaiz(), 20);
		arvore.insereValor(arvore.getRaiz(), 25);

		arvore.imprimeArvore(arvore.getRaiz());
		arvore.liberaMemoria(arvore.getRaiz());

	}

}
