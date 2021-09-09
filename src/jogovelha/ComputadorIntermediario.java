
package jogovelha;

public class ComputadorIntermediario extends Computador {
    
    public ComputadorIntermediario(Tabuleiro tab) {
        super(tab);
    } 
    
    // insercao de 1 a 9 (padrao convertido para pos[x][y])
    public int insercaoCrescente() {
        int ins = 0;

        for (int i = 1; i < 10; i++) {
            if (!this.tab.getJogadasFeitas().contains(i)) {
                ins = i;
                return ins;
            }
        }
        return ins;
    }
    
    @Override
    public Integer[] posicaoJogada() {
        
        // Insere no tabuleiro de forma crescente, da primeira à última
        while (true) {
            int jogada = this.insercaoCrescente();
            
            Integer[] xy = null;
            if (jogada != 0) {
                // transformando padrao 1 a 9 em pos[x][y]
                xy = this.tab.atalhos(jogada);
            }
            
            // verifica se a jogada é possível
            if (tab.getJogadasFeitas().size() < 9) {
                if (!tab.getJogadasFeitas().contains(jogada)) {
                    tab.setJogadasFeitas(jogada);
                    return xy;
                }
            }
            else {
                return null;
            }
        }
    } 
}
