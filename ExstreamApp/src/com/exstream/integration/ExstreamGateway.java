package com.exstream.integration;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.ws.Service;

import com.exstream.xmlobject.Customer;

/**
 * Servlet implementation class ExstreamGateway
 */
@WebServlet("/ExstreamGateway")
public class ExstreamGateway extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExstreamGateway() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Quote Qtn = (Quote) request.getAttribute("Quote");
		// response.getWriter().append(Qtn.getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String action = request.getParameter("action");
			System.out.println(action);

			Object Qtn = getServletContext().getAttribute("Quote12");
			((Customer) Qtn).setDocID(action);
			JAXBContext contextObj = JAXBContext.newInstance(Customer.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.setProperty(Marshaller.JAXB_FRAGMENT, true);
			StringWriter stringWriter = new StringWriter();
			XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

			marshallerObj.marshal(Qtn, xMLStreamWriter);

			String xmlString = "<NewSubscribers>" + stringWriter.getBuffer().toString() + "</NewSubscribers>";
			stringWriter.close();
			System.out.println("\n\n\n XML String" + xmlString + "\n\n\n");

			ServletOutputStream stream = null;
			BufferedInputStream buf = null;

			String base64encodedString = Base64.getEncoder().encodeToString(xmlString.getBytes("utf-8"));
			System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);

			APICalltoEWS api = new APICalltoEWS();
			String httpresponse = api.getDocument(base64encodedString);

			byte[] base64decodedPDF = Base64.getDecoder().decode(httpresponse);

			response.setContentLength(base64decodedPDF.length);
			//PrintWriter out = response.getWriter();
			stream = response.getOutputStream();
			// set response headers
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=Quote.pdf");
			//InputStream is = new ByteArrayInputStream(base64decodedPDF);
			buf = new BufferedInputStream(new ByteArrayInputStream(base64decodedPDF));
			int readBytes = 0;
			while ((readBytes = buf.read()) != -1)
				stream.write(readBytes);
			//out.println(httpresponse);
		}

		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Error.html");
            rd.forward(request, response);
		}
		// out.println(StudentName + RegNo);
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

	}

}
