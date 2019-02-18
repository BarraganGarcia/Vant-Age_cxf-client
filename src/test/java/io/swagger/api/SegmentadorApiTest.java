package io.swagger.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import io.swagger.model.ListError;
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
		List<JacksonJsonProvider> providers = new ArrayList<JacksonJsonProvider>();
		providers.add(provider);

		api = JAXRSClientFactory.create("https://circulodecredito-dev.apigee.net", SegmentadorApi.class, providers);

		Client client = WebClient.client(api);
		ClientConfiguration config = WebClient.getConfig(client);
		config.getOutInterceptors().add(new SignerInterceptor());
	}

	@Test
	public void vantageTest() {
		String xApiKey = "tKwHU70K4EICGelG94nmPDauOSbqnEAB";
		String username = "IHM0915CMI";
		String password = "pr3uBa8l";
		Peticion body = new Peticion();
		body.setFolio(48L);
		body.setNumeroCuenta("1720291_4_1722036");
		body.setTipoContrato("GS");
		body.setTipoCuenta("F");
		body.setTipoFrecuencia("S");
		body.setPeriodosVencidos("0");
		body.setDiasAtraso(0);
		body.setSaldo(new BigDecimal(0));
		body.setFechaApertura("05/02/2013");

		try {
			Respuesta respuesta = api.vantage(xApiKey, username, password, body);
			logger.debug(respuesta.toString());
		} catch (WebApplicationException ex) {
			ResponseImpl r = (ResponseImpl) ex.getResponse();
			ListError readEntity = r.readEntity(ListError.class);
			int errores = readEntity.size();
			for (int i = 0; i < errores; i++) {
				logger.debug(readEntity.get(i).getCode() + " " + readEntity.get(i).getMessage());
			}
		}
	}

}
