package Java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
        public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        // dateFormat.setLenient(false); // Установка строгого режима

        // Преобразование строки в дату
        Date date = dateFormat.parse(dateString);

        return date;

    }

        public static Date easyConv(String dateString)  {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        // dateFormat.setLenient(false); // Установка строгого режима

        try {
            Date date = dateFormat.parse(dateString);
            return date;
        } catch (Exception e) {
            return new Date();
            // TODO: handle exception
        }
        

        

    }

}
