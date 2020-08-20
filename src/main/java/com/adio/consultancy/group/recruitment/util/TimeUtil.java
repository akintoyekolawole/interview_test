package com.adio.consultancy.group.recruitment.util;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kolawole
 */
public class TimeUtil {

  public static String getIsoTime(Timestamp timestamp) {
    if (timestamp == null) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    return timestamp.toLocalDateTime().format(formatter);
  }

  public static Timestamp now() {
    Date date = new Date();
    return new Timestamp(date.getTime());
  }

  public static Timestamp futureTime(int seconds) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(Calendar.SECOND, seconds);
    Date expiryDate = cal.getTime();
    return new Timestamp(expiryDate.getTime());
  }
}
