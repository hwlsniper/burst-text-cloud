package com.burst.text.emoji;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Administrator
 * 表情解析
 */
public class EmojiDealUtil extends EmojiParser {

	/**
	 * 获取非表情字符串
	 * 
	 * @param input
	 * @return
	 */
	public static String getNonEmojiString(String input) {
		int prev = 0;
		StringBuilder sb = new StringBuilder();
		List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
		for (UnicodeCandidate candidate : replacements) {
			sb.append(input.substring(prev, candidate.getEmojiStartIndex()));
			prev = candidate.getFitzpatrickEndIndex();
		}
		return sb.append(input.substring(prev)).toString();
	}

	/**
	 * 获取表情字符串
	 * 
	 * @param input
	 * @return
	 */
	public static String getEmojiUnicodeString(String input) {
		if (StringUtils.isNotBlank(input)) {

			EmojiTransformer transformer = new EmojiTransformer() {
				public String transform(UnicodeCandidate unicodeCandidate) {
					return unicodeCandidate.getEmoji().getHtmlHexadecimal();
				}
			};
			StringBuilder sb = new StringBuilder();
			List<UnicodeCandidate> replacements = getUnicodeCandidates(input);
			for (UnicodeCandidate candidate : replacements) {
				sb.append(transformer.transform(candidate));
			}
			return parseToUnicode(sb.toString());
		} else {
			return null;
		}
	}

	public static String parseToUnicode(String input) {
		if (StringUtils.isNotBlank(input)) {
			return EmojiParser.parseToUnicode(input);
		} else {
			return input;
		}
	}

	public static String getUnicode(String source) {
		String returnUniCode = null;
		String uniCodeTemp = null;
		for (int i = 0; i < source.length(); i++) {
			uniCodeTemp = "\\u" + Integer.toHexString((int) source.charAt(i));
			returnUniCode = returnUniCode == null ? uniCodeTemp : returnUniCode
					+ uniCodeTemp;
		}
		return returnUniCode;
	}

	/**
	 * 批量处理评论内容
	 * 
	 * @param infos
	 * @author 何文亮
	 * @return
	 */
	/*public static List<Comment> bacthParseToUnicode(List<Comment> infos) {

		for (Comment coment : infos) {
			coment.setContent(EmojiParser.parseToUnicode(coment.getContent()));
			//coment.setContent(revert(coment.getContent()));
		}
		return infos;
	}*/

}
