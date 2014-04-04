package com.mlb.qa.android.atb.service.lookup;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.mlb.qa.android.atb.model.Item;

public class LookupHelper {

	@SuppressWarnings("unchecked")
	public static <T extends Item> List<T> unmarshal(Class<T> clazz,
			String source) {
		List<T> result = new LinkedList<T>();

		Matcher matcher = Pattern.compile("<row[^<]*/>", Pattern.DOTALL)
				.matcher(source);
		try {
			while (matcher.find()) {
				JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
				Unmarshaller jaxbUnmarshaller = jaxbContext
						.createUnmarshaller();
				result.add((T) jaxbUnmarshaller.unmarshal(new StringReader(
						matcher.group())));
			}
		} catch (JAXBException e) {
			throw new LookupException(
					"Error while unmarshaling search results: ", e);
		}
		return result;
	}

}
