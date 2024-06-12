/**
 * 
 */
package com.example.demo.util;

/**
 * 
 */
public class JamoParserUtil {

	//초성(19자) ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ
    static String[] chosungKor = {"ㄱ", "ㄱㄱ", "ㄴ", "ㄷ", "ㄷㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅂㅂ", "ㅅ", "ㅅㅅ", "ㅇ", "ㅈ", "ㅈㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
	
	public static String parse(String token) {
		
		if(!token.isEmpty()) {
			
			token = token.toLowerCase();
			
			char[] tokens = token.toCharArray();
			StringBuilder chosungBuffer = new StringBuilder();
			
			int chosung;
			
			for(char ch : tokens) {
				
				if(ch >= 0xAC00 && ch <= 0xD7A3) {
					
					chosung = (((ch - 0xAC00) - (ch - 0xAC00) % 28) / 28) / 21;
					
					chosungBuffer.append(chosungKor[chosung]);
					
				} else {
					if(ch == ' ') {
						chosungBuffer.append(" ");
					}
				}
			}
			System.out.println(chosungBuffer.toString());
			return chosungBuffer.toString();
		} else {
			return "";
		}
		
	}
}
