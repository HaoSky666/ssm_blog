package hao.you.utils;

public class ToolMethodUtil {
    public static boolean isNull(Object obj) {
        if (null == obj || "".equalsIgnoreCase(obj.toString().trim()) || "null".equalsIgnoreCase(obj.toString().trim())) {
            return true;
        }
        return false;
    }

    public static boolean notNull(Object obj) {
        if (null == obj || "".equalsIgnoreCase(obj.toString().trim()) || "null".equalsIgnoreCase(obj.toString().trim())) {
            return false;
        }
        return true;
    }
}
