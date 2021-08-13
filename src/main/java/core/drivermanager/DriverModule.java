package core.drivermanager;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import core.capability.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DriverManager.class).annotatedWith(Names.named("android")).to(AndroidDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).annotatedWith(Names.named("ios")).to(IosDriverManager.class).in(Scopes.SINGLETON);
        bind(DriverManager.class).toProvider(DriverManagerProvider.class).in(Scopes.SINGLETON);

        // bind for capability
        bind(Capability.class).annotatedWith(Names.named("cli")).to(CommandLineCapability.class);
        bind(Capability.class).annotatedWith(Names.named("properties")).to(PropertiesFileCapability.class);
        bind(String.class).annotatedWith(Names.named("platform")).toInstance(getPlatform());

        // bind service
        bind(Service.class).to(CapabilityService.class).in(Scopes.SINGLETON);
    }

    protected String getPlatform() {
        Properties fileProperties = new Properties();
        try {
            fileProperties.load(new FileReader(System.getProperty("user.dir") + "/res/config/mobile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty("mobile.platform") != null ? System.getProperty("mobile.platform") : fileProperties.getProperty("mobile.platform");
    }
}
