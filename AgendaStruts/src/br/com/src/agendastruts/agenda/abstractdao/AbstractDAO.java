package br.com.src.agendastruts.agenda.abstractdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import br.com.src.agendastruts.agenda.abstractpo.AbstractPO;

/**
 * Classe abstrata responsav�l por gerenciar as requisi��es de
 * conex�o ao banco de dados.
 * Utilizando o Hibernate para adquirir uma sess�o aberta.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 23/03/2014 10:37:07
 * @version 1.0
 */
public abstract class AbstractDAO{

	/**
	 * Atributo que armazenar� todas as informa��es
	 * contidas na TAG <session-factory>
	 */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Bloco est�tico respons�vel por carregar um objeto
	 * "Configuration" com os dados configurados na TAG (<hibernate-configuration>)
	 * do arquivo hibernate.cfg.xml
	 * PS: Bloco est�tico garante que seu conte�do ser� executado
	 * pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static {
		// Respons�vel por fazer a leitura do XML criado para o Hibernate 
		AnnotationConfiguration configuration = new AnnotationConfiguration();

		// Carregando as informa��es do XML na variavel conf.
		Configuration conf = configuration.configure( "hibernate.cfg.xml" );

		// Construindo uma fabrica de Sess�es.
		SESSION_FACTORY = conf.buildSessionFactory();
	}

	/**
	 * Retorna uma Sess�o aberta.
	 * 
	 * @return Session - Sess�o aberta e configurada.
	 */
	protected Session getSessaoAberta() {
		return SESSION_FACTORY.openSession();
	}

	/**
	 * M�todo respons�vel por inserir objetos na base de
	 * dados com o aux�lio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a cria��o de conex�es respeitando as
	 * regras do xml de configura��o.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem inseridos.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public Long inserir( AbstractPO obj ) {
		/*Declarando uma variav�l que armazenar� uma Sess�o do 
		 * hibernate contendo uma conex�o aberta e v�lida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenar� uma Transa��o.
		Transaction transacao = null;

		try {
			// Pega uma Sess�o aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transa��o
			transacao = sessao.beginTransaction();

			/*
			 * A��o desejada a ser executada no BD.
			 * Ap�s inserir, o m�todo 'save' retorna o id 
			 * no qual o objeto foi inserido.
			 */
			Long idGerado = (Long) sessao.save( obj );

			// Confirma a a��o executada e fecha a Transa��o.
			transacao.commit();

			System.out.println( "Sucesso ao Inserir" );

			return idGerado;
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transa��o 
			 * tiver sido criada, ser� efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sess�o com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}

		return null;
	}

	/**
	 * M�todo respons�vel por alterar objetos na base de
	 * dados com o aux�lio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a cria��o de conex�es respeitando as
	 * regras do xml de configura��o.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public void alterar( AbstractPO obj ) {
		/*Declarando uma variav�l que armazenar� uma Sess�o do 
		 * hibernate contendo uma conex�o aberta e v�lida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenar� uma Transa��o.
		Transaction transacao = null;

		try {
			// Pega uma Sess�o aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transa��o
			transacao = sessao.beginTransaction();

			/*
			 * A��o desejada a ser executada no BD.
			 */
			sessao.update( obj );

			// Confirma a a��o executada e fecha a Transa��o.
			transacao.commit();

			System.out.println( "Sucesso ao Alterar" );
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transa��o 
			 * tiver sido criada, ser� efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sess�o com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}
	}
	
	/**
	 * M�todo respons�vel por excluir objetos na base de
	 * dados com o aux�lio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a cria��o de conex�es respeitando as
	 * regras do xml de configura��o.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem excluidos.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public void excluir( AbstractPO obj ) {
		/*Declarando uma variav�l que armazenar� uma Sess�o do 
		 * hibernate contendo uma conex�o aberta e v�lida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenar� uma Transa��o.
		Transaction transacao = null;

		try {
			// Pega uma Sess�o aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transa��o
			transacao = sessao.beginTransaction();

			/*
			 * A��o desejada a ser executada no BD.
			 */
			sessao.delete( obj );

			// Confirma a a��o executada e fecha a Transa��o.
			transacao.commit();

			System.out.println( "Sucesso ao Alterar" );
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transa��o 
			 * tiver sido criada, ser� efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sess�o com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}
	}
}
