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
	    this.setTitle( "Roll Number Details..." );
	    this.setLocationRelativeTo( null );
	    this.setModal( true );
	    this.setResizable( false );
	    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	    this.getContentPane().setLayout( new BorderLayout() );

	    JTable shortcutKeysTable = getShortcutKeysTable();
	  //  this.add( shortcutKeysTable, BorderLayout.CENTER );
	    this.add( new JScrollPane(shortcutKeysTable), BorderLayout.CENTER );
       
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible( true );
	    
	  }
	  

	  private JTable getShortcutKeysTable() {
	    JTable shortcutKeysTable;

	    Object rowData[][] = { 
	    		              { "A", "1-42","ENG-ECO-ORC-BKE-SEP-MAR" }, 
	    		              { "A", "44-62","ENG-ECO-ORC-BKE-SEP-HIN" }, 
	    		              { "A", "63-101","ENG-ECO-ORC-BKE-MAT-MAR" },
	    		              { "A", "102-120","ENG-ECO-ORC-BKE-MAT-HIN" },
	    		              
	                         };
	    Object columnNames[] = { "DIV", "ROLL","SUBJETS" };

	    shortcutKeysTable = new JTable(rowData, columnNames);


	 //   this.add(scrollPane, BorderLayout.CENTER);
	    this.setSize(300, 150);
	    
	    return shortcutKeysTable;
	  }

	}