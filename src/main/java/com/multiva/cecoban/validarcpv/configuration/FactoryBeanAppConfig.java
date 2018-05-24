package com.multiva.cecoban.validarcpv.configuration;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.multiva.cecoban.validarcpv.dto.request.Datos;
import com.multiva.cecoban.validarcpv.dto.request.Encabezado;
import com.multiva.cecoban.validarcpv.dto.request.Minucias;
import com.multiva.cecoban.validarcpv.dto.request.Request;
import com.multiva.cecoban.validarcpv.dto.response.ResponseBody;
import com.multiva.cecoban.validarcpv.dto.response.ComparacionCurp;
import com.multiva.cecoban.validarcpv.dto.response.Response;
import com.multiva.cecoban.validarcpv.dto.response.RespuestaComparacion;

@Configuration
@ComponentScan("com.multiva.cecoban.commons.*")
public class FactoryBeanAppConfig {
	
	/**Beans configurados para la clase ValidarCpvApiController
	 * 
	 */
	
	@Bean
	public List<Minucias> minuciasArray(){
		return new ArrayList<>();
	}
	
	@Bean
	public Datos.Builder datos() {
		return new Datos.Builder();
	}
	
	@Bean
	public Minucias.Builder minucias(){
		return new Minucias.Builder();
	}
	
	@Bean
	public Request.Builder request() {
		return new Request.Builder();
	}
	
	@Bean
	public Encabezado.Builder encabezado(){
		return new Encabezado.Builder();
	}
	
	//
	
	/**Beans configurados para la clase ValidarCpvApiClientImpl
	 * 
	 */
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public JSONObject jsonObject() {
		return new JSONObject();
	}
	
	@Bean 
	public HttpHeaders httpHeaders() {
		return new HttpHeaders();
	}
	
	//
	
	/**Beans configurados para la clase ValidarCpvApiServiceImpl----------------
	 * 
	 */
	@Bean
	public Response.Builder response(){
		return new Response.Builder();
	}
	
	@Bean
	public RespuestaComparacion.Builder respuestaComparacion(){
		return new RespuestaComparacion.Builder();
	}
	
	@Bean
	public ComparacionCurp.Builder comparacionCurp(){
		return new ComparacionCurp.Builder();
	}
	
	@Bean
	public ResponseBody.Builder bodyResponse(){
		return new ResponseBody.Builder();
	}

}
