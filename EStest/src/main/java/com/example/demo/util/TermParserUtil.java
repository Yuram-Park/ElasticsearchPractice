/**
 * 
 */
package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component("TermParserUtil")
public class TermParserUtil {

	public Map<String, Object> parse(String originStr) {

		originStr = originStr.toLowerCase();

		String[] strs = originStr.split("");

		StringBuilder regexpResult = new StringBuilder();
		StringBuilder matchResult = new StringBuilder();
		StringBuilder numberResult = new StringBuilder();
		Map<String, Object> resultSet = new HashMap<>();

		for (String str : strs) {

			// 초성일 때 (ㄱ-ㅎ)
			if (str.matches("[ㄱ-ㅎ]")) {

				regexpResult.append(str);

				// 한글일 때 (가-힣)
			} else if (str.matches("[가-힣]")) {

				matchResult.append(str);

				// 영어일 때? 오타일 때?
			} else if (str.matches("[a-zA-Z]")) {

				matchResult.append(str);

				// 숫자일 때
			} else if (str.matches("[0-9]")) {
				numberResult.append(str);

				// 빈칸일 때
			} else if (str.equals(" ")) {

				// 초성일 때
				regexpResult.append(" ");

				// 한글일 때
				matchResult.append(" ");
			}

		}

		resultSet.put("regexp", regexpResult.toString());
		resultSet.put("match", matchResult.toString());
		resultSet.put("number", numberResult.toString());

		return resultSet;
	}
}
