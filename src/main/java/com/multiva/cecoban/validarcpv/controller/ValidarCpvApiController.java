package com.multiva.cecoban.validarcpv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.multiva.cecoban.validarcpv.dto.request.Datos;
import com.multiva.cecoban.validarcpv.dto.request.Encabezado;
import com.multiva.cecoban.validarcpv.dto.request.Localidad;
import com.multiva.cecoban.validarcpv.dto.request.Minucias;
//import com.multiva.cecoban.validarcpv.dto.request.PosicionSatelital;
import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.request.Ubicacion;
import com.multiva.cecoban.validarcpv.dto.response.BodyResponse;
import com.multiva.cecoban.validarcpv.service.ValidarCpvApiService;

@RestController
public class ValidarCpvApiController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidarCpvApiController.class);
	
	private static AtomicLong idCounter = new AtomicLong();
	
	@Autowired
	private ValidarCpvApiService service;
	
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
	
	private Request request;
	
	@Value("${cecoban.validarcpv.formatoimagen}")
	private String formatoImagen;
	
	@PostMapping("/validarcpv")
	public BodyResponse validarCpv(
			@RequestParam("ocr") String ocr, 
			@RequestParam("cic") String cic, 
			@RequestParam("nombre") String nombre,
			@RequestParam("apellidoPaterno") String apellidoPaterno,
			@RequestParam(value="apellidoMaterno", required=false) String apellidoMaterno,
			@RequestParam(value="anioRegistro", required=false) String anioRegistro,
			@RequestParam(value="anioEmision", required=false) String anioEmision,
			@RequestParam("numeroEmisionCredencial") String numeroEmision,
			@RequestParam("claveElector") String claveElector,
			@RequestParam(value="curp", required=false) String curp,
			@RequestParam("codigoPostal") String codigoPostal,
			@RequestParam("ciudad") String ciudad,
			@RequestParam("estado") int estado,
			@RequestParam(value="imagenIndiceDerecho", required=false) String imagenIndiceDerecho,
			@RequestParam(value="imagenIndiceIzquierdo", required=false) String imagenIndiceIzquierdo,
			@RequestParam("consentimiento") boolean consentimiento){
		
		LOGGER.info("ocr --> {}", ocr);
		LOGGER.info("cic --> {}", cic);
		LOGGER.info("nombre --> {}", nombre);
		LOGGER.info("apellidoPaterno --> {}", apellidoPaterno);
		LOGGER.info("apellidoMaterno --> {}", apellidoMaterno);
		LOGGER.info("anioRegistro --> {}", anioRegistro);
		LOGGER.info("anioEmision --> {}", anioEmision);
		LOGGER.info("numeroEmision --> {}", numeroEmision);
		LOGGER.info("claveElector --> {}", claveElector);	
		LOGGER.info("curp --> {}", curp);
		LOGGER.info("curp --> {}", codigoPostal);
		LOGGER.info("ciudad --> {}", ciudad);
		LOGGER.info("estado --> {}", estado);
		LOGGER.info("imagenIndiceDerecho --> {}", imagenIndiceDerecho);
		LOGGER.info("imagenIndiceIzquierdo --> {}", imagenIndiceIzquierdo);
		LOGGER.info("consentimiento --> {}", consentimiento);
		
		String uniqueId = createID();
		
		Encabezado encabezado = encabezadoBuilder.solicitudId(uniqueId)
				.folioCliente("226553239617444307").build();
		
		Datos datos = datosBuilder.ocr(Long.parseLong(ocr)).cic(Long.parseLong(cic)).nombre(nombre).apellidoPaterno(apellidoPaterno)
				.apellidoMaterno(apellidoMaterno).anioRegistro(anioRegistro).anioEmision(anioEmision)
				.numeroEmisionCredencial(numeroEmision).claveElector(claveElector).curp(curp).build();
		
		localidad.setCiudad(ciudad);
		localidad.setCodigoPostal(codigoPostal);
		localidad.setEstado(estado);
		
		if(imagenIndiceDerecho != null && !imagenIndiceDerecho.isEmpty()) {
			agregarMinucia(imagenIndiceIzquierdo, 2);
		}
		
		if(imagenIndiceIzquierdo != null && !imagenIndiceIzquierdo.isEmpty()) {
			agregarMinucia(imagenIndiceIzquierdo, 7);
		}
		
		ubicacion.setLocalidad(localidad);
		
		if(minuciasArray.size()!=0) {
			request = requestBuilder.encabezado(encabezado).datos(datos).ubicacion(ubicacion)
					.consentimiento(consentimiento ? 1 : 0).minucias(minuciasArray).build();
		}else {
			request = requestBuilder.encabezado(encabezado).datos(datos).ubicacion(ubicacion)
					.consentimiento(consentimiento ? 1 : 0).build();
		}
		
		return service.validarCpv(request);
	}

	private static String createID()
	{	
		//String str = String.format("%018d", idCounter.getAndIncrement());  // Numero identificador de 18 dígitos
		String str = "290553239617443019";
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
