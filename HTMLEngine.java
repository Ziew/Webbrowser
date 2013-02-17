import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class HTMLEngine extends JFrame{

	public void start(final JFrame f){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLayout(null);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				f.setBounds(0,0,screenSize.width, screenSize.height);
				f.setVisible(true);
			}});

	}


	public Node sourceToNode(String source){
		try {
			StringBuffer b = new StringBuffer();
			URL myURL = new URL(source);
			Scanner scanner = new Scanner(myURL.openStream(), "utf-8");
			while(scanner.hasNextLine()){
				b.append(scanner.nextLine());
			}
			Convertion c = new Convertion();
			return c.convertToNode(b.toString());
		} 
		catch (MalformedURLException e) { 
		} 
		catch (IOException e) {   
		}
		return null;
	}

	public void TreeConvertion(Node node){
		int i = 0;
		boolean end = true;
		Node n = node;
		while(end){

			if(n.getNodes().size() > 0){
				n = n.getNodes().get(0);
				PageBuilding(n);
			}
			else{
				if(n.getNode()== null){
					end = false;
				}
				else{
					n = n.getNode();
					n.getNodes().remove(0);
				}
			}
		}
		start(this);
	}

	public void PageBuilding(Node n){
		
		if(n.getTag().equals("body")){
			add((Body)TagGenerator.generate(n.getTag()));
		}

	}
	public static void main(String[] args){
		HTMLEngine a = new HTMLEngine();
		a.TreeConvertion(a.sourceToNode("http://example.com/"));

	}

}
