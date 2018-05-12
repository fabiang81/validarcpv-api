package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class RespuestaSituacionRegistral {
	
	private String tipoSituacionRegistral;
	private String tipoReporteRoboExtravio;
	
	public String getTipoSituacionRegistral() {
		return tipoSituacionRegistral;
	}
	public void setTipoSituacionRegistral(String tipoSituacionRegistral) {
		this.tipoSituacionRegistral = tipoSituacionRegistral;
	}
	public String getTipoReporteRoboExtravio() {
		return tipoReporteRoboExtravio;
	}
	public void setTipoReporteRoboExtravio(String tipoReporteRoboExtravio) {
		this.tipoReporteRoboExtravio = tipoReporteRoboExtravio;
	}
	
	@Override
	public String toString() {
		return "RespuestaSituacionRegistral [tipoSituacionRegistral=" + tipoSituacionRegistral
				+ ", tipoReporteRoboExtravio=" + tipoReporteRoboExtravio + "]";
	}
	
}
