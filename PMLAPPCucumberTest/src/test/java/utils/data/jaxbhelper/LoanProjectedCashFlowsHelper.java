package utils.data.jaxbhelper;

import java.util.List;
import java.util.Properties;

import com.freddiemac.datamanager.jaxb.LoanProjectedCashFlow;
import com.freddiemac.datamanager.jaxb.LoanProjectedCashFlows;

public class LoanProjectedCashFlowsHelper {

    public static LoanProjectedCashFlows getLoanProjectedCashFlows(Properties properties) {
        LoanProjectedCashFlows loanProjectedCashFlows = new LoanProjectedCashFlows();
        List<LoanProjectedCashFlow> loanProjectedCashFlowsList = loanProjectedCashFlows.getLoanProjectedCashFlow();
        LoanProjectedCashFlow loanProjectedCashFlowForFirstContainer = LoanProjectedCashFlowHelper
                .getLoanProjectedCashFlowForFirstContainer(properties);
        loanProjectedCashFlowsList.add(loanProjectedCashFlowForFirstContainer);
        return loanProjectedCashFlows;
    }

}
