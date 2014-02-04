package ru.terra.terramarket.gui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.CommonDTO;

public abstract class AbstractEditDialog<Entity extends CommonDTO> extends Dialog {

	public AbstractEditDialog(Shell parent) {
		super(parent, SWT.SHELL_TRIM);
	}

	public abstract Entity getNew();

	public abstract Entity edit(Entity entity);

}
