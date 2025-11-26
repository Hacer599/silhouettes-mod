package com.example.silhouettes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigManager {
    private static final Path CONFIG = Paths.get("config/silhouettes.properties");
    private static Properties props = new Properties();

    public static void load() {
        try {
            if (Files.exists(CONFIG)) {
                props.load(Files.newInputStream(CONFIG));
            } else {
                props.setProperty("spawn_chance","8000");
                props.setProperty("min_distance","24");
                props.setProperty("max_distance","80");
                props.setProperty("max_life_ticks","1200");
                props.setProperty("enable_sound","true");
                props.setProperty("enable_visual","true");
                props.setProperty("look_timeout_ticks","40");
                Files.createDirectories(CONFIG.getParent());
                props.store(Files.newOutputStream(CONFIG), "Silhouettes config");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSpawnChance() { return Integer.parseInt(props.getProperty("spawn_chance","8000")); }
    public static int getMinDistance() { return Integer.parseInt(props.getProperty("min_distance","24")); }
    public static int getMaxDistance() { return Integer.parseInt(props.getProperty("max_distance","80")); }
    public static int getMaxLife() { return Integer.parseInt(props.getProperty("max_life_ticks","1200")); }
    public static boolean isEnableSound() { return Boolean.parseBoolean(props.getProperty("enable_sound","true")); }
    public static boolean isEnableVisual() { return Boolean.parseBoolean(props.getProperty("enable_visual","true")); }
    public static int getLookTimeoutTicks() { return Integer.parseInt(props.getProperty("look_timeout_ticks","40")); }
}
