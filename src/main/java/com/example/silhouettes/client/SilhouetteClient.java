package com.example.silhouettes.client;

import com.example.silhouettes.ConfigManager;
import java.util.ArrayList;
import java.util.List;

public class SilhouetteClient {
    static final List<Object> silhouettes = new ArrayList<>();

    public static void onInitializeClient() {
        // Client initialization placeholder: register tick/render handlers in real mod
        ConfigManager.load();
    }
}
