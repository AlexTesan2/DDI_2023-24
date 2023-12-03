package grupo.StudentServices;

import org.springframework.stereotype.Service;

@Service
public class loggingService {

	public boolean validateUser(String userid, String password) {
		// in28minutes, dummy
		return userid.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("dummy");
	}

}