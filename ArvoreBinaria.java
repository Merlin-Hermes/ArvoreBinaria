package arvoreBinaria.service;

import arvoreBinaria.entity.No;

public class ArvoreBinaria {
	No raiz = null;

	public No getRaiz() {
		return raiz;
	}

	public void liberaMemoria(No raiz) {
		if (raiz == null || raiz.noFolha()) {
			return;
		}

		if (raiz.getDireito() != null) {
			liberaMemoria(raiz.getDireito());
			raiz.setDireito(null);
		}

		if (raiz.getEsquerdo() != null) {
			liberaMemoria(raiz.getEsquerdo());
			raiz.setEsquerdo(null);
		}

		this.raiz = null;
	}

	void calculaNivelNos(No raiz, int nivel) {
		// Verifica se existe a arvore
		if (raiz == null)
			return;

		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel + 1);
		calculaNivelNos(raiz.getDireito(), nivel + 1);
	}

	public void insereValor(No raiz, int valor) {
		// Verifica se a �rvore est� vazia
		if (this.raiz == null) {
			this.raiz = new No(valor);
			return;
		}

		// Verifica para que lado da raiz vai andar
		if (valor > raiz.getValor()) {
			// Se nao tiver lado direito, insere
			if (raiz.getDireito() == null) {
				raiz.setDireito(new No(valor));
				return;
			}

			// Insere recursivamente
			insereValor(raiz.getDireito(), valor);
		} else {
			if (raiz.getEsquerdo() == null) {
				raiz.setEsquerdo(new No(valor));
				return;
			}

			insereValor(raiz.getEsquerdo(), valor);
		}
	}
	
	public boolean buscarValor(int Valor) {
		
		return false;
	}
	
	private No maiorValor(No no) {
        while (no.getDireito() != null) {
            no = no.getDireito();
        }

        return no;
    }

	public No removeNo(No raiz, int Valor) {
		 if (raiz == null) {
			 
             return raiz;
         }

         // valor menor, procurar na sub-�rvore esquerda
         if (Valor < raiz.getValor()) {
             raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), Valor));
         }
         else if (Valor > raiz.getValor()) {
             raiz.setDireito(removeNo(raiz.getDireito(), Valor));
         }
         else { // valor encontrado
             // caso 1: n� � uma folha (n�o tem filhos)
             if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
                 // remove-o (seta a "raiz" deste n� para null)
                 return null;
             }
             else if (raiz.getEsquerdo() != null && raiz.getEsquerdo() != null) {
                 // caso 3: n� tem 2 filhos
                 // encontrar o maior dos filhos que antecede o n�
                 No maiorAntecessor = maiorValor(raiz.getEsquerdo());

                 // copia o valor do antecessor para este n�
                 raiz.setValor(maiorAntecessor.getValor());

                 // remove o antecessor recursivamente
                 raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), maiorAntecessor.getValor()));
             }
             else {
                 // caso 2: n� s� tem um filho
                 raiz = (raiz.getEsquerdo() != null) ? raiz.getEsquerdo() : raiz.getDireito();
             }
         }

         return raiz;
		
	}
	
	public void imprimeArvore(No raiz) {
		if (raiz == null)
			return;

		imprimeArvore(raiz.getEsquerdo());
		System.out.println(raiz.getValor());
		imprimeArvore(raiz.getDireito());
	}
}
