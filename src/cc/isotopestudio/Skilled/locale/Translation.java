/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.locale;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class Translation {

    public static ResourceBundle loadLocale(String localeString) {
        File file = new File(plugin.getDataFolder() + "/locale/", "Msg_" + localeString + ".properties");
        ResourceBundle newLocale = null;

        try {
            java.util.ResourceBundle defaultBundle = new PropertyResourceBundle(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            newLocale = new ResourceBundle(defaultBundle);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File localeFile = new File(plugin.getDataFolder() + File.separator + "locale" + File.separator + "MyPet_" + localeString + ".properties");
        if (localeFile.exists()) {
            if (newLocale == null) {
                newLocale = new ResourceBundle();
            }
            try {
                java.util.ResourceBundle optionalBundle = new PropertyResourceBundle(new InputStreamReader(new FileInputStream(localeFile), "UTF-8"));
                newLocale.addExtensionBundle(optionalBundle);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newLocale;
    }

}
