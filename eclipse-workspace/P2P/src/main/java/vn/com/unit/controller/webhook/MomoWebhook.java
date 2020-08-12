package vn.com.unit.controller.webhook;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mservice.shared.constants.Parameter;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;
import com.mservice.shared.utils.Encoder;

public class MomoWebhook {
	
	EnvTarget target = EnvTarget.DEV;

	ProcessType process = ProcessType.PAY_GATE;
	Environment environment = Environment.selectEnv(target, process);

	@PostMapping(value = "/webhook/momo", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> webhookMomo(@RequestParam Map<String, String> body)
			throws UnsupportedEncodingException {
		

		String rawData = this.getRawDataPaymentResult(body);

		String signatureClient = null;
		try {
			signatureClient = Encoder.signHmacSHA256(rawData, environment.getPartnerInfo().getSecretKey());
			if (signatureClient.equals(body.get("signature"))) {
				// error code == 0 => success => bill success => transfer to shop
				// error code != 0 => error
				return ResponseEntity.ok(null);
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

	private String getRawDataPaymentResult(Map<String, String> body) throws UnsupportedEncodingException {
		
		String partnerCode	= body.get("partnerCode");
		String accessKey 	= body.get("accessKey");
		String requestId	= body.get("requestId");
		String amount 		= body.get("amount");
		String orderId		= body.get("orderId");
		String orderInfo	= this.convertEncode(body.get("orderInfo"));
		String orderType	= body.get("orderType");
		String transId		= body.get("transId");
		String message		= this.convertEncode(body.get("message"));
		String localMessage = this.convertEncode(body.get("localMessage"));
		String payType		= body.get("payType");
		String responseTime = body.get("responseTime");
		String errorCode	= body.get("errorCode");
		String extraData	= this.convertEncode(body.get("extraData"));
		
		String rawData = Parameter.PARTNER_CODE + "=" + partnerCode

							+ "&" + Parameter.ACCESS_KEY + "=" + accessKey
					
							+ "&" + Parameter.REQUEST_ID + "=" + requestId
					
							+ "&" + Parameter.AMOUNT + "=" + amount
					
							+ "&" + Parameter.ORDER_ID + "=" + orderId
					
							+ "&" + Parameter.ORDER_INFO + "=" + orderInfo
					
							+ "&" + Parameter.ORDER_TYPE + "=" + orderType
					
							+ "&" + Parameter.TRANS_ID + "=" + transId
					
							+ "&" + Parameter.MESSAGE + "=" + message
					
							+ "&" + Parameter.LOCAL_MESSAGE + "=" + localMessage
					
							+ "&" + "responseTime" + "=" + responseTime
					
							+ "&" + Parameter.ERROR_CODE + "=" + errorCode
					
							+ "&" + Parameter.PAY_TYPE + "=" + payType
					
							+ "&" + Parameter.EXTRA_DATA + "=" + extraData;
		
		return rawData;
	}
	
	// convert from ISO-8859-1 to UTF-8
	private String convertEncode(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("ISO-8859-1"), "UTF-8");
	}

}
