package br.com.src.agendastruts.agenda.contato.view.action_form;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;
import br.com.src.agendastruts.agenda.contato.model.ContatoPO;

/**
 * 
 * Classe respons�vel por conter um atributo para cada campo na tela(JSP).
 * Todas as altera��es que quiser fazer nos campos da tela, dever�o ser feitas no FORM.
 * Isso porque a tela � carregada com base numa classe FORM, sendo assim, tudo que
 * fizer na classe FORM ser� refletido nos campos da tela.
 * 
 * 
 * @author Eric Luiz Ferras<ciencias_exatas@hotmail.com.br>
 * @since 06/04/2014 14:28:46
 * @version 1.0
 */
public final class ContatoForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7483337054088845452L;

	
	/** Respons�vel por armazernar as mensagens geradas pelo Sistema. */	
	private String mensagem;
	
	
	private String id;
	private String codigo;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String email;
	private String observacao;
	private ArrayList< ContatoPO > contatos = new ArrayList<>();

	
	/**
	 * M�todo respons�vel por retornar o valor do atributo id.
	 * 
	 * @return String id - id a ser retornado(a).
	 */
	public  String getId() {
		return id;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo id.
	 * 
	 * @param String id - id a ser atribuido(a).
	 */
	public  void setId( String id ) {
		this.id = id;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo codigo.
	 * 
	 * @return String codigo - codigo a ser retornado(a).
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo codigo.
	 * 
	 * @param String codigo - codigo a ser atribuido(a).
	 */
	public  void setCodigo( String codigo ) {
		this.codigo = codigo;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo nome.
	 * 
	 * @return String nome - nome a ser retornado(a).
	 */
	public  String getNome() {
		return nome;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo nome.
	 * 
	 * @param String nome - nome a ser atribuido(a).
	 */
	public  void setNome( String nome ) {
		this.nome = nome;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo sobrenome.
	 * 
	 * @return String sobrenome - sobrenome a ser retornado(a).
	 */
	public  String getSobrenome() {
		return sobrenome;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo sobrenome.
	 * 
	 * @param String sobrenome - sobrenome a ser atribuido(a).
	 */
	public  void setSobrenome( String sobrenome ) {
		this.sobrenome = sobrenome;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo dataNascimento.
	 * 
	 * @return String dataNascimento - dataNascimento a ser retornado(a).
	 */
	public  String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo dataNascimento.
	 * 
	 * @param String dataNascimento - dataNascimento a ser atribuido(a).
	 */
	public  void setDataNascimento( String dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo email.
	 * 
	 * @return String email - email a ser retornado(a).
	 */
	public  String getEmail() {
		return email;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo email.
	 * 
	 * @param String email - email a ser atribuido(a).
	 */
	public  void setEmail( String email ) {
		this.email = email;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo observacao.
	 * 
	 * @return String observacao - observacao a ser retornado(a).
	 */
	public  String getObservacao() {
		return observacao;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo observacao.
	 * 
	 * @param String observacao - observacao a ser atribuido(a).
	 */
	public  void setObservacao( String observacao ) {
		this.observacao = observacao;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo contatos.
	 * 
	 * @return ArrayList<ContatoPO> contatos - contatos a ser retornado(a).
	 */
	public  ArrayList< ContatoPO > getContatos() {
		return contatos;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo contatos.
	 * 
	 * @param ArrayList<ContatoPO> contatos - contatos a ser atribuido(a).
	 */
	public  void setContatos( ArrayList< ContatoPO > contatos ) {
		this.contatos = contatos;
	}
	
	
	
	/**
	 * M�todo respons�vel por retornar o valor do atributo mensagem.
	 * @return String mensagem - mensagem a ser retornado(a).
	 */
	public final String getMensagem() {
		return mensagem;
	}

	/**
	 * M�todo respons�vel por atribuir o valor ao atributo mensagem.
	 * @param String mensagem - mensagem a ser atribuido(a).
	 */
	public final void setMensagem( String mensagem ) {
		this.mensagem = mensagem;
	}

	public void limparFormulario(){
		setId( "" );
		setCodigo( "" );
		setDataNascimento( "" );
		setEmail( "" );
		setObservacao( "" );
		setNome( "" );
		setSobrenome( "" );
		getContatos().clear();
	}

}
