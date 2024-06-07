package com.example.demo.util;

import java.text.Normalizer;

import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;


public class JamoParserUtil {
	
	// 한글 소리 마디의 Unicode 시작 지점 (가)
		static char UNICODE_START = 0xAC00;
		
		// 한글의 Unicode 총 글자 수
		static int COUNT_KOREAN = 11172;
		
		// 한글 중성의 Unicode 총 글자 수
		static int COUNT_JUNGSUNG = 21;
		
		// 한글 종성의 Unicode 총 글자 수
		static int COUNT_JONGSUNG = 28;
		
		// 한글 초성의 Unicode 시작 지점 (ㄱ)
		static char CHOSUNG_START = 0x1100;

		protected final static char[] CHOSUNGs = {  
					            0x3131, 0x3132, 0x3134, 0x3137, 0x3138,     // ㄱ, ㄲ, ㄴ, ㄷ, ㄸ  
					            0x3139, 0x3141, 0x3142, 0x3143, 0x3145,     // ㄹ, ㅁ, ㅂ, ㅃ, ㅅ  
					            0x3146, 0x3147, 0x3148, 0x3149, 0x314A,     // ㅆ, ㅇ, ㅈ, ㅉ, ㅊ  
					            0x314B, 0x314C, 0x314D, 0x314E              // ㅋ, ㅌ, ㅍ, ㅎ  
					    };  
		
		public static String parse(String token) {
			int len = token.length();
			
			
			StringBuilder result = new StringBuilder();
			
			if(StringUtils.isNotBlank(token)) {
				char ch;
			
				for (int i = 0; i < len; i++) {
					
					ch = token.charAt(i);
					
					int idx = 0;
					
					for(int j = 0; j < CHOSUNGs.length; j++) {
						if(CHOSUNGs[j] == ch) {
							idx = j;
						}
					}
					
					char first =  (char) (UNICODE_START + idx * (COUNT_JUNGSUNG * COUNT_JONGSUNG));
					char last = (char) (first + (COUNT_JUNGSUNG * COUNT_JONGSUNG) - 1);
					
					result.append("[\\u" + Integer.toString(first, 16).toUpperCase() + "-\\u" + Integer.toString(last, 16).toUpperCase() + "]");
				}
			}
			String repeat = result.toString();
			result.append("|" + repeat + ".+");
			System.out.println(result);
			return result.toString();
		}
}
