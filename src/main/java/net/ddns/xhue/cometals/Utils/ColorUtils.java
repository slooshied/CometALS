package net.ddns.xhue.cometals.Utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {

    public final char COLOR_CHAR = ChatColor.COLOR_CHAR;

    public String cc(String string) {
        string = ChatColor.translateAlternateColorCodes('&', string);
        return string;
    }

    public String ccp(String string) {
        string = ChatColor.translateAlternateColorCodes('&', string);
        return string;
    }

    public String translateAll(String msg) {

        msg = cc(translateHexColorCodes("#", ":", msg));

        return msg;
    }


    public String translateHexColorCodes(String startTag, String endTag, String message) {
        final Pattern hexPattern = Pattern.compile(startTag + "([A-Fa-f0-9]{6})" + endTag);
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }
}
