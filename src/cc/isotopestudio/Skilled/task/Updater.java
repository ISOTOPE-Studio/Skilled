/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static cc.isotopestudio.Skilled.Skilled.plugin;

public class Updater extends Thread {

    @Override
    public void run() {
        if (hasNewVersion()) {
            plugin.getLogger().info("����и��£�����������");
        }
    }

    private static boolean hasNewVersion() {
        try {
            String result = readUrlContent("http://www.isotopestudio.cc/check.php?plugin=Skilled&version=" + plugin.getDescription().getVersion(), 4000);
            if (result.equals("yes")) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            plugin.getLogger().info("���������ʧ�ܣ����������������");
        }
        return false;
    }

    private static String readUrlContent(String address, int timeout) throws IOException {
        StringBuilder contents = new StringBuilder(2048);
        BufferedReader br = null;

        try {
            URL url = new URL(address);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setConnectTimeout(timeout);
            huc.setReadTimeout(timeout);
            huc.setRequestMethod("GET");
            huc.connect();
            br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                contents.append(line);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contents.toString();
    }
}
