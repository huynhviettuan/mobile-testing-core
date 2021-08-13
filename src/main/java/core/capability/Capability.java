package core.capability;

import java.util.Map;

public abstract class Capability {

    protected Map<String, Object> map;

    public abstract Map<String, Object> load();

    public void add(String name, String testcaseName){
        map.put(name, testcaseName);
    }
}
