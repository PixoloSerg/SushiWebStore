/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.controllers;

import com.sushistore.data.entities.Address;
import com.sushistore.data.entities.Schedule;
import com.sushistore.data.utills.ConnectionPool;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author P5
 */
public class ScheduleController {
    
    private static Schedule getSchedule(ResultSet rs) throws SQLException {
        Schedule s = new Schedule();
        s.setId(rs.getInt("ID"));
        s.setBegin(rs.getBigDecimal(Schedule.BEGIN));
        s.setEnd(rs.getBigDecimal(Schedule.END));
        return s;
    }
    
    public static List<Schedule> getScheduleByAddress(Address address) {
        List<Schedule> list = new ArrayList<>();
        ResultSet rs;
        String query = "SELECT S.* FROM SCHEDULE S JOIN ADDRESS_SCHEDULE ADS " 
                + " ON S.ID = ADS.SCHEDULEID AND ADS.ADDRESSID = ? ORDER BY S.ID";
        try (Connection connection = ConnectionPool.getConnectionPool().getConnection();
                PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, address.getId());
            rs = ps.executeQuery();            
            while(rs.next())
                list.add( getSchedule(rs) );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static BigDecimal[] schedulePair(BigDecimal begin, BigDecimal end) {
        BigDecimal[] result = new BigDecimal[2];
        result[0] = begin; result[1] = end.subtract(begin);
        return result;
    }
    
    public static String getDayCaption(int idx) {
        DayOfWeek dow = DayOfWeek.of(idx);
        Locale locale = Locale.getDefault();
        return dow.getDisplayName(TextStyle.SHORT, locale);
    }    
    
    public static String getFormattedScheduleByAddress(Address address) {
        String result = "";
        List<Schedule> list = getScheduleByAddress(address);
	
	Map<Integer, Boolean> map = new HashMap<>();
	for(int i=0; i<list.size(); i++) {	    
	    Schedule t = list.get(i);
	    if(map.containsKey(t.getId())) continue;
	    int start = t.getId(), end = start;
	    String str = ScheduleController.getDayCaption(start);
	    for(int j=i; j<list.size(); j++) {
		Schedule sc = list.get(j);
		if( sc.getBegin().equals(t.getBegin()) && sc.getEnd().equals(t.getEnd()) ) {
		    map.put(sc.getId(), Boolean.TRUE);
		    if(start == 0) {
			str += ", " + ScheduleController.getDayCaption(sc.getId());
			start = sc.getId();
		    }
		    end = sc.getId();
                    if(j != list.size()-1) continue;
		} 
                if(end - start > 1)
                    str += "-" + ScheduleController.getDayCaption(end);
                else if(end - start == 1)
                    str += ", " + ScheduleController.getDayCaption(end);
                start = 0; end = start;		
	    }
	    String e = "";
	    if(!result.isEmpty()) e = "; ";
	    result += e + str + ": " + t.getBegin() + "-" + t.getEnd();
	}        
        return result;        
    }
    
    public static List<String> getBlockedScheduleByAddress(Address a) {
	String res = getFormattedScheduleByAddress(a);
	return Arrays.asList(res.split(";"));
    }
    
}
