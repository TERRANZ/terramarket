package ru.terra.terramarket.gui.swt.report;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TableColumn;

import ru.terra.terramarket.cache.StoreCache;
import ru.terra.terramarket.dto.store.StoreDTO;

public class ReportStoreRemains extends Shell {
	private Table tblReport;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public ReportStoreRemains(Display display) {
		super(display, SWT.SHELL_TRIM);
		setText("Отчёт по остаткам");
		setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);

		ToolItem tiSave = new ToolItem(toolBar, SWT.NONE);
		tiSave.setText("Сохранить");

		tblReport = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblReport.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblReport.setHeaderVisible(true);
		tblReport.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(tblReport, SWT.LEFT);
		tableColumn.setWidth(464);
		tableColumn.setText("Товар");

		TableColumn tableColumn_1 = new TableColumn(tblReport, SWT.NONE);
		tableColumn_1.setWidth(177);
		tableColumn_1.setText("Минимальное");

		TableColumn tableColumn_2 = new TableColumn(tblReport, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Текущее");
		createContents();
		load();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setSize(800, 600);

	}

	@Override
	protected void checkSubclass() {
	}

	public void load() {
		for (StoreDTO store : StoreCache.getInstance().getValues()) {
			if (store.count <= store.product.mincount) {
				TableItem ti = new TableItem(tblReport, SWT.NONE);
				ti.setText(new String[] { store.product.name, store.product.mincount.toString(), store.count.toString() });
			}
		}
	}
}
