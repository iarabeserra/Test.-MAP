package ATIVIDADEUND1;

import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF {
    private static Random random = new Random();

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        int i = 0;
        while (i < filmes.length - 1) {
            if (filmes[i].compareTo(filmes[i + 1]) > 0) {
                return false;
            }
            i++;
        }
        return true; 
    }

    @Override
    public void insertionSort(Filme[] filmes) {
        int tam = filmes.length;
        for (int right = 1; right < tam; right++) {
            Filme aux = filmes[right];
            int left = right - 1;

            while (left >= 0 && filmes[left].compareTo(aux) > 0) {
                filmes[left + 1] = filmes[left];
                left = left - 1;
            }
            filmes[left + 1] = aux;
        }
    }
    
    @Override
    public void quickSort(Filme[] filmes) {
        int esquerda = 0;
        int direita = filmes.length - 1;
        quickSortAux(filmes, esquerda, direita);
    }

    public static void quickSortAux(Filme[] filmes, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivot = partition(filmes, esquerda, direita);
            quickSortAux(filmes, esquerda, pivot - 1);
            quickSortAux(filmes, pivot + 1, direita);
        }
    }

    private static int partition(Filme[] filmes, int esquerda, int direita) {
        Filme pivot = filmes[direita];
        int i = esquerda - 1;

        for (int j = esquerda; j < direita; j++) {
            if (filmes[j].compareTo(pivot) <= 0) {
                i++;
                swap(filmes, i, j);
            }
        }

        swap(filmes, i + 1, direita);
        return i + 1;
    }

    private static void swap(Filme[] A, int i, int j) {
        Filme temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    @Override
    public void quickSortRandom(Filme[] filmes) {
        int esquerda = 0;
        int direita = filmes.length - 1;
        quickSortRandomAux(filmes, esquerda, direita);
    }

    public static void quickSortRandomAux(Filme[] filmes, int esquerda, int direita) {
        if (esquerda < direita) {
            int pivotIndex = random.nextInt(direita - esquerda + 1) + esquerda;
            swap(filmes, pivotIndex, direita);
            int pivot = partition(filmes, esquerda, direita);
            quickSortRandomAux(filmes, esquerda, pivot - 1);
            quickSortRandomAux(filmes, pivot + 1, direita);
        }
    }
    
    @Override
    public void mergeSort(Filme[] filmes) {
        int n = filmes.length;
        if (n == 1) {
            return;
        }

        int meio = n / 2;
        Filme[] esquerda = Arrays.copyOfRange(filmes, 0, meio);
        Filme[] direita = Arrays.copyOfRange(filmes, meio, n);

        mergeSort(esquerda);
        mergeSort(direita);

        merge(filmes, esquerda, direita);
    }

    private static void merge(Filme[] filmes, Filme[] filmesEsquerda, Filme[] filmesDireita) {
        int i = 0, j = 0, k = 0;
        int tamEsquerda = filmesEsquerda.length;
        int tamDireita = filmesDireita.length;

        while (i < tamEsquerda && j < tamDireita) {
            if (filmesEsquerda[i].compareTo(filmesDireita[j]) <= 0) {
                filmes[k++] = filmesEsquerda[i++];
            } else {
                filmes[k++] = filmesDireita[j++];
            }
        }

        while (i < tamEsquerda) {
            filmes[k++] = filmesEsquerda[i++];
        }

        while (j < tamDireita) {
            filmes[k++] = filmesDireita[j++];
        }
    }

    @Override
    public void countingSort(Filme[] filmes) {
        int K = 5;
    
        int[] C = new int[K + 1];
        Arrays.fill(C, 0);

        Filme[] B = new Filme[filmes.length];

        for (int i = 0; i <= K; i++) {
            C[i] = 0;
        }
    
        for (int j = 0; j < filmes.length; j++) {
            int nota = filmes[j].getNota();
            C[nota]++;
        }

        for (int i = 1; i <= K; i++) {
            C[i] += C[i - 1];
        }

        for (int j = filmes.length - 1; j >= 0; j--) {
            int nota = filmes[j].getNota();
            B[filmes.length - C[nota]] = filmes[j];
            C[nota]--;
        }

        for (int i = 0; i < filmes.length; i++) {
            filmes[i] = B[i];
        }
    }
}