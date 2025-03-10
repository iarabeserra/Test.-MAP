package ATIVIDADEUND1;

public interface Busca_IF {

    boolean checaVetorOrdenade(Filme[] filmes);

    Filme buscaLinear_iterativar(Filme[] filmes, int nota) throws Exception;

    Filme buscaLinear_recursivar(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_iterativar(Filme[] filmes, int nota) throws Exception;

    Filme buscaBinaria_recursivar(Filme[] filmes, int nota) throws Exception;

    void busca();

}