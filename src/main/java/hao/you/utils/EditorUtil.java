package hao.you.utils;

public class EditorUtil {

    public static String toEditor(String oldString){
        String newString = toBr(oldString);//将字符串中的换行符转为html中可读的</br>换行符
        return newString;
    }

    //将字符串中的换行符转为html中可读的</br>换行符
    private static String toBr(String oldString){
        return oldString.replaceAll(System.getProperty("line.separator"),"</br>");
    }
}
