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

	public String parse(String originChosung) {
		
		String[] chosungs = originChosung.split("");
		StringBuilder regexp = new StringBuilder();
		
		// 초성 일부만 입력할 경우를 포함
		regexp.append(".*");
		
		for(String ch : chosungs) {
			
			// 초성일 때
			if(ch.matches(".*[ㄱ-ㅎ]+.*")) {
				
				switch (ch) {
				case "ㄱ":
					ch = "[가-깋]";
					break;
				case "ㄲ":
					ch = "[까-낗]";
					break;
				case "ㄴ":
					ch = "[나-닣]";
					break;
				case "ㄷ":
					ch = "[다-딯]";
					break;
				case "ㄸ":
					ch = "[따-띻]";
					break;
				case "ㄹ":
					ch = "[라-맇]";
					break;
				case "ㅁ":
					ch = "[마-밓]";
					break;
				case "ㅂ":
					ch = "[바-빟]";
					break;
				case "ㅃ":
					ch = "[빠-삫]";
					break;
				case "ㅅ":
					ch = "[사-싷]";
					break;
				case "ㅆ":
					ch = "[싸-앃]";
					break;
				case "ㅇ":
					ch = "[아-잏]";
					break;
				case "ㅈ":
					ch = "[자-짛]";
					break;
				case "ㅉ":
					ch = "[짜-찧]";
					break;
				case "ㅊ":
					ch = "[차-칳]";
					break;
				case "ㅋ":
					ch = "[카-킿]";
					break;
				case "ㅌ":
					ch = "[타-팋]";
					break;
				case "ㅍ":
					ch = "[파-핗]";
					break;
				case "ㅎ":
					ch = "[하-힣]";
					break;
				}
				
				regexp.append(ch);
				
			// 띄워쓰기일 때
			} else if(ch.equals(" ")){
				// 또는(|) 입력
				//regexp.append("|");
				// ".*[아-잏][파-핗][가-깋]|[타-팋][라-맇][아-잏]+.*"
				regexp.append("+.*|.*");
				// ".*[아-잏][파-핗][가-깋]+.*|.*[타-팋][라-맇][아-잏]+.*" -> [오스'트레일'리언] 도 나옴
				
			// 초성이 아닌 다른 문자
			} else {
				
			}
		}
		
		// 초성 일부만 입력할 경우를 포함
		regexp.append("+.*");
		System.out.println(regexp);
		return regexp.toString();
	}
}
