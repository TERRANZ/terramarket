package ru.terra.terramarket.gui.swt;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Created with IntelliJ IDEA.
 * User: terranz
 * Date: 29.11.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class ErrorReportDialog extends Dialog {

    public ErrorReportDialog(Shell shell, int i) {
        super(shell, i);
    }

    public void open(Exception e) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
