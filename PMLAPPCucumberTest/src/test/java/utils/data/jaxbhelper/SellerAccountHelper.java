package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.SellerAccount;

public class SellerAccountHelper {

    private static final String SELLER_ACCOUNT_TDENTIFIER_KEY = "SELLER_ACCOUNT_TDENTIFIER";
    private static final String SELLER_NAME_KEY = "SELLER_NAME";

    public static SellerAccount getSellerAccount(Properties properties) {
        SellerAccount sellerAccount = new SellerAccount();
        sellerAccount.setSellerAccountIdentifier(properties.getProperty(SELLER_ACCOUNT_TDENTIFIER_KEY));
        sellerAccount.setSellerName(properties.getProperty(SELLER_NAME_KEY));
        return sellerAccount;
    }
}
