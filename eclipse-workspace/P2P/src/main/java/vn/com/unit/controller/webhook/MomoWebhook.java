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
import vn.com.unit.service.LogService;

// Handler response from Momo server after payment
// Thông thường kết quả thanh toán đi theo cách IPN sẽ tới trước callback returnUrl (3s)

@Controller
public class MomoWebhook {

	EnvTarget target = EnvTarget.DEV;

	ProcessType process = ProcessType.PAY_GATE;
	Environment environment = Environment.selectEnv(target, process);
	
	@Autowired
	LogService logService;

	@PostMapping(value = "/webhook/momo", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> webhookMomo(@RequestParam Map<String, String> body)
			throws UnsupportedEncodingException {

		MomoPaymentResult momoPaymentResult = new MomoPaymentResult(body);
		
		String log = "";
		String rawBody =  momoPaymentResult.toString();
		String type = "webhook";
		String author = this.getClass().getName();

		log = "/webhook/momo body | " + rawBody;
		logService.saveLog(log, type, author);
		
		if (momoPaymentResult.checkSignature()) {
			
			if (momoPaymentResult.getErrorCode().equals("0")) {
				// Handler success
				// Refund if empty product in repository
				log = "/webhook/momo payment success | " + rawBody;
				logService.saveLog(log, type, author);
				
			} else {
				// Handler error
				log = "/webhook/momo payment error | " + rawBody;
				logService.saveLog(log, type, author);
			}

			// Return for Momo
			return ResponseEntity.ok(null);
		}
		
		log = "/webhook/momo wrong signature | " + rawBody;
		logService.saveLog(log, type, author);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

}
