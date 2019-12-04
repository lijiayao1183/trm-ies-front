package com.trm.model.news;

import com.trm.model.common.CommonListResponse;

/**
 * 泛型列表查询
 * @author <a href="mailto:humorbeau@163.com">胡渊博</a>
 * @date 2017年1月9日
 * @version 1.0
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class NewsListResponse <T> extends CommonListResponse implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private T picturesObject;

    public T getPicturesObject() {
        return picturesObject;
    }

    public void setPicturesObject(T picturesObject) {
        this.picturesObject = picturesObject;
    }
	
}
