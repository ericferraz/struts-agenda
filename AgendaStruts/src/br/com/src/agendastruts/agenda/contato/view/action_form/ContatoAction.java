package br.com.src.agendastruts.agenda.contato.view.action_form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.src.agendastruts.agenda.contato.controller.ContatoFacade;
import br.com.src.agendastruts.agenda.contato.model.ContatoPO;
import br.com.src.agendastruts.agenda.exceptions.ApplicationException;
import br.com.src.agendastruts.agenda.utilidades.Messages;
import br.com.src.agendastruts.agenda.utilidades.Utilidades;

/**
 * 
 * Todas as requisições feitas a Servlet Struts passarão por
 * classes como esta. Nesta classe conterá todos os métodos que serão, de alguma
 * forma, chamados pela JSP, como por exemplo: inserir, alterar, excluir,
 * consultar, etc... Está classe é a ligação direta com a camada WEB, sendo a
 * ultima classe da camada JAVA. Quando a JSP de contato for submetida, o
 * Struts procurará loucamente por um método na classe action informada na
 * propriedade "action" do formulario que contenha o nome igual ao nome
 * informado na propriedade "acao" do formulario na JSP. Ex: <form
 * action="ContatoAction"> <html:hidden property="acao" value="inserir"/>
 * ......... </form>
 * 
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 06/04/2014 14:40:04
 * @version 1.0
 */
public final class ContatoAction extends DispatchAction {
	public ActionForward abrirTela(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;

		System.out.println("Abrir Tela");
		filtrar(mapping, meuForm, request, response);
		return mapping.findForward("contato");
	}

	public ActionForward inserir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		try {
			ContatoFacade.getInstance().inserir(meuForm.getCodigo(),
					meuForm.getNome(), meuForm.getSobrenome(),
					meuForm.getDataNascimento(), meuForm.getEmail(),
					meuForm.getObservacao());
			meuForm.limparFormulario();
			atualizarTabela(meuForm);
			this.addMessages(request, Messages.createMessages("sucesso"));
			filtrar(mapping, meuForm, request, response);
		} catch (ApplicationException e) {
			this.addMessages(
					request,
					Messages.createMessages("mensagem",
							new String[] { e.getMessage() }));

		} catch (Exception e) {
			this.addMessages(request, Messages.createMessages("falha"));
		}

		return mapping.findForward("contato");
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		try {
			ContatoFacade.getInstance().alterar(meuForm.getId(),
					meuForm.getCodigo(), meuForm.getNome(),
					meuForm.getSobrenome(), meuForm.getDataNascimento(),
					meuForm.getEmail(), meuForm.getObservacao());
			meuForm.limparFormulario();
			atualizarTabela(meuForm);

			this.addMessages(request, Messages.createMessages("sucesso"));
			filtrar(mapping, meuForm, request, response);
		} catch (ApplicationException e) {
			this.addMessages(
					request,
					Messages.createMessages("mensagem",
							new String[] { e.getMessage() }));

		} catch (Exception e) {
			this.addMessages(request, Messages.createMessages("falha"));
		}

		return mapping.findForward("contato");

	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		try {
			ContatoFacade.getInstance().excluir(meuForm.getId(),
					meuForm.getCodigo(), meuForm.getNome(),
					meuForm.getSobrenome(), meuForm.getDataNascimento(),
					meuForm.getEmail(), meuForm.getObservacao());
			meuForm.limparFormulario();
			atualizarTabela(meuForm);
			this.addMessages(request, Messages.createMessages("sucesso"));
			filtrar(mapping, meuForm, request, response);

		} catch (ApplicationException e) {
			this.addMessages(
					request,
					Messages.createMessages("mensagem",
							new String[] { e.getMessage() }));

		} catch (Exception e) {
			this.addMessages(request, Messages.createMessages("falha"));
		}
		return mapping.findForward("contato");
	}

	public ActionForward filtrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		try {
			ArrayList<ContatoPO> encontrados;
			encontrados = ContatoFacade.getInstance().filtrar(meuForm.getId(),
					meuForm.getCodigo(), meuForm.getNome(),
					meuForm.getSobrenome(), meuForm.getDataNascimento(),
					meuForm.getEmail(), meuForm.getObservacao());

			meuForm.setContatos(encontrados);

			// this.addMessages( request, Messages.createMessages( "sucesso" )
			// );

		} catch (ApplicationException e) {
			this.addMessages(
					request,
					Messages.createMessages("mensagem",
							new String[] { e.getMessage() }));

		} catch (Exception e) {
			this.addMessages(request, Messages.createMessages("falha"));
		}
		return mapping.findForward("contato");
	}

	public ActionForward selecionar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		try {
			ArrayList<ContatoPO> encontrados;
			encontrados = ContatoFacade.getInstance().filtrar(meuForm.getId(),
					null, null, null, null, null, null);

			if (encontrados != null && encontrados.size() == 1) {
				ContatoPO poEncontrado = encontrados.get(0);

				meuForm.setId(poEncontrado.getId().toString());
				meuForm.setCodigo(poEncontrado.getCodigo().toString());
				meuForm.setNome(poEncontrado.getNome());
				meuForm.setSobrenome(poEncontrado.getSobrenome());
				meuForm.setDataNascimento(Utilidades.parseDate(
						poEncontrado.getDataNascimento(), "dd/MM/yyyy"));
				meuForm.setEmail(poEncontrado.getEmail());
				meuForm.setObservacao(poEncontrado.getObservacao());
			}

			// this.addMessages( request, Messages.createMessages( "sucesso" )
			// );

		} catch (ApplicationException e) {
			this.addMessages(
					request,
					Messages.createMessages("mensagem",
							new String[] { e.getMessage() }));

		} catch (Exception e) {
			this.addMessages(request, Messages.createMessages("falha"));
		}
		return mapping.findForward("contato");
	}

	public ActionForward limpar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// Pegando o ActionForm e o retransformando (Especializando) em
		// ContatoForm.
		ContatoForm meuForm = (ContatoForm) form;
		meuForm.limparFormulario();
		filtrar(mapping, meuForm, request, response);
		return mapping.findForward("contato");
	}
	
	private void atualizarTabela( ContatoForm meuForm )  {
		  meuForm.getContatos().clear();
  }

}