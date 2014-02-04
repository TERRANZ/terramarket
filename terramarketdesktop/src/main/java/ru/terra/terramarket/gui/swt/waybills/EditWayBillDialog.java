package ru.terra.terramarket.gui.swt.waybills;

import java.util.Date;

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
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.cache.WayBillsCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.core.Pair;
import ru.terra.terramarket.gui.swt.product.ProductSelectDialog;

public class EditWayBillDialog extends Dialog {

	protected WayBillBean result;
	protected Shell shell;
	private ToolBar toolBar;
	private ToolItem tiReady;
	private Composite composite;
	private Composite composite_1;
	private Table tblProducts;
	private Label lblNewLabel;
	private Button btnAddProduct;
	private Text txtTitle;
	private Label lblNewLabel_1;
	private Text txtSupplier;
	private TableColumn tableColumn;
	private TableColumn tableColumn_1;
	private TableColumn tableColumn_2;
	private WayBillsCache wbc = (WayBillsCache) CacheManager.getInstance().getCache(WayBillsCache.class);
	private static final Integer COLUMN_COUNT = 2;
	private ProductsCache productsCache = (ProductsCache) CacheManager.getInstance().getCache(ProductsCache.class);

	public static class WayBillBean {
		public String title, supplier;
		public Integer[] products;
		public Integer[] counts;
		public Date date = new Date();
		public Integer id;

		public WayBillBean(String title, String supplier, Integer[] products, Integer[] counts, Integer id) {
			super();
			this.title = title;
			this.supplier = supplier;
			this.products = products;
			this.counts = counts;
			this.id = id;
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public EditWayBillDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public WayBillBean open(WayBillBean bean) {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		if (bean == null)
			newWB();
		else
			loadBean(bean);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void loadBean(WayBillBean bean) {
		result = new WayBillBean(bean.title, bean.supplier, bean.products, bean.counts, bean.id);
		txtTitle.setText(bean.title);
		txtSupplier.setText(bean.supplier);
		for (int i = 0; i < bean.counts.length; i++) {
			Pair<Integer, String> product = new Pair<Integer, String>(bean.products[i], productsCache.get(bean.products[i]).name);
			TableItem ti = new TableItem(tblProducts, SWT.NONE);
			ti.setText(new String[] { String.valueOf(i), product.getValue(), String.valueOf(bean.counts[i]) });
			ti.setData(product);
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM | SWT.BORDER);
		shell.setSize(836, 508);
		shell.setText("Накладные");
		shell.setLayout(new GridLayout(1, false));

		toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);

		tiReady = new ToolItem(toolBar, SWT.NONE);
		tiReady.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Integer[] products = new Integer[tblProducts.getItemCount()];
				Integer[] counts = new Integer[tblProducts.getItemCount()];
				int i = 0;
				for (TableItem item : tblProducts.getItems()) {
					Pair<Integer, String> prodInfo = (Pair<Integer, String>) item.getData();
					products[i] = prodInfo.getKey();
					counts[i] = Integer.parseInt(item.getText(COLUMN_COUNT));
					i++;
				}
				if (result == null)
					result = new WayBillBean(txtTitle.getText(), txtSupplier.getText(), products, counts, null);
				else {
					result.title = txtTitle.getText();
					result.supplier = txtSupplier.getText();
					result.products = products;
					result.counts = counts;
				}
				shell.close();
			}
		});
		tiReady.setText("Готово");

		composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.widthHint = 182;
		composite.setLayoutData(gd_composite);

		lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Наименование");

		txtTitle = new Text(composite, SWT.BORDER);
		txtTitle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Поставщик");

		txtSupplier = new Text(composite, SWT.BORDER);
		txtSupplier.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(1, false));

		btnAddProduct = new Button(composite_1, SWT.NONE);
		btnAddProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final TableItem item = new TableItem(tblProducts, SWT.NONE);
				item.setText(new String[] { String.valueOf(tblProducts.getItemCount()), "", "1" });
				Spinner newEditor = new Spinner(tblProducts, SWT.NONE);
				newEditor.setValues(Integer.parseInt(item.getText(COLUMN_COUNT)), 0, 9999, 0, 1, 10);
				final TableEditor editor = new TableEditor(tblProducts);
				// The editor must have the same size as the cell and must
				// not be any smaller than 50 pixels.
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
		});
		btnAddProduct.setText("Добавить продукт");

		tblProducts = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblProducts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblProducts.setHeaderVisible(true);
		tblProducts.setLinesVisible(true);

		tableColumn = new TableColumn(tblProducts, SWT.CENTER);
		tableColumn.setWidth(100);
		tableColumn.setText("№");

		tableColumn_1 = new TableColumn(tblProducts, SWT.CENTER);
		tableColumn_1.setWidth(561);
		tableColumn_1.setText("Товар");

		tableColumn_2 = new TableColumn(tblProducts, SWT.LEFT);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Кол-во");

//		String[] titles = { "№", "Наименование", "Кол-во" };
//		for (int i = 0; i < titles.length; i++) {
//			TableColumn column = new TableColumn(tblProducts, SWT.NONE);
//			column.setText(titles[i]);
//		}
//		for (int i = 0; i < titles.length; i++) {
//			tblProducts.getColumn(i).pack();
//		}
		tblProducts.addListener(SWT.MouseDoubleClick, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (tblProducts.getSelectionCount() > 0) {
					TableItem ti = tblProducts.getSelection()[0];
					Pair<Integer, String> selectedProduct = new ProductSelectDialog(shell, SWT.DIALOG_TRIM).open();
					if (selectedProduct != null) {
						ti.setData(selectedProduct);
						ti.setText(1, selectedProduct.getValue());
					}
				}
			}
		});
		tiReady.setImage(new Image(Display.getDefault(), this.getClass().getResourceAsStream("/drawable/ic_menu_save.png")));

	}

	public void newWB() {
		txtTitle.setText("Накладная  №" + wbc.size() + 1 + " от " + new Date().toString());
	}
}
