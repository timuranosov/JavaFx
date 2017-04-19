package FxHomeWork;
import java.io.PrintWriter;
import java.io.StringWriter;

class CheckDigits {

    private static final String STRING_DELIMITER = " ";

    //проверяет, есть ли цифры в строке
    static boolean hasDigits(String s) {
        String newString = s.replaceAll("\\D", "");
        return (!newString.isEmpty());
    }

    //выводит цифры, содержащиеся в строке(если они есть)
    static String getDigits(String s){
        return s.replaceAll("\\D", "").replaceAll("", STRING_DELIMITER);
    }

    //записывает весь стек-трейс в строку
    static String getStackTrace (RuntimeException e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
