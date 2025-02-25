package ATIVIDADEUND1;

public interface Busca_IF {

    boolean checaVetorOrdenado(Filme[] filmes);

    Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception;

    Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception;

}