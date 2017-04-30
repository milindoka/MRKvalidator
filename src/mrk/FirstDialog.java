package mrk;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class FirstDialog extends JDialog {
	  public FirstDialog( JFrame parent ) {
	    super( parent );
	    this.setTitle( "Shortcut Keys of..." );
	    this.setLocationRelativeTo( null );
	    this.setModal( true );
	    this.setResizable( false );
	    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	    this.getContentPane().setLayout( new BorderLayout() );

	    JTable shortcutKeysTable = getShortcutKeysTable();
	  //  this.add( shortcutKeysTable, BorderLayout.CENTER );
	    this.add( new JScrollPane(shortcutKeysTable), BorderLayout.CENTER );

	    this.pack();
	    this.setVisible( true );
	  }

	  private JTable getShortcutKeysTable() {
	    JTable shortcutKeysTable;

	    Object rowData[][] = { { "1", "11" }, { "2", "22"} };
	    Object columnNames[] = { "Column One", "Column Two" };

	    shortcutKeysTable = new JTable(rowData, columnNames);


	 //   this.add(scrollPane, BorderLayout.CENTER);
	    this.setSize(300, 150);

	    return shortcutKeysTable;
	  }

	}