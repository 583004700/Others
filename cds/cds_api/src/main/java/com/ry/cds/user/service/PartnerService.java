package com.ry.cds.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.Partner;
import com.ry.cds.user.dao.IPartnerDao;
import com.ry.cds.utils.ListHelper;
import com.ry.cds.utils.ListHelper.IMapConvert;

@Service
public class PartnerService implements IPartnerService {
	@Autowired
	private IPartnerDao partnerDao;

	@Cacheable(value = "partners")
	@Override
	public Map<String, String> partnerKeySecretMap() {
		List<Partner> partnerList = partnerDao.partners();
		if (ListHelper.isNotEmpty(partnerList)) {
			return ListHelper.convert2Map(partnerList, new IMapConvert<Partner, String, String>() {
				@Override
				public String getKey(Partner o) {

					return o.getPartnerKey();
				}

				@Override
				public String getValue(Partner o) {
					return o.getPartnerSecret();
				}
			});
		}
		return null;
	}

	@Override
	public String getSecretByKey(String key) {
		
		String secret = null;
		Map<String, String> map = this.partnerKeySecretMap();
		if (null != map && map.containsKey(key)) {
			secret = map.get(key);
		}
		return secret;
	}
}