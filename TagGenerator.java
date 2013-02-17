
public class TagGenerator {
	public static Tag generate(String tag){
		Tag tags = null;
		switch(tag){
		case "body" : tags = new Body(); break; 
		case "p" : tags = new P(); break;
		case "div" : tags = new Div(); break;
		case "head" : tags = new Head(); break;
		case "a" : tags = new A(); break;
		case "html" : tags = new Html(); break;
		}
		return tags;
	}
}
