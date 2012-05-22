package com.tyland.util;


import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public final class EncoderUtil {
	
	private static final ShaPasswordEncoder SHA1_ENCODER = new ShaPasswordEncoder();
	
	private EncoderUtil(){
	
	}
		
	public static String sha1Encode(String originalString){
		String encodeString = null;
			
		if (StringUtils.isNotEmpty(originalString)){
				encodeString = SHA1_ENCODER.encodePassword(originalString, null);
		}
			
		return encodeString;
	}
	
	public static void main(String[] args){
		System.out.println(sha1Encode("888888"));
	}
}
