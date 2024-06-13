package com.qf.androidautomation.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class IbanVerificationApi {

	public int ibanVerification(int requestId, String accessToken) {
		int statusCode = 0;
		String bearerAcessToken =  "Bearer " + accessToken;
		try {
			Config configProperty = new Config();
			CloseableHttpClient httpClient = HttpClients.createDefault();
			
			HttpPut httpPut = new HttpPut(configProperty.getProperty("api.ibanVerification"));
			httpPut.addHeader("Content-Type", "application/json");
			httpPut.addHeader(configProperty.getProperty("api.header"), bearerAcessToken);
			
			String requestBody = "{\"requestId\": " + requestId + ", \"ibanStatus\": \"VERIFIED\"}";
			StringEntity requestEntity = new StringEntity(requestBody);
			httpPut.setEntity(requestEntity);
			HttpResponse response = httpClient.execute(httpPut);
			statusCode = response.getStatusLine().getStatusCode();
			System.out.println("Response Status Code: " + statusCode);
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusCode;
	}
}
