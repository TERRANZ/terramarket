package ru.terra.terramarket.gui.swt.product;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import ru.terra.terramarket.cache.GroupCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.gui.swt.AbstractEditDialog;

public class ProductEditDialog extends AbstractEditDialog<ProductDTO> {

	protected ProductDTO result;
	protected Shell shell;
	private Text txtName;
	private Text txtBarcode;
	private Text txtQtype;
	private Combo txtGroup;
	private Spinner spMincount;
	private Spinner spPriceIn;
	private Spinner spPriceOut;
	private String[] groups;
	private GroupCache groupCache = (GroupCache) CacheManager.getInstance().getCache(GroupCache.class);

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public ProductEditDialog(Shell parent, int style) {
		super(parent);
		setText("Товар");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public ProductDTO open(ProductDTO dto) {
		createContents();
		if (dto != null) {
			result = new ProductDTO(dto);
			load();
		}

		else
			result = new ProductDTO();
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

	private void load() {
		txtName.setText(result.name);
		txtBarcode.setText(result.barcode != null ? result.barcode : "");
		txtGroup.setText(result.group.name);
		txtGroup.setData(result.group.id);
		txtQtype.setText(result.qtype.toString());
		spMincount.setSelection(result.mincount);
		spPriceIn.setSelection(result.priceIn);
		spPriceOut.setSelection(result.priceOut);
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(566, 337);
		shell.setText(getText());
		shell.setLayout(new GridLayout(1, false));

		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		ToolItem tiReady = new ToolItem(toolBar, SWT.NONE);
		tiReady.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (txtGroup.getSelectionIndex() == -1) {
					MessageDialog.openError(shell, "Ошибка сохранения", "Не выбрана группа товара");
					return;
				}
				result.name = txtName.getText();
				result.barcode = txtBarcode.getText();

				result.group = groupCache.getValues().get(txtGroup.getSelectionIndex());
				result.qtype = 0;// TODO
				result.mincount = spMincount.getSelection();
				result.priceIn = spPriceIn.getSelection();
				result.priceOut = spPriceOut.getSelection();
				shell.close();
			}
		});
		tiReady.setImage(new Image(Display.getDefault(), this.getClass().getResourceAsStream("/drawable/ic_menu_save.png")));
		tiReady.setText("Готово");

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite.setBounds(0, 0, 64, 64);
		composite.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(composite, SWT.CENTER);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Наименование");

		txtName = new Text(composite, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = new Label(composite, SWT.CENTER);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Код");

		txtBarcode = new Text(composite, SWT.BORDER);
		txtBarcode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("Ед. измерения");

		txtQtype = new Text(composite, SWT.BORDER);
		txtQtype.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("Минимальное кол-во");

		spMincount = new Spinner(composite, SWT.BORDER);
		spMincount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		spMincount.setMaximum(9999999);
		spMincount.setMinimum(1);

		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("Цена приход");

		spPriceIn = new Spinner(composite, SWT.BORDER);
		spPriceIn.setMaximum(9999999);
		spPriceIn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setAlignment(SWT.CENTER);
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_5.setText("Цена расход");

		spPriceOut = new Spinner(composite, SWT.BORDER);
		spPriceOut.setMaximum(9999999);
		spPriceOut.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setAlignment(SWT.CENTER);
		lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("Группа");

		groups = new String[groupCache.size()];
		for (int i = 0; i < groups.length; i++) {
			groups[i] = groupCache.getValues().get(i).name;
		}

		txtGroup = new Combo(composite, SWT.BORDER);
		txtGroup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("selected " + txtGroup.getItem(txtGroup.getSelectionIndex()) + " is in cache: "
						+ groupCache.getValues().get(txtGroup.getSelectionIndex()).name);
			}
		});
		txtGroup.setItems(groups);
		txtGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	@Override
	public ProductDTO getNew() {
		return open(null);
	}

	@Override
	public ProductDTO edit(ProductDTO entity) {
		return open(entity);
	}
}
