package ATIVIDADEUND1;

public interface Ordenacao_IF {

    public boolean checaVetorOrdenado(Filme[] filmes);
  
    public void insertionSort(Filme[] filmes);
    /* --------------------------------------------- */
  
    public void quickSort(Filme[] filmes); 
  
    public void quickSortRandom(Filme[] filmes);
  
    public void mergeSort(Filme[] filmes);
  
    public void countingSort(Filme[] filmes);
  
}