package datetime;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Oleksandra_Dmytrenko on 15/03/2018.
 */
public class DeteTimeFormatted {
    private static final DateTimeFormatter CM_WELL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    private static final DateTimeFormatter GF_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxxx");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_Zoned = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public String getCurrentIsoDateTime() {
        String dt = Instant.now().toString();
        System.out.println(dt);
        if (!dt.contains(".")) {
            dt = dt.replace("Z", ".000Z");
        }
        System.out.println(dt);
        return dt;
    }

    public String getDateTimeFormated() {
        ZonedDateTime now = ZonedDateTime.now();
        String dateTime = now.format(DATE_TIME_FORMATTER_Zoned);
        System.out.println(dateTime);
        return dateTime;
    }
}