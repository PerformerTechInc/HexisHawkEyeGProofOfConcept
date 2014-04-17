package com.mlb.qa.atb.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.mlb.qa.common.string.StringUtils;
import com.qaprosoft.carina.core.foundation.exception.NotSupportedOperationException;

public class TicketServiceStringAdapter extends XmlAdapter<String, String> {

	@Override
	public String marshal(String arg0) throws Exception {
		throw new NotSupportedOperationException();
	}

	@Override
	public String unmarshal(String source) throws Exception {
		if (source == null) {
			return null;
		}
		return StringUtils.replaceUtf8HtmlCodesWithCharacters(source.trim()).replaceAll("\\s{2,}", " ")
				.replaceAll("&reg;", new Character('\u00AE').toString());
	}

}
