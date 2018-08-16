package inject_Page_Object_Using_Guice_1;

import org.openqa.selenium.WebDriver;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Google {
    private final WebDriver driver;
    @Inject
    @Named("application.url")
    private String URL;
    @Inject
    public Google(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(this.URL);
        this.driver.quit();
    }

}