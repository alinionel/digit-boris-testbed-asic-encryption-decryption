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
        String encryptedContent = encryptionService.signAndEncrypt("<ConnectivityRequest xmlns=\"http://ec.europa.eu/boris/v1_0/ConnectivityRequest\" xmlns:bbc=\"http://ec.europa.eu/boris/v1_0/common/BasicComponents\">\n" +
                "    <bbc:SendingDateTime>2021-09-24T13:42:00.000Z</bbc:SendingDateTime>\n" +
                "</ConnectivityRequest>");

        System.out.println(encryptedContent);
    }



    /* ---- Getters and Setters ---- */
}
