package ATIVIDADEUND1;

public class Busca implements Busca_IF{
    
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
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {
        if(nota<0){
            throw new Exception("Idade negativa");
        }
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i].getNota() == nota) {
                return filmes[i];
            }
        }
        return null;
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {
        if(nota<0){
            throw new Exception("Idade negativa");
        }
        return buscaLinearRecursivaAux(filmes, nota, 0);
    }

    private Filme buscaLinearRecursivaAux(Filme[] filmes, int nota, int index) {
        if (index >= filmes.length) {
            return null;
        }

        if (filmes[index].getNota() == nota) {
            return filmes[index];
        }

        return buscaLinearRecursivaAux(filmes, nota, index + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {
        if(nota<0){
            throw new Exception("Idade negativa");
        }
        int esquerda = 0;
        int direita = filmes.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            int comparacao = Integer.compare(filmes[meio].getNota(), nota);

            if (comparacao == 0) {
                return filmes[meio];
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
        if(nota<0){
            throw new Exception("Idade negativa");
        }
        return buscaBinariaRecursivaAux(filmes, nota, 0, filmes.length - 1);
    }

    private Filme buscaBinariaRecursivaAux(Filme[] filmes, int nota, int esquerda, int direita) throws Exception {
        if (esquerda > direita) {
            return null;
        }

        int meio = esquerda + (direita - esquerda) / 2;
        int comparacao = Integer.compare(filmes[meio].getNota(), nota);

        if (comparacao == 0) {
            return filmes[meio];
        } else if (comparacao < 0) {
            return buscaBinariaRecursivaAux(filmes, nota, meio + 1, direita);
        } else {
            return buscaBinariaRecursivaAux(filmes, nota, esquerda, meio - 1);
        }
    }
}