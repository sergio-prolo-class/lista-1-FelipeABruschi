/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;
import java.util.Random;

public class App {

    public static int direcao(){
        Random indice = new Random();
        return indice.nextInt(2);
    }

    public static int posicao() {
        Random indice = new Random();
        return indice.nextInt(10);
    }

    public static void printar_tabuleiro(char tabuleiro[][]) {
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                System.out.print(tabuleiro[i][j] + " ");
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        //gerando tabuleiro vazio " . "
        char[][] tabuleiro = new char[10][10];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++)
                tabuleiro[i][j] = '.';

        char[] navio = new char[] {'P', 'E', 'C', 'S', 'N'};
        int[] tamanho = new int[] {5, 4, 3, 3, 2};

        for(int n = 0; n < 5; n++){
            int tam = tamanho[n];
            int linha = posicao(), coluna = posicao();
            int direcao = direcao();

            boolean navio_inserido = false;

            while(!navio_inserido)
                for(int i = 0; i < 10; i++)
                    for(int j = 0; j < 10; j++)
                        if(linha == i && coluna == j){
                            int inserir_navio = 0;
                            if(direcao == 0) {
                                while(coluna + tam > 10) {
                                    coluna = posicao();
                                    linha = posicao();
                                    j = coluna;
                                    i = linha;
                                }
                                for (int k = 0, aux = j; k < tam; k++, aux++)
                                    if (tabuleiro[i][aux] != '.') {
                                        linha = posicao();
                                        coluna = posicao();
                                        direcao = direcao();
                                        inserir_navio = 1;
                                        break;
                                    }
                                if (inserir_navio == 0) {
                                    for (int z = 0, aux = j; z < tam; z++, aux++)
                                        tabuleiro[i][aux] = navio[n];
                                    navio_inserido = true;
                                }
                            }
                            else {
                                while(linha + tam > 10){
                                    linha = posicao();
                                    coluna = posicao();
                                    i = linha;
                                    j = coluna;
                                }
                                for (int k = 0, aux = i; k < tam; k++, aux++)
                                    if (tabuleiro[aux][j] != '.') {
                                        linha = posicao();
                                        coluna = posicao();
                                        direcao = direcao();
                                        inserir_navio = 1;
                                        break;
                                    }
                                if (inserir_navio == 0) {
                                    for (int z = 0, aux = i; z < tam; z++, aux++)
                                        tabuleiro[aux][j] = navio[n];
                                    navio_inserido = true;
                                }
                            }
                        }
        }
    printar_tabuleiro(tabuleiro);
    }
}
