package model;

import java.io.Serializable;
import java.sql.Date;


public class CalendarLogic  implements Serializable{

	public Date CurrentDate(Date updated) {
		java.util.Date udate=new java.util.Date();
		updated = new Date(udate.getTime());
		return updated;
	}

}
