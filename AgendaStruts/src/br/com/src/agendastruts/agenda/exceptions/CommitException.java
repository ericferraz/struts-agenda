package br.com.src.agendastruts.agenda.exceptions;

import java.sql.SQLException;



/**
 * Classe que representa o erro ocorrido no ato da 
 * confirmação dos processos realizados na conexão.
 *
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 09/11/2012 20:54:55
 * @version 1.0
 */
public final class CommitException extends SQLException {
	
	public CommitException(String message) {
		super(message);
	}

	public CommitException(String message, Throwable cause) {
		super(message, cause);
	}
}
