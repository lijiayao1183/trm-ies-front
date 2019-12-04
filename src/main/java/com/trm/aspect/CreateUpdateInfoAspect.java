package com.trm.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.trm.util.SessionUtil;

/**
 * @author Vani
 * add update and create info when update or create any object with ASPECT
 *
 */
@Component("createUpdateInfoAspect")
@Aspect
@Order(10)
public class CreateUpdateInfoAspect {
	
	private static Logger logger = LoggerFactory.getLogger(CreateUpdateInfoAspect.class);
	
	@Pointcut(value="execution(* com.trm.dao..*.create*(..))")
	public void createInfoAspect(){}
	
	@Pointcut(value="execution(* com.trm.dao..*.modify*(..))")
	public void updateInfoAspect(){}
	
	@Before(value="createInfoAspect()")
    public void beforeCreateInfo(JoinPoint pjp) throws Exception {
		
		logger.debug("EnterInto beforeCreateInfo");
		
		Object[] objectArray = pjp.getArgs();
		if(objectArray.length!=0){
			
			Object obj = objectArray[0];
			Date date = new Date();
			String username = SessionUtil.getUsernameFromSession();
			Method m1, m2, m3, m4;
			try {

				m1 = obj.getClass().getMethod("setCreator", String.class);
				m2 = obj.getClass().getMethod("setCreateTime", Date.class);

				m3 = obj.getClass().getMethod("setUpdater", String.class);
				m4 = obj.getClass().getMethod("setUpdateTime", Date.class);

				m1.invoke(obj, username);
				m2.invoke(obj, date);
				m3.invoke(obj, username);
				m4.invoke(obj, date);
				
			} catch (Exception e) {
				logger.error("ErrorIn beforeCreateInfo " + e.getMessage());
				e.printStackTrace();
				throw e;
				
			} 
		}
		logger.debug("ExitFrom beforeCreateInfo");
	}
	
	
	@Before(value="updateInfoAspect()")
    public void beforeUpdateInfo(JoinPoint pjp) throws Exception {
		
		logger.debug("EnterInto beforeUpdateInfo");
		
		Object[] objectArray = pjp.getArgs();
		if(objectArray.length!=0){
			Object obj = objectArray[0];
			Date date = new Date();
			String username = SessionUtil.getUsernameFromSession();
			Method m1, m2;
			try{
				m1 = obj.getClass().getMethod("setUpdater", String.class);
				m2 = obj.getClass().getMethod("setUpdateTime", Date.class);

				m1.invoke(obj, username);
				m2.invoke(obj, date);
			} catch (Exception e) {
				logger.error("ErrorIn beforeUpdateInfo " + e.getMessage());
				e.printStackTrace();
				throw e;
			} 
			
		}
		
		logger.debug("ExitFrom beforeUpdateInfo");
	}
}
