
public class Viewcontrol extends UserInterface{

	public void catchInput() {
		
	   String name = textField.getText();
	   int weight = Integer.valueOf(textField_1.getText());
	
	   Keyword keyword = new Keyword(name,weight);
	   KeywordList Keywordlist = new KeywordList();
	   Keywordlist.addtolist(keyword);
	   
	}
	
	
	
	
	
	
	
}
