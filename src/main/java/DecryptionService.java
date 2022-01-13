import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Properties;

/**
 * @author s4dad\potolal
 */
public class DecryptionService extends AbstractService {

    /* ---- Constants ---- */


    /* ---- Instance Variables ---- */


    /* ---- Constructors ---- */


    /* ---- Business methods ---- */

    public String validateAndDecrypt(String message) {

        byte[] encryptedMessageAsByteArray = Base64.getDecoder().decode(message);

        return this.validateAndDecrypt(encryptedMessageAsByteArray);
    }

    public String validateAndDecrypt(byte[] encryptedMessageAsByteArray) {

        ByteArrayInputStream encryptedMessageAsByteArrayStream = new ByteArrayInputStream(encryptedMessageAsByteArray);
        Properties decryptionProperties = this.loadDecryptionProperties();
        String senderCertificateContentAsString = this.retrieveSenderCertificateContentAsString(decryptionProperties.getProperty("certificate.name"));
        ASiCService aSiCService = super.getAsicService(decryptionProperties);

        return aSiCService.validateAndDecrypt(encryptedMessageAsByteArrayStream, senderCertificateContentAsString);
    }

    private Properties loadDecryptionProperties() {

        return super.loadProperties("decryption.properties");
    }

    private String retrieveSenderCertificateContentAsString(String certificateFileName)  {

        return super.retrieveCertificateContentAsString(certificateFileName);
    }


    /* ---- Getters and Setters ---- */
}
