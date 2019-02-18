package io.swagger.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignerInterceptor extends AbstractPhaseInterceptor<Message> {
	
	private Logger logger = LoggerFactory.getLogger(SignerInterceptor.class.getName());

	public SignerInterceptor() {
		super(Phase.PRE_STREAM);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		boolean isOutbound = false;
		isOutbound = message == message.getExchange().getOutMessage()
				|| message == message.getExchange().getOutFaultMessage();

		if (isOutbound) {

			OutputStream os = message.getContent(OutputStream.class);

			CachedOutputStream cs = new CachedOutputStream();
			message.setContent(OutputStream.class, cs);
			message.getInterceptorChain().doIntercept(message);
			
			try {
				cs.flush();
				
                CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);
                CachedOutputStream.copyStream(csnew.getInputStream(), os, 1024);
                
				StringBuilder sb = new StringBuilder();
				cs.writeCacheTo(sb);
				logger.debug("Payload: " + sb.toString());
				
				Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
				
				List<String> list = headers.get("x-signature");
				if(list == null) {
					list = new ArrayList<String>();
					headers.put("x-signature", list);
				} else {
					list.clear();
				}

				list.add(Signer.getInstance().signPayload(sb.toString()));
				
				cs.close();

				os.flush();
				message.setContent(OutputStream.class, os);
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
