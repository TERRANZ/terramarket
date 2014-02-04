package ru.terra.terramarket.gui.swt.product;

import java.util.HashMap;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import ru.terra.terramarket.cache.GroupCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.gui.swt.group.GroupsWindow;
import ru.terra.terramarket.network.RestClient;

public class ProductsWindow extends Shell {
	private Table tblProducts;
	private Tree trGroups;
	private GroupCache groupCache = (GroupCache) CacheManager.getInstance().getCache(GroupCache.class);
	private GroupDTO currGroup;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public ProductsWindow(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);

		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new GroupsWindow(getDisplay()).open();
			}
		});
		tltmNewItem.setText("Группы");

		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProductDTO newProd = new ProductEditDialog(getShell(), SWT.DIALOG_TRIM).open(null);
				if (newProd != null && newProd.group != null)
					newProd = new RestClient(ProductsWindow.this).createProduct(newProd);
			}
		});
		tltmNewItem_1.setText("Добавить товар");

		Composite composite = new Composite(this, SWT.BORDER);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		FillLayout fl_composite = new FillLayout(SWT.HORIZONTAL);
		fl_composite.spacing = 2;
		composite.setLayout(fl_composite);

		trGroups = new Tree(composite, SWT.BORDER);
		trGroups.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Logger.getLogger(ProductsWindow.class).info("Selected tree item");
				if (trGroups.getSelection().length > 0) {
					currGroup = (GroupDTO) trGroups.getSelection()[0].getData();
					loadGroup(currGroup);
				}
			}
		});

		tblProducts = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tblProducts.setHeaderVisible(true);
		tblProducts.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(tblProducts, SWT.NONE);
		tblclmnNewColumn.setWidth(52);
		tblclmnNewColumn.setText("№");

		TableColumn tblclmnNewColumn_1 = new TableColumn(tblProducts, SWT.NONE);
		tblclmnNewColumn_1.setWidth(223);
		tblclmnNewColumn_1.setText("Наименование");

		TableColumn tblclmnNewColumn_2 = new TableColumn(tblProducts, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Код");
		createContents();
		load();
		tblProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				editProduct();
			}
		});
	}

	protected void editProduct() {
		if (tblProducts.getSelection().length > 0) {
			TableItem currItem = tblProducts.getSelection()[0];
			ProductDTO product = (ProductDTO) currItem.getData();
			ProductDTO newProd = new ProductEditDialog(getShell(), SWT.DIALOG_TRIM).open(product);
			new RestClient(ProductsWindow.this).updateProduct(newProd);
			if (newProd != null && newProd.errorCode == 0) {
				currItem.setData(newProd);
				currItem.setText(new String[] { newProd.id.toString(), newProd.name, newProd.barcode });
				loadGroup(currGroup);
			} else {
				MessageDialog.openError(getShell(), "Ошибка при созднии товара", newProd.errorMessage);
			}
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Управление товарами");
		setSize(817, 749);

	}

	@Override
	protected void checkSubclass() {
	}

	private void load() {
		HashMap<Integer, TreeItem> blockMap = new HashMap<Integer, TreeItem>();
		for (GroupDTO g : groupCache.getValues()) {
			TreeItem newItem;

			TreeItem parentItem = blockMap.get(g.parent);
			if (parentItem != null) {
				newItem = new TreeItem(parentItem, 0);
			} else {
				newItem = new TreeItem(trGroups, 0);
			}

			newItem.setText(g.name);
			newItem.setData(g);
			blockMap.put(g.id, newItem);
		}
	}

	private void loadGroup(GroupDTO group) {
		tblProducts.clearAll();
		tblProducts.removeAll();
		for (ProductDTO product : group.productList) {
			TableItem ti = new TableItem(tblProducts, SWT.NONE);
			ti.setText(new String[] { product.id.toString(), product.name, product.barcode });
			ti.setData(product);
		}
	}
}
