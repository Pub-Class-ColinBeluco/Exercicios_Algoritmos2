import java.lang.reflect.Array;
import java.util.ArrayList;

public class RadixSort {
    public static void radixSort(ArrayList<Integer> A) {
        // processa os dígitos igualmente (uma das razões pelas quais também funciona ordenar strings)
        // usa o bucketSort como auxiliar
        // separa pela maior casa decimal

        // Algo em comum com os dois últimos algoritmos: verificar se o vetor de entrada está vazio (aqui não é necessário)
        // e obter o maior valor

        // O radix sort é basicamente uma mistura
        // // funciona como o counting sort, mas dividido em partes menores, cujas ordenações são bucket sort
        // // detalhe... dentro do bucket sort ainda tem outro algoritmo de ordenação funcionando

        // Encontrar o maior valor do vetor, para uso futuro
        int maior = A.get(0);   // Calma que ainda vamos achar o maior valor
        for(int i = 1; i <= A.size()-1; i++)   {
            if(A.get(i) > maior)
                maior = A.get(i);
        }
        // Basicamente, o laço for abaixo se repete até a casa do maior valor (ou seja, até a dezena, centena ou milhar

        for(int digitoPos = 1; digitoPos <= maior/digitoPos; digitoPos *= 10)   {
            for(int i = 0; i < A.size(); i++)
                System.out.print(A.get(i) + " ");
            System.out.println("");
            bucketSort(A, digitoPos);
        }
    }
    public static void bucketSort(ArrayList<Integer> A, int digitoPos)    {
        // Sim, o bucket sort é usado aqui, mas com bastante mudanças

        // Primeiro, os buckets já é de tamanho 10
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);
        for(int i = 0; i <= digitoPos-1; i++)
            buckets.add(i, new ArrayList<>());

        // Bucket index - para qual posição do bucket o valor original vai?
        // Faz a distribuição, com base no dígito (casa decimal) atual
        for(int num: A) {
            int digitoAtual = (num/digitoPos) % 10;
            buckets.get(digitoAtual).add(num);
        }

        // Junta os elementos do bucket de volta no vetor original (isso será feito algumas outras vezes, dependendo
        // do maior valor do vetor)


    }

    private static void insertionSort(ArrayList<Integer> desordenado)   {
        for(int i = 1; i <= desordenado.size() - 1; i++)    {
            for(int j = i; j > 0; j++)  {
                if(desordenado.get(j-1) > desordenado.get(j))   {
                    int temp = desordenado.get(j);
                    desordenado.set(j, desordenado.get(j-1));
                    desordenado.set((j-1), temp);
                }
            }
        }
    }
}
