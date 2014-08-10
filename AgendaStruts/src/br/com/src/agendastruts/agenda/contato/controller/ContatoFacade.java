package br.com.src.agendastruts.agenda.contato.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import br.com.src.agendastruts.agenda.contato.model.ContatoPO;
import br.com.src.agendastruts.agenda.contato.model.ContatoService;
import br.com.src.agendastruts.agenda.exceptions.ApplicationException;
import br.com.src.agendastruts.agenda.utilidades.Utilidades;

/**
 * Classe que representa a interliga��o do Sistema com a camada de Front-end.
 * 
 * Aqui entende-se como camada de Front-end toda classe e/ou arquivos criados
 * especialmente para a visualiza��o.
 * 
 * Ex: Framework Struts, Framework JSF, Swing, JSP, Servlets, Java + Flex, Java FX, etc...
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/03/2014 16:52:10
 * @version 1.0
 */
public class ContatoFacade{
	/**
	 * Atributo respons�vel por possibilitar o acesso da
	 * Camada Controller a Camada MODEL
	 */
	private ContatoService service;

	// ******************************************** \\
	// ************ APLICANDO SINGLETON *********** \\
	// ******************************************** \\
	/**
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * <b>SINGLETON</b> Construtor privado que permite apenas que a propria
	 * classe se instancie. Isso para garantir o SINGLETON.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 17:00:22
	 * @version 1.0
	 */
	private ContatoFacade() throws ApplicationException{
		service = new ContatoService();
	}

	/**
	 * Declara��o do atributo que auxilia o <b>SINGLETON</b>
	 */
	private static ContatoFacade instance;

	/**
	 * <b>SINGLETON</b> M�todo respons�vel por retornar uma instancia de
	 * ContatoFacade.
	 * 
	 * @return ContatoFacade instance - Uma instancia da pr�pria Classe.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 09/03/2014 17:03:13
	 * @version 1.0
	 */
	public static ContatoFacade getInstance() throws ApplicationException {
		if ( instance == null ) {
			instance = new ContatoFacade();
		}
		return instance;
	}

	// *************************FIM**************** \\
	// ************ APLICANDO SINGLETON *********** \\
	// **************************FIM*************** \\

