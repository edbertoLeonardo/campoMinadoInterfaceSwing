package br.com.empresa.campoMinado.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.empresa.campoMinado.modelo.Tabuleiro;

public class PainelTabulerio extends JPanel{
	private static final long serialVersionUID = 1L;

	public PainelTabulerio(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservadores(e ->{
			
			SwingUtilities.invokeLater(() -> {
				
				if (e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Ganhou :)");
				} else {
					JOptionPane.showMessageDialog(this, "Perdeu :(");
				}
				
				tabuleiro.reiniciar();
			});
				
		});
			
	}
	
}
