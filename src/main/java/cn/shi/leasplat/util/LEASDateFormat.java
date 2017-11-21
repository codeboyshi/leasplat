package cn.shi.leasplat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LEASDateFormat extends SimpleDateFormat{

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat DATE_HOUR_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH");

    @Override
    public Date parse(String source) throws ParseException
    {
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
            return DATE_FORMATTER.parse(source);
        else if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}$"))
            return DATE_HOUR_FORMATTER.parse(source);
        else
            return TIME_FORMATTER.parse(source);
    }
}
