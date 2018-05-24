package com.multiva.cecoban.validarcpv.service;

import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.response.ResponseBody;

public interface ValidarCpvApiService {
	
	ResponseBody validarCpv(Request request);

}
