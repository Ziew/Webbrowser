import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;


public class Body extends JPanel implements Tag{
	
	public Body(){
		setVisible(true);
		setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width, screenSize.height);
		
		setBackground(Color.WHITE);
	}
	public Body(String bgcolor){
		int intValue = Integer.parseInt( bgcolor,16);
		Color c = new Color( intValue );
		setBackground(c);
	}

}