	/**
	 * M�todo respons�vel por iniciar o processo de inser��o com a aplica��o.
	 * Este m�todo tem como objetivo pegar os dados vindo como parametro
	 * e realizar convers�es para seus respectivos tipo na Camada de Neg�cio.
	 * 
	 * Este m�todo faz parte da classe Facade que esta localizada na camada de Controle
	 * da Aplica��o; as classes localizadas nesta camada s�o respons�vel por interligar
	 * a camada de Visualiza��o(V) com a camada de Negocio(M).
	 * 
	 * @param codigo
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param email
	 * @param observacao
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 16/03/2014 09:18:10
	 * @version 1.0
	 * @throws ApplicationException
	 */
	public void inserir( String codigo, String nome, String sobrenome, String dataNascimento, String email, String observacao ) throws ApplicationException {
		// Criando as variaveis da convers�o
		Integer codigoConvertido = null;
		Date dataNascimentoConvertida = null;

		try {
			codigoConvertido = Integer.valueOf( codigo );
			dataNascimentoConvertida = Utilidades.parseDate( dataNascimento, "dd/MM/yyyy" );
		} catch ( NumberFormatException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( ParseException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro inesperado nas convers�es de dados", e );
		}

		ContatoPO po = new ContatoPO( null, codigoConvertido, nome, sobrenome, dataNascimentoConvertida, email, observacao );

		service.inserir( po );
	}

	/**
	 * M�todo respons�vel por iniciar o processo de altera��o com a aplica��o.
	 * Este m�todo tem como objetivo pegar os dados vindo como parametro
	 * e realizar convers�es para seus respectivos tipo na Camada de Neg�cio.
	 * 
	 * Este m�todo faz parte da classe Facade que esta localizada na camada de Controle
	 * da Aplica��o; as classes localizadas nesta camada s�o respons�vel por interligar
	 * a camada de Visualiza��o(V) com a camada de Negocio(M).
	 * 
	 * @param id
	 * @param codigo
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param email
	 * @param observacao
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 16/03/2014 09:45:47
	 * @version 1.0
	 */
	public void alterar( String id, String codigo, String nome, String sobrenome, String dataNascimento, String email, String observacao ) throws ApplicationException {
		// Criando as variaveis da convers�o
		Long idConvertido = null;
		Integer codigoConvertido = null;
		Date dataNascimentoConvertida = null;

		try {
			idConvertido = Long.valueOf( id );
			codigoConvertido = Integer.valueOf( codigo );
			dataNascimentoConvertida = Utilidades.parseDate( dataNascimento, "dd/MM/yyyy" );
		} catch ( NumberFormatException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( ParseException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro inesperado nas convers�es de dados", e );
		}

		ContatoPO po = new ContatoPO( idConvertido, codigoConvertido, nome, sobrenome, dataNascimentoConvertida, email, observacao );

		service.alterar( po );
	}

	/**
	 * M�todo respons�vel por iniciar o processo de altera��o com a aplica��o.
	 * Este m�todo tem como objetivo pegar os dados vindo como parametro
	 * e realizar convers�es para seus respectivos tipo na Camada de Neg�cio.
	 * 
	 * Este m�todo faz parte da classe Facade que esta localizada na camada de Controle
	 * da Aplica��o; as classes localizadas nesta camada s�o respons�vel por interligar
	 * a camada de Visualiza��o(V) com a camada de Negocio(M).
	 * 
	 * 
	 * @param id
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 16/03/2014 10:19:26
	 * @version 1.0
	 */
	public void excluir( String id, String codigo, String nome, String sobrenome, String dataNascimento, String email, String observacao ) throws ApplicationException {
		// Criando as variaveis da convers�o
		Long idConvertido = null;
		Integer codigoConvertido = null;
		Date dataNascimentoConvertida = null;

		try {
			idConvertido = Long.valueOf( id );
			codigoConvertido = Integer.valueOf( codigo );
			dataNascimentoConvertida = Utilidades.parseDate( dataNascimento, "dd/MM/yyyy" );
		} catch ( NumberFormatException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( ParseException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro inesperado nas convers�es de dados", e );
		}

		ContatoPO po = new ContatoPO( idConvertido, codigoConvertido, nome, sobrenome, dataNascimentoConvertida, email, observacao );

		service.excluir( po );
	}

	/**
	 * M�todo respons�vel por iniciar o processo de Filtragem com a aplica��o.
	 * Este m�todo tem como objetivo pegar os dados vindo como parametro
	 * e realizar convers�es para seus respectivos tipo na Camada de Neg�cio.
	 * 
	 * Este m�todo faz parte da classe Facade que esta localizada na camada de Controle
	 * da Aplica��o; as classes localizadas nesta camada s�o respons�vel por interligar
	 * a camada de Visualiza��o(V) com a camada de Negocio(M).
	 * 
	 * @param id
	 * @param codigo
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param email
	 * @param observacao
	 * @return
	 * @throws ApplicationException
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 16/03/2014 10:19:47
	 * @version 1.0
	 */
	public ArrayList< ContatoPO > filtrar( String id, String codigo, String nome, String sobrenome, String dataNascimento, String email, String observacao ) throws ApplicationException {
		// Criando as variaveis da convers�o
		Long idConvertido = null;
		Integer codigoConvertido = null;
		Date dataNascimentoConvertida = null;

		try {
			if ( !( id == null || id.isEmpty() ) ) {
				idConvertido = Long.valueOf( id );
			}

			if ( !( codigo == null || codigo.isEmpty() ) ) {
				codigoConvertido = Integer.valueOf( codigo );
			}

			if ( !( dataNascimento == null || dataNascimento.replace( "/", "" ).trim().isEmpty() ) ) {
				dataNascimentoConvertida = Utilidades.parseDate( dataNascimento, "dd/MM/yyyy" );
			}
		} catch ( NumberFormatException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( ParseException e ) {
			throw new ApplicationException( "Falha nas convers�es dos dados!", e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro inesperado nas convers�es de dados", e );
		}

		ContatoPO po = new ContatoPO( idConvertido, codigoConvertido, nome, sobrenome, dataNascimentoConvertida, email, observacao );

		return service.filtrar( po );
	}
}
