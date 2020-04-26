package com.portafolio.util.rest.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.portafolio.util.exceptions.RestClientUtilException;

public class RestClientUtil {
	
	
	/**
	 * This method get the json data metrics from the external service.
	 * 
	 * @param wsUri
	 * @param uriPathParams
	 * @param queryParams
	 * @return JSONObject
	 */
	public static JSONObject getJsonFromWs(String wsUri, Map<String, String> uriPathParams,
			Map<String, String> queryParams, String token, Map<String, Integer> properties) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(wsUri);

		if (queryParams != null && !queryParams.isEmpty()) {
			// Set the query parameters
			for (String queryParanName : queryParams.keySet()) {
				builder.queryParam(queryParanName, queryParams.get(queryParanName));
			}
		}

		URI finalWsUri = builder.build().toUri();
		if (uriPathParams != null && !uriPathParams.isEmpty()) {
			finalWsUri = builder.buildAndExpand(uriPathParams).toUri();
		}

		System.out.println("Uri = "+ finalWsUri);

		// Add the JSON Accept-MediaType to header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		if(!token.equals(null)) {
			requestHeaders.add(HttpHeaders.AUTHORIZATION, token);
		}
		
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(properties.get("connectionTimeout"));
		httpRequestFactory.setConnectTimeout(properties.get("requestTimeout"));
		httpRequestFactory.setReadTimeout(properties.get("readTimeout"));

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

		// Make the HTTP GET request, marshaling the response to a String
		ResponseEntity<String> response = null;
		
		response = retryCallEndpoint(properties, finalWsUri, requestHeaders, restTemplate, response);
		
		if(response != null) {
			
			System.out.println("Response status code = "+ response.getStatusCode());
			
			if (!response.getStatusCode().is2xxSuccessful()) {
				JSONObject error = new JSONObject(response.getBody());
				throw new RestClientUtilException(error.getString("message"));
			}
			
			return new JSONObject(response.getBody().trim());
		}else {
			System.err.println(new RestClientUtilException("Error to call: "+finalWsUri));
			throw new RestClientUtilException("Error to call: {}"+finalWsUri);
		}

	}
	
	private static ResponseEntity<String> retryCallEndpoint(Map<String, Integer> properties, URI finalWsUri,
			HttpHeaders requestHeaders, RestTemplate restTemplate, ResponseEntity<String> response) {
		try {
			response = getResponse(finalWsUri, requestHeaders, restTemplate);
		} catch (HttpServerErrorException restClient){
			if(restClient.getStatusCode().equals(HttpStatus.GATEWAY_TIMEOUT)) {
				System.out.println("GATEWAY TIMEOUT. Code: "+ HttpStatus.GATEWAY_TIMEOUT);
				for (int i = 0; i < properties.get("retryEndPoint");) {
					System.out.println("RERTY CALL ENDPOINT: "+finalWsUri);
					try {
						response = getResponse(finalWsUri, requestHeaders, restTemplate);
						if(response.getStatusCode().equals(HttpStatus.OK)) {
							break;
						}
					} catch (HttpServerErrorException e) {
						i++;
						if (e.getStatusCode().equals(HttpStatus.GATEWAY_TIMEOUT)
								&& i != properties.get("retryEndPoint")) {
							continue;
						} else {
							System.err.println("Error Trying to call EndPoint.");
							System.err.println("EndPoint not respond!!! " +e);
						}
					}
				}
			}
		}
		return response;
	}
	
	private static ResponseEntity<String> getResponse(URI finalWsUri, HttpHeaders requestHeaders,
			RestTemplate restTemplate) {
		ResponseEntity<String> response = restTemplate.exchange(finalWsUri, HttpMethod.GET,
				new HttpEntity<>(requestHeaders), String.class);
		return response;
	}
	
	/**
	 * This method get the json data metrics from the external service.
	 * 
	 * @param wsUri
	 * @param uriPathParams
	 * @param queryParams
	 * @return JSONObject
	 */
	public static JSONArray getJsonArrayFromWs(String wsUri, Map<String, String> uriPathParams,
			Map<String, String> queryParams, String token, Map<String, Integer> properties) {

		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(wsUri);

			if (queryParams != null && !queryParams.isEmpty()) {
				// Set the query parameters
				for (String queryParanName : queryParams.keySet()) {
					builder.queryParam(queryParanName, queryParams.get(queryParanName));
				}
			}

			URI finalWsUri = builder.build().toUri();
			if (uriPathParams != null && !uriPathParams.isEmpty()) {
				finalWsUri = builder.buildAndExpand(uriPathParams).toUri();
			}

			System.out.println("Uri = "+ finalWsUri);

			// Add the JSON Accept-MediaType to header
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			if (token != null) {
				requestHeaders.add("Authorization", token);
			}

			System.out.println("---------------" + requestHeaders.toString());
			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();

			// Make the HTTP GET request, marshaling the response to a String
			ResponseEntity<String> response = null;
			response = retryCallEndpoint(properties, finalWsUri, requestHeaders, restTemplate, response);

			System.out.println("Response status code = "+ response.getStatusCode());

			if (!response.getStatusCode().equals(HttpStatus.OK)
					&& !response.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
				JSONArray error = new JSONArray(response.getBody());
				throw new RestClientUtilException(error.getJSONObject(0).getString("message"));
			}
			
			return new JSONArray(response.getBody().trim());
		} catch (RestClientException e) {
			System.err.println(e.getLocalizedMessage() + e);
			throw new RestClientUtilException(e);
		} catch (JSONException e) {
			System.err.println(e.getLocalizedMessage() + e);
			throw new RestClientUtilException(e);
		}
	}
	
	public static Object postToWs(String wsUri, Map<String, String> uriPathParams, Map<String, String> queryParams,
			Object body, String token, String basic) throws JSONException {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(wsUri);

		if (queryParams != null && !queryParams.isEmpty()) {
			// Set the query parameters
			for (String queryParanName : queryParams.keySet()) {
				builder.queryParam(queryParanName, queryParams.get(queryParanName));
			}
		}

		URI finalWsUri = builder.build().toUri();
		if (uriPathParams != null && !uriPathParams.isEmpty()) {
			finalWsUri = builder.buildAndExpand(uriPathParams).toUri();
		}

		// Add the JSON Accept-MediaType to header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		if (token != null) {
			requestHeaders.add("Authorization", token);
		} else if(basic != null) {
			requestHeaders.add("Authorization", basic);
		}

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Make the HTTP GET request, marshaling the response to a String
		ResponseEntity<String> response = restTemplate.exchange(finalWsUri, HttpMethod.POST,
				new HttpEntity<>(body, requestHeaders), String.class);

		if (!response.getStatusCode().equals(HttpStatus.OK)) {
			JSONObject error = new JSONObject(response.getBody());
			try {
				throw new Exception(error.getString("message"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return response.getBody().trim();
	}
	
	public static Object putToWs(String wsUri, Map<String, String> uriPathParams, Map<String, String> queryParams,
			Object body, String token) throws JSONException {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(wsUri);

		if (queryParams != null && !queryParams.isEmpty()) {
			// Set the query parameters
			for (String queryParanName : queryParams.keySet()) {
				builder.queryParam(queryParanName, queryParams.get(queryParanName));
			}
		}

		URI finalWsUri = builder.build().toUri();
		if (uriPathParams != null && !uriPathParams.isEmpty()) {
			finalWsUri = builder.buildAndExpand(uriPathParams).toUri();
		}

		// Add the JSON Accept-MediaType to header
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		if (token != null) {
			requestHeaders.add("Authorization", token);
		} 

		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Make the HTTP GET request, marshaling the response to a String
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(finalWsUri, HttpMethod.PUT,
					new HttpEntity<>(body, requestHeaders), String.class);
			
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				JSONObject error = new JSONObject(response.getBody());
				try {
					throw new Exception(error.getString("message"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			return null;
		}
		
		return response.getBody().trim();
	}

}
