import java.awt.BorderLayout;

import javax.swing.JTextPane;


public class P extends JTextPane implements Tag{
	public P(){
		setEditable(false);
		setLayout(new BorderLayout());
	}
}
