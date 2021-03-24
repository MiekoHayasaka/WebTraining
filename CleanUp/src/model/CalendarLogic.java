package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;


public class CalendarLogic  implements Serializable{

	public int Status(int day,String period) {
		int status=0;
		// 現在日時を取得
		Calendar last = Calendar.getInstance();

		// 最後に掃除した日
		//Calendar last = Calendar.getInstance();
		//last.setTime(updated);


		// 次回掃除予定日
		Calendar next = Calendar.getInstance();
		//next.setTime(updated);
		if(period.equals("日")) {
			next.add(Calendar.DAY_OF_MONTH, day);
		}else if(period.equals("週")) {
			next.add(Calendar.WEEK_OF_YEAR, day);
		}else if(period.equals("ケ月")) {
			next.add(Calendar.MONTH, day);
		}else {
			next.add(Calendar.YEAR, day);
		}

		//次回掃除予定日 - 最後に掃除した日
		long lastMillis = last.getTimeInMillis();
		long nextMillis = next.getTimeInMillis();
		long diff = (nextMillis - lastMillis) / 1000 / 60 / 60 / 24;
		status=(int)diff;


		return status;
	}

	public int Status(int day,String period,Date updated) {
		int status=0;
		// 現在日時を取得
		//Calendar today = Calendar.getInstance();

		// 最後に掃除した日
		Calendar last = Calendar.getInstance();
		last.setTime(updated);


		// 次回掃除予定日
		Calendar next = Calendar.getInstance();
		next.setTime(updated);
		if(period.equals("日")) {
			next.add(Calendar.DAY_OF_MONTH, day);
		}else if(period.equals("週")) {
			next.add(Calendar.WEEK_OF_YEAR, day);
		}else if(period.equals("ケ月")) {
			next.add(Calendar.MONTH, day);
		}else {
			next.add(Calendar.YEAR, day);
		}

		//次回掃除予定日 - 最後に掃除した日
		long lastMillis = last.getTimeInMillis();
		long nextMillis = next.getTimeInMillis();
		long diff = (nextMillis - lastMillis) / 1000 / 60 / 60 / 24;
		status=(int)diff;


		return status;
	}

}
