package com.exstream.integration;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class APICalltoCC {

	public String getDocument() throws IOException {
		// Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		String wsURL = "http://www.webservicex.net/globalweather.asmx";

		URL url = new URL(wsURL);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput = " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.webserviceX.NET\">\r\n"				
				+ " <soapenv:Header/>\r\n" 
				+ "<soapenv:Body>\n" 
				+ "<web:GetCitiesByCountry>\r\n" 
				+ "<!--Optional:-->\n"
				+ "<web:CountryName>india</web:CountryName>" 
				+ "</web:GetCitiesByCountry>\n" 
				+ " </soapenv:Body>\n"
				+ " </soapenv:Envelope>";
		System.out.println(xmlInput);
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction = "http://www.webserviceX.NET/GetCitiesByCountry";
		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		
		
		//System.out.println("Content Length" +  httpConn.getRequestProperty("Content-Length"));
		OutputStream out = httpConn.getOutputStream();
		// Write the content of the request to the outputstream of the HTTP
		// Connection.
		out.write(b);
		out.close();
		// Ready with sending the request.

		// Read the response.
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		// Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
			outputString = outputString + responseString;
		}

		//System.out.println("Response" + outputString);
		return outputString;

		// Parse the String output to a org.w3c.dom.Document and be able to
		// reach
		// every node with the org.w3c.dom API.
		// Document document = parseXmlFile(outputString);
		// NodeList nodeLst = document.getElementsByTagName("GetWeatherResult");
		// String weatherResult =
		// nodeLst.item(0).getTextContent();System.out.println("Weather:
		// "+weatherResult);

		// Write the SOAP message formatted to the console.
		// String formattedSOAPResponse = formatXML(
		// outputString);System.out.println(formattedSOAPResponse);return
		// weatherResult;

	}
}