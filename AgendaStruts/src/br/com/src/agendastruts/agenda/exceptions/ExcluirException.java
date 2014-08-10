package br.com.src.agendastruts.agenda.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * exclusão de dados na base.
 *
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class ExcluirException extends SQLException {
	
	public ExcluirException(String message) {
		super(message);
	}

	public ExcluirException(String message, Throwable cause) {
		super(message, cause);
	}
}
