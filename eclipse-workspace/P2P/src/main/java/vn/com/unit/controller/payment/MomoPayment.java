package vn.com.unit.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mservice.allinone.models.CaptureMoMoRequest;
import com.mservice.allinone.models.CaptureMoMoResponse;
import com.mservice.allinone.processor.allinone.CaptureMoMo;
import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;

import vn.com.unit.service.PaymentService;
import vn.com.unit.utils.CommonUtils;

@Controller
public class MomoPayment {

	@Autowired
	PaymentService paymentService;

	private EnvTarget target = EnvTarget.DEV;

	private ProcessType process = ProcessType.PAY_GATE;
	private Environment environment = Environment.selectEnv(target, process);

	@PostMapping("/cart/payment/momo")
	public ModelAndView momoPayment(Model model, @RequestParam(value = "address") String address) {

		try {

			Long bill_id = paymentService.createBill(address);

			String total = paymentService.calculateBillTotal(bill_id).toString();

			CaptureMoMo captureMoMo = new CaptureMoMo(environment);

			String orderId = bill_id.toString() + "T" + String.valueOf(System.currentTimeMillis());
			String requestId = bill_id.toString() + orderId;
			// => requestId.replace(orderId, ""); => bill_id
			String amount = total;
			String orderInfo = "Total : " + total + " Address: " + CommonUtils.convertEncode(address);

			String returnUrl = "http://localhost:8080/callback";
			String notifyUrl = "https://1dd10ec48399.ngrok.io/webhook/momo";

			String extraData = "";

			CaptureMoMoRequest captureMoMoRequest = captureMoMo.createPaymentCreationRequest(orderId, requestId, amount,
					orderInfo, returnUrl, notifyUrl, extraData);

			CaptureMoMoResponse captureMoMoResponse = captureMoMo.execute(captureMoMoRequest);
			String payUrl = captureMoMoResponse.getPayUrl();

			return new ModelAndView("redirect:" + payUrl);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/cart");
	}
}
