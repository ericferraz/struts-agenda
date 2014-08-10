package br.com.src.agendastruts.agenda.utilidades;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * Classe que responsável por gerenciar a leitura do arquivo XML
 * que contem os dados de configuração do banco de dados.
 * 
 * @author Eric Luiz Ferras <ciencias_exatas@hotmail.com.br>
 * @since 02/03/2014 16:45:17
 * @version 1.0
 */
public abstract class LeitorXML{
	public static final String DRIVER = "driver";
	public static final String URL = "url";
	public static final String USUARIO = "usuario";
	public static final String SENHA = "senha";
	public static final String AUTO_COMMIT = "auto_commit";
	public static final String SCHEMA = "schema";

	public static String getValor( String nomeElemento ) {
		final String caminhoArquivo = "config/configuracao_jdbc.xml";

		// Carrega o XML
		SAXBuilder saxBuilder = new SAXBuilder();

		// Obtendo o XML criado.
		File fileXML = new File( caminhoArquivo );

		try {
			// Convertendo o arquivo para um Objeto Document
			Document xml = saxBuilder.build( fileXML );

			// Pegando o Nó RAIZ do XML.
			Element configuracaoJDBC = xml.getRootElement();

			Element tag = configuracaoJDBC.getChild(nomeElemento);
			String valor = tag.getAttributeValue( "valor" );

			return valor;
		} catch ( JDOMException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}

		return null;
	}
}
