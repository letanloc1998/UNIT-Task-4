package vn.com.unit.controller;


import com.mservice.pay.models.POSPayResponse;
import com.mservice.pay.models.TransactionQueryResponse;
import com.mservice.pay.models.TransactionRefundResponse;
import com.mservice.pay.processor.notallinone.POSPay;
import com.mservice.pay.processor.notallinone.TransactionQuery;
import com.mservice.pay.processor.notallinone.TransactionRefund;
import com.mservice.shared.constants.Parameter;
//import com.mservice.shared.constants.ProcessType;
import com.mservice.shared.constants.RequestType;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;
import com.mservice.shared.sharedmodels.PartnerInfo;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.mservice.allinone.models.CaptureMoMoRequest;

//import com.mservice.allinone.processor.allinone.PayATM;

//import com.mservice.allinone.PayGate;
import com.mservice.allinone.models.CaptureMoMoResponse;
import com.mservice.allinone.models.PayATMResponse;
import com.mservice.allinone.models.PayGateRequest;
import com.mservice.allinone.models.QueryStatusTransactionResponse;
import com.mservice.allinone.models.RefundMoMoResponse;
import com.mservice.allinone.processor.allinone.*;
import com.mservice.shared.exception.MoMoException;
//import com.mservice.shared.sharedmodels.Environment;

//import com.mservice.allinone.processor.allinone.PayATM;
//import com.mservice.allinone.processor.allinone.CaptureMoMo;
//import com.mservice.allinone.processor.allinone.RefundMoMo;
//import com.mservice.allinone.processor.allinone.RefundATM;
import com.mservice.allinone.models.PayGateRequest;

import com.mservice.shared.utils.Encoder;

import com.mservice.allinone.processor.allinone.CaptureMoMo;


//https://github.com/momo-wallet/java/blob/master/src/main/java/com/mservice/pay/models/QRNotifyRequest.java
import com.mservice.pay.models.QRNotifyRequest;

public class TestMomo {

	// https://business.momo.vn/merchant/integrateInfo
	// https://test-payment.momo.vn/gw_payment/transactionProcessor
	
//	String partnerCode = "";
//	String accessKey = "";
//	String secretKey = "";
	
//	PartnerInfo devInfo = new PartnerInfo(partnerCode, accessKey, secretKey);
	
/*	
	String requestId = String.valueOf(System.currentTimeMillis());
    String orderId = String.valueOf(System.currentTimeMillis());
    
    String orderInfo = "Pay With MoMo";
    String returnURL = "https://google.com.vn";
    String notifyURL = "https://google.com.vn";
    String extraData = "";
    String bankCode = "SML";
    String customerNumber = "0963181714";

    EnvTarget target = EnvTarget.DEV;
    
    // PAY_GATE, APP_IN_APP, PAY_POS, PAY_QUERY_STATUS, PAY_REFUND, PAY_CONFIRM;
	ProcessType process = ProcessType.PAY_GATE;
    Environment environment = Environment.selectEnv(target, process);
    
//    PayGate
*/  
    
    public void test() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
//    	String secretKey = environment.getPartnerInfo().getSecretKey();
//    	String data = "partnerCode=MOMO&accessKey=F8BBA842ECF85&requestId=MM1540456472575&amount=150000&orderId=MM1540456472575&orderInfo=SDK team.&returnUrl=https://momo.vn&notifyUrl=https://momo.vn&extraData=email=abc@gmail.com";
//    	String signature = Encoder.signHmacSHA256(data, secretKey);
    	
    	
//    	TransactionQuery.process(env, partnerRefId, secretKey, publicKey, momoTransId, version)
//    	PayGateRequest asdasd = new PayGateRequest(partnerCode, signature, signature, accessKey, amount, signature, data, signature, notifyUrl, returnUrl, requestType)
    	
//    	QRNotifyRequest qr = new QRNotifyRequest(status, signature, amount, error, partnerRefId, momoTransId, message, partnerCode, accessKey, partnerTransId, transType, responseTime, storeId)
    	
//    	CaptureMoMoRequest captureMoMoRequest = new CaptureMoMoRequest(partnerCode, signature, signature, accessKey, amount, signature, data, signature, notifyUrl, returnUrl, requestType);
    	
    	// https://developers.momo.vn/v1/#cong-thanh-toan-momo-phuong-thuc-thanh-toan
    	EnvTarget target = EnvTarget.DEV;
    	
        // PAY_GATE, APP_IN_APP, PAY_POS, PAY_QUERY_STATUS, PAY_REFUND, PAY_CONFIRM;
    	ProcessType process = ProcessType.PAY_GATE;
        Environment environment = Environment.selectEnv(target, process);
        
    	CaptureMoMo captureMoMo = new CaptureMoMo(environment);
    	
        String requestId = String.valueOf(System.currentTimeMillis());
        
        
    	CaptureMoMoRequest captureMoMoRequest = captureMoMo.createPaymentCreationRequest(orderId, requestId, amount, orderInfo, returnUrl, notifyUrl, extraData);
    	
    	CaptureMoMoResponse captureMoMoResponse = captureMoMo.execute(captureMoMoRequest);
    	captureMoMoResponse.getPayUrl();
    	captureMoMoResponse.getQrCodeUrl();
    }
    
}
