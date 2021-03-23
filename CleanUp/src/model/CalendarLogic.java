package model;

import java.io.Serializable;
import java.sql.Date;


public class CalendarLogic  implements Serializable{

	public int Status(int day,String period,Date updated) {
		int status=0;
		java.util.Date udate=new java.util.Date();
		updated = new Date(udate.getTime());
		return status;
	}

}
