package com.multiva.cecoban.validarcpv.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.multiva.cecoban.validarcpv.client.ValidarCpvApiClient;
import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.response.ResponseBody;
import com.multiva.cecoban.validarcpv.dto.response.ComparacionCurp;
import com.multiva.cecoban.validarcpv.dto.response.DataResponse;
import com.multiva.cecoban.validarcpv.dto.response.Digestivos;
import com.multiva.cecoban.validarcpv.dto.response.MinutiaeResponse;
import com.multiva.cecoban.validarcpv.dto.response.Response;
import com.multiva.cecoban.validarcpv.dto.response.RespuestaComparacion;
import com.multiva.cecoban.validarcpv.dto.response.RespuestaSituacionRegistral;
import com.multiva.cecoban.validarcpv.dto.response.TimeStamp;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ValidarCpvApiServiceImpl implements ValidarCpvApiService {
	
	@Autowired
	private ValidarCpvApiClient client;
	
	@Autowired
	private Response.Builder responseBuilder;
	
	@Autowired
	private RespuestaComparacion.Builder respuestaComparacionBuilder;
	
	@Autowired
	private ComparacionCurp.Builder comparacionCurpBuilder;
	
	@Autowired
	private ResponseBody.Builder bodyResponseBuilder;
	
	@Autowired
	private RespuestaSituacionRegistral respuestaSituacionRegistral;
	
	@Autowired
	private TimeStamp timeStamp;
	
	@Autowired
	private Digestivos digestivos;
	
	@Autowired
	private MinutiaeResponse minutiaeResponse;
	
	@Autowired
	private DataResponse dataResponse;
	
	private Response response;
	
	private ComparacionCurp comparacionCurp;

	@Override
	public ResponseBody validarCpv(Request request) {
		
		JSONObject jsonCecobanResponse = client.validarCpv(request);
		
		try {
			convertResponseJsonToJava(jsonCecobanResponse);
			convertTimeStampJsonToJava(jsonCecobanResponse);
			convertDigestivosJsonToJava(jsonCecobanResponse);
			convertComparacionCurpJsonToJava(jsonCecobanResponse);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ResponseBody bodyResponse = 	bodyResponseBuilder
				.response(response)
				.timeStamp(timeStamp)
				.digestivos(digestivos)
				.comparacionCurp(comparacionCurp).build();
		
		return bodyResponse;
	}
	
	private Response convertResponseJsonToJava(JSONObject jsonCecobanResponse) throws JSONException {
		JSONObject jsonResponse = jsonCecobanResponse.getJSONObject("response");
		JSONObject jsonDataResponse = validateJsonField(jsonResponse, "dataResponse");
		if(jsonDataResponse != null) {
			JSONObject jsonRespuestaComparacion = jsonDataResponse.getJSONObject("respuestaComparacion");
			JSONObject jsonRespuestaSituacionRegistral = jsonDataResponse.getJSONObject("respuestaSituacionRegistral");
			RespuestaComparacion respuestaComparacion = respuestaComparacionBuilder
					.ocr(validateJsonBooleanField(jsonRespuestaComparacion, "ocr"))
					.nombre(validateJsonBooleanField(jsonRespuestaComparacion, "nombre"))
					.apellidoPaterno(validateJsonBooleanField(jsonRespuestaComparacion, "apellidoPaterno"))
					.apellidoMaterno(validateJsonBooleanField(jsonRespuestaComparacion, "apellidoMaterno"))
					.anioRegistro(validateJsonBooleanField(jsonRespuestaComparacion, "anioRegistro"))
					.anioEmision(validateJsonBooleanField(jsonRespuestaComparacion, "anioEmision"))
					.numeroEmisionCredencial(validateJsonBooleanField(jsonRespuestaComparacion, "numeroEmisionCredencial"))
					.claveElector(validateJsonBooleanField(jsonRespuestaComparacion, "claveElector"))
					.curp(validateJsonBooleanField(jsonRespuestaComparacion, "curp")).build();
			
			respuestaSituacionRegistral.setTipoSituacionRegistral(validateJsonField(jsonRespuestaSituacionRegistral, "tipoSituacionRegistral"));
			respuestaSituacionRegistral.setTipoReporteRoboExtravio(validateJsonField(jsonRespuestaSituacionRegistral, "tipoReporteRoboExtravio"));
			
			dataResponse.setCodigoRespuestaDatos(validateJsonField(jsonDataResponse, "codigoRespuestaDatos"));
			dataResponse.setRespuestaComparacion(respuestaComparacion);
			dataResponse.setRespuestaSituacionRegistral(respuestaSituacionRegistral);
			
			JSONObject jsonMinutiaeResponse = validateJsonField(jsonResponse, "minutiaeResponse");
			
			minutiaeResponse.setCodigoRespuestaMinucia(validateJsonField(jsonMinutiaeResponse, "codigoRespuestaMinucia"));
			minutiaeResponse.setSimilitud2(validateJsonField(jsonMinutiaeResponse, "similitud2"));
			minutiaeResponse.setSimilitud7(validateJsonField(jsonMinutiaeResponse, "similitud7"));
			
		}else {
			dataResponse = null;
			minutiaeResponse = null;
		}
		
		response = responseBuilder
				.minutiaeResponse(minutiaeResponse)
				.codigoRespuesta(validateJsonField(jsonResponse, "codigoRespuesta"))
				.fechaHoraPeticion(validateJsonField(jsonResponse, "fechaHoraPeticion"))
				.tiempoProcesamiento(validateJsonField(jsonResponse, "tiempoProcesamiento"))
				.indiceSolicitud(validateJsonField(jsonResponse, "indiceSolicitud"))
				.peticionId(validateJsonField(jsonResponse, "peticionId"))
				.folioCliente(validateJsonField(jsonResponse, "folioCliente"))
				.codigoRespuestaCCB(validateJsonField(jsonResponse, "codigoRespuestaCCB"))
				.descripcionRespuestaCCB(validateJsonField(jsonResponse, "descripcionRespuestaCCB"))
				.dataResponse(dataResponse).build();
		
		return response;
	}
	
	private TimeStamp convertTimeStampJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonTimeStamp = validateJsonField(jsonCecobanResponse, "timeStamp");
		if(jsonTimeStamp != null) {
			timeStamp.setMomento(validateJsonField(jsonTimeStamp, "momento"));
			timeStamp.setIndice(validateJsonField(jsonTimeStamp, "indice"));
			timeStamp.setNumeroSerie(validateJsonField(jsonTimeStamp, "numeroSerie"));
		}else {
			timeStamp = null;
		}
		return timeStamp;
		
	}
	
	private Digestivos convertDigestivosJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonDigestivos = validateJsonField(jsonCecobanResponse, "digestivos");
		if(jsonDigestivos != null) {
			digestivos.setDigEntradaDatos(validateJsonField(jsonDigestivos, "digEntradaDatos"));
			digestivos.setDigSalidaDatos(validateJsonField(jsonDigestivos, "digSalidaDatos"));
			digestivos.setDigTimestamp(validateJsonField(jsonDigestivos, "digTimeStamp"));
		}else {
			digestivos = null;
		}
		return digestivos;
	}
	
	private ComparacionCurp convertComparacionCurpJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonComparacionCurp= validateJsonField(jsonCecobanResponse, "comparacionCURP");
		if(jsonComparacionCurp != null) {
			comparacionCurp = comparacionCurpBuilder.curpCoincide(validateJsonField(jsonComparacionCurp, "curpCoincide"))
					.nombreCoincide(validateJsonBooleanField(jsonComparacionCurp, "nombreCoincide"))
					.apellidoPaternoCoincide(validateJsonBooleanField(jsonComparacionCurp, "apellidoPaternoCoincide"))
					.apellidoMaternoCoincide(validateJsonBooleanField(jsonComparacionCurp, "apellidoMaternoCoincide"))
					.codigoRespuestaCCB(validateJsonField(jsonComparacionCurp, "codigoRespuestaCCB"))
					.descripcionRespuestaCCB(validateJsonField(jsonComparacionCurp, "descripcionRespuestaCCB"))
					.codigoRespuestaRENAPO(validateJsonField(jsonComparacionCurp, "codigoRespuestaRENAPO"))
					.descripcionRespuestaRENAPO(validateJsonField(jsonComparacionCurp, "descripcionRespuestaRENAPO")).build();
		}else {
			comparacionCurp = null;
		}
		return comparacionCurp;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T validateJsonField(JSONObject jsonString, String field) {
		if(jsonString!=null && jsonString.has(field)) {
			return (T) jsonString.get(field);
		}
		return null;
	}
	
	private Boolean validateJsonBooleanField(JSONObject jsonString, String field) {
		if(jsonString!=null && jsonString.has(field)) {
			return jsonString.getBoolean(field);
		}
		return false;
	}
}
