package creatingGUI;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ProjectFrame extends JFrame {
	private ProjectPanel currentPanel;
	private JRadioButton button1;
	private JRadioButton button2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtIsPressed;
	private JTextField txtIsPressed_1;
	
	public ProjectFrame() {		
		currentPanel = new ProjectPanel();
		SpringLayout springLayout = (SpringLayout) currentPanel.getLayout();
		
		

			
		JRadioButton button1 = new JRadioButton("Button1");
		buttonGroup_1.add(button1);
		springLayout.putConstraint(SpringLayout.NORTH, button1, 71, SpringLayout.NORTH, currentPanel);
		springLayout.putConstraint(SpringLayout.WEST, button1, 70, SpringLayout.WEST, currentPanel);
		currentPanel.add(button1);
		
		JRadioButton button2 = new JRadioButton("Button2");
		buttonGroup_1.add(button2);
		springLayout.putConstraint(SpringLayout.WEST, button2, 15, SpringLayout.EAST, button1);
		springLayout.putConstraint(SpringLayout.SOUTH, button2, 0, SpringLayout.SOUTH, button1);
		currentPanel.add(button2);
		
		txtIsPressed = new JTextField();
		txtIsPressed.setText("1 is pressed");
		springLayout.putConstraint(SpringLayout.SOUTH, txtIsPressed, -45, SpringLayout.SOUTH, currentPanel);
		springLayout.putConstraint(SpringLayout.EAST, txtIsPressed, 0, SpringLayout.EAST, button1);
		currentPanel.add(txtIsPressed);
		txtIsPressed.setColumns(10);
		
		txtIsPressed_1 = new JTextField();
		txtIsPressed_1.setText("2 is pressed");
		springLayout.putConstraint(SpringLayout.NORTH, txtIsPressed_1, 0, SpringLayout.NORTH, txtIsPressed);
		springLayout.putConstraint(SpringLayout.EAST, txtIsPressed_1, -71, SpringLayout.EAST, currentPanel);
		currentPanel.add(txtIsPressed_1);
		txtIsPressed_1.setColumns(10);
		

		setupFrame();
	}
	
	private void setupFrame() {
		this.setContentPane(currentPanel);

	}
	
	public void start() {
		this.setSize(500,500);
		this.setVisible(true);
	}
}
