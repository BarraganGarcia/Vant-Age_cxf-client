package io.swagger.interceptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifierInterceptor extends AbstractPhaseInterceptor<Message> {

	private Logger logger = LoggerFactory.getLogger(VerifierInterceptor.class.getName());

	public VerifierInterceptor() {
		super(Phase.POST_STREAM);
	}

	@Override
	public void handleMessage(Message message) throws Fault {

		@SuppressWarnings("unchecked")
		Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);

		List<String> list = headers.get("x-signature");
		String signature = null;
		if (list != null) {
			for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
				signature = (String) iterator.next();
				break;
			}
			if (signature != null) {
				logger.debug("firma: " + signature);
				InputStream is = message.getContent(InputStream.class);
				if (is != null) {
					try {
						String payload = IOUtils.readStringFromStream(is);
						boolean verify = Signer.getInstance().verifyPayload(payload, signature);
						logger.debug("Verify: " + verify);
						if(!verify) {
							throw new VerifyingSignatureException("Error al verificar la firma del payload.");
						} else {
							InputStream nis = new ByteArrayInputStream(payload.getBytes());
							message.setContent(InputStream.class, nis);
							logger.debug("Response payload: '" + payload+ "'");
						}
						is.close();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public void handleFault(Message message) {
	}

}