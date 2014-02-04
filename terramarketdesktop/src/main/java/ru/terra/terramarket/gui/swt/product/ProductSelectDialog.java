package ru.terra.terramarket.gui.swt.product;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.core.Pair;
import ru.terra.terramarket.dto.product.ProductDTO;

public class ProductSelectDialog extends Dialog {

	protected Pair<Integer, String> result;
	protected Shell shell;
	private Table tblProducts;
	private Text txtSearch;
	private ProductsCache productsCache = (ProductsCache) CacheManager.getInstance().getCache(ProductsCache.class);

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public ProductSelectDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Pair<Integer, String> open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(550, 405);
		shell.setText("Выбор товара");
		shell.setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);

		ToolItem tiReady = new ToolItem(toolBar, SWT.NONE);
		tiReady.setText("Готово");
		tiReady.setImage(new Image(Display.getDefault(), this.getClass().getResourceAsStream("/drawable/ic_menu_save.png")));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setBounds(0, 0, 70, 16);
		lblNewLabel.setText("Поиск");

		txtSearch = new Text(composite, SWT.BORDER);
		txtSearch.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
			}
		});
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		tblProducts = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				ready();
			}
		});
		tblProducts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblProducts.setHeaderVisible(true);
		tblProducts.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(tblProducts, SWT.NONE);
		tblclmnNewColumn.setWidth(132);
		tblclmnNewColumn.setText("Идентификатор");

		TableColumn tblclmnNewColumn_1 = new TableColumn(tblProducts, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Товар");

		for (ProductDTO product : productsCache.getValues()) {
			TableItem ti = new TableItem(tblProducts, SWT.NONE);
			ti.setText(new String[] { product.id.toString(), product.name });
		}
	}

	public void ready() {
		if (tblProducts.getSelectionCount() > 0) {
			TableItem ti = tblProducts.getSelection()[0];
			result = new Pair<Integer, String>(Integer.parseInt(ti.getText(0)), ti.getText(1));
			shell.close();
		}
	}
}
