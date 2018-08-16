package inject_Page_Object_Using_Guice_1;

import com.google.inject.name.Names;
import org.openqa.selenium.WebDriver;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {

        //DriverManager config
        bind(DriverManager.class)
                .to(ChromeDriverManager.class)
                .in(Scopes.SINGLETON);

        //My test input properties

        try {
            Properties props = new Properties();
            props.load(new FileInputStream("uat.properties"));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            //skip
        }
    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }
}