import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Properties;

/**
 * @author s4dad\potolal
 */
public abstract class AbstractService {

    /* ---- Constants ---- */


    /* ---- Instance Variables ---- */


    /* ---- Constructors ---- */


    /* ---- Business methods ---- */

    protected ASiCService getAsicService(Properties properties) {

        KeyStoreHelper keyStoreHelper = this.getKeyStoreHelper(properties);

        return new ASiCService(keyStoreHelper, this.getAsicHelper(keyStoreHelper));
    }

    protected ASiCHelper getAsicHelper(KeyStoreHelper keyStoreHelper) {

        return new ASiCHelper(keyStoreHelper);
    }

    protected KeyStoreHelper getKeyStoreHelper(Properties prop) {
        String keystorePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + prop.getProperty("keyStore.name");
        String ksPwd = prop.getProperty("keyStore.password");
        String keyAlias = prop.getProperty("keyStore.key.alias" );
        String privateKeyPwd = prop.getProperty("keyStore.privateKey.password");

        return new KeyStoreHelper(keystorePath, ksPwd, privateKeyPwd, keyAlias);

    }

    protected Properties loadProperties(String propertiesFileName) {
        String applicationPropertiesPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()  + propertiesFileName;
        InputStream input = null;

        try {
            input = new FileInputStream(applicationPropertiesPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Issue loading %s at: %s", propertiesFileName, applicationPropertiesPath) , e);
        }

        Properties prop = new Properties();

        try {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Issue loading %s at: %s", propertiesFileName, applicationPropertiesPath) , e);
        }
        return prop;
    }

    protected String retrieveCertificateContentAsString(String certificateFileName)  {
        File certificateFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath() + certificateFileName);

        try {
            return new String(Files.readAllBytes(certificateFile.toPath()), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Issue loading " + certificateFileName + " file at: " + certificateFile.toPath(), e);
        }
    }


    /* ---- Getters and Setters ---- */
}
