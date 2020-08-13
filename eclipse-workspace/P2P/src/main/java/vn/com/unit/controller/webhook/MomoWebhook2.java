package vn.com.unit.controller.webhook;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;

import vn.com.unit.model.MomoPaymentResult;

// Handler response from Momo server after payment
// Thông thường kết quả thanh toán đi theo cách IPN sẽ tới trước callback returnUrl (3s)

@Controller
public class MomoWebhook {

	EnvTarget target = EnvTarget.DEV;

	ProcessType process = ProcessType.PAY_GATE;
	Environment environment = Environment.selectEnv(target, process);

	@PostMapping(value = "/webhook/momo", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> webhookMomo(@RequestParam Map<String, String> body)
			throws UnsupportedEncodingException {

		MomoPaymentResult momoPaymentResult = new MomoPaymentResult(body);
		
		if (momoPaymentResult.checkSignature()) {
			if (momoPaymentResult.getErrorCode().equals("0")) {
				// Handler success
				// Refund if empty product in repository
			} else {
				// Handler error
			}

			// Return for Momo
			return ResponseEntity.ok(null);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

}
