package nl.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager
{
    private static ConfigManager configManager;
    private final Map<String, Object> settings;

    private ConfigManager()
    {
        settings = new HashMap<>();
    }

    public void set(String key, Object value)
    {
        settings.put(key, value);
    }

    public Object get(String key)
    {
        return settings.get(key);
    }

    public static ConfigManager getConfigManager()
    {
        if (configManager == null)
        {
            configManager = new ConfigManager();
        }

        return configManager;
    }
}
