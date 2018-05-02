package com.multiva.cecoban.validarcpv.dto.response;

public class CredencialElector extends GeneralData{
	
	private int ocr;
	private int cic;
	private String anioRegistro;
	private String anioEmision;
	private String numeroEmision;
	private String claveElector;
	private String curp;
	
	public int getOcr() {
		return ocr;
	}
	public void setOcr(int ocr) {
		this.ocr = ocr;
	}
	public int getCic() {
		return cic;
	}
	public void setCic(int cic) {
		this.cic = cic;
	}
	public String getAnioRegistro() {
		return anioRegistro;
	}
	public void setAnioRegistro(String anioRegistro) {
		this.anioRegistro = anioRegistro;
	}
	public String getAnioEmision() {
		return anioEmision;
	}
	public void setAnioEmision(String anioEmision) {
		this.anioEmision = anioEmision;
	}
	public String getNumeroEmision() {
		return numeroEmision;
	}
	public void setNumeroEmision(String numeroEmision) {
		this.numeroEmision = numeroEmision;
	}
	public String getClaveElector() {
		return claveElector;
	}
	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}

}
