package ru.terra.terramarket.gui.swt;

import javax.ws.rs.InternalServerErrorException;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.cache.WayBillsCache;
import ru.terra.terramarket.core.CacheManager;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.gui.abstracted.ProductListWindow;
import ru.terra.terramarket.gui.swt.group.GroupsWindow;
import ru.terra.terramarket.gui.swt.product.ProductEditDialog;
import ru.terra.terramarket.gui.swt.product.ProductsWindow;
import ru.terra.terramarket.gui.swt.sell.SellsWindow;
import ru.terra.terramarket.gui.swt.store.StoreWindow;
import ru.terra.terramarket.gui.swt.waybills.EditWayBillDialog;
import ru.terra.terramarket.gui.swt.waybills.EditWayBillDialog.WayBillBean;
import ru.terra.terramarket.gui.swt.waybills.WayBillsWindow;
import ru.terra.terramarket.network.RestClient;

public class MainWindow {
	private WayBillsCache wbc = (WayBillsCache) CacheManager.getInstance().getCache(WayBillsCache.class);

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		if (new LoginDialog(shell, SWT.DIALOG_TRIM).open()) {
			Logger.getLogger(MainWindow.class).info("logged in");
		} else {
			Logger.getLogger(MainWindow.class).info("NOT logged in");
			shell.close();
			System.exit(0);
		}
		shell.setSize(792, 497);
		shell.setText("Управление продажами");

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem mrSells = new MenuItem(menu, SWT.CASCADE);
		mrSells.setText("Продажи");

		Menu menu_2 = new Menu(mrSells);
		mrSells.setMenu(menu_2);

		MenuItem miSellsManage = new MenuItem(menu_2, SWT.NONE);
		miSellsManage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new SellsWindow(display).open();
			}
		});
		miSellsManage.setText("Ведение продаж...");

		MenuItem mrWB = new MenuItem(menu, SWT.CASCADE);
		mrWB.setText("Накладные");

		Menu menu_1 = new Menu(mrWB);
		mrWB.setMenu(menu_1);

		MenuItem miWBAdd = new MenuItem(menu_1, SWT.NONE);
		miWBAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WayBillBean wb = new EditWayBillDialog(shell, SWT.SHELL_TRIM).open(null);
				if (wb != null) {
					WayBillDTO newwb = new RestClient(shell).createWB(wb);
					if (newwb.errorCode == 0) {
						wbc.add(newwb.id, newwb);
					}
				}
			}
		});
		miWBAdd.setText("Добавить...");

		MenuItem miWBManage = new MenuItem(menu_1, SWT.NONE);
		miWBManage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new WayBillsWindow(display).open();
			}
		});
		miWBManage.setText("Управление...");

		MenuItem mrProducts = new MenuItem(menu, SWT.CASCADE);
		mrProducts.setText("Товары");

		Menu menu_4 = new Menu(mrProducts);
		mrProducts.setMenu(menu_4);

		MenuItem miAddProd = new MenuItem(menu_4, SWT.NONE);
		miAddProd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProductDTO newProd = new ProductEditDialog(shell, SWT.DIALOG_TRIM).open(null);
				if (newProd != null && newProd.filled())
					try {
						newProd = new RestClient(shell).createProduct(newProd);
					} catch (Exception ex) {
						if (ex instanceof InternalServerErrorException)
							MessageDialog.openError(shell, "Ошибка при сохранении товара", "Ошибка сервера");
						ex.printStackTrace();
					}
			}
		});
		miAddProd.setText("Добавить...");

		MenuItem miProductsManage = new MenuItem(menu_4, SWT.NONE);
		miProductsManage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//new ProductsWindow(display).open();
				new ProductListWindow(display).open();
			}
		});
		miProductsManage.setText("Управление...");

		MenuItem miGroupsManage = new MenuItem(menu_4, SWT.NONE);
		miGroupsManage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new GroupsWindow(display).open();
			}
		});
		miGroupsManage.setText("Группы...");
		
		MenuItem mrStore = new MenuItem(menu, SWT.CASCADE);
		mrStore.setText("Склад");
		
		Menu menu_5 = new Menu(mrStore);
		mrStore.setMenu(menu_5);
		
		MenuItem mntmNewItem = new MenuItem(menu_5, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new StoreWindow(display).open();
			}
		});
		mntmNewItem.setText("На склад...");

		Menu menu_3 = new Menu(shell);
		shell.setMenu(menu_3);
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				CacheManager.getInstance().fillCache(shell);
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
