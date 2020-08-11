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
import com.mservice.shared.sharedmodels.PartnerInfo;

public class TestMomo {

	// https://business.momo.vn/merchant/integrateInfo
	// https://test-payment.momo.vn/gw_payment/transactionProcessor
	
	String partnerCode = "";
	String accessKey = "";
	String secretKey = "";
	
	PartnerInfo devInfo = new PartnerInfo(partnerCode, accessKey, secretKey);
}
