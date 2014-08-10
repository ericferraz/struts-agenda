package br.com.src.agendastruts.agenda.utilidades;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * Classe interna(inner class) responsável por gerenciar as ações realizadas na JTable.
 * Nesta classe estarão os metodos que por exemplo adicionará, removerá e atualizará
 * os dados da tabela.
 * 
 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
 * @since 04/09/2013 21:46:52
 * @version 1.0
 */
public class TableModelGenerica extends AbstractTableModel{

    private static final long serialVersionUID = 8481971720570885610L;

	/*
	 * Atributo responsável por armazenar os dados referentes ao 
	 * cabeçalho da JTable. Ex: Colunas (String[] cabecalho) A B C D
	 */
	private String[ ] cabecalho;

	/*
	 * Atributo responsável por armazenar os dados referentes as 
	 * linhas da JTable. Ex: Linhas (ArrayList) 1 2 3. 
	 * Agora juntando o ArrayList(linhas) com ArrayList<String>(colunas) -->
	 * ArrayList<ArrayList<String>>: A B C D 1 2 3
	 */
	private ArrayList< ArrayList< String >> linhas = new ArrayList< ArrayList< String > >();

	public TableModelGenerica( String[ ] cabecalho ){
		this.cabecalho = cabecalho;
	}

	/**
	 * Método responsável por retornar o valor do atributo cabecalho.
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
	 * Retorna a quantidade de linhas que a tabela terá
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return linhas.size();
	}

	/**
	 * Retorna a quantidade de colunas que a JTable terá.
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return getCabecalho().length;
	}

	/**
	 * Método padrão utilizado pela JTable para a nomeação das colunas(cabeçalho).
	 * 
	 * @return String - Nome da coluna referente ao parametro.
	 */
	@Override
	public String getColumnName( int coluna ) {
		return getCabecalho()[ coluna ];
	}

	/**
	 * Método padrão utilizado para recuperar dados de uma determinada celula.
	 * 
	 * @param int linha - Linha onde está o valor.
	 * @param int coluna - Coluna onde está o valor.
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
	 * Método responsável por setar valores em determinadas celulas. Usado quando se altera o valor de alguma linha.
	 * 
	 * @param Object valor - Valor a ser adicionado na celula referente a linha e coluna informadas.
	 * @param int linha - Linha onde será adicionado o valor vindo como parametro.
	 * @param int coluna - Coluna onde será adicionado o valor vindo como parametro.
	 * 
	 *        Polimorfico
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt( Object valor, int linha, int coluna ) {
		// Setando o valor passado numa celula especifica.
		linhas.get( linha ).set( coluna, valor.toString() );

		// Confirmando a atualização do dado da celula em questão.
		fireTableCellUpdated( linha, coluna );
	}

	// ************ INICIO DOS MEUS MÉTODOS ************ \\

	/**
	 * Método responsável por adicionar linhas na tabela.
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

		// Confirmando a inserção da linha em questão.
		fireTableRowsInserted( linhas.size(), linhas.size() );
	}

	/**
	 * Método responsável por remover as linhas da tabela.
	 */
	public void limpar() {
		if ( getRowCount() > 0 ) {
			fireTableRowsDeleted( 0, getRowCount() );
			linhas.clear();
		}
	}
}