package ru.terra.terramarket.gui.swt;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.terra.terramarket.core.ConfigConstants;
import ru.terra.terramarket.core.ConfigService;
import ru.terra.terramarket.network.LoginTask;

public class LoginDialog extends Dialog {

	protected Boolean result = false;
	protected Shell shell;
	private Text txtLogin;
	private Text txtPass;
	private Button button;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public LoginDialog(Shell parent, int style) {
		super(parent, style);
		setText("Вход в систему");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Boolean open() {
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
		shell.setSize(347, 124);
		shell.setText(getText());
		shell.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Имя пользователя");

		txtLogin = new Text(shell, SWT.BORDER);
		txtLogin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtLogin.setText(ConfigService.getInstance().getConfig(ConfigConstants.LOGIN, ""));

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Пароль");

		txtPass = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtPass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtPass.setText(ConfigService.getInstance().getConfig(ConfigConstants.PASS, ""));
		new Label(shell, SWT.NONE);

		button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ExecutorService executor = Executors.newFixedThreadPool(1);
				Future<Boolean> submit = executor.submit(new LoginTask(txtLogin.getText(), txtPass.getText()));
				try {
					result = submit.get();
					if (result) {
						ConfigService.getInstance().setConfig(ConfigConstants.LOGIN, txtLogin.getText());
						ConfigService.getInstance().setConfig(ConfigConstants.PASS, txtPass.getText());
						//MessageDialog.openInformation(shell, "Вход", "Вход успешен");
						shell.dispose();
					} else {
						MessageDialog.openInformation(shell, "Вход", "Вход не удался");
					}
				} catch (InterruptedException | ExecutionException e1) {
					e1.printStackTrace();
				}
				executor.shutdown();
			}
		});
		button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		button.setText("Вход");

	}

}
