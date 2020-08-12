package vn.com.unit.payment;

import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.Environment.EnvTarget;
import com.mservice.shared.sharedmodels.Environment.ProcessType;

public class MomoPayment {

	EnvTarget target = EnvTarget.DEV;

	ProcessType process = ProcessType.PAY_GATE;
	Environment environment = Environment.selectEnv(target, process);
	
}
