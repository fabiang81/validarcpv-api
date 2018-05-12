package com.multiva.cecoban.validarcpv.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiva.cecoban.validarcpv.client.ValidarCpvApiClient;
import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.response.BodyResponse;
import com.multiva.cecoban.validarcpv.dto.response.ComparacionCurp;
import com.multiva.cecoban.validarcpv.dto.response.DataResponse;
import com.multiva.cecoban.validarcpv.dto.response.Digestivos;
import com.multiva.cecoban.validarcpv.dto.response.Response;
import com.multiva.cecoban.validarcpv.dto.response.RespuestaComparacion;
import com.multiva.cecoban.validarcpv.dto.response.RespuestaSituacionRegistral;
import com.multiva.cecoban.validarcpv.dto.response.TimeStamp;

@Service
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
	private BodyResponse.Builder bodyResponseBuilder;
	
	@Autowired
	private RespuestaSituacionRegistral respuestaSituacionRegistral;
	
	@Autowired
	private DataResponse dataResponse;
	
	@Autowired
	private TimeStamp timeStamp;
	
	@Autowired
	private Digestivos digestivos;
	
	private Response response;
	
	private ComparacionCurp comparacionCurp;

	@Override
	public BodyResponse validarCpv(Request request) {
		/**
		 * TODO:
		 * Validación de request 
		 */
		
		JSONObject jsonCecobanResponse = client.validarCpv(request);
		
		try {
			JSONObject jsonResponse = jsonCecobanResponse.getJSONObject("response");
			if(jsonResponse.getString("codigoRespuestaCCB").equals("CRGEN000")) {
				convertResponseJsonToJava(jsonResponse);
				convertTimeStampJsonToJava(jsonCecobanResponse);
				convertDigestivosJsonToJava(jsonCecobanResponse);
				convertComparacionCurpJsonToJava(jsonCecobanResponse);
			}else {
				response = responseBuilder.codigoRespuesta(jsonResponse.getInt("codigoRespuesta"))
						.tiempoProcesamiento(jsonResponse.getInt("tiempoProcesamiento"))
						.codigoRespuestaCCB(jsonResponse.getString("codigoRespuestaCCB"))
						.descripcionRespuestaCCB(jsonResponse.getString("descripcionRespuestaCCB")).build();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		BodyResponse bodyResponse = 	bodyResponseBuilder.response(response)
				.timeStamp(timeStamp)
				.digestivos(digestivos)
				.comparacionCurp(comparacionCurp).build();
		
		return bodyResponse;
	}
	
	private Response convertResponseJsonToJava(JSONObject jsonResponse) throws JSONException {	
		JSONObject jsonDataResponse = jsonResponse.getJSONObject("dataResponse");
		JSONObject jsonRespuestaComparacion = jsonDataResponse.getJSONObject("respuestaComparacion");
		JSONObject jsonRespuestaSituacionRegistral = jsonDataResponse.getJSONObject("respuestaSituacionRegistral");
		
		RespuestaComparacion respuestaComparacion = respuestaComparacionBuilder.ocr(jsonRespuestaComparacion.getBoolean("ocr"))
				.nombre(jsonRespuestaComparacion.getBoolean("nombre"))
				.apellidoPaterno(jsonRespuestaComparacion.getBoolean("apellidoPaterno"))
				.apellidoMaterno(jsonRespuestaComparacion.getBoolean("apellidoMaterno"))
				.anioRegistro(jsonRespuestaComparacion.getBoolean("anioRegistro"))
				.anioEmision(jsonRespuestaComparacion.getBoolean("anioEmision"))
				.numeroEmisionCredencial(jsonRespuestaComparacion.getBoolean("numeroEmisionCredencial"))
				.claveElector(jsonRespuestaComparacion.getBoolean("claveElector"))
				.curp(jsonRespuestaComparacion.getBoolean("curp")).build();
		
		respuestaSituacionRegistral.setTipoSituacionRegistral(jsonRespuestaSituacionRegistral.getString("tipoSituacionRegistral"));
		respuestaSituacionRegistral.setTipoReporteRoboExtravio(jsonRespuestaSituacionRegistral.getString("tipoReporteRoboExtravio"));
		
		dataResponse.setCodigoRespuestaDatos(jsonDataResponse.getInt("codigoRespuestaDatos"));
		dataResponse.setRespuestaComparacion(respuestaComparacion);
		dataResponse.setRespuestaSituacionRegistral(respuestaSituacionRegistral);
				
		response = responseBuilder.codigoRespuesta(jsonResponse.getInt("codigoRespuesta"))
				.fechaHoraPeticion(jsonResponse.getString("fechaHoraPeticion"))
				.tiempoProcesamiento(jsonResponse.getInt("tiempoProcesamiento"))
				.indiceSolicitud(jsonResponse.getString("indiceSolicitud"))
				.peticionId(jsonResponse.getString("peticionId"))
				.folioCliente(jsonResponse.getString("folioCliente"))
				.codigoRespuestaCCB(jsonResponse.getString("codigoRespuestaCCB"))
				.descripcionRespuestaCCB(jsonResponse.getString("descripcionRespuestaCCB"))
				.dataResponse(dataResponse).build();
		
		return response;
	}
	
	private TimeStamp convertTimeStampJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonTimeStamp = jsonCecobanResponse.getJSONObject("timeStamp");
		timeStamp.setMomento(jsonTimeStamp.getString("momento"));
		timeStamp.setIndice(jsonTimeStamp.getString("indice"));
		timeStamp.setNumeroSerie(jsonTimeStamp.getString("numeroSerie"));
		
		return timeStamp;
		
	}
	
	private Digestivos convertDigestivosJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonDigestivos = jsonCecobanResponse.getJSONObject("digestivos");
		digestivos.setDigEntradaDatos(jsonDigestivos.getString("digEntradaDatos"));
		digestivos.setDigSalidaDatos(jsonDigestivos.getString("digSalidaDatos"));
		digestivos.setDigTimestamp(jsonDigestivos.getString("digTimeStamp"));
		return digestivos;
	}
	
	private ComparacionCurp convertComparacionCurpJsonToJava(JSONObject jsonCecobanResponse) throws JSONException{
		JSONObject jsonComparacionCurp= jsonCecobanResponse.getJSONObject("comparacionCURP");
		comparacionCurp = comparacionCurpBuilder.curpCoincide(jsonComparacionCurp.getBoolean("curpCoincide"))
				.nombreCoincide(jsonComparacionCurp.getBoolean("nombreCoincide"))
				.apellidoPaternoCoincide(jsonComparacionCurp.getBoolean("apellidoPaternoCoincide"))
				.apellidoMaternoCoincide(jsonComparacionCurp.getBoolean("apellidoMaternoCoincide"))
				.codigoRespuestaCCB(jsonComparacionCurp.getString("codigoRespuestaCCB"))
				.descripcionRespuestaCCB(jsonComparacionCurp.getString("descripcionRespuestaCCB"))
				.codigoRespuestaRENAPO(jsonComparacionCurp.getString("codigoRespuestaRENAPO"))
				.descripcionRespuestaRENAPO(jsonComparacionCurp.getString("descripcionRespuestaRENAPO")).build();
		return comparacionCurp;
	}

}
