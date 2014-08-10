package br.com.src.agendastruts.agenda.principal;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.src.agendastruts.agenda.contato.view.ContatoVIEW;

public class Sistema{

	public static void main( String[ ] args ) {

		try {
			UIManager.setLookAndFeel( "com.jtattoo.plaf.hifi.HiFiLookAndFeel" );
		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e ) {

			e.printStackTrace();
		}

		new ContatoVIEW().setVisible( true );
	}

}
