package com.activiti.didi.util;
import org.apache.log4j.Logger;

public class LogUtil {

	// 将Log类封装成单实例的模式，独立于其他类。以后要用到日志的地方只要获得Log的实例就可以方便使用
	private static LogUtil logUtil;
	
	// 构造函数，用于初始化Logger配置需要的属性
	private LogUtil() {
	}
   
   /**
    * 公共日志记录
    * @return
    */
   public Logger CommonLog() {
       return Logger.getLogger("CommonLog");
   }
   
	/**
	 * 提供公共方法获取实例
	 * @return
	 */
	public static LogUtil getLoger() {

		if (logUtil != null) {

			return logUtil;
		} else {

			return new LogUtil();
		}
	}
}
