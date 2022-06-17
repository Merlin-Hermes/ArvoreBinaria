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

	public void calculaNivelNos(No raiz, int nivel) {
		if (raiz == null)
			return;

		raiz.setNivel(nivel);
		calculaNivelNos(raiz.getEsquerdo(), nivel + 1);
		calculaNivelNos(raiz.getDireito(), nivel + 1);
	}


	public void insereValor(No raiz, int valor) {
        if (this.raiz == null) {
            this.raiz = new No(valor);
            return;
        }

        if (valor > raiz.getValor()) {
            if (raiz.getDireito() == null) {
                raiz.setDireito(new No(valor));
                return;
            }

            insereValor(raiz.getDireito(), valor);
        } else {
            if (raiz.getEsquerdo() == null) {
                raiz.setEsquerdo(new No(valor));
                return;
            }

            insereValor(raiz.getEsquerdo(), valor);
        }
    }

    public boolean buscarValor(No raiz, int Valor) {
        boolean aux = false;

        if (raiz == null) {
            aux = false;
        } else if (raiz.getValor() == Valor) {
            aux = true;
        } else {
            if (raiz.getValor() > Valor) {
                aux = buscarValor(raiz.getDireito(), Valor);
            } else {
                aux = buscarValor(raiz.getEsquerdo(), Valor);
            }
        }
        return aux;
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

        if (Valor < raiz.getValor()) {
            raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), Valor));
        } else if (Valor > raiz.getValor()) {
            raiz.setDireito(removeNo(raiz.getDireito(), Valor));
        } else {

            if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
                return null;
            } else if (raiz.getEsquerdo() != null && raiz.getEsquerdo() != null) {
                No maiorAntecessor = maiorValor(raiz.getEsquerdo());

                raiz.setValor(maiorAntecessor.getValor());

                raiz.setEsquerdo(removeNo(raiz.getEsquerdo(), maiorAntecessor.getValor()));
            } else {
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
