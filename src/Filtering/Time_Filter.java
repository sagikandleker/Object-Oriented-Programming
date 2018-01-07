package Filtering;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Data_Setup.Record;
import Main_App.Write_2_CSV;

/**
 * Filtering by Begin time to End time.
 *
 */
public class Time_Filter {

	private String start, end;

	public Time_Filter(String start, String end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * 
	 * @param tf
	 * @throws ParseException
	 */
	public static void timeFilter(Time_Filter tf) throws ParseException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date_start =  format.parse(tf.start);
		Date date_end =  format.parse(tf.end);
		Write_2_CSV.All_Data_List.stream()
		.filter(p -> p.getDate().after(date_start) && p.getDate().before(date_end))
		.forEach(p -> Filter.time_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList())));

	}
}
