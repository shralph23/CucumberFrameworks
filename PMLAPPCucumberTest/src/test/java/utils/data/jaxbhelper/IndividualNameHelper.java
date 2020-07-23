package utils.data.jaxbhelper;

import java.math.BigInteger;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.IndividualName;

public class IndividualNameHelper {

    private static final String INDIVIDUAL_NAME_TYPE_KEY = "INDIVIDUAL_NAME_TYPE";
    private static final int INDIVIDUAL_NAME_IDENTIFIER_KEY = 0;
    private static final String INDIVIDUAL_MIDDLE_NAME_KEY = "INDIVIDUAL_MIDDLE_NAME";
    private static final String INDIVIDUAL_FULL_NAME_KEY = "INDIVIDUAL_FULL_NAME";
    private static final String INDIVIDUAL_IDENTIFIER_KEY = "INDIVIDUAL_IDENTIFIER";
    private static final String INDIVIDUAL_LAST_NAME_KEY = "INDIVIDUAL_LAST_NAME";
    private static final String INDIVIDUAL_FIRST_NAME_KEY = "INDIVIDUAL_FIRST_NAME";
    private static final String FUNCTIONAL_TITLE_DESCRIPTION_KEY = "INDIVIDUAL_FIRST_NAME";
    private static final String FREDDIEMAC_EMPLOYEE_IDENTIFIER_KEY = "FREDDIEMAC_EMPLOYEE_IDENTIFIER";
    private static final String EDUCATIONAL_ACHIEVEMENT_DESCRIPTION_KEY = "EDUCATIONAL_ACHIEVEMENT_DESCRIPTION";

    public static IndividualName getIndividualName(Properties properties) {
        IndividualName individualName = new IndividualName();
        individualName
                .setEducationalAchievementDescription(properties.getProperty(EDUCATIONAL_ACHIEVEMENT_DESCRIPTION_KEY));
        individualName.setFreddieMacEmployeeIdentifier(properties.getProperty(FREDDIEMAC_EMPLOYEE_IDENTIFIER_KEY));
        individualName.setFunctionalTitleDescription(properties.getProperty(FUNCTIONAL_TITLE_DESCRIPTION_KEY));
        individualName.setIndividualFirstName(properties.getProperty(INDIVIDUAL_FIRST_NAME_KEY));
        individualName.setIndividualFullName(properties.getProperty(INDIVIDUAL_FULL_NAME_KEY));
        individualName.setIndividualIdentifier(properties.getProperty(INDIVIDUAL_IDENTIFIER_KEY));
        individualName.setIndividualLastName(properties.getProperty(INDIVIDUAL_LAST_NAME_KEY));
        individualName.setIndividualMiddleName(properties.getProperty(INDIVIDUAL_MIDDLE_NAME_KEY));
        individualName.setIndividualNameIdentifier(BigInteger.valueOf(INDIVIDUAL_NAME_IDENTIFIER_KEY));
        individualName.setIndividualNameType(properties.getProperty(INDIVIDUAL_NAME_TYPE_KEY));
        return individualName;
    }
}
