
import java.io.IOException;
import shoppe.conterler.dangnhapconterler;
import shoppe.conterler.indexconterler;
import shoppe.view.fromdangnhapview;
import shoppe.view.indexview;

public class app {
    public static void main(String[] args) throws IOException {
        indexview view = new indexview();
        indexconterler control = new indexconterler(view);
    }
}
