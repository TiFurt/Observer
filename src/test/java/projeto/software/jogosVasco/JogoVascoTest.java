package projeto.software.jogosVasco;

import org.junit.jupiter.api.Test;
import projeto.software.pessoaEmSaConsciencia.PessoaEmSaConsciencia;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JogoVascoTest {
    @Test
    void deveNotificarUmaPessoa() {
        JogoVasco jogoVasco = new JogoVasco("Flamengo");
        PessoaEmSaConsciencia pessoa = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 1");
        pessoa.acomponarJogo(jogoVasco);
        jogoVasco.agendarJogo("01/01/2021", "Maracanã");
        assertEquals("PessoaEmSaConsciencia 1, próximo jogo: JogoVasco{data=01/01/2021, local='Maracanã', adversario='Flamengo'}", pessoa.getUltimoJogo());
    }

    @Test
    void deveNotificarPessoaEmSaConsciencias() {
        JogoVasco jogoVasco = new JogoVasco("Flamengo");
        PessoaEmSaConsciencia pessoa1 = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 1");
        PessoaEmSaConsciencia pessoa2 = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 2");
        pessoa1.acomponarJogo(jogoVasco);
        pessoa2.acomponarJogo(jogoVasco);
        jogoVasco.agendarJogo("01/01/2021", "Maracanã");
        assertEquals("PessoaEmSaConsciencia 1, próximo jogo: JogoVasco{data=01/01/2021, local='Maracanã', adversario='Flamengo'}", pessoa1.getUltimoJogo());
        assertEquals("PessoaEmSaConsciencia 2, próximo jogo: JogoVasco{data=01/01/2021, local='Maracanã', adversario='Flamengo'}", pessoa2.getUltimoJogo());
    }

    @Test
    void naoDeveNotificarPessoaEmSaConsciencia() {
        JogoVasco jogoVasco = new JogoVasco("Flamengo");
        PessoaEmSaConsciencia pessoa = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 1");
        jogoVasco.agendarJogo("01/01/2021", "Maracanã");
        assertEquals(null, pessoa.getUltimoJogo());
    }

    @Test
    void deveNotificarPessoaEmSaConscienciaJogoVascoA() {
        JogoVasco jogoVascoA = new JogoVasco("Flamengo");
        JogoVasco jogoVascoB = new JogoVasco("Fluminense");
        PessoaEmSaConsciencia pessoa1 = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 1");
        PessoaEmSaConsciencia pessoa2 = new PessoaEmSaConsciencia("PessoaEmSaConsciencia 2");
        pessoa1.acomponarJogo(jogoVascoA);
        pessoa2.acomponarJogo(jogoVascoB);
        jogoVascoA.agendarJogo("01/01/2021", "Maracanã");
        assertEquals("PessoaEmSaConsciencia 1, próximo jogo: JogoVasco{data=01/01/2021, local='Maracanã', adversario='Flamengo'}", pessoa1.getUltimoJogo());
        assertEquals(null, pessoa2.getUltimoJogo());
    }
}