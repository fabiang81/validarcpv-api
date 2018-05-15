package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class MinutiaeResponse {
	
	private Integer codigoRespuestaMinucia;
	private String similitud2;
	private String similitud7;
	
	public Integer getCodigoRespuestaMinucia() {
		return codigoRespuestaMinucia;
	}
	public void setCodigoRespuestaMinucia(Integer codigoRespuestaMinucia) {
		this.codigoRespuestaMinucia = codigoRespuestaMinucia;
	}
	public String getSimilitud2() {
		return similitud2;
	}
	public void setSimilitud2(String similitud2) {
		this.similitud2 = similitud2;
	}
	public String getSimilitud7() {
		return similitud7;
	}
	public void setSimilitud7(String similitud7) {
		this.similitud7 = similitud7;
	}
	
	@Override
	public String toString() {
		return "Minucia [codigoRespuestaMinucia=" + codigoRespuestaMinucia + ", similitud2=" + similitud2
				+ ", similitud7=" + similitud7 + "]";
	}

}
