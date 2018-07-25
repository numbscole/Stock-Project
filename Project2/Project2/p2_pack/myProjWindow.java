package p2_pack;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class myProjWindow {

	protected Shell shell;
	private MenuItem mntmJanuary;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			myProjWindow window = new myProjWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1199, 760);
		shell.setText("SWT Application");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(619, 25, 312, 32);
		
		Composite CompPanel = new Composite(shell, SWT.NONE);
		CompPanel.setBounds(0, 121, 1173, 600);
		
		Composite composite_1 = new Composite(CompPanel, SWT.NONE);
		composite_1.setBounds(0, 0, 245, 590);
		
		Composite DatePanel = new Composite(shell, SWT.NONE);
		DatePanel.setBounds(0, 121, 1173, 600);
		
		Composite composite_2 = new Composite(DatePanel, SWT.NONE);
		composite_2.setBounds(0, 0, 244, 600);
		
		Button CRButton = new Button(group, SWT.RADIO);
		CRButton.setBounds(187, 10, 90, 16);
		CRButton.setText("Company");
		
		Button DRButton = new Button(group, SWT.RADIO);
		DRButton.setBounds(10, 10, 90, 16);
		DRButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CompPanel.setVisible(false);
				DatePanel.setVisible(true);

			}
		});
		DRButton.setText("Date");
		
		CRButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CompPanel.setVisible(true);
				DatePanel.setVisible(false);
			}
		});

		
		Label lblTransactionsOrganizedBy = new Label(shell, SWT.NONE);
		lblTransactionsOrganizedBy.setBounds(426, 34, 155, 21);
		lblTransactionsOrganizedBy.setText("Transactions Organized By:");

		
		Label lblCompanies = new Label(composite_1, SWT.NONE);
		lblCompanies.setBounds(10, 10, 107, 24);
		lblCompanies.setText("Companies:");
		
		Group group_1 = new Group(composite_1, SWT.NONE);
		group_1.setBounds(7, 37, 96, 347);
		
		Button btnAa = new Button(group_1, SWT.RADIO);
		btnAa.setBounds(3, 15, 90, 16);
		btnAa.setText("AA");
		
		Button button = new Button(group_1, SWT.RADIO);
		button.setBounds(3, 74, 90, 16);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("AA");
		
		Button button_1 = new Button(group_1, SWT.RADIO);
		button_1.setBounds(3, 147, 90, 16);
		button_1.setText("BB");
		
		Button button_2 = new Button(group_1, SWT.RADIO);
		button_2.setBounds(3, 237, 90, 16);
		button_2.setText("AC");
		
		Button button_3 = new Button(group_1, SWT.RADIO);
		button_3.setBounds(3, 328, 90, 16);
		button_3.setText("BC");
		
		Button button_4 = new Button(group_1, SWT.RADIO);
		button_4.setBounds(3, 107, 90, 16);
		button_4.setText("CB");
		
		Label lblYear = new Label(composite_2, SWT.NONE);
		lblYear.setBounds(0, 0, 55, 15);
		lblYear.setText("Year, 2011");
		
		Menu menu_2 = new Menu(composite_2);
		composite_2.setMenu(menu_2);
		
		mntmJanuary = new MenuItem(menu_2, SWT.RADIO);
		mntmJanuary.setText("January");
		
		MenuItem mntmFebuary = new MenuItem(menu_2, SWT.RADIO);
		mntmFebuary.setText("Febuary");
		
		MenuItem mntmMarch = new MenuItem(menu_2, SWT.RADIO);
		mntmMarch.setText("March");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("New SubMenu");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmCharts = new MenuItem(menu_1, SWT.NONE);
		mntmCharts.setText("Charts");

		//J-combo box
		//
	}
}
