package onerb.cm.modelo;

import java.util.ArrayList;
import java.util.List;


public class Campo {
	private boolean minado = false;
	private boolean aberto = false;
	private boolean marcado = false;

	private final int linha, coluna;

	private List<Campo> vizinhos = new ArrayList<>();
	private List<CampoObservador> observadores = new ArrayList<>();
	
	public void registrarObservadores(CampoObservador obs) {
		observadores.add(obs);
	}
    private void notificarObservadores(CampoEvento evento) {
    	observadores.stream().forEach(o->o.eventoOcorreu(this, evento));
    }

	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		
			int deltaLinha = Math.abs(this.getLinha() - vizinho.getLinha());// dif de 1 ou 0 entre linhas
			int deltaColuna = Math.abs(this.getColuna() - vizinho.getColuna());// dif de 1 ou 0 entre colunas
			
			//(delta linha é 0 ou 1 )&&(delta coluna é 0 ou 1)
			if ((deltaLinha == 0 || deltaLinha == 1) && (deltaColuna == 0 || deltaColuna == 1) ) {
				this.vizinhos.add(vizinho);
				return true;
			} 
			else {
				return false;
			}
	}

	public void alternarMarcado() {// alterna entre marcado e nao marcado
		if (!this.isAberto())// se nao for aberto pode ser marcado
			this.setMarcado(!this.isMarcado());
		
		if(marcado) 
			notificarObservadores(CampoEvento.MARCAR);
		else
			notificarObservadores(CampoEvento.DESMARCAR);

		
	}

	public boolean abrir() {
		if (this.isAberto() == false && this.isMarcado() == false) {// se nao for aberto e nao marcado
			if (this.isMinado() == true) {// se for minado da explosao
				notificarObservadores(CampoEvento.EXPLODIR);
				return true;
			}
			this.setAberto(true);

			if (vizinhacaSegura() == true) {// abre a vizinhaca ao redor
				for (int i = 0; i < vizinhos.size(); i++) {
					vizinhos.get(i).abrir();
				}
				return true;
			}
		}
		return false;
	}

	public boolean vizinhacaSegura() {// pega array de vizinhos e verifica se tem algum com mina
		for (int i = 0; i < vizinhos.size(); i++) {
			if (this.vizinhos.get(i).isMinado() == true)
				return false;
		}
		return true;
	}
    /*os campos tem 4 estados
     1-Aberto e sem mina ao redor= devendado
     2-Aberto e com minas ao redor
     3-Marcado= protegido
     4-Aberto e com mina
     */
	boolean objetivoAlcan() {
		boolean desvendado = !this.isMinado() && this.isAberto();// Nao minado e aberto
		boolean protegido = this.isMinado() && this.isMarcado();// tem mina e esta marcado
		return desvendado || protegido;
	}

	public int minasNaVizinhaca() {// quantidade de minas proximas
		return (int)this.vizinhos.stream().filter(x -> x.isMinado()).count();
	}

	void reiniciar() {// reinicia campos
		this.setAberto(false);
		this.setMarcado(false);
		this.setMinado(false);
		notificarObservadores(CampoEvento.REINICIAR);
	}

	public boolean isMinado() {
		return minado;
	}

	

	public void setMinado(boolean minado) {
		this.minado = minado;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
		
		if(aberto)
			notificarObservadores(CampoEvento.ABRIR);

	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public List<Campo> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(List<Campo> vizinhos) {
		this.vizinhos = vizinhos;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

}
