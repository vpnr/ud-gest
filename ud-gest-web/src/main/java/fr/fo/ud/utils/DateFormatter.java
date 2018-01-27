package fr.fo.ud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date>{

	@Override
	public String print(Date object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
		return dateFormat.parse(text);
	}
	
}
