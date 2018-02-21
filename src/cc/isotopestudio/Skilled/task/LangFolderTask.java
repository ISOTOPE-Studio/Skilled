/*
 * Copyright (c) 2017. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.task;

import cc.isotopestudio.Skilled.message.Msg;
import cc.isotopestudio.Skilled.utli.PluginFile;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

import static cc.isotopestudio.Skilled.Skilled.*;

public class LangFolderTask extends BukkitRunnable {

    @Override
    public void run() {
        lang = config.getString("lang", "zh_CN");
        if (!new File("lang/" + lang).exists()) {
            msgFile = new PluginFile(plugin, "lang/msg_zh_CN.yml", "lang/msg_zh_CN.yml");
        }
        msgFile = new PluginFile(plugin, "lang/msg_" + lang + ".yml");
        Msg.noPermission = getMsg("noPermission");
        Msg.notNumber = getMsg("notNumber");
        Msg.mustBePlayer = getMsg("mustBePlayer");
        Msg.mustBeInt = getMsg("mustBeInt");
        Msg.hasClass = getMsg("hasClass");
        Msg.hasMetaData = getMsg("hasMetaData");
        Msg.noItem = getMsg("noItem");
        Msg.mustbe1 = getMsg("mustbe1");
        Msg.playerNotOnline = getMsg("playerNotOnline");
        Msg.noSkill = getMsg("noSkill");
        Msg.noClass = getMsg("noClass");
        Msg.noMagic = getMsg("noMagic");
        Msg.noSkillPoint = getMsg("noSkillPoint");
        Msg.noLife = getMsg("noLife");
        Msg.cooldown = getMsg("cooldown");
        Msg.release = getMsg("release");
        Msg.endSkill = getMsg("endSkill");
        Msg.successJoin = getMsg("successJoin");
        Msg.successUnlock = getMsg("successUnlock");
        Msg.successUpgrade = getMsg("successUpgrade");
        Msg.skillName = new String[9][5];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 4; j++) {
                Msg.skillName[i][j] = getSkillName(i, j);
            }
        }
        Msg.skillDescription = new String[9][5];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 4; j++) {
                Msg.skillDescription[i][j] = getSkillDes(i, j);
            }
        }
        Msg.className = new String[9];
        for (int i = 1; i <= 8; i++) {
            Msg.className[i] = getClassName(i);
        }
    }

    private static String getMsg(String path) {
        return ChatColor.translateAlternateColorCodes('&',
                msgFile.getString("msg." + path, "&cÓïÑÔÎÄ¼þ msg." + path + " ´íÎó"));
    }

    private static String getClassName(int job) {
        String path = "classes.c" + job + ".name";
        return ChatColor.translateAlternateColorCodes('&',
                msgFile.getString(path, "&cÓïÑÔÎÄ¼þ " + path + "´íÎó"));
    }

    private static String getSkillName(int job, int skill) {
        String path = "classes.c" + job + ".skills.s" + skill + ".name";
        return ChatColor.translateAlternateColorCodes('&',
                msgFile.getString(path,
                        "&cÓïÑÔÎÄ¼þ " + path + " ´íÎó"));
    }

    private static String getSkillDes(int job, int skill) {
        String path = "classes.c" + job + ".skills.s" + skill + ".description";
        return ChatColor.translateAlternateColorCodes('&',
                msgFile.getString(path,
                        "&cÓïÑÔÎÄ¼þ " + path + " ´íÎó"));
    }
}
