import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;


public class klasa {
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {


			public void run() {
				// TODO Auto-generated method stub


				JFrame frame = new JFrame();
				frame.setSize(1280, 1024);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setLayout(null);
				JTextPane t = new JTextPane();
				t.setEditable(false);
				t.setBounds(100, 55, 333, 333);
				JPanel jp = new JPanel();
				jp.setBounds(0, 0, 1280, 1024);
				int intValue = Integer.parseInt( "f0f0f2",16);
				Color aColor = new Color( intValue );
				jp.setBackground(aColor);
				JPanel jp2 = new JPanel();
				StringBuilder sb = new StringBuilder();
				sb.append("<h1>Example Domain\n</h1>");
				sb.append("This domain is established to be used for illustrative examples in documents. You do \n");
				sb.append("not need to coordinate or ask for permission to use this domain in examples, and it is  \n");
				sb.append("not available for registration.  \n");
				sb.append("<a href=http://mail.yahoo.com>yahoo mail</a>");
				jp2.setBackground(Color.WHITE);
				jp2.setBounds(340, 100, 600, 300);
				
				Button b = new Button();
				b.setBackground(Color.WHITE);
				t.setEditorKit(new HTMLEditorKit());
				t.addHyperlinkListener(new HyperlinkListener() {
				    public void hyperlinkUpdate(HyperlinkEvent e) {
				        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				           System.out.println("asd");
				        }
				    }
				});
				
				frame.add(jp);
				jp.add(jp2);
				jp2.setLayout(null);
				
				jp2.add(t);
				jp.setLayout(null);
				MutableAttributeSet attrs = t.getInputAttributes();
				
				int size = StyleConstants.getFontSize(attrs);

				
				StyleConstants.setFontSize(attrs, size * 2);

				//StyledDocument doc = t.getStyledDocument();
				//doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
			
				
				t.setText(sb.toString());
				jp2.add((Component) TagGenerator.generate("body"));




		

			}
		});
	}
}
