
public class Viewcontrol extends UserInterface{

	public void catchInput() {
		
	   String name = textField.getText();
	   int weight = Integer.valueOf(textField_1.getText());
	   int count=0;
	   
	   Keyword keyword = new Keyword(name, weight, count);
	   KeywordList Keywordlist = new KeywordList();
	   Keywordlist.addtolist(keyword);
	   
	}
	
	
	
	
	
	
	
}
