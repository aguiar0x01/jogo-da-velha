
package jogovelha;

public class ComputadorFacil extends Computador {
    public ComputadorFacil(Tabuleiro tab) {
        super(tab);
    }
    
    @Override
    public Integer[] posicaoJogada() {
        // Insere aleatoriamente no tabuleiro, conforme disponível

        while (true) {
            // random 1 a 9
            int jogada = random.nextInt(MAX_RANDOM + MIN_RANDOM) + MIN_RANDOM;

            // transformando padrao 1 a 9 em pos[x][y]
            Integer[] xy = this.tab.atalhos(jogada);

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
