package br.com.src.agendastruts.agenda.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * insersão de dados na base.
 *
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class InserirException extends SQLException {
	
	public InserirException(String message) {
		super(message);
	}

	public InserirException(String message, Throwable cause) {
		super(message, cause);
	}
}
