package io.swagger.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.impl.ResponseImpl;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import io.swagger.interceptor.SignerInterceptor;
import io.swagger.interceptor.VerifierInterceptor;
import io.swagger.interceptor.VerifyingSignatureException;
import io.swagger.model.Error;
import io.swagger.model.Errors;
import io.swagger.model.Peticion;
import io.swagger.model.Respuesta;

/**
 * Vantage
 *
 * API tests for SegmentadorApi
 */
public class SegmentadorApiTest {

	private Logger logger = LoggerFactory.getLogger(SegmentadorApiTest.class.getName());
	
	private SegmentadorApi api;

	@Before
	public void setup() {
		JacksonJsonProvider provider = new JacksonJsonProvider();
		ArrayList<JacksonJsonProvider> providers = new ArrayList<JacksonJsonProvider>();
		providers.add(provider);

		api = JAXRSClientFactory.create("https://circulodecredito-dev.apigee.net", SegmentadorApi.class, providers);

		Client client = WebClient.client(api);
		ClientConfiguration config = WebClient.getConfig(client);
		config.getOutInterceptors().add(new SignerInterceptor());
		config.getInInterceptors().add(new VerifierInterceptor());
	}

	@Test
	public void vantageTest() {
		String xApiKey = "";
		String username = "";
		String password = "";
		Peticion body = new Peticion();
		body.setFolio(0L);
		body.setNumeroCuenta("");
		body.setTipoContrato("");
		body.setTipoCuenta("");
		body.setTipoFrecuencia("");
		body.setPeriodosVencidos("");
		body.setDiasAtraso(0);
		body.setSaldo(new BigDecimal(0));
		body.setFechaApertura("");

		try {
			Respuesta respuesta = api.vantage(xApiKey, username, password, body);
			logger.debug(respuesta.toString());
		} catch (WebApplicationException ex) {
			ResponseImpl r = (ResponseImpl) ex.getResponse();
			try {
				Errors readEntity = r.readEntity(Errors.class);
				if(readEntity != null) {
					List<Error> errors = readEntity.getErrors();
					for (Iterator<Error> iterator = errors.iterator(); iterator.hasNext();) {
						Error error = iterator.next();
						logger.debug(error.getCode() + " " + error.getMessage());
					}
				}

			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch (ProcessingException e) {
			Throwable cause = e.getCause();
			if(cause instanceof VerifyingSignatureException) {
				logger.debug(cause.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		SegmentadorApiTest a = new SegmentadorApiTest();
		a.setup();
		a.vantageTest();
	}

}