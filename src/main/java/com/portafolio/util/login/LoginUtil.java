package com.portafolio.util.login;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.http.HttpHeaders;

import com.google.gson.Gson;
import com.portafolio.util.rest.client.RestClientUtil;

public class LoginUtil {
	
	/**
	 * myHotel Login
	 * @param httpHeaders
	 * @return
	 * @throws Exception 
	 * @throws JSONException 
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> fermeLogin(HttpHeaders httpHeaders, String loginUrl) throws JSONException, Exception {
		Object loginResponse;
		Map<String, String> mapResponse;
		Map<String, String> body = getCredentialsOfHeader(httpHeaders);

		loginResponse = RestClientUtil.postToWs(loginUrl, null, null, body);

		mapResponse = new Gson().fromJson(loginResponse.toString(), Map.class);

		return mapResponse;
	}

	public static Map<String, String> getCredentialsOfHeader(HttpHeaders httpHeaders) {
		
		Map<String, String> headerMap = httpHeaders.toSingleValueMap();

		String auth = headerMap.get("authorization").toString().replace("Basic", "").trim();

		String authorization = new String(Base64.getDecoder().decode(auth));

		String[] credencials = authorization.split(":");
		String user = credencials[0];
		String pass = credencials[1];

		Map<String, String> body = new LinkedHashMap<>();

		body.put("username", user);
		body.put("password", pass);
		return body;
	}

}
