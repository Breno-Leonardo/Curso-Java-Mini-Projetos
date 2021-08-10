package onerb.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Tabuleiro implements CampoObservador {
	private final int colunas, linhas;

	private final List<Campo> campos = new ArrayList<>();
	private final List<Consumer<ResultadoEvento>> observadores = new ArrayList<>();

	public Tabuleiro(int colunas, int linhas) {
		this.colunas = colunas;
		this.linhas = linhas;
		gerarCampos();
		associarVizinhos();
		sortearMinas();

	}

	public void registrarObservadores(Consumer<ResultadoEvento> observador) {
		observadores.add(observador);
	}

	private void notificarObservadores(boolean resultado) {
		observadores.stream().forEach(o -> o.accept(new ResultadoEvento(resultado)));
	}

	public void abrir(int coluna, int linha) {
		// filtra os campos para achar o campo desejado
		this.campos.parallelStream().filter(c -> c.getColuna() == coluna && c.getLinha() == linha).findFirst()
				.ifPresent(c -> c.abrir());

	}

	private void mostrarMinas() {
		for (int i = 0; i < campos.size(); i++) {// abre todos os campos
			if (campos.get(i).isMinado() && campos.get(i).isMarcado()==false)
				campos.get(i).setAberto(true);
		}
	}

	public void marcar(int coluna, int linha) {
		this.campos.parallelStream().filter(c -> c.getColuna() == coluna && c.getLinha() == linha).findFirst()
				.ifPresent(c -> c.alternarMarcado());
	}

	private void sortearMinas() {
		int maxMinas = this.campos.size() / 6;
		int minasArmadas = 0;
		while (minasArmadas < maxMinas) {
			Random num = new Random();
			Campo x = this.campos.get(num.nextInt(campos.size()));// gera um numero entre 0 e a qtd de campos
			if (x.isMinado() == false) {// se ele ja nao tiver mina
				x.setMinado(true);
				minasArmadas++;
			}
		}
	}

	public boolean fimDoJogo() {
		for (int i = 0; i < this.campos.size(); i++) {
			if (this.campos.get(i).objetivoAlcan() == false)// se houver algum não aberto ou nao marcado
				return false;
		}
		return true;
	}

	public void reiniciar() {
		this.campos.forEach(c -> c.reiniciar());
		this.sortearMinas();
	}

	private void gerarCampos() {
		for (int i = 0; i < colunas; i++) {
			for (int j = 0; j < linhas; j++) {
				Campo campo = new Campo(i, j);
				campo.registrarObservadores(this);// registra em cada campo o tabuleiro como observador
				campos.add(campo);
			}
		}
	}

	private void associarVizinhos() {
		for (int i = 0; i < this.campos.size(); i++) {// pega um campo
			for (int j = 0; j < campos.size(); j++) {// testa vizinhanca com todos outros no arrayList de campos
				campos.get(i).adicionarVizinho(campos.get(j));
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int numCampo = 0;
		for (int i = 0; i < this.colunas; i++) {
			sb.append("   ");
			sb.append(i);
		}
		sb.append("\n");
		for (int i = 0; i < this.colunas; i++) {
			sb.append(i);
			for (int j = 0; j < this.linhas; j++) {
				sb.append(" ");
				sb.append(campos.get(numCampo));
				numCampo++;
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public List<Campo> getCampos() {
		return campos;
	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		if (evento==CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);// notifica que perdeu o jogo 
		} else if (fimDoJogo()) {
			System.out.println("Ganhou");
			notificarObservadores(true);// notifica que ganhou
		}
	}

	public int getColunas() {
		return colunas;
	}

	public int getLinhas() {
		return linhas;
	}

}
