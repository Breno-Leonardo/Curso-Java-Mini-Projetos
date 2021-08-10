package onerb.cm.visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import onerb.cm.modelo.Campo;
import onerb.cm.modelo.CampoEvento;
import onerb.cm.modelo.CampoObservador;

public class BotaoCampo extends JButton implements CampoObservador, MouseListener {

	private final Color BG_PADRAO = new Color(184, 184, 184);
	private final Color BG_MARCAR = new Color(8, 179, 247);
	private final Color BG_EXPLODIR = new Color(189, 66, 68);
	private final Color TEXTO_VERDE = new Color(0, 100, 0);

	private Campo campo;

	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBorder(BorderFactory.createBevelBorder(0));
		setBackground(BG_PADRAO);
		addMouseListener(this);
		campo.registrarObservadores(this);
	}

	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch (evento) {
		case ABRIR: {
			aplicarEstiloAbrir();
			break;

		}
		case MARCAR: {
			aplicarEstiloMarcar();
			break;

		}
		case EXPLODIR: {
			aplicarEstiloExplodir();
			break;

		}
		default:
			aplicarEstiloPadrao();
			break;
		}
	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setText("X");

	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setText("M");

	}

	private void aplicarEstiloAbrir() {
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		if(campo.isMinado()) {
			setBackground(Color.RED);
			return;
		}
		setBackground(BG_PADRAO);
		switch (campo.minasNaVizinhaca()) {
		case 1: {
			setForeground(TEXTO_VERDE);
			break;
		}
		case 2: {
			setForeground(Color.BLUE);
			break;

		}
		case 3: {
			setForeground(Color.yellow);
			break;

		}
		case 4:
		case 5:
		case 6:
			setForeground(Color.RED);
			break;

		default:
			setForeground(Color.PINK);
		}
		String valor = !campo.vizinhacaSegura() ? campo.minasNaVizinhaca() + "" : "";// se nao estiver segura coloca o
																						// texto
		setText(valor);// define texto do botao
	}
	// interface eventos do mouse

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {// clicou com o botao esquerdo
			campo.abrir();// ele abre o campo q cria todo um fluxo ate o botao campo
		} else
			campo.alternarMarcado();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
