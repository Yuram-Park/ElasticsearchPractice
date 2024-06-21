/**
 * 
 */
package com.example.demo.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component("chosungRegexpUtil")
public class ChosungRegexpUtil {

	public String parse(String originTerm) {

		if (!originTerm.isBlank() && originTerm.matches(".*[ㄱ-ㅎ]+.*")) {

			originTerm = originTerm.trim();
			originTerm = originTerm.replace("  ", " "); // 공백이 두번 들어간 경우 대체
			
			String[] strs = originTerm.split("");
			StringBuilder regexp = new StringBuilder();

			for (String str : strs) {
				
				// 초성일 때
				if (str.matches("[ㄱ-ㅎ]")) {

					switch (str) {
					case "ㄱ":
						str = "[가-깋]";
						break;
					case "ㄲ":
						str = "[까-낗]";
						break;
					case "ㄴ":
						str = "[나-닣]";
						break;
					case "ㄷ":
						str = "[다-딯]";
						break;
					case "ㄸ":
						str = "[따-띻]";
						break;
					case "ㄹ":
						str = "[라-맇]";
						break;
					case "ㅁ":
						str = "[마-밓]";
						break;
					case "ㅂ":
						str = "[바-빟]";
						break;
					case "ㅃ":
						str = "[빠-삫]";
						break;
					case "ㅅ":
						str = "[사-싷]";
						break;
					case "ㅆ":
						str = "[싸-앃]";
						break;
					case "ㅇ":
						str = "[아-잏]";
						break;
					case "ㅈ":
						str = "[자-짛]";
						break;
					case "ㅉ":
						str = "[짜-찧]";
						break;
					case "ㅊ":
						str = "[차-칳]";
						break;
					case "ㅋ":
						str = "[카-킿]";
						break;
					case "ㅌ":
						str = "[타-팋]";
						break;
					case "ㅍ":
						str = "[파-핗]";
						break;
					case "ㅎ":
						str = "[하-힣]";
						break;
					}

					regexp.append(str);

					// 초성 외 글자일 때
				} else {
//					Pattern.quote(str);
					regexp.append(str);
				} 
			}

			return Pattern.quote(regexp.toString());
		} else {
			return "";
		}
	}
}
