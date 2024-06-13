package com.qf.androidautomation.utils;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

public class IbanRequestIdApi {

	public int getIbanRequestId(String nationalId, String accessToken) {
		Config configProperty = new Config();
		String bearerAcessToken =  "Bearer " + accessToken;
		int requestId = 0;
		try {
			HttpClient httpClient = HttpClients.createDefault();
			URI uri = new URI(configProperty.getProperty("api.getIbanRequestId"));
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader(configProperty.getProperty("api.header"), bearerAcessToken);
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String responseBody = EntityUtils.toString(entity);

			JSONObject jsonObject = new JSONObject(responseBody);
			JSONArray ibanRequests = jsonObject.getJSONArray("ibanRequests");

			for (int i = 0; i < ibanRequests.length(); i++) {
				JSONObject request = ibanRequests.getJSONObject(i);
				if (request.getString("customerId").equals(nationalId)) {
					requestId = request.getInt("requestId");
					break;
				}
			}
		} catch (IOException | URISyntaxException | JSONException e) {
			e.printStackTrace();
		}
		System.out.println("Request ID for customerId "+ nationalId +": " + requestId);
		return requestId;
	}
}
