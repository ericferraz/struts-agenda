package br.com.src.agendastruts.agenda.contato.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.src.agendastruts.agenda.abstractdao.AbstractDAO;
import br.com.src.agendastruts.agenda.abstractpo.AbstractPO;
import br.com.src.agendastruts.agenda.contato.model.ContatoPO;
import br.com.src.agendastruts.agenda.exceptions.FiltrarException;
import br.com.src.agendastruts.agenda.interfaces.InterfaceCRUD;

public final class ContatoDAO extends AbstractDAO implements InterfaceCRUD{

	public Object filtrar(AbstractPO obj) throws FiltrarException{
		ContatoPO po = null;
		// Verificando se obj é um objeto do tipo ContatoPO
		if ( obj instanceof ContatoPO ) {
			po = (ContatoPO) obj;
		} else {
			throw new FiltrarException( "Objeto informado não condiz com o contexto: " + obj );
		}
		
		/*Declarando uma variavél que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega a Sessão aberta com o Hibernate
			sessao = getSessaoAberta();

			// Criando uma HQL(Hibernate Query Language) como se estivessemos criando uma NamedQuery
			/** Constante que contém a HQL a ser executada */
			final StringBuffer HQL = new StringBuffer();
			HQL.append( "SELECT contato FROM " );
			HQL.append( "ContatoPO contato " );
			HQL.append( "WHERE 1=1 " );

			if ( po.getId() != null ) {
				HQL.append( "AND contato.id = :idParam " );
			}

			if ( po.getCodigo() != null ) {
				HQL.append( "AND contato.codigo = :codigoParam " );
			}

			if ( po.getNome() != null && !po.getNome().isEmpty() ) {
				HQL.append( "AND contato.nome = :nomeParam " );
			}

			if ( po.getSobrenome() != null && !po.getSobrenome().isEmpty() ) {
				HQL.append( "AND contato.sobrenome = :sobrenomeParam " );
			}

			if ( po.getDataNascimento() != null ) {
				HQL.append( "AND contato.dataNascimento = :dataNascimentoParam " );
			}

			if ( po.getEmail() != null && !po.getEmail().isEmpty() ) {
				HQL.append( "AND contato.email = :emailParam " );
			}

			if ( po.getObservacao() != null && !po.getObservacao().isEmpty() ) {
				HQL.append( "AND contato.observacao = :observacaoParam " );
			}

			/*Criando e inicializando uma variavel responsável por criar uma Query
			com base na nossa HQL criada acima deixando-a preparada para o 
			Hibernate executa-la.*/
			Query query = sessao.createQuery( HQL.toString() );

			if ( po.getId() != null ) {
				query.setLong( "idParam", po.getId() );
			}

			if ( po.getCodigo() != null ) {
				query.setInteger( "codigoParam", po.getCodigo() );
			}

			if ( po.getNome() != null && !po.getNome().isEmpty() ) {
				query.setString( "nomeParam", po.getNome() );
			}

			if ( po.getSobrenome() != null && !po.getSobrenome().isEmpty() ) {
				query.setString( "sobrenomeParam", po.getSobrenome() );
			}

			if ( po.getDataNascimento() != null ) {
				query.setDate( "dataNascimentoParam", po.getDataNascimento() );
			}

			if ( po.getEmail() != null && !po.getEmail().isEmpty() ) {
				query.setString( "emailParam", po.getEmail() );
			}

			if ( po.getObservacao() != null && !po.getObservacao().isEmpty() ) {
				query.setString( "observacaoParam", po.getObservacao() );
			}

			System.out.println( HQL.toString() );

			// Executando a Query retornando o casting de seu resultado.
			return (ArrayList< ContatoPO >) query.list();
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		} finally {
			// Fecha a Sessão com o BD.
			if ( sessao != null && sessao.isOpen() ) {
				sessao.close();
			}
		}
	}
}
