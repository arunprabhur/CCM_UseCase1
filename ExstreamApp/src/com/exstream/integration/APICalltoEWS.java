package com.exstream.integration;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class APICalltoEWS {

	public String getDocument(String EncodedXML) throws Exception {
		// Code to make a webservice HTTP request		
		String wsURL = "http://10.240.206.31:2443/EngineService.svc";
		URL url = new URL(wsURL);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:com=\"http://schemas.datacontract.org/2004/07/com.hpexstream.services.ews\">\r\n"				
				+ "<soapenv:Header/>\r\n" 
				+ "<soapenv:Body>\n" 
				+ "<tem:Compose>\r\n" 
				+ "<tem:request>\r\n"				
				+ "<com:Driver>\r\n"
				+ "<com:Driver>"+ EncodedXML +"</com:Driver>\r\n"
				+ "<com:FileName>NewSubscriber</com:FileName>\r\n" 
				+ "</com:Driver>\r\n"
				+ "<com:EngineOptions>\n" + 
				"               <com:EngineOption>\n" + 
				"                   <com:Name>RUNMODE</com:Name>\n" + 
				"                   <com:Value>Production</com:Value>\n" + 
				"                </com:EngineOption>                   \n" + 
				"                <com:EngineOption>\n" + 
				"                   <com:Name>FILEMAP</com:Name>\n" + 
				"                   <com:Value>ini,E:\\installed_apps\\CCM_Demo\\UseCase1\\EWS\\EngineService\\input\\Ini.txt</com:Value>\n" + 
				"                </com:EngineOption>\n" + 
				"                <com:EngineOption>\n" + 
				"                   <com:Name>FILEMAP</com:Name>\n" + 
				"                   <com:Value>RetailStore,E:\\installed_apps\\CCM_Demo\\UseCase1\\EWS\\EngineService\\input\\RetailLocations.dat</com:Value>\n" + 
				"                </com:EngineOption>\n" + 
				"</com:EngineOptions>"
				+ "<com:PubFile>Vivanet.pub</com:PubFile>\r\n" 
				+ "</tem:request>\r\n" 
				+ "</tem:Compose>\r\n" 				
				+ " </soapenv:Body>\n"
				+ " </soapenv:Envelope>";
		System.out.println(xmlInput);
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction = "http://tempuri.org/IEngineService/Compose";
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
		/*InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		String PDF = null;*/
		// Write the SOAP message response to a String.
		/*while ((responseString = in.readLine()) != null ) {
			
			if (responseString.contains("FileOutput"))
				PDF= responseString;
			else
			outputString = outputString + responseString;
			
		}*/
		
		InputStream is = httpConn.getInputStream();

		// Create a Factory to Obtain DOM Parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Creates a Parser with configured values from jaxp.properties
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Pass the InputStream and Construct the Document
		Document doc = builder.parse(is);
		String PDF = null;
		// Get the ROOT element
		Element element = doc.getDocumentElement();

		NodeList nList = doc.getElementsByTagName("a:FileOutput");
		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			PDF = nNode.getTextContent();
			

		}
		//System.out.println("Response" + outputString);
		return PDF;

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
	private Document parseXML(InputStream stream)
		    throws Exception
		    {
		        DocumentBuilderFactory objDocumentBuilderFactory = null;
		        DocumentBuilder objDocumentBuilder = null;
		        Document doc = null;
		        try
		        {
		            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
		            doc = objDocumentBuilder.parse(stream);
		        }
		        catch(Exception ex)
		        {
		            throw ex;
		        }       

		        return doc;
		    }
}