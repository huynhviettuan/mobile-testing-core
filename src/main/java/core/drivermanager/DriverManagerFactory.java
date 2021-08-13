package core.drivermanager;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

import java.util.HashMap;
import java.util.Map;


public class DriverManagerFactory {

    private static Map<String, DriverManager> managerMap;

    static {
        managerMap = new HashMap<>();
        managerMap.put("android", new AndroidDriverManager());
        managerMap.put("ios", new IosDriverManager());
    }

    public static DriverManager getManager(String platform) {
        DriverManager manager = managerMap.get(platform);
        return manager;
    }

    public static DriverManager getManagerUsingGuice(){
        String platform = System.getProperty("mobile.platform");
        Injector injector = Guice.createInjector(new DriverModule());
        DriverManager manager = injector.getInstance(Key.get(DriverManager.class, Names.named(platform)));
        return manager;
    }
}
