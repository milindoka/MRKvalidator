package mrk;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class FirstDialog extends JDialog{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FirstDialog(){
        super();
        JPanel panel=new JPanel();
        panel.add(new JLabel("Hello dialog"));
        this.getContentPane().add(panel);
    }
    
    public FirstDialog(JFrame mf,String title,boolean modal){
        super(mf,title,modal);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        JPanel panel=new JPanel();
        panel.add(new JLabel("Hello dialog"));
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}
