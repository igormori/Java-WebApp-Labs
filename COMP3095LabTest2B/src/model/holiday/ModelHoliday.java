package model.holiday;

import java.util.HashMap;
import java.util.Map;

public class ModelHoliday {
	
	Map<String, String> holiday;
	public ModelHoliday() {
		holiday = new HashMap<String, String>();
		holiday.put("2019","January,1 Tue Happy new Year");
		holiday.put("2019","Febuary,18 Mon Ontario Family Day");
		holiday.put("2019","March, 19 Fri Good Friday");
		
		
	
	}
	

	public String matchAb(String year,String month) {
		
		return holiday.get(year);
	}
}
