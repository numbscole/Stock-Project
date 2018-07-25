package windowBuilder;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProjectRunner{
	private static JTextField txtPressButtonAfter;
	private static JTextField textField_1;
	private static final ButtonGroup buttonGroup = new ButtonGroup();
	private static final ButtonGroup buttonGroupCompanies = new ButtonGroup();
	private static JTable table;
	private static ImageIcon myImage;

	
	
	public static void main(String[] args) {
		Data dat = new Data("./dow_jones_index.data");
		int toBroke = 0;

		
		JFrame frame = new JFrame("Project 2");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain, "name_489072209459833");
		panelMain.setLayout(null);
		panelMain.setVisible(true);
		
		
		
		JSlider slider = new JSlider();

		slider.setPaintTicks(true);
		slider.setBounds(465, 180, 277, 45);
		panelMain.add(slider);
				
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(634, 124, 108, 20);
		panelMain.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("$" + 100*slider.getValue());
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField_1.setText("$" + (100*slider.getValue()));
			}
		});		
		
		
		JPanel DetailsPanel = new JPanel();
		frame.getContentPane().add(DetailsPanel, "name_489080885496905");
		DetailsPanel.setVisible(false);
		
		JButton CompanyDetails = new JButton("Compay Stock Details");
		CompanyDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetailsPanel.setVisible(true);
				panelMain.setVisible(false);
			}
		});
		CompanyDetails.setBounds(10, 11, 187, 66);
		panelMain.add(CompanyDetails);
		

		

		
		JTextPane txtpnInputAmountTo = new JTextPane();
		txtpnInputAmountTo.setBackground(SystemColor.activeCaption);
		txtpnInputAmountTo.setText("Amount to Give to Broker:");
		txtpnInputAmountTo.setBounds(465, 110, 98, 45);
		panelMain.add(txtpnInputAmountTo);
		
		JRadioButton rdbtnB1 = new JRadioButton("Broker 1");
		rdbtnB1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		buttonGroup.add(rdbtnB1);
		rdbtnB1.setBounds(118, 123, 109, 23);
		panelMain.add(rdbtnB1);
		

		
		JRadioButton rdbtnB2 = new JRadioButton("Broker 2");
		rdbtnB2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		buttonGroup.add(rdbtnB2);
		rdbtnB2.setBounds(118, 187, 109, 23);
		panelMain.add(rdbtnB2);
		
		JRadioButton rdbtnB3 = new JRadioButton("Broker 3");
		rdbtnB3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		buttonGroup.add(rdbtnB3);
		rdbtnB3.setBounds(118, 251, 109, 23);
		panelMain.add(rdbtnB3);
		
		
		
		
		
		txtPressButtonAfter = new JTextField();
		txtPressButtonAfter.setHorizontalAlignment(SwingConstants.CENTER);
		txtPressButtonAfter.setText("Press Button after Choosing a Broker");
		txtPressButtonAfter.setBounds(27, 436, 246, 31);
		panelMain.add(txtPressButtonAfter);
		txtPressButtonAfter.setColumns(10);
		
		JButton btnBrokerSelector = new JButton("Button!");
		btnBrokerSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnB1.isSelected())
				{
					txtPressButtonAfter.setText(MyBroker(dat, 100*slider.getValue(), 1));
				}
				if(rdbtnB2.isSelected())
				{
					txtPressButtonAfter.setText(MyBroker(dat, 100*slider.getValue(), 2));
				}
				if(rdbtnB3.isSelected())
				{
					txtPressButtonAfter.setText(MyBroker(dat, 100*slider.getValue(), 3));
				}
				
			}
		});
		btnBrokerSelector.setBounds(73, 333, 154, 61);
		panelMain.add(btnBrokerSelector);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(404, 315, 442, 235);
		panelMain.add(imagePanel);
		DetailsPanel.setLayout(null);
		
		
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("../windowBuilder/TerriblePicture.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			imagePanel.add(picLabel);
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		imagePanel.setVisible(false);
		
		JCheckBox chckbxShowAnImage = new JCheckBox("Show An Image?");
		chckbxShowAnImage.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(chckbxShowAnImage.isSelected())
					imagePanel.setVisible(true);
				else
					imagePanel.setVisible(false);
			}
		});
		chckbxShowAnImage.setBounds(542, 285, 154, 23);
		panelMain.add(chckbxShowAnImage);
		
		
		
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Stock");
        model.addColumn("Week");
        model.addColumn("Open Price");
        model.addColumn("Close Price");
        
        JScrollPane js=new JScrollPane(table);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(77, 328, 754, 176);
        DetailsPanel.add(js);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(dat.getStockCount(), 1));  // company number of rows, 1 column
        for (int i = 0; i < dat.getStockCount(); i++) {
        	JRadioButton testerButt = new JRadioButton(dat.getStockName(i));
        	testerButt.setName(dat.getStockName(i));
        	panel.add(testerButt);
        	buttonGroupCompanies.add(testerButt);
        	testerButt.addChangeListener(new ChangeListener() {
        		public void stateChanged(ChangeEvent e) {
        			if(testerButt.isSelected()) {
        				int index = 0;

        				for (int k = 0; k < dat.getStockCount(); k++) {
        					if (testerButt.getName().equals(dat.getStockName(k)))
        						index = k;
        				}
        				model.setRowCount(0);
        				for (int j = 0; j < dat.getWeekCount(); j++) {
        					model.addRow(new Object[] { dat.getStockName(index), dat.getWeekDate(j),
        							"$" + dat.getStocksWeek(index, j).getOpen(),
        							"$" + dat.getStocksWeek(index, j).getClose() });
        				}
        			}
        		}
        	});
        }		


		
		JButton btnBDoneButton = new JButton("Done!");
		btnBDoneButton.setBounds(656, 252, 97, 37);
		btnBDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				buttonGroupCompanies.clearSelection();
				DetailsPanel.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		DetailsPanel.add(btnBDoneButton);

		
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 33, 171, 214);

        DetailsPanel.add(scrollPane);
		
		frame.setVisible(true);

	}
	public static String MyBroker(Data dat, int amount, int whoBrokes) {
		String toReturn = "";
		if (whoBrokes == 1) {
		BasicPredictor stockMan = new Broker(dat);
		stockMan.setPortfolioAmount(amount);
		stockMan.predict();
//		System.out.println("type 1 final amount $"+stockMan.getPortfolioAmount());
//		System.out.println("--------------------------------\n--------------------------------");
		toReturn = "" + stockMan.getPortfolioAmount();


		}
		if (whoBrokes == 2) {
		Broker1 stockerMan = new Broker1(dat);
		stockerMan.setPortfolioAmount(amount);
		stockerMan.predict();
//		System.out.println("type 2 final amount $"+stockerMan.getPortfolioAmount());
//		System.out.println("--------------------------------\n--------------------------------");
		toReturn = "" + stockerMan.getPortfolioAmount();


		}
		if(whoBrokes == 3) {
		Broker2 stockestMan = new Broker2(dat);
		stockestMan.setPortfolioAmount(amount);
		stockestMan.predict();
//		System.out.println("type 3 final amount $"+stockestMan.getPortfolioAmount());
//		System.out.println("--------------------------------\n--------------------------------");
		toReturn = "" + stockestMan.getPortfolioAmount();

		}
		
//		System.out.println(dat.getStockCount());
//		System.out.println(dat.getWeekCount());
//		System.out.println(dat.getStocksWeek(1, 1));
//		System.out.println(dat.getStockSymbol(2));
//		System.out.println(dat.getStockName(2));
//		System.out.println(dat.getWeekDate(3));		
		//System.out.println(stockMan.rankStocks(3));
		
		return toReturn;
	}
}
