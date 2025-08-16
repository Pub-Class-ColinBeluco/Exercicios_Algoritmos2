import java.util.ArrayList;

public class BucketSort {
    // Importante que a classe seta "static" para usar no RadixSort
    public static void bucketSort(ArrayList<Integer> A, int numBuckets)    {
        // Utiliza vetor de listas diferentes
        // Complexidade de tempo (k = quantidade de buckets - lista dentro de lista)
        // MELHOR CASO - O(n+k)
        // MÉDIO CASO - O(n+k)
        // PIOR CASO - O(n²) - a depender do algoritmo de ordenação nas listas internas

        // Se o vetor estiver vazio, não tem o que fazer :/
        if (A.isEmpty())
            return;
        // Encontrar o maior valor do vetor, para uso futuro
        int maior = A.get(0);   // Calma que ainda vamos achar o maior valor
        for(int i = 1; i <= A.size()-1; i++)   {
            if(A.get(i) > maior)
                maior = A.get(i);
        }
        // Buckets = listas onde um ou mais valores serão guardados
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for(int i = 0; i <= numBuckets-1; i++)
            buckets.add(i, new ArrayList<>());

        // Bucket index - para qual posição do bucket o valor original vai?
        // Faz a distribuição
        for(int i = 0; i <= A.size()-1; i++) {
            double bucketIndex = Math.floor((A.get(i) * numBuckets) % 10);
            buckets.get((int) bucketIndex).add(A.get(i));
        }

        // Ordena as "mini listas" (usando um outro algoritmo simples de ordenação)
        for(int i = 0; i <= numBuckets-1; i++)
            insertionSort(buckets.get(i));

        // Recombina os elementos de volta no vetor original
        int pos = 0;
        for(int i = 0; i <= numBuckets-1; i++)   {
            for(int elemento: buckets.get(i)) {
                A.set(pos, elemento);
                pos++;
            }
        }
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
