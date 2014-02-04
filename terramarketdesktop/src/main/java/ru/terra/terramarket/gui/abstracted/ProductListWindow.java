package ru.terra.terramarket.gui.abstracted;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.gui.swt.AbstractEditDialog;
import ru.terra.terramarket.gui.swt.AbstractListWindow;
import ru.terra.terramarket.gui.swt.product.ProductEditDialog;
import ru.terra.terramarket.network.RestClient;

public class ProductListWindow extends AbstractListWindow<ProductDTO> {

	public ProductListWindow(Display display) {
		super(display, "Управление товарами", "Добавить товар", CacheManager.getInstance().getCache(ProductsCache.class));
	}

	@Override
	protected AbstractEditDialog<ProductDTO> createEditDialog() {
		return new ProductEditDialog(getShell(), SWT.DIALOG_TRIM);
	}

	@Override
	protected String[] getTableRowText(ProductDTO entity) {
		return new String[] { entity.id.toString(), entity.name, entity.barcode };
	}

	@Override
	protected boolean createEntity(ProductDTO entity) {
		return new RestClient(this).createProduct(entity) != null;
	}

	@Override
	protected boolean updateEntity(ProductDTO entity) {
		return new RestClient(this).updateProduct(entity);
	}

	@Override
	protected void createTableColumns(Table table) {
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(52);
		tblclmnNewColumn.setText("№");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(223);
		tblclmnNewColumn_1.setText("Наименование");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Код");
	}

	@Override
	protected void createContents() {

	}

}
