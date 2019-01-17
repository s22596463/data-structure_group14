import java.io.IOException;
import java.util.ArrayList;

public class WebTree {
 
 public WebNode root;
 
 public WebTree (WebPage rootPage) {
  this.root = new WebNode(rootPage);
 }
 
 public int setPostOrderScore(String keyword) throws IOException {
  setPostOrderScore(root, keyword);
  return root.setNodeScore(keyword);
 }
 
 private void setPostOrderScore(WebNode startNode, String keyword) throws IOException {
  for(WebNode child : startNode.children) {
   setPostOrderScore(child, keyword);
  }
 // System.out.println("here");
 startNode.setNodeScore(keyword);
 }
}
