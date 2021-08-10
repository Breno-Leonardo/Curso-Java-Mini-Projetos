package modelo;

public class Memoria {
	private final static Memoria memoria = new Memoria();
	private String valor1;
	private String valor2;
	private char ope;
	private Double resultadoF ;
	private Long resultadoI ;
	private boolean temFlutuante ;
	private boolean temFlutuante2 ;
	private Long v1I ;
	private Long v2I ;
	private Double v1F ;
	private Double v2F ;
	private Memoria() {

	}
public void reiniciarMemoria() {
	resultadoF = 0D;
	resultadoI = 0L;
	temFlutuante = false;
    temFlutuante2 = false;
	v1I = 0L;// valor 1 inteiro
	v2I = 0L;
	v1F = 0D;// valor 1 flutuante
	v2F = 0D;
}
	public String FazerCalculo(String valor) {
		reiniciarMemoria();
		for (int i = 0; i < valor.length(); i++) {//separando a string
			if (valor.charAt(i) == ' ') {
				valor1 = valor.substring(0, i);
				ope = valor.charAt(i + 1);
				valor2 = valor.substring(i + 3, valor.length());
				break;
			}
		}
		
		for (int i = 0; i < valor1.length(); i++) {// valor 1 flutuante ou nao
			if (valor1.charAt(i) == '.') {
				v1F = Double.parseDouble(valor1);
				temFlutuante = true;
				break;
			}
			else if (i == valor1.length() - 1) {// nao flutuante
				v1I = Long.parseLong(valor1);
			}
		}
		
		for (int i = 0; i < valor2.length(); i++) {// valor 2 flutuante ou nao
			if (valor2.charAt(i) == '.') {
				v2F = Double.parseDouble(valor2);
				temFlutuante2 = true;
				break;
			}
			if (i == valor2.length() - 1) {// ta no fim do loop ou seja:nao flutuante
				v2I = Long.parseLong(valor2);
			}
		}

		// Operacao
		if (ope == '+') {//SOMA
			if (temFlutuante == true || temFlutuante2 == true) {
				resultadoF = v1F + v2F + v1I + v2I;
				return resultadoF.toString();
			} else {
				resultadoI = v1I + v2I;
				return resultadoI.toString();
			}
		} 
		
		else if (ope == '-') {//SUBTRACAO
			if (temFlutuante == true || temFlutuante2 == true) {
				resultadoF = v1F - v2F - v1I - v2I;
				return resultadoF.toString();
			} else {
				resultadoI = v1I - v2I;
				return resultadoI.toString();
			}
		} 
		
		else if (ope == '*') {//MULTIPLICACAO
			if (temFlutuante == true || temFlutuante2 == true) {//tem algum flutuante
				if ((temFlutuante == true && temFlutuante2 == true) == true) {//os dois sao
                    resultadoF= v1F*v2F;

				} 
				else if ((temFlutuante == true && temFlutuante2 == true) == false) {//tem 1 flutuante
                   if(v1F>0) 
                	   v2F=1D; // elemento neutro da multiplicacao e divisao
                   else
                	   v1F=1D; // elemento neutro da multiplicacao e divisao
                   if(v1I>0) 
                	   v2I=1L; // elemento neutro da multiplicacao e divisao
                   else
                	   v1I=1L; // elemento neutro da multiplicacao e divisao
                   resultadoF = v1F * v2F * v1I * v2I;
				}
				return resultadoF.toString();
			} 
			else {
				resultadoI = v1I * v2I;
				return resultadoI.toString();
			}
		} 
		
		else if (ope == '/') {//DIVISAO
			Double vD1 ;
			Double vD2 ;
			if(v1I>v1F)
                   vD1=(double)v1I;
			else
				vD1=v1F;
			
			if(v2I>v2F)
                vD2=(double)v2I;
			else
				vD2=v2F;
				resultadoF =(vD1/vD2);
				if(resultadoF%1==0) {
					resultadoI=(long)(vD1/vD2);
					return resultadoI.toString();
				}
				return resultadoF.toString();
			
		}
		return valor;
	}
	public static Memoria getMemoria() {
		return memoria;
	}

}
