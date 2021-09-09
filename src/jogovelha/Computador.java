
package jogovelha;

import java.util.Random;

public class Computador {
    protected Tabuleiro tab;
    protected int MIN_RANDOM = 1;
    protected int MAX_RANDOM = 8; // A soma de MIN e MAX gera um Random(1, 9)
    
    protected String bolinhaOuX;
    protected Random random = new Random();
    
    // construtor
    public Computador(Tabuleiro tab) {
        this.tab = tab;
    
    }
    
    // define o lado do computador com base na escolha do adversário
    public String bolinhaOuX(String ladoAdversario) {
        if (ladoAdversario.equals("O")) {
            this.bolinhaOuX = "X";
            return "X";
        }
        else {
            this.bolinhaOuX = "O";
            return "O";
        }
    }
    
    // Método implementado nas classes filhas / polimorfismo
    public Integer[] posicaoJogada() {
        return null;
    }
    
    /* inserção no tabuleiro e passagem de argumentos para 
    as funções de verificar vitória, e detalhes visuais */
    public int inserirJogada(String bolinhaOuX, Integer[] pos) {
        if (tab.getJogadasFeitas().size() < 9) {
            this.tab.setTabuleiro(pos[0], pos[1], bolinhaOuX);
            this.tab.mostrarJogadas("Computador");
            
            if (this.tab.situacaoJogo(bolinhaOuX, "Computador")) {
                return 1; // vitória
            }
            return 0;
        }
        /* adição de elemento na última jogada possível */
        else {
            this.tab.setTabuleiro(pos[0], pos[1], bolinhaOuX);
            this.tab.mostrarJogadas("Computador");
            
            if (this.tab.situacaoJogo(bolinhaOuX, "Computador")) {
                return 1; // vitória
            }
            return -1; // empate
        }
    }
}
