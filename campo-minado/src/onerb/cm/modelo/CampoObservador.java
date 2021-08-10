package onerb.cm.modelo;

@FunctionalInterface
public interface CampoObservador {
	//define oq acontece quando eventos ocorrem
	public void eventoOcorreu(Campo campo, CampoEvento evento);

	
}
