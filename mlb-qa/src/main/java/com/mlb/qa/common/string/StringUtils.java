package com.mlb.qa.common.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String replaceUtf8HtmlCodesWithCharacters(String source) {
		String result = source;
		String codeRegEx = "&#\\d{1,4};";
		Matcher matcher = Pattern.compile(codeRegEx).matcher(result);
		while (matcher.find()) {
			String code = matcher.group();
			int codePoint = Integer.parseInt(org.apache.commons.lang.StringUtils.substringBetween(code, "&#", ";"));
			result = result.replaceFirst(code, new String(Character.toChars(codePoint)));
		}
		return result;
	}
}
