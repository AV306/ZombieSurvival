package me.jungdab.zsm.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TimeUtil {
    public static String dayTimeToHHmm(long time) {
        int HH = dayTimeToHour(time);
        int mm = dayTimeToMinute(time);

        if(HH < 12) {
            return String.format("AM %02d:%02d", HH, mm);
        }
        else {
            if(HH > 12) HH -= 12;
            return String.format("PM %02d:%02d", HH, mm);
        }
    }

    public static int dayTimeToDay(long time) {
        return (int) (time + 6000) / 24000 + 1;
    }

    public static int dayTimeToHour(long time) {
        return (int) ((time % 24000) / 1000 + 6) % 24;
    }

    public static int dayTimeToMinute(long time) {
        return (int) ((time % 24000) % 1000) * 60 / 1000;
    }
}
