import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Data {
    String login = "fominaelena";
    String email1 = "efomina@company.ru";
    String spaceEmail = "  efomina@company.ru  ";
    String email2 = "efomina2@company.ru";
    String password = "1P73BP4Z";
    String spaceLogin = "  fominaelena  ";
    String wrongLogin = "qwe123!@#";
    String spacePassword = "   1P73BP4Z   ";
    String failedAuthAlertText = "Неверные данные для авторизации.";
    String failedAuthAlertText2 = "Неверные данные для авторизации";

    String getBufferedString() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        boolean hasStringText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasStringText) {
            try {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }
}
