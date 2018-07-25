package creatingGUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import java.awt.Color;

public class ProjectPanel extends JPanel 
{
	private JButton testButton;
	private JTextArea testTextArea;
	private SpringLayout currentLayout;
	
	public ProjectPanel() {
		setBackground(new Color(0, 153, 102));
		
		testButton = new JButton("Click Here");
		testTextArea = new JTextArea();
		currentLayout = new SpringLayout();

		setupPanel();
	}
	
	private void setupPanel() {
		this.setLayout(currentLayout);
		this.add(testButton);
		this.add(testTextArea);
		
		currentLayout.putConstraint(SpringLayout.WEST, testButton, 184, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, testButton, -81, SpringLayout.SOUTH, this);
		
	}

}
