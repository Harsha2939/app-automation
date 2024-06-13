package com.qf.androidautomation.utils;

import java.net.HttpURLConnection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayoutsApprovalApi {

	public int creditApproval(String objectId, String accessToken, String payoutStatus) {
		String bearerAcessToken = "Bearer " + accessToken;
		Config configProperty = new Config();
		int statusCode = 0;
		try {

			String apiEndpoint = configProperty.getProperty("api.creditApproval");
			String Authorization = configProperty.getProperty("api.header");

			CloseableHttpClient httpClient = HttpClients.createDefault();

			HttpPut httpPut = new HttpPut(apiEndpoint);

			httpPut.addHeader("Content-Type", "application/json");
			httpPut.addHeader(Authorization, bearerAcessToken);

			JSONObject payoutObject = new JSONObject();
			payoutObject.put("objectId", objectId);
			payoutObject.put("payoutStatus", payoutStatus);

			JSONArray payoutsArray = new JSONArray();
			payoutsArray.put(payoutObject);

			JSONObject requestBody = new JSONObject();
			requestBody.put("payouts", payoutsArray);

			StringEntity requestEntity = new StringEntity(requestBody.toString());
			httpPut.setEntity(requestEntity);

			CloseableHttpResponse response = httpClient.execute(httpPut);
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Response Status Code: " + statusCode);
				System.out.println("Credit Approval Was Done");
			} else {
				System.out.println("Unable to approve");
			}
			httpClient.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusCode;
	}
}
