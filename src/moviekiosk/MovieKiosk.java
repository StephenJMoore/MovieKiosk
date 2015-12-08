
package moviekiosk;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Stephen Moore
 */
public class MovieKiosk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        KioskGui window = new KioskGui();
        window.setVisible(true);
    }
}
