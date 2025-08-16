import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> desordenada = new ArrayList<>();
        desordenada.add(6000);
        desordenada.add(500);
        desordenada.add(40);
        desordenada.add(3);
        desordenada.add(23);
        desordenada.add(0);
        desordenada.add(10);
        for(int i: desordenada) {
            System.out.print(i + " ");
        }
        RadixSort.radixSort(desordenada);
        for(int i: desordenada) {
            System.out.print(i + " ");
        }
    }
}