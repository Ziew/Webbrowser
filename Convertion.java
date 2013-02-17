
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Convertion {
	public String convertTag(String tag){
		String tagName = new String();
		Matcher d = Pattern.compile("^<\\w*?\\s|^</\\w*?>|<\\w*?>").matcher(tag);
		while(d.find()){
			Matcher f = Pattern.compile("[^<].*[^>]|\\w").matcher(d.group());
			while(f.find()){
				tagName = f.group();
				Matcher b = Pattern.compile("\\S*[^\\s]" ).matcher(tagName);
				while(b.find()){
					tagName = b.group();
				}
			}
		}
		return tagName;
	}
	public void convertTag(String tag, Node node){
		Matcher a = Pattern.compile("\\s.*?=\".*?\"", Pattern.DOTALL| Pattern.MULTILINE).matcher(tag);
		while(a.find()){
			Matcher f = Pattern.compile("\\s.*=|\".*?\"",Pattern.DOTALL| Pattern.MULTILINE).matcher(a.group());
			while(f.find()){
				String command = f.group();
				f.find();
				String value = f.group();
				node.addParametr(command, value);
			}
		}
	}

	public Node convertToNode(String source) throws IOException{
		Node node = new Node("The Main Node");
		HashMap<Integer,String> value = convertToValue(source);
		Matcher m = Pattern.compile("<.*?>",Pattern.DOTALL).matcher(source);

		while(m.find()){
			while((m.group().matches(".*/>$"))){
				m.find();
			}
			
			String tagName = convertTag(m.group());
			
			if(!tagName.matches("^/.*")){
				
				
				node.addNode(new Node(tagName));
				node.getNodes().get(node.getNodes().size()-1).setNode(node);
				node = node.getNodes().get(node.getNodes().size()-1);
				if(!(value.get(m.end())== null)){
					node.addValues(value.get(m.end()));
				}
			}
			else{
				node = node.getNode();
				if(!(value.get(m.end())== null)){
					node.addValues(value.get(m.end()));
				}
			}
		}
		return node;
	}


	public HashMap<Integer,String> convertToValue(String source){
		HashMap<Integer,String> value = new HashMap<Integer, String>();
		Matcher m = Pattern.compile(">.*?<" ,Pattern.DOTALL| Pattern.MULTILINE).matcher(source);
		while(m.find()){
			Matcher d = Pattern.compile("[^>]\\S+.*[^<]" ,Pattern.DOTALL| Pattern.MULTILINE).matcher(m.group());
			while(d.find()){
				value.put(m.start() + 1, d.group());
			}
		}
		return value;
	}

}
