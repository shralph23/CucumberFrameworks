package utils.data.jaxbhelper;

import java.util.Properties;

import com.freddiemac.datamanager.jaxb.SellerUser;

public class SellerUserHelper {
    private static final String SELLER_USER_TDENTIFIER_KEY = "SELLER_USER_TDENTIFIER";

    public static SellerUser getSellerUser(Properties properties) {
        SellerUser sellerUser = new SellerUser();
        sellerUser.setSellerUserIdentifier(properties.getProperty(SELLER_USER_TDENTIFIER_KEY));
        return sellerUser;
    }
}
