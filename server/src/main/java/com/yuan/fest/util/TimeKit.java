package com.yuan.fest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class TimeKit {

    /**
     * 每天的秒数
     */
    public static final int ONE_DAY_SECOND = 86400;

	/**
	 * 获取当前时间戳秒数
	 * @return 秒数
	 */
	public static int getTimeStamp(){
		return (int)(System.currentTimeMillis()/1000);
	}

	/**
	 * 获取某天0点起始点的时间戳秒数
	 * @param datetime 某天的时间戳秒数
	 * @return 该天0点的时间戳秒数
     */
	public static int getDateBeginTime(int datetime){
		Date date = new Date(datetime * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String dateStr = formatter.format(date);
			Date dateNew = formatter.parse(dateStr);
			return (int) (dateNew.getTime() / 1000L);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datetime;
	}

    /**
     * 获取某天是星期几的值
     * @param datetime 某天的时间戳秒数
     * @return 星期数，星期一是1，星期日是7
     */
    public static int getDateWeek(int datetime){
        Calendar stime = Calendar.getInstance();
        stime.setTimeInMillis(datetime * 1000L);
        stime.set(Calendar.HOUR_OF_DAY, 0);
        stime.set(Calendar.MINUTE, 0);
        stime.set(Calendar.SECOND, 0);
        stime.set(Calendar.MILLISECOND, 0);
        int week = stime.get(Calendar.DAY_OF_WEEK);// 星期日为第一天，星期一为第二天。。。。。星期六为第七天
        if (week == 1) {// 先进行换算 “0000011”，左边第一位为星期一
            week = 7;
        } else {
            week = week - 1;
        }
        return week;
    }

	/**
	 * 根据分钟数,返回HH:mm格式字符串
	 * @param minutes 分钟数
	 * @return 格式字符串
	 */
	public static String getCheckTimeFormat(int minutes) {
		int hour = minutes / 60;
		int minute = minutes % 60;
		return  String.format("%02d", hour) + ":" + String.format("%02d", minute);
	}

    /**
     * 根据时间戳秒数，获取月日时:分字符串
     * @param datetime 时间戳秒数
     * @return 格式字符串
     */
	public static String getMonthMinuteTimeStr(int datetime){
		Date date = new Date(datetime * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日HH:mm");
		try{
			return formatter.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间戳秒数，获取月日时:分:秒字符串
	 * @param datetime 
	 * @return
     */
	public static String getMonthSecondTimeStr(int datetime){
		Date date = new Date(datetime * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日HH:mm:ss");
		try{
			return formatter.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public static String getFullDateTimeStr(int datetime){
        Date date = new Date(datetime*1000l);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            return formatter.format(date);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据时间戳秒数，获取年月日字符串
     * @param datetime
     * @return
     */
    public static String getYearDayTimeStr(int datetime){
        Date date = new Date(datetime * 1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        try{
            return formatter.format(date);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * 根据时间戳秒数，获取年-月-日字符串
	 * @param datetime
	 * @return
	 */
	public static String getDateFormatStr(int datetime){
		Date date = new Date(datetime * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			return formatter.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时长,h小时m分格式
	 */
	/**
	 * 根据分钟数获取时分的格式字符串
	 * @param minutes
	 * @return
	 */
	public static String getTimePeriodFormat(int minutes){
		if(minutes < 60){
			return String.format("%d分", minutes);
		}
		int hour = minutes / 60;
		int minute = minutes % 60;
		if(minutes == 0){
			return String.format("%d小时", hour);
		}
		return String.format("%d小时%d分", hour, minute);
	}


	/**
	 * 根据分钟数获取天时分格式字符串
	 * @param minutes
	 * @return
	 */
	public static String getTimePeriodFormatDay(int minutes){
		if(minutes < 60){
			return String.format("%d分", minutes);
		}
		int hour = minutes / 60;
		int minute = minutes % 60;
		if(hour < 24){
			if(minutes == 0) {
				return String.format("%d小时", hour);
			}
			return String.format("%d小时%d分", hour, minute);
		}else{
			int day = hour / 24;
			int hourResidue = hour % 24;
			return  String.format("%d天%d小时%d分", day, hourResidue, minute);
		}
	}


	/**
	 * 根据时间戳秒数，获取年月日 时:分字符串
	 * @param datetime
	 * @return
	 */
	public static String getYearDateTimeStr(int datetime){
		Date date = new Date(datetime*1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		try{
			return formatter.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据秒数获取中文时间字符串
	 * @param second
	 * @return
	 */
	public static String getTimePeriod(int second){
		StringBuilder timeString = new StringBuilder();
		int timeFinish;
		timeFinish = second;
		if (timeFinish >= ONE_DAY_SECOND){
			timeString.append(timeFinish / ONE_DAY_SECOND).append("天");
			timeFinish = timeFinish % ONE_DAY_SECOND;
			if (timeFinish >= 3600){
				timeString.append(timeFinish / 3600).append("小时");
				timeFinish = timeFinish % 3600;
				if (timeFinish >= 60){
					timeString.append(timeFinish / 60).append("分");
					timeFinish = timeFinish % 60;
					if(timeFinish > 0){
						timeString.append(timeFinish).append("秒");
					}
				}else{
					timeString.append(timeFinish % 60).append("秒");
				}
			}
			else{
				if (timeFinish >= 60){
					timeString.append(timeFinish / 60).append("分");
					timeFinish = timeFinish % 60;
					if(timeFinish > 0){
						timeString.append(timeFinish).append("秒");
					}
				}else{
					timeString.append(timeFinish % 60).append("秒");
				}
			}
		}
		else{
			if (timeFinish >= 3600){
				timeString.append(timeFinish / 3600).append("小时");
				timeFinish = timeFinish % 3600;
				if (timeFinish >= 60){
					timeString.append(timeFinish / 60).append("分");
					timeFinish = timeFinish % 60;
					if(timeFinish > 0){
						timeString.append(timeFinish).append("秒");
					}
				}else
				{
					timeString.append(timeFinish % 60).append("秒");
				}
			}
			else{
				if (timeFinish >= 60){
					timeString.append(timeFinish / 60).append("分");
					timeFinish = timeFinish % 60;
					if(timeFinish > 0){
						timeString.append(timeFinish).append("秒");
					}
				}else{
					timeString.append(timeFinish % 60).append("秒");
				}
			}
		}
		return timeString.toString();
	}

	/**
	 * 根据时间戳秒数，获取年-月-日 时:分 字符串
	 * @param datetime
	 * @return
	 */
	public static String getYearDateTimeStr2(int datetime){
		Date date = new Date(datetime * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try{
			return formatter.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

    /**
     * 获取某一天的时间戳
     * @param datetime
     * @return
     */
	public static  Integer getDateBeginTimeStamp(Integer datetime){
        Date date = new Date(datetime * 1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dateStr = formatter.format(date);
            Date dateNew = formatter.parse(dateStr);
            return (int) (dateNew.getTime() / 1000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datetime;
    }

    /**
     * 获取第二天开始的时间戳
     * @return
     */
	public static Integer getNextDayBeginTimeStamp(){
	    Integer datetime = getTimeStamp() + 86400;

        return getDateBeginTimeStamp(datetime);
    }

    /**
     * 获取前一天开始的时间戳
     * @return
     */
    public static Integer getPreDayBeginTimeStamp(){
        Integer datetime = getTimeStamp() - 86400;
        return getDateBeginTimeStamp(datetime);
    }

	/**
	 * 把Date类型时间转换为秒数
	 * @param date
	 * @return
	 */
	public static Integer translateDateToTimeStamp(Date date){
		Integer time = new Integer(String.valueOf(date.getTime() / 1000L));

		return time;
	}


    /**
     * 从字符串获取日期时间戳
     * @param yyyyMMdd
     * @return
     */
	public static int getDateFromString(String yyyyMMdd){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try{
            return (int) (formatter.parse(yyyyMMdd).getTime()/1000L);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
