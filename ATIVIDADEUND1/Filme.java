package ATIVIDADEUND1;

public class Filme implements Filme_IF {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public int compareTo(Filme_IF outro_Filme) {
        if (this.nota != outro_Filme.getNota()) {
            return Integer.compare(outro_Filme.getNota(), this.nota);
        }
    
        if (this.ano != outro_Filme.getAno()) {
            return Integer.compare(this.ano, outro_Filme.getAno());
        }
    
        return this.nome.compareTo(outro_Filme.getNome());
    }

    @Override
    public String toString() {
        return nome + " (" + ano + ") [" + nota + "]";
    }
}
