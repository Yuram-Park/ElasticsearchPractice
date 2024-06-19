/**
 * 
 */
package com.example.demo.util;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component("chosungParserUtil2")
public class ChosungParserUtil2 {

	public String parse(String originStr) {

		if (!originStr.isBlank()) {

			originStr = originStr.trim();
			originStr = originStr.replace("  ", " "); // 공백이 두번 들어간 경우 대체
			
			String[] strs = originStr.split("");
			StringBuilder regexp = new StringBuilder();

			// ~를 포함하는
			regexp.append(".*");

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

					// 공백일 때
				} else if (str.equals(" ")) {

					regexp.append("+.*|.*"); 

					// 초성이 아닌 다른 문자
				} else {
					// 한글일 경우

					// 숫자일 경우

					// 영어일 경우? 영어 오타일경우,
				}
			}

			// 초성 일부만 입력할 경우를 포함
			regexp.append("+.*");
			System.out.println(regexp);
			return regexp.toString();
		} else {
			return "";
		}
	}
}
