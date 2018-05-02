package com.multiva.cecoban.validarcpv.client;

import org.springframework.stereotype.Component;

import com.multiva.cecoban.validarcpv.dto.response.CredencialElector;

@Component
public class ValidarCpvRestClientImpl implements ValidarCpvRestClient {

	@Override
	public CredencialElector validarCpv() {
		CredencialElector credencialElector= new CredencialElector();
		credencialElector.setNombre("Fabian");
		credencialElector.setApellidoPaterno("Gonzalez");
		credencialElector.setApellidoMaterno("Arellano");
		credencialElector.setOcr(12345678);
		credencialElector.setCic(2468);
		credencialElector.setAnioRegistro("2010");
		credencialElector.setAnioEmision("2019");
		credencialElector.setNumeroEmision("288480");
		credencialElector.setClaveElector("GOAR3488484");
		credencialElector.setCurp("GOAR829374KH9");
		return credencialElector;
	}

}
