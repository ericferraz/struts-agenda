package br.com.src.agendastruts.agenda.interfaces;

import br.com.src.agendastruts.agenda.abstractpo.AbstractPO;
import br.com.src.agendastruts.agenda.exceptions.AlterarException;
import br.com.src.agendastruts.agenda.exceptions.ExcluirException;
import br.com.src.agendastruts.agenda.exceptions.FiltrarException;
import br.com.src.agendastruts.agenda.exceptions.InserirException;

/**
 * Interface responsável por representar os métodos de um CRUD.
 * Interface usada para exemplificar na pratica o uso de Interfaces.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/03/2014 10:57:57
 * @version 1.0
 * @version 1.1  Criado o método filtrar.
 */
public interface InterfaceCRUD{

	/**
	 * Método responsável por inserir registro na base de dados
	 * 
	 * @param AbstractPO po - Objeto contendo os dados a serem inseridos
	 * @throws InserirException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 11:00:49
	 * @version 1.0
	 */
	Long inserir( AbstractPO po ) throws InserirException;

	/**
	 * Método responsável por alterar registro na base de dados
	 * 
	 * @param AbstractPO po - Objeto contendo os dados a serem alterados
	 * @throws AlterarException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 11:01:48
	 * @version 1.0
	 */
	void alterar( AbstractPO po ) throws AlterarException;

	/**
	 * Método responsável por excluir registro na base de dados
	 * 
	 * @param AbstractPO po - Objeto contendo os dados a serem excluidos
	 * @throws ExcluirException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 11:04:09
	 * @version 1.0
	 */
	void excluir( AbstractPO po ) throws ExcluirException;

	public Object filtrar( AbstractPO po ) throws FiltrarException;
}
