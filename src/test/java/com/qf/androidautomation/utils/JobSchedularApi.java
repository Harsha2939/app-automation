package com.qf.androidautomation.utils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JobSchedularApi {
	
	public static void main(String[] args) {
		String response = main("1698884622","");
		System.out.println(response);
	}

    public static String main(String nationalId, String accessToken) {
    	String responseBody = "";
        try {
            Config configProperty = new Config();
            CloseableHttpClient httpClient = HttpClients.createDefault();
            
            String apiEndpoint = configProperty.getProperty("api.jobSchedular");
            String completeApi = apiEndpoint + "?nationalId=" + nationalId;
            HttpPost httpPost = new HttpPost(completeApi);
            
            httpPost.addHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJWM3Ntd00xTVp6QUVFUVNNMWU2VFluZ2hySHhRdndtOTB3bmx4dXlUVGprIn0.eyJleHAiOjE3MTcwNDk4NjEsImlhdCI6MTcxNzA0ODk2MSwianRpIjoiYzRkMzVkMzQtZjIwNy00OWE2LTgzZTAtZmNkNDYyM2MxY2Y5IiwiaXNzIjoiaHR0cDovLzE1MC4yMzAuNTMuMTg2L2F1dGgvcmVhbG1zL1FGaW5hbmNlIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijk2ZWNjMDNlLWZjMGQtNGYzZC04ZDg4LTE2NjBmYWE1NzY0OSIsInR5cCI6IkJlYXJlciIsImF6cCI6InFmLWNvbm5lY3QtYXBpIiwic2Vzc2lvbl9zdGF0ZSI6IjU4YzIxZmIyLWZmMjYtNDk5Mi04MGMxLTMzNmQ1MmFiMGUwNiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiUUEiLCJBTlRJX0ZSQVVEIiwiQ1VTVE9NRVJfQ0FSRSIsIkZJTkFOQ0UiLCJPUEVSQVRJT04iLCJvZmZsaW5lX2FjY2VzcyIsImRlZmF1bHQtcm9sZXMtcWZpbmFuY2UiLCJ1bWFfYXV0aG9yaXphdGlvbiIsIlVTRVIiLCJDT01QTElBTkNFIiwiSEVMUF9ERVNLIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsicWYtY29ubmVjdC1hcGkiOnsicm9sZXMiOlsiUUEiLCJSQUNfQVBQUk9WRVIiLCJBTlRJX0ZSQVVEIiwiRklOQU5DRSIsIk9QRVJBVElPTiIsIlJBQ19WSUVXRVIiLCJDT01QTElBTkNFIiwiVVNFUiIsIkhFTFBfREVTSyJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwic2lkIjoiNThjMjFmYjItZmYyNi00OTkyLTgwYzEtMzM2ZDUyYWIwZTA2IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiIxMjM0NTY3ODkwIn0.YE0znunqJSV4rYqG4ZjsgakYFnplyi6U5DFoRp9fkRZw8z8BZfGGsiL4qQWeQHHI-ljZ1MIoW9ZvzvRSZFOaCwwxMg-sOgfcQzLJDkOPlXCMK_pCJZJsOT7Z6ezUH4ISMkrwZwxx_NdxArgVkOd9UzX6YwMdBza5KT8zDdUgP5BiuM0XbwQDSwRcXJCWO0g454P60jaRltDZaJPcHzpVlv0VXGyhFRrZqywvxFAuQagc6Ve3N_C-p1kErqNcewxSXd7nSLWKkl-xrSH9Wbj1EzieML5iHa-sWz4qHynB8s0enEyZdmQuQjkltU6dqe5UUm1y0UD9l8T6IMu0hJoJgA");

            String requestBody = "";
            StringEntity requestEntity = new StringEntity(requestBody);
            httpPost.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Response Status Code: " + statusCode);

            responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("Response Body: " + responseBody);

            httpClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBody;
    }
}
