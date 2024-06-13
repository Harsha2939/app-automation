package com.qf.androidautomation.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromisoryNoteApi {
	
	public static void main(String[] args) {
		String nationalId = "1370483115";
		apiReponse(nationalId);
		// System.out.println(result);
	}

	public static void apiReponse(String nationalId) {

		String promissoryNoteId = null;
		String compAppId = null;
		Config configProperty = new Config();
		try { 
			String apiUrl = configProperty.getProperty("api.getPromissoryInfo");
			URI uri = new URI(apiUrl + "?nationalId=" + nationalId);

			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body().toString());

			promissoryNoteId = extractPromissoryNoteId(response.body().toString());
			compAppId = extractCompAppId(response.body().toString());

			System.out.println("promissoryNoteId: " + promissoryNoteId);
			System.out.println("compAppId: " + compAppId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String extractPromissoryNoteId(String message) {
		Pattern pattern = Pattern.compile("\"promissoryNoteId\":\"([^\"]+)\"");
		Matcher matcher = pattern.matcher(message);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "promissoryNoteId not found in the response.";
		}
	}

	public static String extractCompAppId(String message) {
		Pattern pattern = Pattern.compile("\"compAppId\":\"([^\"]+)\"");
		Matcher matcher = pattern.matcher(message);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "compAppId not found in the response.";
		}
	}

}
