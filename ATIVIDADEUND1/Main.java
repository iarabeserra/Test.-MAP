package ATIVIDADEUND1;

import java.util.Random;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private static Random random = new Random();

    public static String gerarTitulo() {
        int tamanho = 10;

        String palavra = "";

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(ALPHABET.length());
            palavra += ALPHABET.charAt(index);
        }

        return palavra;
    }

    public static Filme[] gerarFilmes(int length) {
        Filme[] filmes = new Filme[length];

        for(int i = 0; i<length; i++){
            int nota = random.nextInt(5) + 1;
            int ano = random.nextInt(2024 - 1999 + 1) + 1999;
            String titulo = gerarTitulo();
            Filme filme = new Filme(titulo, nota, ano);
            filmes[i] = filme;
        }

        return filmes;
    }

    public static void mostrarVetor(Filme[] filmes, Ordenacao ord, String metodo){
        switch (metodo) {
            case "insertionSort":
                ord.insertionSort(filmes);
                break;
            case "quickSort":
                ord.quickSort(filmes);
                break;
            case "quickSortRandom":
                ord.quickSortRandom(filmes);
                break;
            case "mergeSort":
                ord.mergeSort(filmes);
                break;
            case "countingSort":
                ord.countingSort(filmes);
                break;
            default:
                System.out.println("Metodo de ordenacao nao encontrado.");
                return;
        }
        for(Filme filme: filmes){
            System.out.println(filme);
        }
    }

    public static void executarOrdenacao(String nomeMetodo, Filme[] filmesParaOrdenar, int quantidadeTestes, Ordenacao ord, String metodo) {
        double soma = 0L;
        try {
            long tempoInicial = System.nanoTime();
            for (int i = 0; i < quantidadeTestes; i++) {

            
                switch (metodo) {
                    case "insertionSort":
                        ord.insertionSort(filmesParaOrdenar);
                        break;
                    case "quickSort":
                        ord.quickSort(filmesParaOrdenar);
                        break;
                    case "quickSortRandom":
                        ord.quickSortRandom(filmesParaOrdenar);
                        break;
                        case "mergeSort":
                        ord.mergeSort(filmesParaOrdenar);
                        break;
                    case "countingSort":
                        ord.countingSort(filmesParaOrdenar);
                        break;
                    default:
                        System.out.println("Metodo de ordenacao nao encontrado.");
                        return;
                }
            }
    
                long tempoFinal = System.nanoTime();
                soma += (tempoFinal - tempoInicial) / 1000000000.0;
                System.out.println(nomeMetodo + " - Média: " + (soma / quantidadeTestes) + " segundos");
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void inverterVetor(Filme[] filmes) {
        int n = filmes.length;
        for (int i = 0; i < n / 2; i++) {
            Filme temp = filmes[i];
            filmes[i] = filmes[n - i - 1];
            filmes[n - i - 1] = temp;
        }
    }

    public static void executarBusca(String nomeMetodo, Filme[] filmes, int quantidadeTestes, Busca busca, int metodo, int nota) {
        double soma = 0L;

        for (int i = 0; i < quantidadeTestes; i++) {

            long tempoInicial = System.nanoTime();
            try{
                switch (metodo) {
                    case 1:
                        busca.buscaLinear_iterativa(filmes, nota);
                        break;
                    case 2:
                        busca.buscaLinear_recursiva(filmes, nota);
                        break;
                    case 3:
                        busca.buscaBinaria_iterativa(filmes, nota);
                        break;
                    case 4:
                        busca.buscaBinaria_recursiva(filmes, nota);
                        break;
                    default:
                        System.out.println("Metodo de busca nao encontrado.");
                        return;
                }
            } catch (Exception | StackOverflowError e) {
                System.out.println(e.getMessage());
            }

            long tempoFinal = System.nanoTime();
            soma += (tempoFinal - tempoInicial) / 1000000000.0;
        }

        System.out.println(nomeMetodo + " - Média: " + (soma / quantidadeTestes) + " segundos");
    }



    public static void main(String[] args) {
        final int TAMANHO_VETOR = 100000;
        Filme[] filmes = gerarFilmes(TAMANHO_VETOR);
        Filme[] testes = gerarFilmes(5);

        Ordenacao ord = new Ordenacao();

        Busca busca = new Busca();

        int quantidadeTestes = 10;

        System.out.println("========== INSERTION SORT ==========");
        mostrarVetor(testes.clone(), ord, "insertionSort");
        System.out.println();

        System.out.println("========== QUICK SORT ==========");
        mostrarVetor(testes.clone(), ord, "quickSort");
        System.out.println();

        System.out.println("========== QUICK SORT RANDOM ==========");
        mostrarVetor(testes.clone(), ord, "quickSortRandom");
        System.out.println();

        System.out.println("========== MERGE SORT ==========");
        mostrarVetor(testes.clone(), ord, "mergeSort");
        System.out.println();

        System.out.println("========== COUNTING SORT ==========");
        mostrarVetor(testes.clone(), ord, "countingSort");
        System.out.println();


        Filme[] filmesOrdenados = filmes.clone();
        ord.mergeSort(filmesOrdenados);

        Filme[] filmesOrdenadosInverso = filmesOrdenados.clone();
        inverterVetor(filmesOrdenadosInverso);

        System.out.println("========== ANALISE DE VETORES ALEATORIOS ==========");

        executarOrdenacao("Insertion Sort", filmes.clone(), quantidadeTestes, ord, "insertionSort");
        executarOrdenacao("Quick Sort", filmes.clone(), quantidadeTestes, ord, "quickSort");
        executarOrdenacao("Quick Sort Shuffle", filmes.clone(), quantidadeTestes, ord, "quickSortRandom");
        executarOrdenacao("Merge Sort", filmes.clone(), quantidadeTestes, ord, "mergeSort");
        executarOrdenacao("Counting Sort", filmes.clone(), quantidadeTestes, ord, "countingSort");
        System.out.println();

      /*   System.out.println("========== ANALISE DE VETORES JA ORDENADOS ==========");

        executarOrdenacao("Insertion Sort", filmesOrdenados.clone(), quantidadeTestes, ord, "insertionSort");
        executarOrdenacao("Quick Sort", filmesOrdenados.clone(), quantidadeTestes, ord, "quickSort");
        executarOrdenacao("Quick Sort Shuffle", filmesOrdenados.clone(), quantidadeTestes, ord, "quickSortRandom");
        executarOrdenacao("Merge Sort", filmesOrdenados.clone(), quantidadeTestes, ord, "mergeSort");
        executarOrdenacao("Counting Sort", filmesOrdenados.clone(), quantidadeTestes, ord, "countingSort");
        System.out.println();

        System.out.println("========== ANALISE DE VETORES JA ORDENADOS INVERSAMENTE ==========");

        executarOrdenacao("Insertion Sort", filmesOrdenadosInverso.clone(), quantidadeTestes, ord, "insertionSort");
        executarOrdenacao("Quick Sort", filmesOrdenadosInverso.clone(), quantidadeTestes, ord, "quickSort");
        executarOrdenacao("Quick Sort Shuffle", filmesOrdenadosInverso.clone(), quantidadeTestes, ord, "quickSortRandom");
        executarOrdenacao("Merge Sort", filmesOrdenadosInverso.clone(), quantidadeTestes, ord, "mergeSort");
        executarOrdenacao("Counting Sort", filmesOrdenadosInverso.clone(), quantidadeTestes, ord, "countingSort");
        System.out.println();

        System.out.println("======= BUSCAS =======");
        executarBusca("Busca Linear Iterativa", filmesOrdenados, quantidadeTestes, busca,1, 6);
        executarBusca("Busca Linear Recursiva", filmesOrdenados, quantidadeTestes, busca,2, 6);
        executarBusca("Busca Binarira Iterativa", filmesOrdenados, quantidadeTestes, busca,3, 6);
        executarBusca("Busca Binaria Recursiva", filmesOrdenados, quantidadeTestes, busca,4, 6);
*/
    }
}
