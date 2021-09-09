
package jogovelha;
import java.util.Scanner;

public class Jogador {
    private final Tabuleiro tab;
    private final Scanner entrada = new Scanner(System.in);
    
    // construtor
    public Jogador(Tabuleiro tab) {
        this.tab = tab;
    }
    
    // define o lado do jogador
    public String bolinhaOuX() {
        while (true) {
            
            System.out.print("\nX ou O? => ");
            String bolinhaOuX = entrada.next().toUpperCase();

            if (bolinhaOuX.equals("O") || bolinhaOuX.equals("X")) {
                return bolinhaOuX;
            }
        }
    }
    
    // entrada e retorno da posição escolhida pelo Usuário/Jogador.
    public Integer[] posicaoJogada() {
        while (true) {
       
            Integer xy[];
            System.out.print("\n(0 para SAIR)\nPosição da Jogada [1~9]: ");
            int jogada = entrada.nextInt();

            if (jogada != 0) { // inválido
                xy = this.tab.atalhos(jogada);
            }
            else {
                this.tab.situacaoJogo("SAIR", ""); // jogo inacabado
                return null;
            }

            /* validação de entrada de 1 a 9 e verificação de jogada */
            if (jogada > 0 && jogada < 10) {
                if (!tab.getJogadasFeitas().contains(jogada)) {
                    tab.setJogadasFeitas(jogada);
                    return xy;
                }
            }
       }
   }
    
    /* inserção no tabuleiro e passagem de argumentos para 
    as funções de verificar vitória, e detalhes visuais */
    public int inserirJogada(String bolinhaOuX, Integer[] pos) {
        if (tab.getJogadasFeitas().size() < 9) {
            this.tab.setTabuleiro(pos[0], pos[1], bolinhaOuX);
            this.tab.mostrarJogadas("Jogador");

            if (this.tab.situacaoJogo(bolinhaOuX, "Jogador")) {
                return 1; // vitória
            }
            return 0;
        }
        /* adição de elemento na última jogada possível */
        else {
            this.tab.setTabuleiro(pos[0], pos[1], bolinhaOuX);
            this.tab.mostrarJogadas("Jogador");
            
            if (this.tab.situacaoJogo(bolinhaOuX, "Jogador")) {
                return 1; // vitória
            }
            
            this.tab.situacaoJogo("Empate", "");
            return -1; // empate
        }
    }
    
}
