package core.drivermanager;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.name.Names;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DriverManagerProvider implements Provider<DriverManager> {

    @Inject
    private Injector injector; // injector of TestNG

    @Override
    public DriverManager get() {
        Properties fileProperties = new Properties();
        try {
            fileProperties.load(new FileReader(System.getProperty("user.dir") + "/res/config/mobile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String platform = System.getProperty("mobile.platform") != null ? System.getProperty("mobile.platform") : fileProperties.getProperty("mobile.platform");
        DriverManager manager = injector.getInstance(Key.get(DriverManager.class, Names.named(platform)));
        return manager;
    }
}
