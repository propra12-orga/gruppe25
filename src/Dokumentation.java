
import java.awt.Dimension;


import java.io.IOException;


import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;


import javax.swing.JScrollPane;


public class Dokumentation {
	
	
	public static void show(){
		

		
		 //Create an editor pane.
        JEditorPane editorPane = createEditorPane();
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
 
        //Create a text pane.
        JTextPane textPane = new JTextPane();
        JScrollPane paneScrollPane = new JScrollPane(textPane);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));
 
      
      
       
 
        JFrame frame = new JFrame("Dokumentation");
        frame.add(editorScrollPane);
        frame.pack();
        frame.setVisible(true);
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setResizable(false);
		
	}
	
	 public static JEditorPane createEditorPane() {
	        JEditorPane editorPane = new JEditorPane();
	        editorPane.setEditable(false);
	        java.net.URL helpURL = Dokumentation.class.getResource(
	                                        "dokumentation.html");
	        if (helpURL != null) {
	            try {
	                editorPane.setPage(helpURL);
	            } catch (IOException e) {
	                System.err.println("Attempted to read a bad URL: " + helpURL);
	            }
	        } else {
	            System.err.println("Couldn't find file: dokumentation.html");
	        }
	 
	        return editorPane;
	    }
	 
	
	   
}


