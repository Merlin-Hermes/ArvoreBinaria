package arvoreBinaria;

import arvoreBinaria.service.ArvoreBinaria;

import java.util.Random;
import java.util.Scanner;

public class Laboratorio {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner leitor = new Scanner(System.in);
        Random cartas = new Random();

        int dano = 0;


        System.out.println("--------------------------------");
        System.out.println("MARSHADOW");
        System.out.println("--------------------------------");
        System.out.println("Esta e a guerra final contra Marshadow");


        for (int i = 0; i < 5; i++) {
            arvore.insereValor(arvore.getRaiz(), cartas.nextInt(100) + 1);
        }

        for (int i = 0; i < 5; i++) {

            System.out.println("Tente advinhar as cartas viradas para baixo");
            int chute = leitor.nextInt();

            boolean tentativa = arvore.buscarValor(arvore.getRaiz(), chute);

            if (!tentativa) {
                System.out.println("infelizmente deu ruim amigo");
            } else {
                System.out.println("Parabens voce acertou");
                arvore.removeNo(arvore.getRaiz(), chute);
                dano++;
            }

        }

        if (dano < 3) {
            System.out.println("Que pena voce perdeu, Marshadow e invencivel");
        } else {
            System.out.println("para bens voce derrotou Marshadow");
        }

        System.out.println("cartas que nao foram advinhadas: ");
        arvore.imprimeArvore(arvore.getRaiz());
        arvore.liberaMemoria(arvore.getRaiz());

    }

}
