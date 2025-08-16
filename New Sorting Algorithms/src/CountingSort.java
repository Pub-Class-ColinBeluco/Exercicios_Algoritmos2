import java.util.ArrayList;

public class CountingSort {
    public static void countingSort(ArrayList<Integer> A)  {
        // Só funciona com números inteiros não negativos
        // Cria um vetor auxiliar cujo tamanho é o maior_valor+1 encontrado no vetor original
        // Adiciona 1 no índice do vetor auxiliar: a posição indica o valor
        // Com esses 1's no vetor auxiliar, é reordenado o vetor original
        // IMPORTANTE: O incremento é para lidar com valores repetidos
        //      (vc vai entender)
        // Desempenho:
        //   em todos os casos O(n)
        // Desvantagem: pode gerar um vetor auxiliar muito grande
        // Dependendo da utilização, pode criar dois vetores auxiliares (oxi)
        // Inadaptável e estável

        // Se o vetor estiver vazio, não tem o que fazer :/
        if (A.isEmpty())
            return;

        // Encontrar o maior valor do vetor, para uso futuro
        int maior = A.get(0);   // Calma que ainda vamos achar o maior valor
        for(int i = 0; i <= A.size()-1; i++)
            if(A.get(i) > maior)
                maior = A.get(i);

        // Array auxiliar de contagem de ocorrências de um número
        ArrayList<Integer> count = new ArrayList<>(maior+1);
        for(int i = 0; i <= maior; i++)
            count.add(i, 0);

        // Somar as ocorrências
        for(int i = 0; i <= A.size()-1; i++)
            count.set(A.get(i), count.get(A.get(i))+1);
        // Reordenar segundo as ocorrências em count
        int pos = 0;
        for(int i = 0; i <= count.size()-1; i++)    {
            if(count.get(i) > 0)    {
                A.set(pos, i);
                pos++;
            }
        }
    }
}
