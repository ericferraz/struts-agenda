package br.com.src.agendastruts.agenda.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utilidades{
	public static Date parseDate( String data, String mascara ) throws ParseException {
		if ( data != null && !"".equals( data ) ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) && data.length() > 10 ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "dd/MM/yyyy" );
			}

			dateFormat.setLenient( false );
			return dateFormat.parse( data );
		}

		return null;
	}

	public static String parseDate( Date data, String mascara ) throws ParseException {
		if ( data != null ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();

			if ( mascara != null && !"".equals( mascara ) ) {
				dateFormat.applyPattern( mascara );
			} else {
				dateFormat.applyPattern( "dd/MM/yyyy" );
			}

			dateFormat.setLenient( false );
			return dateFormat.format( data ); // <-- O format é o que difere do outro método.
		}

		return null;
	}
}
