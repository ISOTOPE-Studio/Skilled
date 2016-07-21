/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.locale;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ResourceBundle extends java.util.ResourceBundle {
    private List<java.util.ResourceBundle> extensionBundles = new ArrayList<>();
    private boolean noParent = false;

    public ResourceBundle(java.util.ResourceBundle parent) {
        this.parent = parent;
    }

    public ResourceBundle() {
        noParent = true;
    }

    public void addExtensionBundle(java.util.ResourceBundle bundle) {
        if (bundle == null) {
            return;
        }

        this.extensionBundles.add(bundle);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public Enumeration<String> getKeys() {
        Set keys = new HashSet();
        if (!noParent) {
            keys.addAll(this.parent.keySet());
        }

        for (java.util.ResourceBundle bundle : this.extensionBundles) {
            keys.addAll(bundle.keySet());
        }
        return Collections.enumeration(keys);
    }

    protected Object handleGetObject(String key) {
        Object object;

        if ((object = getObjectFromExtensionBundles(key)) != null) {
            return object;
        }
        return this.parent.getObject(key);
    }

    @Nullable
    private Object getObjectFromExtensionBundles(String key) {
        if (this.extensionBundles.size() == 0) {
            return null;
        }
        try {
            Object object;
            for (java.util.ResourceBundle bundle : this.extensionBundles) {
                if ((object = bundle.getObject(key)) != null) {
                    return object;
                }
            }
        } catch (MissingResourceException ignored) {
        }
        return null;
    }
}