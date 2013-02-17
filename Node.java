import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Node {
	 private String tag;
	 private Map<String, String> parameters;
	 private ArrayList<Node> nodes = new ArrayList<Node>();
	 private ArrayList<String> values = new ArrayList<String>();
	 private Node node;

	 public Node(String tag){
		 this.tag = tag;
	 }
	 public String getTag(){
		 return tag;
	 }
	 public Node getNode(){
		 return node;
	 }
	 public Map<String, String> getParameters(){
		 return parameters;
	 }
	 public ArrayList<Node> getNodes(){
		 return nodes;
	 }
	 public void setNode(Node node){
		 this.node = node;
	 }
	 public ArrayList<String> getValues(){
		 return values;
	 }
	 public void addParametr(String command, String value){
		 parameters.put(command, value);
	 }
	 public void addNode(Node node){
		 nodes.add(node);
	 }
	 public void addValues(String values){
		 this.values.add(values);
	 }

}
