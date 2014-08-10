package br.com.src.agendastruts.agenda.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * consulta de dados na base.
 *
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class FiltrarException extends SQLException {
	
	public FiltrarException(String message) {
		super(message);
	}

	public FiltrarException(String message, Throwable cause) {
		super(message, cause);
	}
}
