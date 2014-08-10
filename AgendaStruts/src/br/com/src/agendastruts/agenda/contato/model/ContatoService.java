package br.com.src.agendastruts.agenda.contato.model;

import java.util.ArrayList;

import br.com.src.agendastruts.agenda.contato.dao.ContatoDAO;
import br.com.src.agendastruts.agenda.exceptions.AlterarException;
import br.com.src.agendastruts.agenda.exceptions.ApplicationException;
import br.com.src.agendastruts.agenda.exceptions.ExcluirException;
import br.com.src.agendastruts.agenda.exceptions.FiltrarException;
import br.com.src.agendastruts.agenda.exceptions.InserirException;
import br.com.src.agendastruts.agenda.interfaces.InterfaceCRUD;

/**
 * Classe respons�vel por conter as regras de neg�cios do nosso sistema.
 * Esta classe representa a camada Model(M) do MVC.
 * Ser� nesta Classe que iremos pegar os dados dos campos da tela(V) e
 * preencher o nosso PO(M) enviando-o � camada DAO para consultas e
 * persistencias. Neste nosso sistema, todos os tratamentos de exce��o estar�o
 * centralizados aqui, juntamente com as poss�veis valida��es de campos e
 * regras.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/03/2014 16:12:11
 * @version 1.0
 */
public final class ContatoService{
	/**
	 * Atributo respons�vel por possibilitar o acesso da Camada Model a Camada DAO.
	 * Aqui esta sendo aplicado o conceito de GENERALIZA��O na qual
	 * um atributo do tipo de uma Interface receber� um Objeto do tipo de uma classe
	 * que implementa esta mesma Interface
	 */
	private final InterfaceCRUD DAO;

	public ContatoService() throws ApplicationException{
		DAO = new ContatoDAO();
	}

	/**
	 * M�todo respons�vel por trabalhar os dados antes de mandar para a Camada de
	 * persit�ncia(DAO).
	 * 
	 * @param ContatoPO po - Objeto contendo todos os dados a serem persistidos.
	 * @throws ApplicationException - Caso ocorra algum erro na aplica��o.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 16:21:42
	 * @version 1.0
	 */
	public void inserir( ContatoPO po ) throws ApplicationException {
		/** Criando um Bloco de Transa��o */
		try {
			if ( !isCamposObrigatoriosPreenchidos( po ) ) {
				throw new ApplicationException( "Preencha todos os campos!" );
			}

			po.setId( DAO.inserir( po ) );
		} catch ( InserirException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido", e );
		} 
	}

	/**
	 * M�todo respons�vel por trabalhar os dados antes de mandar para a Camada de
	 * persit�ncia(DAO).
	 * 
	 * @param ContatoPO po - Objeto contendo todos os dados a serem persistidos.
	 * @throws ApplicationException - Caso ocorra algum erro na aplica��o.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 16:41:39
	 * @version 1.0
	 */
	public void alterar( ContatoPO po ) throws ApplicationException {
		/** Criando um Bloco de Transa��o */
		try {
			
			if ( !isCamposObrigatoriosPreenchidos( po ) ) {
				throw new ApplicationException( "Preencha todos os campos!" );
			}

			DAO.alterar( po );
		}catch ( AlterarException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido", e );
		} 
	}

	/**
	 * M�todo respons�vel por trabalhar os dados antes de mandar para a Camada de
	 * persit�ncia(DAO).
	 * 
	 * @param ContatoPO po - Objeto contendo todos os dados a serem persistidos.
	 * @throws ApplicationException - Caso ocorra algum erro na aplica��o.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 16:45:00
	 * @version 1.0
	 */
	public void excluir( ContatoPO po ) throws ApplicationException {
		/** Criando um Bloco de Transa��o */
		try {
			
			if ( po.getId() == null || po.getId() <= Long.valueOf( "0" ) ) {
				throw new ApplicationException( "Nenhum registro foi selecionado." );
			}

			DAO.excluir( po );
		} catch ( ExcluirException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido", e );
		} 
	}

	/**
	 * M�todo respons�vel por trabalhar os dados antes de mandar para a Camada de 
	 * persit�ncia(DAO).
	 *
	 * @param ContatoPO po - Objeto contendo todos os dados a serem filtrados.
	 * @throws ApplicationException - Caso ocorra algum erro na aplica��o.
	 *
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 16:50:20
	 * @version 1.0
	 */
	public ArrayList< ContatoPO > filtrar( ContatoPO po ) throws ApplicationException {
		/** Criando um Bloco de Transa��o */
		try {
			
			return (ArrayList< ContatoPO >) DAO.filtrar( po );

		} catch ( FiltrarException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	private boolean isCamposObrigatoriosPreenchidos( ContatoPO po ) {
		if ( po.getCodigo() == null || ( po.getNome() == null || po.getNome().isEmpty() ) || ( po.getSobrenome() == null || po.getSobrenome().isEmpty() ) || po.getDataNascimento() == null ) {

			return false;
		}
		return true;
	}
}
