package br.com.src.agendastruts.agenda.utilidades;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * Classe interna(inner class) respons�vel por gerenciar as a��es realizadas na JTable.
 * Nesta classe estar�o os metodos que por exemplo adicionar�, remover� e atualizar�
 * os dados da tabela.
 * 
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 04/09/2013 21:46:52
 * @version 1.0
 */
public class TableModelGenerica extends AbstractTableModel{

    private static final long serialVersionUID = 8481971720570885610L;

	/*
	 * Atributo respons�vel por armazenar os dados referentes ao 
	 * cabe�alho da JTable. Ex: Colunas (String[] cabecalho) A B C D
	 */
	private String[ ] cabecalho;

	/*
	 * Atributo respons�vel por armazenar os dados referentes as 
	 * linhas da JTable. Ex: Linhas (ArrayList) 1 2 3. 
	 * Agora juntando o ArrayList(linhas) com ArrayList<String>(colunas) -->
	 * ArrayList<ArrayList<String>>: A B C D 1 2 3
	 */
	private ArrayList< ArrayList< String >> linhas = new ArrayList< ArrayList< String > >();

	public TableModelGenerica( String[ ] cabecalho ){
		this.cabecalho = cabecalho;
	}

	/**
	 * M�todo respons�vel por retornar o valor do atributo cabecalho.
	 * 
	 * @return String[] cabecalho - cabecalho a ser retornado(a).
	 */
	private final String[ ] getCabecalho() {
		if ( cabecalho == null ) {
			cabecalho = new String[ ] { "??????????" };
		}
		return cabecalho;
	}

	/**
	 * Retorna a quantidade de linhas que a tabela ter�
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	/**
	 * Retorna a quantidade de colunas que a JTable ter�.
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return getCabecalho().length;
	}

	/**
	 * M�todo padr�o utilizado pela JTable para a nomea��o das colunas(cabe�alho).
	 * 
	 * @return String - Nome da coluna referente ao parametro.
	 */
	@Override
	public String getColumnName( int coluna ) {
		return getCabecalho()[ coluna ];
	}

	/**
	 * M�todo padr�o utilizado para recuperar dados de uma determinada celula.
	 * 
	 * @param int linha - Linha onde est� o valor.
	 * @param int coluna - Coluna onde est� o valor.
	 * @return Object - Dado localizado na celula em questao.
	 * 
	 *         Polimorfico
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt( int linha, int coluna ) {
		// Pegando os dados contidos numa celula especifica.
		Object valorCelula = linhas.get( linha ).get( coluna );
		return valorCelula;
	}

	/**
	 * M�todo respons�vel por setar valores em determinadas celulas. Usado quando se altera o valor de alguma linha.
	 * 
	 * @param Object valor - Valor a ser adicionado na celula referente a linha e coluna informadas.
	 * @param int linha - Linha onde ser� adicionado o valor vindo como parametro.
	 * @param int coluna - Coluna onde ser� adicionado o valor vindo como parametro.
	 * 
	 *        Polimorfico
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt( Object valor, int linha, int coluna ) {
		// Setando o valor passado numa celula especifica.
		linhas.get( linha ).set( coluna, valor.toString() );

		// Confirmando a atualiza��o do dado da celula em quest�o.
		fireTableCellUpdated( linha, coluna );
	}

	// ************ INICIO DOS MEUS M�TODOS ************ \\

	/**
	 * M�todo respons�vel por adicionar linhas na tabela.
	 * 
	 * @param ArrayList<String> linhaASerAdicionada.
	 * 
	 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
	 * @since 05/09/2013 20:49:00
	 * @version 1.0
	 */
	public void addLinha( ArrayList< String > linha ) {
		// Adicionando uma linha na JTable
		linhas.add( linha );

		// Confirmando a inser��o da linha em quest�o.
		fireTableRowsInserted( linhas.size(), linhas.size() );
	}

	/**
	 * M�todo respons�vel por remover as linhas da tabela.
	 */
	public void limpar() {
		if ( getRowCount() > 0 ) {
			fireTableRowsDeleted( 0, getRowCount() );
			linhas.clear();
		}
	}
}