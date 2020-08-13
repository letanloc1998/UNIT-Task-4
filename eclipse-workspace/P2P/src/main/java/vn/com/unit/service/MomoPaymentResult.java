package vn.com.unit.service;



import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mservice.shared.constants.Parameter;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;
import com.mservice.shared.utils.Encoder;

@Service
@Transactional
public class MomoPaymentResult {

	EnvTarget target = EnvTarget.DEV;
	ProcessType process = ProcessType.PAY_GATE;
	Environment environment = Environment.selectEnv(target, process);

	private String partnerCode;
	private String accessKey;
	private String requestId;
	private String amount;
	private String orderId;
	private String orderInfo;
	private String orderType;
	private String transId;
	private String message;
	private String localMessage;
	private String payType;
	private String responseTime;
	private String errorCode;
	private String extraData;
	private String signature;
	
	@Autowired
	LogService logService;

	public void setMomoPaymentResult(Map<String, String> body) throws UnsupportedEncodingException {
		partnerCode = body.get(Parameter.PARTNER_CODE);
		accessKey = body.get(Parameter.ACCESS_KEY);
		requestId = body.get(Parameter.REQUEST_ID);
		amount = body.get(Parameter.AMOUNT);
		orderId = body.get(Parameter.ORDER_ID);
		orderInfo = this.convertEncode(body.get(Parameter.ORDER_INFO));
		orderType = body.get(Parameter.ORDER_TYPE);
		transId = body.get(Parameter.TRANS_ID);
		message = this.convertEncode(body.get(Parameter.MESSAGE));
		localMessage = this.convertEncode(body.get(Parameter.LOCAL_MESSAGE));
		responseTime = body.get(Parameter.DATE);
		errorCode = body.get(Parameter.ERROR_CODE);
		payType = body.get(Parameter.PAY_TYPE);
		extraData = this.convertEncode(body.get(Parameter.EXTRA_DATA));
		signature = body.get("signature");
		this.log();
	}

	public void log() {
		logService.saveLog(this.getRawData() + "&" + "signature" + "=" + signature, "webhook", this.getClass().getName());
	}

	private String getRawData() {

		return Parameter.PARTNER_CODE + "=" + partnerCode

				+ "&" + Parameter.ACCESS_KEY + "=" + accessKey

				+ "&" + Parameter.REQUEST_ID + "=" + requestId

				+ "&" + Parameter.AMOUNT + "=" + amount

				+ "&" + Parameter.ORDER_ID + "=" + orderId

				+ "&" + Parameter.ORDER_INFO + "=" + orderInfo

				+ "&" + Parameter.ORDER_TYPE + "=" + orderType

				+ "&" + Parameter.TRANS_ID + "=" + transId

				+ "&" + Parameter.MESSAGE + "=" + message

				+ "&" + Parameter.LOCAL_MESSAGE + "=" + localMessage

				+ "&" + Parameter.DATE + "=" + responseTime

				+ "&" + Parameter.ERROR_CODE + "=" + errorCode

				+ "&" + Parameter.PAY_TYPE + "=" + payType

				+ "&" + Parameter.EXTRA_DATA + "=" + extraData;
	}

	public boolean checkSignature() {

		try {
			String rawData = this.getRawData();
			String signatureClient = Encoder.signHmacSHA256(rawData, environment.getPartnerInfo().getSecretKey());
			return signatureClient.equals(this.signature);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	// convert from ISO-8859-1 to UTF-8
	private String convertEncode(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("ISO-8859-1"), "UTF-8");
	}

	public String getErrorCode() {
		return errorCode;
	}

}

