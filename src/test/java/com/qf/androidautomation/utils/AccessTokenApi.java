package com.qf.androidautomation.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.JSONObject;

public class AccessTokenApi {

	public String getAccessToken() {
		Config configProperty = new Config();
		String accessToken = null;
		try {
			String url = configProperty.getProperty("api.accesstoken");
			String json = new JSONObject().put("uid", configProperty.getProperty("accesstoken.uid"))
					.put("password", configProperty.getProperty("accesstoken.password")).toString();

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(json)).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			if (response.statusCode() == 200) {
				String responseBody = response.body();
				JSONObject responseJson = new JSONObject(responseBody);
				accessToken = responseJson.optString("access_token");

				if (!accessToken.isEmpty()) {
					System.out.println("Access Token: " + accessToken);
				} else {
					System.out.println("Access token not found in the response.");
				}
				
			} else {
				System.out.println("Failed to get access token: " + response.statusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}
}
