package com.multiva.cecoban.validarcpv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.multiva.cecoban.commons.dto.request.TransactionRequest;
import com.multiva.cecoban.commons.dto.response.TransactionResponse;
import com.multiva.cecoban.commons.service.TransactionLogApiService;
import com.multiva.cecoban.validarcpv.dto.request.DataRequest;
import com.multiva.cecoban.validarcpv.dto.request.Datos;
import com.multiva.cecoban.validarcpv.dto.request.Encabezado;
import com.multiva.cecoban.validarcpv.dto.request.Localidad;
import com.multiva.cecoban.validarcpv.dto.request.Minucias;
//import com.multiva.cecoban.validarcpv.dto.request.PosicionSatelital;
import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.request.Ubicacion;
import com.multiva.cecoban.validarcpv.dto.response.ResponseBody;
import com.multiva.cecoban.validarcpv.service.ValidarCpvApiService;

import io.swagger.annotations.ApiOperation;

//Configuración temporal 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ValidarCpvApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidarCpvApiController.class);
	
	@Autowired
	private ValidarCpvApiService service;
	
	@Autowired
	private TransactionLogApiService transactionLogService;
	
	@Autowired
	private Encabezado.Builder encabezadoBuilder;
	
	@Autowired
	private Datos.Builder datosBuilder;
	
	@Autowired
	private Minucias.Builder minuciasBuilder;

	@Autowired
	private Request.Builder requestBuilder;
	
	@Autowired
	private Ubicacion ubicacion;
	
	@Autowired
	private Localidad localidad;
	
	@Autowired
	private 	List<Minucias> minuciasArray;
	
	/*@Autowired
	private PosicionSatelital posicionSatelital;*/
	
	@Autowired
	private TransactionRequest transactionRequest;
	
	private Request request;
	
	@Value("${cecoban.validarcpv.formatoimagen}")
	private String formatoImagen;
	
	@ApiOperation(value = "Permite recibir los datos que se encuentran en la credencial para votar, así como la(s) minucias.",response = ResponseBody.class)
	@PostMapping("/validarCPV")
	public ResponseBody validarCpv(@RequestBody DataRequest dataRequest){
		
		LOGGER.info("ocr --> {}", dataRequest.getOcr());
		LOGGER.info("cic --> {}", dataRequest.getCic());
		LOGGER.info("nombre --> {}", dataRequest.getNombre());
		LOGGER.info("apellidoPaterno --> {}", dataRequest.getApellidoPaterno());
		LOGGER.info("apellidoMaterno --> {}", dataRequest.getApellidoMaterno());
		LOGGER.info("anioRegistro --> {}", dataRequest.getAnioRegistro());
		LOGGER.info("anioEmision --> {}", dataRequest.getAnioEmision());
		LOGGER.info("numeroEmision --> {}", dataRequest.getNumeroEmision());
		LOGGER.info("claveElector --> {}", dataRequest.getClaveElector());	
		LOGGER.info("curp --> {}", dataRequest.getCurp());
		LOGGER.info("curp --> {}", dataRequest.getCurp());
		LOGGER.info("ciudad --> {}", dataRequest.getCiudad());
		LOGGER.info("estado --> {}", dataRequest.getEstado());
		LOGGER.info("imagenIndiceDerecho --> {}", dataRequest.getImagenIndiceDerecho());
		LOGGER.info("imagenIndiceIzquierdo --> {}", dataRequest.getImagenIndiceIzquierdo());
		LOGGER.info("consentimiento --> {}", dataRequest.isConsentimiento());
		
		String uniqueId = createID();
		
		Encabezado encabezado = encabezadoBuilder.solicitudId(uniqueId)
				.folioCliente("226553239617444307").build();
		
		Datos datos = datosBuilder
				.ocr(Long.parseLong(dataRequest.getOcr())).cic(Long.parseLong(dataRequest.getCic()))
				.nombre(dataRequest.getNombre()).apellidoPaterno(dataRequest.getApellidoPaterno())
				.apellidoMaterno(dataRequest.getApellidoMaterno()).anioRegistro(dataRequest.getAnioRegistro())
				.anioEmision(dataRequest.getAnioEmision()).numeroEmisionCredencial(dataRequest.getNumeroEmision())
				.claveElector(dataRequest.getClaveElector()).curp(dataRequest.getCurp()).build();
		
		localidad.setCiudad(dataRequest.getCiudad());
		localidad.setCodigoPostal(dataRequest.getCodigoPostal());
		localidad.setEstado(dataRequest.getEstado());
		
		if(dataRequest.getImagenIndiceDerecho() != null && !dataRequest.getImagenIndiceDerecho().isEmpty()) {
			agregarMinucia(dataRequest.getImagenIndiceDerecho(), 2);
		}
		
		if(dataRequest.getImagenIndiceIzquierdo() != null && !dataRequest.getImagenIndiceIzquierdo().isEmpty()) {
			agregarMinucia(dataRequest.getImagenIndiceIzquierdo(), 7);
		}
		
		ubicacion.setLocalidad(localidad);
		
		if(minuciasArray.size()!=0) {
			request = requestBuilder.encabezado(encabezado).datos(datos).ubicacion(ubicacion)
					.consentimiento(dataRequest.isConsentimiento() ? 1 : 0).minucias(minuciasArray).build();
		}else {
			request = requestBuilder.encabezado(encabezado).datos(datos).ubicacion(ubicacion)
					.consentimiento(dataRequest.isConsentimiento() ? 1 : 0).build();
		}
		
		return service.validarCpv(request);
	}

	private String createID()
	{	
		TransactionResponse transactionResponse = transactionLogService.createTransaction(transactionRequest);
		String str = String.format("%018d", transactionResponse.getSolicitudId());  // Numero identificador de 18 dígitos
	    return str;
	}
	
	private void agregarMinucia(String imagen, int dedo) {
		//String encoded = Base64.getEncoder().encodeToString(imagen.getBytes());
		Minucias minuciasDer = minuciasBuilder.tipo(formatoImagen)
				.dedo(dedo)
				.minucia(imagen).build();
				//.minucia(encoded).build();	
				
		minuciasArray.add(minuciasDer);
	}

}
