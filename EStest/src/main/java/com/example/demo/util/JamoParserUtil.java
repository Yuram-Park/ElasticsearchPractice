package com.example.demo.util;

import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;

@Component("jamoParserUtil")
public class JamoParserUtil {
	
	// 한글 소리 마디의 Unicode 시작 지점 (가)
		static char UNICODE_SYLLABLES_START_CODEPOINT = 0xAC00;
		
		// 한글의 Unicode 총 글자 수
		static int COUNT_IN_UNICODE = 11172;
		
		// 한글 중성의 Unicode 총 글자 수
		static int COUNT_JUNGSUNG_IN_UNICODE = 21;
		
		// 한글 종성의 Unicode 총 글자 수
		static int COUNT_JONGSUNG_IN_UNICODE = 28;
		
		// 한글 자모 분해의 계산 기본 값 (중성 글자 수 * 종성 글자 수)
		static int JAMO_SPLIT_VALUE = COUNT_JUNGSUNG_IN_UNICODE * COUNT_JONGSUNG_IN_UNICODE;

		protected final static char[] COMPATIBILITY_CHOSUNGs = {  
					            0x3131, 0x3132, 0x3134, 0x3137, 0x3138,     // ㄱ, ㄲ, ㄴ, ㄷ, ㄸ  
					            0x3139, 0x3141, 0x3142, 0x3143, 0x3145,     // ㄹ, ㅁ, ㅂ, ㅃ, ㅅ  
					            0x3146, 0x3147, 0x3148, 0x3149, 0x314A,     // ㅆ, ㅇ, ㅈ, ㅉ, ㅊ  
					            0x314B, 0x314C, 0x314D, 0x314E              // ㅋ, ㅌ, ㅍ, ㅎ  
					    };  
		
		public static String parse(String token) {
			StringBuilder result = new StringBuilder();
			
			if(StringUtils.isNotBlank(token)) {
				char ch, expectedKorean;
				int chosung;
			
				for (int i = 0, length = token.length(); i < length; i++) {
					ch = token.charAt(i);
					
					expectedKorean = (char) (ch - UNICODE_SYLLABLES_START_CODEPOINT);
	
					if (expectedKorean >= 0 && expectedKorean <= COUNT_IN_UNICODE) {
						
						chosung = expectedKorean / JAMO_SPLIT_VALUE;
						
						System.out.println(chosung); 
						
						result.append(COMPATIBILITY_CHOSUNGs[chosung]);
						
					}//else {
					//	System.out.println("노한글");
					//	result.toString();
					//	break;
					//}
				}
			}
			System.out.println(result.toString()); // ㅇㅇㄷㅇ 저장완료 -> 유니코드 범위로 변환 필요
			return result.toString();
		}
}
