package projeto.software.pessoaEmSaConsciencia;

import projeto.software.jogosVasco.JogoVasco;

import java.util.Observable;
import java.util.Observer;

public class PessoaEmSaConsciencia implements Observer {
    private String nome;
    private String ultimoJogo;

    public PessoaEmSaConsciencia(String nome) {
        this.nome = nome;
    }

    public String getUltimoJogo() {
        return ultimoJogo;
    }

    public void acomponarJogo(JogoVasco jogoVasco) {
        jogoVasco.addObserver(this);
    }

    @Override
    public void update(Observable jogoVascco, Object arg) {
        this.ultimoJogo = this.nome + ", próximo jogo: " + jogoVascco.toString();
    }
}
