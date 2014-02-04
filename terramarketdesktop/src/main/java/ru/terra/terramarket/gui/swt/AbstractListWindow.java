package ru.terra.terramarket.gui.swt;

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

import ru.terra.terramarket.cache.AbstractCache;
import ru.terra.terramarket.cache.WayBillsCache;
import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.gui.swt.waybills.EditWayBillDialog.WayBillBean;
import ru.terra.terramarket.network.RestClient;

public abstract class AbstractListWindow<Entity extends CommonDTO> extends Shell {
	protected Table table;
	private Boolean isEdited = false;
	protected AbstractCache<Entity> cache;

	protected abstract AbstractEditDialog<Entity> createEditDialog();

	protected abstract String[] getTableRowText(Entity entity);

	protected abstract boolean createEntity(Entity entity);

	protected abstract boolean updateEntity(Entity entity);

	protected abstract void createTableColumns(Table table);

	private class NewEntitySelectionAdapter extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			Entity newEntity = createEditDialog().getNew();
			if (newEntity != null) {
				TableItem ti = new TableItem(table, SWT.NONE);
				ti.setData(newEntity);
				ti.setText(getTableRowText(newEntity));
				if (createEntity(newEntity))
					load();
			}

		}
	}

	public AbstractListWindow(final Display display, String title, String newText,AbstractCache<Entity> cache) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));
		this.cache = cache;

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);

		ToolItem tiNewEntity = new ToolItem(toolBar, SWT.NONE);
		tiNewEntity.addSelectionListener(new NewEntitySelectionAdapter());
		// WayBillBean wb = new EditWayBillDialog(WayBillsWindow.this,
		// SWT.SHELL_TRIM).open(null);
		// if (wb != null) {
		// TableItem ti = new TableItem(table, SWT.NONE);
		// ti.setData(wb);
		// ti.setText(new String[] { wb.date.toString(), wb.title });
		// WayBillDTO newwb = new
		// RestClient(WayBillsWindow.this).createWB(wb);
		// if (newwb.errorCode == 0) {
		// wbc.add(newwb.id, newwb);
		// load();
		// }
		// }

		setText(title);
		tiNewEntity.setText(newText);

		ToolItem tiSeparator = new ToolItem(toolBar, SWT.SEPARATOR);

		ToolItem tiExit = new ToolItem(toolBar, SWT.NONE);
		tiExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (isEdited) {
					if (MessageDialog.openQuestion(AbstractListWindow.this, "Сохранить", "Не сохранены изменения")) {
						save();
						close();
					}
				} else {
					close();
				}
			}
		});
		tiExit.setText("Закрыть");

		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		// tableColumn.setWidth(100);
		// tableColumn.setText("Дата");
		//
		// TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		// tableColumn_1.setWidth(100);
		// tableColumn_1.setText("Накладная");
		setSize(600, 800);
		createTableColumns(table);
		createContents();

		table.addMouseListener(new EditTableItemAdapter());
		load();
	}

	private class EditTableItemAdapter extends MouseAdapter {
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			if (table.getSelectionCount() > 0) {
				TableItem ti = table.getSelection()[0];
				Entity oldEntity = (Entity) ti.getData();
				Entity entity = createEditDialog().edit(oldEntity);
				if (entity != null) {
					ti.setData(entity);
					ti.setText(getTableRowText(entity));
					updateEntity(entity);
					// try {
					// new RestClient().updateWayBill(wb, oldWb);
					// } catch (ClientException ce) {
					// ce.printStackTrace();
					// }
				}
			}
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected abstract void createContents();

	@Override
	protected void checkSubclass() {
	}

	private void save() {
	}

	private void load() {
		table.removeAll();
		for (Entity entity : cache.getValues()) {
			TableItem ti = new TableItem(table, SWT.NONE);
			ti.setData(entity);
			ti.setText(getTableRowText(entity));
		}
		// for (WayBillDTO wb : wbc.getValues()) {
		// Integer[] products = new Integer[wb.waybillItems.size()];
		// Integer[] counts = new Integer[wb.waybillItems.size()];
		// for (int i = 0; i < products.length; i++) {
		// products[i] = wb.waybillItems.get(i).product.id;
		// counts[i] = wb.waybillItems.get(i).count;
		// }
		// WayBillBean bean = new WayBillBean(wb.title, wb.supplier, products,
		// counts, wb.id);
		// TableItem ti = new TableItem(table, SWT.NONE);
		// ti.setText(new String[] { bean.date.toString(), bean.title });
		// ti.setData(bean);
		// }
	}
}
