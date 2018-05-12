package com.multiva.cecoban.validarcpv.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiva.cecoban.validarcpv.controller.ValidarCpvApiController;
import com.multiva.cecoban.validarcpv.dto.request.Request;

@Component
public class ValidarCpvApiClientImpl implements ValidarCpvApiClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidarCpvApiController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JSONObject jsonObject;
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	ObjectMapper mapper;
	
	@Value("${cecoban.validarcpv.serviceURL}")
	private String validarCpvUrl;
	
	//Descomentar para propósitos de testing sólamente
	static {
	    disableSslVerification();
	}//

	@Override
	public JSONObject validarCpv(Request request) {
		
		String jsonString = "";
		HttpEntity<String> httpEntity;
		
		try {
			jsonString = mapper.writeValueAsString(request);
			LOGGER.info("Request object converted to JSON String --> {}", jsonString);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			httpEntity = new HttpEntity<>(jsonString, httpHeaders);
			
			@SuppressWarnings("rawtypes")
			ResponseEntity<Map> validarCpvresponse = restTemplate.exchange(validarCpvUrl, HttpMethod.POST, httpEntity, Map.class);
			if (validarCpvresponse.getStatusCode() == HttpStatus.OK) {
				LOGGER.info("validarCpvresponse.getStatusCode() --> {}", validarCpvresponse.getStatusCode());
	    			jsonObject = new JSONObject(validarCpvresponse.getBody());
				LOGGER.info("jsonObject response --> {}", jsonObject.toString());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} /*catch (JSONException e) {
			e.printStackTrace();
		}*/
		return jsonObject;
	}
	
	/**Descomentar el método para propósitos de testing solamente
	 * 
	 */
	private static void disableSslVerification() {
	    try
	    {
	        // Create a trust manager that does not validate certificate chains
	        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	            }
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	            }
	        }
	        };

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					// TODO Auto-generated method stub
					return true;
				}
	        };

	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	}
	
}
