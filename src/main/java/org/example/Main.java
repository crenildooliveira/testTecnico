package org.example;

public class Main {
    public static void main(String[] args) {

        /// 1- 1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
        /// Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
        /// Imprimir(SOMA);
        /// Ao final do processamento, qual será o valor da variável SOMA?

        int INDICE = 13, SOMA = 0, K = 0;

        while(K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor de SOMA é:" + SOMA);
    }
}