package com.qf.androidautomation.utils;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetOTP {

	private int attempts = 0;

	public String sendRequest(String nationalId, String eventType, String activity) {
		String otp = null;
		Config configProperty = new Config();
		try {
			String baseURI = configProperty.getProperty("grafana.url");
			String direction = "backward";
			int limit = 1;
			String sample = cacheParams();

		    LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime adjustedTime = currentTime.minusHours(5).minusMinutes(30);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String timestamp = adjustedTime.format(formatter);

			String queryPara = "{app=\"qf-connect\"} |= \"" + activity + "\" |= \"" + eventType + "\" |= \"" + nationalId
					+ "\" |= \"" + timestamp + "\"";
			String query = URLEncoder.encode(queryPara, StandardCharsets.UTF_8);
			System.out.println(queryPara);
			URI uri = new URI(
					baseURI + "?query=" + query + "&direction=" + direction + "&limit=" + limit + "&sample=" + sample);

			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(uri).header(configProperty.getProperty("api.header"),
					configProperty.getProperty("authorization.bearer")).GET().build();

			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.toString());
			otp = extractGeneratedOtpMessage(response.body().toString(), activity, eventType);
			if (otp.equals("OTP not found in the message.") && attempts < 2) {
				attempts++;
				otp = sendRequest(nationalId, eventType, activity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!otp.isEmpty() && otp != null) {
			return otp;
		} else {
			return "OTP not found for nationalId";

		}
	}

	private static String extractGeneratedOtpMessage(String message, String activity, String eventType) {
		String otpPattern = "Generated OTP in " + activity + ": (\\d+) during "+ eventType +"";
		Pattern pattern = Pattern.compile(otpPattern);
		Matcher matcher = pattern.matcher(message);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "OTP not found in the message.";
		}
	}

	private static String cacheParams() {
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000);
		return String.valueOf(randomNumber);
	}
}
