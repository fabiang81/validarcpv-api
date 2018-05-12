package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class Minucia {
	
	private int codigoRespuestaMinucia;
	private double similitud2;
	private double similitud7;
	
	public int getCodigoRespuestaMinucia() {
		return codigoRespuestaMinucia;
	}
	public void setCodigoRespuestaMinucia(int codigoRespuestaMinucia) {
		this.codigoRespuestaMinucia = codigoRespuestaMinucia;
	}
	public double getSimilitud2() {
		return similitud2;
	}
	public void setSimilitud2(double similitud2) {
		this.similitud2 = similitud2;
	}
	public double getSimilitud7() {
		return similitud7;
	}
	public void setSimilitud7(double similitud7) {
		this.similitud7 = similitud7;
	}
	
	@Override
	public String toString() {
		return "Minucia [codigoRespuestaMinucia=" + codigoRespuestaMinucia + ", similitud2=" + similitud2
				+ ", similitud7=" + similitud7 + "]";
	}

}
