package ru.terra.terramarket.gui.swt.store;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.StoreCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.core.Pair;
import ru.terra.terramarket.dto.store.StoreDTO;
import ru.terra.terramarket.gui.swt.product.ProductSelectDialog;
import ru.terra.terramarket.gui.swt.report.ReportStoreRemains;
import ru.terra.terramarket.network.RestClient;

public class StoreWindow extends Shell {
	protected static final int COLUMN_COUNT = 2;
	private Table tblProducts;
	private Map<Integer, TableItem> productsMap = new HashMap<Integer, TableItem>();

	public enum StoreState {
		OLD, NEW, UPD;
	}

	public class StoreBean {
		public Integer prodId = 0;
		public StoreState state = StoreState.OLD;
		public Integer count;

		public StoreBean(Integer prodId, StoreState state, Integer count) {
			super();
			this.prodId = prodId;
			this.state = state;
			this.count = count;
		}

	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public StoreWindow(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);

		ToolItem tiReport = new ToolItem(toolBar, SWT.NONE);
		tiReport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new ReportStoreRemains(getDisplay()).open();
			}
		});
		tiReport.setText("Отчёт по остаткам");
		ToolItem tiReady = new ToolItem(toolBar, SWT.NONE);
		tiReady.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblProducts.getItemCount() > 0) {
					RestClient restClient = new RestClient(StoreWindow.this);
					for (TableItem ti : tblProducts.getItems()) {
						StoreBean productHolder = (StoreBean) ti.getData();
						boolean ret = false;
						if (productHolder.state == StoreState.NEW)
							ret = restClient.storeAdd(productHolder.prodId, Integer.valueOf(ti.getText(2)));
						else if (productHolder.state == StoreState.UPD)
							ret = restClient.storeUpdate(productHolder.prodId, Integer.valueOf(ti.getText(2)));
						if (ret)
							((StoreCache) CacheManager.getInstance().getCache(StoreCache.class)).fill(getShell());	
						productHolder.state = StoreState.OLD;
					}
				}
			}
		});
		tiReady.setImage(new Image(Display.getDefault(), this.getClass().getResourceAsStream("/drawable/ic_menu_save.png")));
		tiReady.setText("Готово");
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Button btnAddProduct = new Button(composite, SWT.NONE);
		btnAddProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pair<Integer, String> selectedProduct = new ProductSelectDialog(getShell(), SWT.DIALOG_TRIM).open();
				if (selectedProduct != null) {
					TableItem item = null;
					StoreState state = StoreState.NEW;
					if (productsMap.containsKey(selectedProduct.getKey())) {
						item = productsMap.get(selectedProduct.getKey());
						state = StoreState.UPD;
					} else 
						item = new TableItem(tblProducts, SWT.NONE);					
					Date currDate = new Date();
					item.setData(new StoreBean(selectedProduct.getKey(), state, 1));
					item.setText(new String[] { selectedProduct.getValue(), currDate.toString(), "1" });
					Spinner newEditor = new Spinner(tblProducts, SWT.NONE);
					newEditor.setValues(Integer.parseInt(item.getText(COLUMN_COUNT)), 0, 9999, 0, 1, 10);
					final TableEditor editor = new TableEditor(tblProducts);
					editor.horizontalAlignment = SWT.LEFT;
					editor.grabHorizontal = true;
					editor.minimumWidth = 50;
					newEditor.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent me) {
							Spinner text = (Spinner) editor.getEditor();
							text.setMaximum(9999999);
							text.setMinimum(0);
							editor.getItem().setText(COLUMN_COUNT, text.getText());
						}
					});
					editor.setEditor(newEditor, item, COLUMN_COUNT);
				}
			}
		});
		btnAddProduct.setText("Добавить");

		tblProducts = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tblProducts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblProducts.setHeaderVisible(true);
		tblProducts.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(tblProducts, SWT.NONE);
		tableColumn.setWidth(484);
		tableColumn.setText("Товар");

		TableColumn tableColumn_1 = new TableColumn(tblProducts, SWT.NONE);
		tableColumn_1.setWidth(195);
		tableColumn_1.setText("Последнее обновление");

		TableColumn tableColumn_2 = new TableColumn(tblProducts, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Остаток");
		createContents();
		load();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Склад");
		setSize(834, 392);

	}

	@Override
	protected void checkSubclass() {
	}

	private void load() {
		for (StoreDTO storeDTO : ((StoreCache) CacheManager.getInstance().getCache(StoreCache.class)).getValues()) {
			TableItem item = new TableItem(tblProducts, SWT.NONE);
			item.setData(new StoreBean(storeDTO.product.id, StoreState.OLD, 1));
			item.setText(new String[] { storeDTO.product.name, storeDTO.updated.toString(), String.valueOf(storeDTO.count) });
			productsMap.put(storeDTO.product.id, item);
		}
	}
}
