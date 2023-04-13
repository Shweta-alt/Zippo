package com.geekster.zippo;

// import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//@SpringBootApplication
public class ZippoApplication {

	public static void main(String[] args) throws Exception {
		URL getUrl = new URL( "https://api.zippopotam.us/us/33162");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		if(responseCode == 200){

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			StringBuffer JSONResponseData = new StringBuffer();
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;

			while((readLine = in.readLine()) != null){
				jsonResponseData.append(readLine);
			}

			in.close();

			JSONObject masterData = new JSONObject((jsonResponseData.toString()));

//			JSONObject zipCode = (JSONObject) masterData.get("value");

//			System.out.println("Jokes: " + zipcode);
			System.out.println(masterData.get("places"));
		}else{
//			System.out.println("This is not valid URL"  + responseCode);

			System.out.println("This is not valid URL" + responseCode);
		}

	}

}
