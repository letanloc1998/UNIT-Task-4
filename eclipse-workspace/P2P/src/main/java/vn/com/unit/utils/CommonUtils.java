package vn.com.unit.utils;

import java.io.UnsupportedEncodingException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {
	
	public static int ROW_OF_PAGE = 3;
	
	public static String DEFAULT_PASSWORD = "123";

	public static String encodePassword(String rawPassword) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(rawPassword);
	}
	
	// Convert from ISO-8859-1 to UTF-8
	public static String convertEncode(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("ISO-8859-1"), "UTF-8");
	}

}
