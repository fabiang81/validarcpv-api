package com.multiva.cecoban.validarcpv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiva.cecoban.validarcpv.client.ValidarCpvRestClient;
import com.multiva.cecoban.validarcpv.dto.response.CredencialElector;

@RestController
public class ServiceRestController {
	
	@Autowired
	ValidarCpvRestClient client;
	
	@GetMapping("/validarcpv")
	public CredencialElector validarCpv(){
		return client.validarCpv();
	}

}
