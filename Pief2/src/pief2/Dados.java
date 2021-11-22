package pief2;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    List<Double> valores = new ArrayList();
    List<Integer> freq = new ArrayList();

    public Dados() {

    }

    public double amplitude() {
        List<Double> valoresCopia = new ArrayList();
        valoresCopia.addAll(this.valores);
        valoresCopia.sort(null);
        return valoresCopia.get(valores.size() - 1) - valoresCopia.get(0);

    }

    public int numeroDeClasses() {
        double n = (Math.sqrt(valores.size()));
        int nInt = (int) n;
        if (n - nInt >= 0.5) {
            return nInt + 1;
        } else {
            return nInt;
        }

    }

    public int amplitudeDeClasse() {
        double amplitude = (amplitude() / numeroDeClasses()) + 0.9;
        int amplitudeInt =  (int) amplitude;
        return amplitudeInt;
    }

    public double media() {
        double aux = 0;
        double soma = 0;
        for (int i = 0; i < valores.size(); i++) {
            soma = soma + (valores.get(i) * freq.get(i));
            aux = aux + freq.get(i);
        }
        return soma / aux;
    }

    public double moda() {
        List<Integer> freq1 = new ArrayList();
        freq1.addAll(freq);
        double maior = freq1.get(0);
        int n = 0;
        for (int i = 0; i < freq1.size(); i++) {
            if (freq1.get(i) > maior) {
                maior = freq1.get(i);
                n = i;
                i = 0;

            }
        }
        freq1.remove(n);
        freq1.add(n, 0);
        for (int i = 0; i < freq1.size(); i++) {
            if (maior == freq1.get(i)) {

                return 0;
            }

        }
        return valores.get(n);
    }

    public double mediana() {
        double soma1 = 0;
        for (int i = 0; i < freq.size(); i++) {
            soma1 = soma1 + freq.get(i);
        }
        List<Double> c1 = new ArrayList();
        c1.addAll(Metodos.vetorzao(valores, freq));

        Metodos.ordenarList(c1);

        if (c1.size() % 2 == 0) {
            return (c1.get((c1.size() / 2) - 1) + c1.get((c1.size() / 2))) / 2;
        } else {
            return c1.get((c1.size()) / 2);
        }

    }

    public double desvio() {
        double variancia = 0;
        double n1 = 0;
        for (int i = 0; i < freq.size(); i++) {
            n1 = n1 + freq.get(i);

        }
        double media = media();
        for (int i = 0; i < valores.size(); i++) {
            variancia = variancia + (Math.pow((valores.get(i) - media), 2) * freq.get(i)) / (n1 - 1);

        }

        return Math.sqrt(variancia);
    }

    public double CV() {
        double desvio = desvio();
        double media1 = media();
        return (desvio / media1) * 100;

    }

    public double pearson() {
        double media = media();
        double moda = moda();
        double desvio = desvio();
        double pearson;
        if (moda == 0) {
            pearson = 0;

        } else {
            pearson = (media - moda) / desvio;
        }
        return pearson;
    }

    public double quartil(int index) {
        List<Double> c12 = new ArrayList();
        c12.addAll(Metodos.vetorzao(valores, freq));
        Metodos.ordenarList(c12);
        int k = (index * (c12.size() + 1)) / 4;

        return (c12.get(k - 1)) + ((((index * (c12.size() + 1)) / 4) - k) * (c12.get(k) - c12.get(k - 1)));

    }

    public double percentil(int index) {
        List<Double> c12 = new ArrayList();
        c12.addAll(Metodos.vetorzao(valores, freq));
        Metodos.ordenarList(c12);
        int k = (index * (c12.size() + 1)) / 100;
        if (k == 0) {
            k = 1;
        }
        double valor = (c12.get(k - 1)) + ((((index * (c12.size() + 1)) / 100.0) - k) * (c12.get(k) - c12.get(k - 1)));

        return Metodos.arredondar(valor, 2);
    }

}
