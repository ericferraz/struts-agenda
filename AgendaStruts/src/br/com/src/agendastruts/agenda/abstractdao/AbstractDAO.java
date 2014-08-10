package br.com.src.agendastruts.agenda.abstractdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import br.com.src.agendastruts.agenda.abstractpo.AbstractPO;

/**
 * Classe abstrata responsavél por gerenciar as requisições de
 * conexão ao banco de dados.
 * Utilizando o Hibernate para adquirir uma sessão aberta.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 23/03/2014 10:37:07
 * @version 1.0
 */
public abstract class AbstractDAO{

	/**
	 * Atributo que armazenará todas as informações
	 * contidas na TAG <session-factory>
	 */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Bloco estático responsável por carregar um objeto
	 * "Configuration" com os dados configurados na TAG (<hibernate-configuration>)
	 * do arquivo hibernate.cfg.xml
	 * PS: Bloco estático garante que seu conteúdo será executado
	 * pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static {
		// Responsável por fazer a leitura do XML criado para o Hibernate 
		AnnotationConfiguration configuration = new AnnotationConfiguration();

		// Carregando as informações do XML na variavel conf.
		Configuration conf = configuration.configure( "hibernate.cfg.xml" );

		// Construindo uma fabrica de Sessões.
		SESSION_FACTORY = conf.buildSessionFactory();
	}

	/**
	 * Retorna uma Sessão aberta.
	 * 
	 * @return Session - Sessão aberta e configurada.
	 */
	protected Session getSessaoAberta() {
		return SESSION_FACTORY.openSession();
	}

	/**
	 * Método responsável por inserir objetos na base de
	 * dados com o auxílio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a criação de conexões respeitando as
	 * regras do xml de configuração.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem inseridos.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public Long inserir( AbstractPO obj ) {
		/*Declarando uma variavél que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenará uma Transação.
		Transaction transacao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transação
			transacao = sessao.beginTransaction();

			/*
			 * Ação desejada a ser executada no BD.
			 * Após inserir, o método 'save' retorna o id 
			 * no qual o objeto foi inserido.
			 */
			Long idGerado = (Long) sessao.save( obj );

			// Confirma a ação executada e fecha a Transação.
			transacao.commit();

			System.out.println( "Sucesso ao Inserir" );

			return idGerado;
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transação 
			 * tiver sido criada, será efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sessão com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}

		return null;
	}

	/**
	 * Método responsável por alterar objetos na base de
	 * dados com o auxílio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a criação de conexões respeitando as
	 * regras do xml de configuração.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public void alterar( AbstractPO obj ) {
		/*Declarando uma variavél que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenará uma Transação.
		Transaction transacao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transação
			transacao = sessao.beginTransaction();

			/*
			 * Ação desejada a ser executada no BD.
			 */
			sessao.update( obj );

			// Confirma a ação executada e fecha a Transação.
			transacao.commit();

			System.out.println( "Sucesso ao Alterar" );
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transação 
			 * tiver sido criada, será efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sessão com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}
	}
	
	/**
	 * Método responsável por excluir objetos na base de
	 * dados com o auxílio da framework Hibernate.
	 * 
	 * Objetos utilizados para a persistencia:
	 * # Transaction: Objeto que controla os processos a serem realizados no BD.
	 * # Session: Objeto que gerencia a criação de conexões respeitando as
	 * regras do xml de configuração.
	 * 
	 * @param Object
	 *        obj - Objeto contendo os dados a serem excluidos.
	 * 
	 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
	 * @since 23/03/2014 11:13:04
	 * @version 1.0
	 */
	public void excluir( AbstractPO obj ) {
		/*Declarando uma variavél que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		// Declarando uma variavel que armazenará uma Transação.
		Transaction transacao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transação
			transacao = sessao.beginTransaction();

			/*
			 * Ação desejada a ser executada no BD.
			 */
			sessao.delete( obj );

			// Confirma a ação executada e fecha a Transação.
			transacao.commit();

			System.out.println( "Sucesso ao Alterar" );
		} catch ( Exception e ) {
			/* Caso ocorra algum erro no processo, se a transação 
			 * tiver sido criada, será efetuado um Rollback na 
			 * mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}

			e.printStackTrace();
		} finally {
			// Fecha a Sessão com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}
	}
}
