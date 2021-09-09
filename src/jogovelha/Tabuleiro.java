
package jogovelha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Tabuleiro {
    private final String[][] tabuleiro = new String[3][3];
    private final List<Integer> jogadasFeitas = new ArrayList<>();
    
    // determina estados: Vitória, Derrota, Empate ou Jogo Inacabado.
    public boolean situacaoJogo(String jogada, String quemJogou) {
        String[][] tab = this.getTabuleiro();
        
        if (jogada.equals("SAIR")) {
            System.out.println("\n====> Jogo Inacadabo <====\n");
            return true;
        }
        
        else if (jogada.equals("Empate")) {
            System.out.println("\n====> Empate <====\n");
        }
        
        // linhas
        else if (this.confereHorizontal(jogada, quemJogou, tab) != null) {
            if (quemJogou.equals("Jogador")) {
                System.out.printf("\n====> Você Venceu! [%s] <====\n\n", jogada);
            }
            else {
                System.out.printf("\n====> Você Perdeu! <====\n\n");
            }
            return true;
        }
        
        // colunas
        else if (this.confereVertical(jogada, quemJogou, tab) != null) {
            if (quemJogou.equals("Jogador")) {
                System.out.printf("\n====> Você Venceu! [%s] <====\n\n", jogada);
            }
            else {
                System.out.printf("\n====> Você Perdeu! <====\n\n");
            }
            return true;
        }
        
        // diagonal
        else if (this.confereDiagonal(jogada, quemJogou, tab) != null) {
            if (quemJogou.equals("Jogador")) {
                System.out.printf("\n====> Você Venceu! [%s] <====\n\n", jogada);
            }
            else {
                System.out.printf("\n====> Você Perdeu! <====\n\n");
            }
            return true;
        }
        
        return false;
    }
    
    public String confereHorizontal(String jogada, String quemJogou, String[][] tab) {
        String jogador = null;
        
        for (int linha = 0; linha < 3; linha++) {
            // altera-se apenas a posição das linhas
            if (tab[linha][0] == jogada && tab[linha][1] == jogada && tab[linha][2] == jogada) {
                jogador = quemJogou;
            }
        }
        return jogador;
    }
    
    public String confereVertical(String jogada, String quemJogou, String[][] tab) {
        String jogador = null;
        
        for (int coluna = 0; coluna < 3; coluna++) {
            // altera-se apenas a posição das colunas
            if (tab[0][coluna] == jogada && tab[1][coluna] == jogada && tab[2][coluna] == jogada) {
                jogador = quemJogou;
            }
        }
        return jogador;
    }
    
    // verificações manuais
    public String confereDiagonal(String jogada, String quemJogou, String[][] tab) {
        String jogador = null;
        
        // Diagonal   [\]
        if (tab[0][0] == jogada && tab[1][1] == jogada && tab[2][2] == jogada) {
            jogador = quemJogou;
        }
        // Diagonal    [/]
        else if (tab[0][2] == jogada && tab[1][1] == jogada && tab[2][0] == jogada) {
            jogador = quemJogou;
        }
        return jogador;
    }
    
    // imprime as jogadas inseridas ou imprime "-", caso vazio
    public void mostrarJogadas(String quemJogou) {
        
        System.out.printf("\n=> %s <=\n", quemJogou);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // imprime na posição linha-coluna
                if (this.getTabuleiro()[i][j] == null) {
                    System.out.print(" - ");
                }
                else {
                    System.out.printf("[%s]", this.getTabuleiro()[i][j]);
                }

                if (j == 2) {
                    System.out.println("");
                }
            }
        }
    }
    
    public Integer[] atalhos(int pos) {
        /* Map de valores esperados como chave, e as coordenadas como valor
        => 1 => "00" => [0, 0]
        */
        Integer[] coord = new Integer[2];
        
        Map<Integer, String> atalhos = new HashMap<Integer, String>();
        atalhos.put(1, "00");
        atalhos.put(2, "01");
        atalhos.put(3, "02");
        atalhos.put(4, "10");
        atalhos.put(5, "11");
        atalhos.put(6, "12");
        atalhos.put(7, "20");
        atalhos.put(8, "21");
        atalhos.put(9, "22");

        // Separação da string-valor do Map em índices individuais
        String indices = atalhos.get(pos);
        int ind0 = Integer.valueOf(indices.substring(0, 1));
        int ind1 = Integer.valueOf(indices.substring(1, 2));
        
        coord[0] = ind0; coord[1] = ind1;
        return coord;
    }

    // getters e setters
    public List<Integer> getJogadasFeitas() {
        return jogadasFeitas;
    }

    public void setJogadasFeitas(int jogada) {
        this.jogadasFeitas.add(jogada);
    }
    
    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int ind0, int ind1, String jogada) {
        this.tabuleiro[ind0][ind1] = jogada;
    }
 
}
