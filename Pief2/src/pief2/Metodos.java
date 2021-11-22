package pief2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metodos {

   

    public static List<Double> vetorzao(List<Double> valores, List<Integer> freq) {
        double soma = 0;
        for (int i = 0; i < freq.size(); i++) {
            soma = soma + freq.get(i);

        }
        List<Double> c = new ArrayList();
        for (int i = 0; i < freq.size(); i++) {
            for (int j = 0; j < freq.get(i); j++) {

                c.add(valores.get(i));

            }

        }
        return c;
    }

    public static void ordenarAmbos(List<Double> valores, List<Integer> freq) {
        double aux;
        int aux2;
        for (int i = 0; i < valores.size(); i++) {
            for (int j = i + 1; j < valores.size(); j++) {
                if (valores.get(i) > valores.get(j)) {
                    aux = valores.get(i);
                    valores.add(i, valores.get(j));
                    valores.remove(i + 1);
                    valores.add(j, aux);
                    valores.remove(j + 1);
                    
                    aux2 = freq.get(i);                  
                    freq.add(i, freq.get(j));
                    freq.remove(i+1);                  
                    freq.add(j, aux2);
                    freq.remove(j+1);

                }

            }
        }

    }

    public static int mediaListDouble(List<Double> a) {
        int cont = 0;
        int soma = 0;
        for (int i = 0; i < a.size(); i++) {
            soma += a.get(i);
            cont++;

        }
        return soma / cont;
    }

    public static int mediaListInteger(List<Integer> a) {
        int cont = 0;
        int soma = 0;
        for (int i = 0; i < a.size(); i++) {
            soma += a.get(i);
            cont++;

        }
        return soma / cont;
    }

    public static double arredondar(double d, int i) {
        return ((int) (d * Math.pow(10, i))) / Math.pow(10, i);
    }

    public static void imprimirVetor(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void ordenarList(List<Double> a) {

        a.sort(null);

    }

    public static void ordenarVetor(double[] a) {
        Arrays.sort(a);
    }
}
