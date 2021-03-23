package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;


public class CalendarLogic  implements Serializable{

	public int Status(int day,String period,Date updated) {
		int status=0;
		//今日の日付
		Calendar today = Calendar.getInstance();

		// 最後に掃除した日
		Calendar cal = Calendar.getInstance();
		cal.setTime(updated);

		// 次回掃除予定日
		if(period.equals("日")) {
			cal.add(Calendar.DATE, day);
		}else if(period.equals("週")) {
			//ここは計算が必要かな？
		}else if(period.equals("ケ月")) {
			cal.add(Calendar.MONTH, day);
		}else {
			cal.add(Calendar.YEAR, day);
		}

		//次回掃除予定日 - 最後に掃除した日


		return status;
	}

}
