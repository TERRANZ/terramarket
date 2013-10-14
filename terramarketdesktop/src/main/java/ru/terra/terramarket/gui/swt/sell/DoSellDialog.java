package ru.terra.terramarket.gui.swt.sell;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.core.Pair;
import ru.terra.terramarket.gui.swt.product.ProductSelectDialog;
import ru.terra.terramarket.network.RestClient;

public class DoSellDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table tblProducts;
	private Text txtProduct;
	private static final Integer COLUMN_COUNT = 2;
	private String[] productNumbers;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public DoSellDialog(Shell parent, int style) {
		super(parent, style);
		setText("Новая продажа");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
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
		shell.setSize(694, 489);
		shell.setText("Продажа");
		shell.setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);

		ToolItem tiReady = new ToolItem(toolBar, SWT.NONE);
		tiReady.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblProducts.getItemCount() > 0) {
					Integer[] products = new Integer[tblProducts.getItemCount()];
					Integer[] counts = new Integer[tblProducts.getItemCount()];
					int i = 0;
					for (TableItem ti : tblProducts.getItems()) {
						products[i] = (Integer) ti.getData();
						counts[i] = Integer.parseInt(ti.getText(2));
						i++;
					}
					new RestClient().doSell(products, counts);
				}
			}
		});
		tiReady.setImage(new Image(Display.getDefault(), this.getClass().getResourceAsStream("/drawable/ic_menu_save.png")));
		tiReady.setText("Готово");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("Товар");

		txtProduct = new Text(composite, SWT.BORDER);
		txtProduct.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnSelectProduct = new Button(composite, SWT.NONE);
		btnSelectProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pair<Integer, String> selectedProduct = new ProductSelectDialog(shell, SWT.DIALOG_TRIM).open();
				if (selectedProduct != null) {
					final TableItem item = new TableItem(tblProducts, SWT.NONE);
					item.setData(selectedProduct.getKey());
					item.setText(new String[] { String.valueOf(tblProducts.getItemCount()), selectedProduct.getValue(), "1" });
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
		btnSelectProduct.setText("Выбрать");

		tblProducts = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tblProducts.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tblProducts.setHeaderVisible(true);
		tblProducts.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(tblProducts, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("№");

		TableColumn tableColumn_1 = new TableColumn(tblProducts, SWT.NONE);
		tableColumn_1.setWidth(408);
		tableColumn_1.setText("Товар");

		TableColumn tableColumn_2 = new TableColumn(tblProducts, SWT.NONE);
		tableColumn_2.setWidth(113);
		tableColumn_2.setText("Количество");

		productNumbers = new String[ProductsCache.getInstance().size()];
		for (int i = 0; i < productNumbers.length; i++) {
			productNumbers[i] = ProductsCache.getInstance().getValues().get(i).barcode;
		}

		setAutoCompletion(txtProduct, null);
		txtProduct.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				setAutoCompletion(txtProduct, txtProduct.getText());
			}
		});
	}

	private String[] getAllProposals(String text) {
		String[] proposals = productNumbers;
		if (text == null || text.length() == 0)
			proposals = productNumbers;
		else {
			for (int i = 0; i < productNumbers.length; i++)
				proposals[i] = text + i;
		}
		return proposals;
	}

	private void setAutoCompletion(Text text, String value) {
		try {
			ContentProposalAdapter adapter = null;
			String[] defaultProposals = getAllProposals(value);
			SimpleContentProposalProvider scp = new SimpleContentProposalProvider(defaultProposals);
			scp.setProposals(defaultProposals);
			KeyStroke ks = KeyStroke.getInstance("Ctrl+Space");
			adapter = new ContentProposalAdapter(text, new TextContentAdapter(), scp, ks, null);
			adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
