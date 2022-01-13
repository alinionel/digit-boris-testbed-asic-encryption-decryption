import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

/**
 * @author s4dad\potolal
 */
public class EncryptionService extends AbstractService {

    /* ---- Constants ---- */


    /* ---- Instance Variables ---- */

//    private static final String RESOURCES_PATH = "/home/potolal/development/workspaces/intelliJ/BORIS/TESTBED/ASiCEncryptionDecriptionClient/security/";


    /* ---- Constructors ---- */

    /* ---- Business methods ---- */

    public String signAndEncrypt(String message) throws IOException {

        Properties properties = this.loadEncryptionProperties();
        String receiverCertificateUsedForEncryption = this.retrieveSenderCertificateUsedForEncryption(properties.getProperty("certificate.name"));
        ASiCService aSiCService = super.getAsicService(properties);
        ByteArrayOutputStream baos = aSiCService.signAndEncrypt(message, receiverCertificateUsedForEncryption);
        String encryptedMessageAsBase64String = Base64.getEncoder().encodeToString(baos.toByteArray());

        return encryptedMessageAsBase64String;
    }

    private Properties loadEncryptionProperties() {

        return super.loadProperties("encryption.properties");
    }

    private String retrieveSenderCertificateUsedForEncryption(String certificateFileName)  {

        return super.retrieveCertificateContentAsString(certificateFileName);
    }


    /* ---- Getters and Setters ---- */
}
