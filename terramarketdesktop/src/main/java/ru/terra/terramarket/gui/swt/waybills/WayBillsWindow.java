package ru.terra.terramarket.gui.swt.waybills;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.WayBillsCache;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.gui.swt.waybills.EditWayBillDialog.WayBillBean;
import ru.terra.terramarket.network.RestClient;

public class WayBillsWindow extends Shell {
	private Table tblWBs;
	private Boolean isEdited = false;
	private WayBillsCache wbc = WayBillsCache.getInstance();	

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public WayBillsWindow(final Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);

		ToolItem tiNewWB = new ToolItem(toolBar, SWT.NONE);
		tiNewWB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WayBillBean wb = new EditWayBillDialog(WayBillsWindow.this, SWT.SHELL_TRIM).open(null);
				if (wb != null) {
					TableItem ti = new TableItem(tblWBs, SWT.NONE);
					ti.setData(wb);
					ti.setText(new String[] { wb.date.toString(), wb.title });
					WayBillDTO newwb = new RestClient(WayBillsWindow.this).createWB(wb);
					if (newwb.errorCode == 0) {
						wbc.add(newwb.id, newwb);
						load();
					}
				}
			}
		});
		tiNewWB.setText("Новая накладная");

		ToolItem tiSeparator = new ToolItem(toolBar, SWT.SEPARATOR);

		ToolItem tiExit = new ToolItem(toolBar, SWT.NONE);
		tiExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (isEdited) {
					if (MessageDialog.openQuestion(WayBillsWindow.this, "Сохранить", "Не сохранены изменения")) {
						save();
						close();
					}
				} else {
					close();
				}
			}
		});
		tiExit.setText("Закрыть");

		tblWBs = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblWBs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblWBs.setHeaderVisible(true);
		tblWBs.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(tblWBs, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Дата");

		TableColumn tableColumn_1 = new TableColumn(tblWBs, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Накладная");
		createContents();

		tblWBs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (tblWBs.getSelectionCount() > 0) {
					TableItem ti = tblWBs.getSelection()[0];
					WayBillBean oldWb = (WayBillBean) ti.getData();
					WayBillBean wb = new EditWayBillDialog(WayBillsWindow.this, SWT.SHELL_TRIM).open(oldWb);
					if (wb != null) {
						ti.setData(wb);
						ti.setText(new String[] { wb.date.toString(), wb.title });
//						try {
//							new RestClient().updateWayBill(wb, oldWb);
//						} catch (ClientException ce) {
//							ce.printStackTrace();
//						}
					}
				}
			}
		});
		load();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Управление накладными");
		setSize(682, 435);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private void save() {
	}

	private void load() {
		tblWBs.removeAll();
		for (WayBillDTO wb : wbc.getValues()) {
			Integer[] products = new Integer[wb.waybillItems.size()];
			Integer[] counts = new Integer[wb.waybillItems.size()];
			for (int i = 0; i < products.length; i++) {
				products[i] = wb.waybillItems.get(i).product.id;
				counts[i] = wb.waybillItems.get(i).count;
			}
			WayBillBean bean = new WayBillBean(wb.title, wb.supplier, products, counts, wb.id);
			TableItem ti = new TableItem(tblWBs, SWT.NONE);
			ti.setText(new String[] { bean.date.toString(), bean.title });
			ti.setData(bean);
		}
	}
}
