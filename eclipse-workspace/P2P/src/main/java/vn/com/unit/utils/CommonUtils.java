package vn.com.unit.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {
	
	public static int ROW_OF_PAGE = 3;
	
	public static String DEFAULT_PASSWORD = "123";

	public static String encodePassword(String rawPassword) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(rawPassword);
	}

}
