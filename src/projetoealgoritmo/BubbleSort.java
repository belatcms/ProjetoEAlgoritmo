package projetoealgoritmo;

import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class BubbleSort {

    public static void main(String args[]) throws IOException {
        int k, tamanho_vetor = 0;

        for (int tamanho = 1; tamanho <= 3; tamanho++) {

            int n = 0;

            if (tamanho == 1) {
                n = 100;
            } else if (tamanho == 2) {
                n = 1000;
            } else {
                n = 10000;
            }
            int[] vetor = new int[n];
            Random gerador = new Random(); // alimentar vetor aleatoriamente

            for (int j = 1; j <= 30; j++) {

                // aqui começa a geração do vetor
                tamanho_vetor = n;
                System.out.println("Aguarde... Gerando vetor");
                for (k = 0; k < n; k++) {
                    vetor[k] = gerador.nextInt(n * 3); // números diferentes (sementes)
                }


                double tempoi = System.nanoTime();

                int qtcomp = 0, qttroca = 0;

                boolean troca = true;
                int aux;
                while (troca) {
                    troca = false;
                    for (int i = 0; i < vetor.length - 1; i++) {
                        
                        if (vetor[i] > vetor[i + 1]) {
                            aux = vetor[i];
                            vetor[i] = vetor[i + 1];
                            vetor[i + 1] = aux;
                            troca = true;
                            qttroca+=3;
                        }
                        qtcomp++;
                    }
                }

                double tempof = System.nanoTime();
                double tempom = tempof - tempoi;
// tempom deve ser dividido por 10^9 para se ter o tempo de execução em segundos
                tempom = tempom / 1000000000.0;
                System.out.println(" ");
                System.out.println("Vetor gerado:" + tamanho_vetor  + "," + j);
                for (k = 0; k < n; k++) {
                    System.out.print(vetor[k] + " ");
                }

                // aberto para operações de saída através do objeto arq instanciado e criado a partir da classe FileWriter.
                FileWriter arq = new FileWriter("BubbleSort.txt", true);
// o objeto de gravação gravaArq é associado a um fluxo de saída de dados baseado em caracteresatravés da classe PrinterWriter .
                PrintWriter gravaArq = new PrintWriter(arq, true);
//gravaArq.write(tamanho do vetor, tamanho do vetor, tempo inicial, tempo final e tempo médio);
                gravaArq.printf("%2d ;%2d ;%2d ; %2d ; %.10f ; %n", tamanho_vetor, j, qtcomp, qttroca, tempom);
                gravaArq.close();
                arq.close();
            }
        }
    }
}