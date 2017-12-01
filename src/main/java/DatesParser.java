

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.SneakyThrows;

/**
 * Created by Oleksandra_Dmytrenko on 07.11.2017.
 */
public class DatesParser {
    @SneakyThrows
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String dateInString = "07 JAN 2013";

        if (!StringUtils.isEmpty(dateInString)) {
            try {
                Date date = formatter.parse(dateInString);
                System.out.println(date);
                System.out.println(formatter.format(date));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}