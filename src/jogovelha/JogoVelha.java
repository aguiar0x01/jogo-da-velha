
package jogovelha;
import java.util.Scanner;

public class JogoVelha {
    // metodo principal
    public static void main(String[] args) {

        // Instancias
        Tabuleiro tab = new Tabuleiro();
        Jogador jogador = new Jogador(tab);
        
        // validacao de entrada [1, 2, 3]
        while (true) {
			Scanner entrada = new Scanner(System.in);
            System.out.print("\nNivel de dificuldade (1, 2, ou 3) => ");
            int nivel = entrada.nextInt();
            
            if (nivel > 0 && nivel < 4) {
                switch (nivel) {
                    case 1:
                        nivelFacil(jogador, tab);
                        break;
                    case 2:
                        nivelMedio(jogador, tab);
                        break;
                    case 3:
                        nivelDificil(jogador, tab);
                        break;
                    default:
                        break;
                }
                break;
            }
            
        }
        
    }
    
    /* niveis facil, medio e dificil */
    
    public static void nivelFacil(Jogador jogador, Tabuleiro tab) {
        
        ComputadorFacil compFacil = new ComputadorFacil(tab);
        
        // Definicao de lados [X ou O]
        String ladoJogador = jogador.bolinhaOuX();
        
        // Com a escolha do jogador, define-se o lado contrario
        String ladoComputador = compFacil.bolinhaOuX(ladoJogador);
        
        while (true) {
            // Posicoes no tabuleiro [1-9]
            Integer[] posJogador = jogador.posicaoJogada();
            if (posJogador == null) break; // Partida Inacadaba.
            
            Integer[] posComputador = compFacil.posicaoJogada();

            /* Se inserirJogada() resultar em 1,
            significa que alguem venceu o jogo (Jogador/Computador) 
            
            OU se resultar em -1, significa zero jogadas restantes ou Empate */
            
            int statusJogador = jogador.inserirJogada(ladoJogador, posJogador);
            if (statusJogador == 1 || statusJogador == -1) break;
            
            int statusComputador = compFacil.inserirJogada(ladoComputador, posComputador);
            if (statusComputador == 1 || statusComputador == -1) break;
        }
    }
    
    public static void nivelMedio(Jogador jogador, Tabuleiro tab) {
        
        ComputadorIntermediario compMedio = new ComputadorIntermediario(tab);
        String ladoJogador = jogador.bolinhaOuX();
        String ladoComputador = compMedio.bolinhaOuX(ladoJogador);
        
        while (true) {
            Integer[] posJogador = jogador.posicaoJogada();
            if (posJogador == null) break; // Partida Inacadaba.
            
            Integer[] posComputador = compMedio.posicaoJogada();

            /* Se inserirJogada() resultar em 1,
            significa que alguem venceu o jogo (Jogador/Computador) 
            
            OU se resultar em -1, significa zero jogadas restantes ou Empate */
            
            int statusJogador = jogador.inserirJogada(ladoJogador, posJogador);
            if (statusJogador == 1 || statusJogador == -1) break;
            
            int statusComputador = compMedio.inserirJogada(ladoComputador, posComputador);
            if (statusComputador == 1 || statusComputador == -1) break;
        }
    }
    
    public static void nivelDificil(Jogador jogador, Tabuleiro tab) {
        
        ComputadorDificil compDificil = new ComputadorDificil(tab);
        String ladoJogador = jogador.bolinhaOuX();
        String ladoComputador = compDificil.bolinhaOuX(ladoJogador);
        
        while (true) {
            Integer[] posJogador = jogador.posicaoJogada();
            if (posJogador == null) break;
            
            Integer[] posComputador = compDificil.posicaoJogada();

            /* Se inserirJogada() resultar em 1,
            significa que alguem venceu o jogo (Jogador/Computador) 
            
            OU se resultar em -1, significa zero jogadas restantes ou Empate */
            
            int statusJogador = jogador.inserirJogada(ladoJogador, posJogador);
            if (statusJogador == 1 || statusJogador == -1) break;
            
            int statusComputador = compDificil.inserirJogada(ladoComputador, posComputador);
            if (statusComputador == 1 || statusComputador == -1) break;
        }
    }
    
}
