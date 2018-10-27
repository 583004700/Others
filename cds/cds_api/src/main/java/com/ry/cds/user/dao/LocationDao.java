package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.mapper.LocationMapper;

@Repository
public class LocationDao implements ILocationDao {
	@Autowired
	LocationMapper locationMapper;

	@Override
	public long getPrimaryByLocationCode(String locationCode) {
		return locationMapper.getPrimaryByLocationCode(locationCode);
	}
}