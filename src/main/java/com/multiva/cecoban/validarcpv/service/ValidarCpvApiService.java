package com.multiva.cecoban.validarcpv.service;

import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.response.BodyResponse;

public interface ValidarCpvApiService {
	
	BodyResponse validarCpv(Request request);

}
