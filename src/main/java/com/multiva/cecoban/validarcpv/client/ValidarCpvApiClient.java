package com.multiva.cecoban.validarcpv.client;

import org.json.JSONObject;

import com.multiva.cecoban.validarcpv.dto.request.Request;

public interface ValidarCpvApiClient {
	
	public JSONObject validarCpv(Request request);

}
