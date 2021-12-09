import java.util.ArrayList;
import java.util.List;

public class DecryptFilter implements Filter {
    private String encryptType;
    private SymmetricKeyCryptoStrategy cryptoStrategy;

    DecryptFilter() {
        this.encryptType = "AES256"; // default encryptType
        this.cryptoStrategy = SymmetricKeyFactory.createCryptoStrategy(encryptType);
        String symmetricKey = SymmetricKeyFactory.createKey(encryptType, "cHandleKey");
        cryptoStrategy.init(symmetricKey);
    }

    public Object execute(Object request) {

        // Visitor String to Visitor
//      System.out.println ( "Decrypted :" + request);
//      return request + "01234";

        List<String> reqarray = (ArrayList) request;
        List<Visitor> visitarr = new ArrayList<Visitor>();
        for (String requestEnc : reqarray) {
            Visitor visitor = cryptoStrategy.decrypt(requestEnc);
            visitarr.add(visitor);
        }
        return visitarr;
    }
}