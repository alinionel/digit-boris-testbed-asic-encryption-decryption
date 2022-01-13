import java.io.IOException;

/**
 * @author s4dad\potolal
 */
public class EncryptionRunner {

    /* ---- Constants ---- */


    /* ---- Instance Variables ---- */


    /* ---- Constructors ---- */


    /* ---- Business methods ---- */

    public static void main(String[] args) throws IOException {

        EncryptionService encryptionService = new EncryptionService();
        String encryptedContent = encryptionService.signAndEncrypt("<ConnectivityRequest xmlns=\"http://ec.europa.eu/boris/v1_0/ConnectivityRequest\"\n" +
                "                      xmlns:bbc=\"http://ec.europa.eu/boris/v1_0/common/BasicComponents\">\n" +
                "    <bbc:SendingDateTime>$timestamp</bbc:SendingDateTime>\n" +
                "</ConnectivityRequest>");

        System.out.println(encryptedContent);
    }



    /* ---- Getters and Setters ---- */
}
