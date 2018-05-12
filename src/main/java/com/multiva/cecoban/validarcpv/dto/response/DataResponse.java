package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class DataResponse {
	
	private int codigoRespuestaDatos;
	private RespuestaComparacion respuestaComparacion;
	private RespuestaSituacionRegistral respuestaSituacionRegistral;
	
	public int getCodigoRespuestaDatos() {
		return codigoRespuestaDatos;
	}
	public void setCodigoRespuestaDatos(int codigoRespuestaDatos) {
		this.codigoRespuestaDatos = codigoRespuestaDatos;
	}
	public RespuestaComparacion getRespuestaComparacion() {
		return respuestaComparacion;
	}
	public void setRespuestaComparacion(RespuestaComparacion respuestaComparacion) {
		this.respuestaComparacion = respuestaComparacion;
	}
	public RespuestaSituacionRegistral getRespuestaSituacionRegistral() {
		return respuestaSituacionRegistral;
	}
	public void setRespuestaSituacionRegistral(RespuestaSituacionRegistral respuestaSituacionRegistral) {
		this.respuestaSituacionRegistral = respuestaSituacionRegistral;
	}
	
	@Override
	public String toString() {
		return "DataResponse [codigoRespuestaDatos=" + codigoRespuestaDatos + ", respuestaComparacion="
				+ respuestaComparacion + ", respuestaSituacionRegistral=" + respuestaSituacionRegistral + "]";
	}

}
