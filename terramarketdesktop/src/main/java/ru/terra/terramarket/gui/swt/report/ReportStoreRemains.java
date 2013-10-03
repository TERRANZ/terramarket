package ru.terra.terramarket.gui.swt.report;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;

public class ReportStoreRemains extends Shell {

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public ReportStoreRemains(Display display) {
		super(display, SWT.SHELL_TRIM);
		setText("Отчёт по остаткам");
		setLayout(new FillLayout(SWT.HORIZONTAL));

		//Browser bReport = new Browser(this, SWT.NONE);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(800, 600);

	}

	@Override
	protected void checkSubclass() {
	}
}
