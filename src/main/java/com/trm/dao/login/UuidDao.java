package com.trm.dao.login;

import com.trm.entity.TrmUuid;
import com.trm.model.login.Uuid;

/**
 * @description UUID生成
 * @author zhaosimiao 
 * @date 2017-10-9 10:12:16
 */
public interface UuidDao {
	
	public TrmUuid checkUsername(String username);
	
	public boolean insertUuid(TrmUuid entity);
	
	public boolean updateUuid(Uuid uuid);
	
	public TrmUuid getUuid(String code);
	
}
