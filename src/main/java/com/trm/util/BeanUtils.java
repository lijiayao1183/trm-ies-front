package com.trm.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

/**
 * BeanCopy
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月9日
 * @version 1.0
 */
public abstract class BeanUtils extends org.springframework.beans.BeanUtils{
	/**
	 * 将给定的源bean的属性值复制到目标bean中。
	 * <p>注意：源和目标类不必匹配或甚至相互派生，只要属性匹配。源bean暴露的任何bean属性，但目标bean不会被忽略。
	 * <p>这只是一个方便的方法。对于更复杂的传输需求，考虑使用全BeanWrapper。
	 * <p>1.属性值为null时不做copy
	 * <p>2.属性类型为java.util.Date时转换java.sql.Timestamp
	 * @param source 源bean
	 * @param target 目标bean
	 * @throws BeansException
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							if(value instanceof Date){
								String dateStr = DictionaryGeneratePrefixUtil.getStringDateHH((Date)value);
								Timestamp time = TrmDateUtil.conFromStringToTimestampHH(dateStr);
								writeMethod.invoke(target, time);
							}else{
								writeMethod.invoke(target, value);
							}
						}
					} catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}
	
}
