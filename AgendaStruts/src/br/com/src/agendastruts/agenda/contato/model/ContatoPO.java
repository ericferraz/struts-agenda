package br.com.src.agendastruts.agenda.contato.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.src.agendastruts.agenda.abstractpo.AbstractPO;

/**
 * Classe que representa a camada de negocio do nosso sistema.
 * 
 * Esta classe é responsável por conter todos os atributos de persistencia do
 * Objeto ContatoPO.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 09/03/2014 11:46:45
 * @version 1.0
 */
@Entity
@Table(name="contatos")
/* Uma das formas de consulta: HQL pré-definida(@NamedQueries) */
@NamedQueries(
		value={
				@NamedQuery(name="ContatoPO.filtrarPorId", query="Select contato From ContatoPO contato where contato.id = :idParam")
		}
)
public final class ContatoPO extends AbstractPO{
	
	@Column(name="codigo", nullable=false)
	private Integer codigo;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="sobrenome", nullable=false)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento", nullable=false)
	private Date dataNascimento;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="observacao", nullable=true)
	private String observacao;

	public ContatoPO(){}
	
	public ContatoPO( Long id ){
		super( id );
	}

	public ContatoPO( Long id, Integer codigo, String nome, String sobrenome, Date dataNascimento, String email, String observacao ){
		super( id );
		setCodigo( codigo );
		setNome( nome );
		setSobrenome( sobrenome );
		setDataNascimento( dataNascimento );
		setEmail( email );
		setObservacao( observacao );
	}

	/**
	 * Método responsável por retornar o valor do atributo codigo.
	 * 
	 * @return Integer codigo - codigo a ser retornado(a).
	 */
	public final Integer getCodigo() {
		return codigo;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo codigo.
	 * 
	 * @param Integer codigo - codigo a ser atribuido(a).
	 */
	public final void setCodigo( Integer codigo ) {
		this.codigo = codigo;
	}

	/**
	 * Método responsável por retornar o valor do atributo nome.
	 * 
	 * @return String nome - nome a ser retornado(a).
	 */
	public final String getNome() {
		return nome;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo nome.
	 * 
	 * @param String nome - nome a ser atribuido(a).
	 */
	public final void setNome( String nome ) {
		this.nome = nome;
	}

	/**
	 * Método responsável por retornar o valor do atributo sobrenome.
	 * 
	 * @return String sobrenome - sobrenome a ser retornado(a).
	 */
	public final String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo sobrenome.
	 * 
	 * @param String sobrenome - sobrenome a ser atribuido(a).
	 */
	public final void setSobrenome( String sobrenome ) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Método responsável por retornar o valor do atributo dataNascimento.
	 * 
	 * @return Date dataNascimento - dataNascimento a ser retornado(a).
	 */
	public final Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo dataNascimento.
	 * 
	 * @param Date dataNascimento - dataNascimento a ser atribuido(a).
	 */
	public final void setDataNascimento( Date dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Método responsável por retornar o valor do atributo email.
	 * 
	 * @return String email - email a ser retornado(a).
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo email.
	 * 
	 * @param String email - email a ser atribuido(a).
	 */
	public final void setEmail( String email ) {
		this.email = email;
	}

	/**
	 * Método responsável por retornar o valor do atributo observacao.
	 * 
	 * @return String observacao - observacao a ser retornado(a).
	 */
	public final String getObservacao() {
		return observacao;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo observacao.
	 * 
	 * @param String observacao - observacao a ser atribuido(a).
	 */
	public final void setObservacao( String observacao ) {
		this.observacao = observacao;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( codigo == null ) ? 0 : codigo.hashCode() );
		result = prime * result + ( ( dataNascimento == null ) ? 0 : dataNascimento.hashCode() );
		result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( observacao == null ) ? 0 : observacao.hashCode() );
		result = prime * result + ( ( sobrenome == null ) ? 0 : sobrenome.hashCode() );
		return result;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( !super.equals( obj ) ) {
			return false;
		}
		if ( !( obj instanceof ContatoPO ) ) {
			return false;
		}
		ContatoPO other = (ContatoPO) obj;
		if ( codigo == null ) {
			if ( other.codigo != null ) {
				return false;
			}
		} else if ( !codigo.equals( other.codigo ) ) {
			return false;
		}
		if ( dataNascimento == null ) {
			if ( other.dataNascimento != null ) {
				return false;
			}
		} else if ( !dataNascimento.equals( other.dataNascimento ) ) {
			return false;
		}
		if ( email == null ) {
			if ( other.email != null ) {
				return false;
			}
		} else if ( !email.equals( other.email ) ) {
			return false;
		}
		if ( nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !nome.equals( other.nome ) ) {
			return false;
		}
		if ( observacao == null ) {
			if ( other.observacao != null ) {
				return false;
			}
		} else if ( !observacao.equals( other.observacao ) ) {
			return false;
		}
		if ( sobrenome == null ) {
			if ( other.sobrenome != null ) {
				return false;
			}
		} else if ( !sobrenome.equals( other.sobrenome ) ) {
			return false;
		}
		return true;
	}

	/**
	 * Polimorfico
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContatoPO [getCodigo()=" + getCodigo() + ", getNome()=" + getNome() + ", getSobrenome()=" + getSobrenome() + ", getDataNascimento()=" + getDataNascimento() + ", getEmail()=" + getEmail() + ", getObservacao()=" + getObservacao() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
