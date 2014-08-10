package br.com.src.agendastruts.agenda.exceptions;

import java.sql.SQLException;

/**
 * Classe que representa o erro ocorrido na Aplica��o.
 * 
 * Este erro ser� lan�ado sempre para as camadas de front-end.
 *
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 12/09/2013 21:30:13
 * @version 1.0
 */
public final class ApplicationException extends SQLException {
	
	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
