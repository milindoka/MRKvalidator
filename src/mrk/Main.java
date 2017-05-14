package mrk;


import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

public class Main
{
    public static void main(String[] args) 
    {  
    	
    	///////////////////////All caps - KeyBoard Event Dispatcher ////////////
    /*	Works but sometime crashes at : table.getCellEditor().stopCellEditing();
       in RollSubDialog
    */	
    	  KeyboardFocusManager.getCurrentKeyboardFocusManager()
          .addKeyEventDispatcher(new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
              // This example converts all typed keys to upper
              // case
              if (e.getID() == KeyEvent.KEY_TYPED) {
                e.setKeyChar(Character.toUpperCase(e
                    .getKeyChar()));
              }
              // If the key should not be dispatched to the
              // focused component, set discardEvent to true
              boolean discardEvent = false;
              return discardEvent;
            }
          });  	
    	 
    	/////////////////////////////////////KeyBoard Event Dispatcher //////////// 	  
    	  
    	  
        SwingUtilities.invokeLater(new Runnable()   
        {
            @Override
            public void run() {                                           
            	Model model = new Model(0);
            	View view = new View("-"); 
            	Controller controller = new Controller(model,view);
            	controller.LinkViewControls();
            }
        });  
    }
}