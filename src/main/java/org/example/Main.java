package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /// 1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
        /// Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
        /// Imprimir(SOMA);
        /// Ao final do processamento, qual será o valor da variável SOMA?
        int INDICE = 13, SOMA = 0, K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor de SOMA é: " + SOMA);

        /// 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número para verificar se pertence à sequência de Fibonacci: ");

        int numero = scanner.nextInt();

        if (fibonacci(numero)) {
            System.out.println("O númro " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " NÃO pertence à sequência de Fibonacci.");
        }

        /// 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
        /// • O menor valor de faturamento ocorrido em um dia do mês;
        /// • O maior valor de faturamento ocorrido em um dia do mês;
        /// • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

        try {
            File file = new File("src/main/java/org/example/json/dados.json");

            if (!file.exists()) {
                System.out.println("Arquivo JSON não encontrado!");
                return;
            }

            FileReader reader = new FileReader(file);
            int i;
            StringBuilder jsonString = new StringBuilder();
            while ((i = reader.read()) != -1) {
                jsonString.append((char) i);
            }

            JSONArray dados = new JSONArray(jsonString.toString());


            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;


            for (int j = 0; j < dados.length(); j++) {
                JSONObject item = dados.getJSONObject(j);
                double valor = item.getDouble("valor");
                int dia = item.getInt("dia");


                if (valor > 0 && valor < menorFaturamento) {
                    menorFaturamento = valor;
                }


                if (valor > maiorFaturamento) {
                    maiorFaturamento = valor;
                }


                if (valor > 0) {
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }


            double mediaMensal = somaFaturamento / diasComFaturamento;


            int diasAcimaDaMedia = 0;
            for (int j = 0; j < dados.length(); j++) {
                JSONObject item = dados.getJSONObject(j);
                double valor = item.getDouble("valor");

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }


            System.out.println("Menoor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valr de faturamento: " + maiorFaturamento);
            System.out.println("Númer de dias com faturamento superior à média mensal: " + diasAcimaDaMedia);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean fibonacci(int n) {
        int inicio = 0;
        int fim = 1;

        while (inicio < n) {
            int proximo = inicio + fim;
            inicio = fim;
            fim = proximo;

            if (inicio == n) {
                return true;
            }
        }

        return false;
    }
}
