package inject_Page_Object_Using_Guice_1;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

@Guice(modules = {
	    DriverModule.class
	})
	public class GuiceTest {
	    @Inject
	    Google google;


	    @Test()
	    public void f() throws InterruptedException {
	     google.goTo();
	    }

	}