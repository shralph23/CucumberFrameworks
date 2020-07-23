package featuredefinition;

import java.io.IOException;

import core.BaseGlobalHooks;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class GlobalHooks extends BaseGlobalHooks {

	@Before
	public void before(Scenario scenario) throws IOException {
	    beforeSetUp(scenario);
	}
}
