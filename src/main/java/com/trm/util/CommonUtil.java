package com.trm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.common.util.StringHelper;

import com.trm.constants.SystemConstants;

public class CommonUtil {

	public static boolean isAjaxRequest(HttpServletRequest request) {

		String ajaxIndicator = request.getParameter(SystemConstants.AJAX_INDICATOR);
		if (null == ajaxIndicator || "".equals(ajaxIndicator.trim())) {
			return false;
		}
		return true;
	}

	public static List<String> sortListwithASCOrder(List<String> strToOrder) {

		if (null != strToOrder) {
			Object[] obj = strToOrder.toArray();
			Arrays.sort(obj);
			List<String> list = new ArrayList<String>();
			for (Object str : obj) {
				list.add(str.toString());
			}
			return list;
		}
		return null;

	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof List)) {
			return ((List) obj).size() == 0;
		}
		if ((obj instanceof String)) {
			return ((String) obj).trim().equals("");
		}
		return false;
	}
	
	/**
	 * 任意字符串为空返回true
	 * @Title isEmpty
	 * @param parameter 可传多个
	 * @return 参数说明
	 * @return boolean 返回类型
	 * @throws
	 * @see
	 * @author huyuanbo
	 */
	public static boolean isEmpty(String... parameter) {
		int index = 0;
		while(index < parameter.length){
			if(StringHelper.isEmpty(parameter[index])){
				return true;
			};
			index++;
		}
		return false;
	}
	
	/**
	 * 去除字符串内的空格包含中文空格
	 * @param str
	 * @return 参数说明
	 * @author huyuanbo
	 */
	public static String trim(String str){
        str = str.replaceAll("\\s*", "");
        str = str.replaceAll("　", "");
        return str;
    }
	
	/**
     * 检查非空业务参数
     * @param reqParams 任意多个需检查非空的业务参数
     * @param reqParams
     * @return Null false；NotNull true
     * @author huyuanbo
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNotNull(Object... reqParams) {
        boolean checkFlag = true;
        if (reqParams != null) {
            for (Object obj : reqParams) {
                if (obj == null) {
                    checkFlag = false;
                    break;
                }
                if (obj instanceof String && StringUtils.isBlank((String) obj)) {
                    checkFlag = false;
                    break;
                }
                if (obj instanceof List && ((List) obj).size() == 0) {
                    checkFlag = false;
                    break;
                }
            }
        } else {
            checkFlag = false;
        }
        return checkFlag;
    }
}
