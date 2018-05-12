package com.multiva.cecoban.validarcpv.dto.response;

import org.springframework.stereotype.Component;

@Component
public class MinutiaeResponse {

	private Minucia minucia;
	
	public Minucia getMinucia() {
		return minucia;
	}
	public void setMinucia(Minucia minucia) {
		this.minucia = minucia;
	}
	
	@Override
	public String toString() {
		return "MinutiaeResponse [minucia=" + minucia + "]";
	}

}
