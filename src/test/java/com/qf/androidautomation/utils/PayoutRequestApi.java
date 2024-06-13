package com.qf.androidautomation.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayoutRequestApi {

	public String getPayoutRequest(String nationalId, String accessToken, String payoutStatus) {
		String objectId = null;
		String payoutPageType = "CREDIT";
		Config configProperty = new Config();
		String bearerAcessToken =  "Bearer " + accessToken;

		try {
			String apiUrl = configProperty.getProperty("api.creditPayouts");
			String Authorization = configProperty.getProperty("api.header");

			String urlString = String.format(apiUrl, payoutPageType, payoutStatus, nationalId);
			URL url = new URL(urlString);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty(Authorization, bearerAcessToken);

			conn.setDoOutput(true);

			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			StringBuilder response = new StringBuilder();
			String responseLine;
			while ((responseLine = bufferReader.readLine()) != null) {
				response.append(responseLine.trim());
			}

			JSONObject jsonResponse = new JSONObject(response.toString());
			JSONArray payouts = jsonResponse.getJSONArray("payouts");
			
			if (payouts.length() > 0) {
				JSONObject payout = payouts.getJSONObject(0);
				objectId = payout.getString("objectId");
				System.out.println("objectId: " + objectId);
			} else {
				System.out.println("No payouts found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectId;
	}
}