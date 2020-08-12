package vn.com.unit.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mservice.allinone.models.RefundMoMoRequest;
import com.mservice.allinone.processor.allinone.RefundMoMo;
import com.mservice.shared.exception.MoMoException;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;

@Controller
public class TestRefund {

	EnvTarget target = EnvTarget.DEV;

	ProcessType process = ProcessType.PAY_REFUND;
	Environment environment = Environment.selectEnv(target, process);
	
	@RequestMapping("/refund")
	public void test() {
		RefundMoMo refundMoMo = new RefundMoMo(environment);
		String requestId = "1597228817961";
		String orderId = "1597228817961";
		String amount = "9999";
		String transId = "2323118387";
		RefundMoMoRequest refundMoMoRequest = refundMoMo.createRefundRequest(requestId, orderId, amount, transId);
		
		try {
			refundMoMo.execute(refundMoMoRequest);
		} catch (MoMoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
