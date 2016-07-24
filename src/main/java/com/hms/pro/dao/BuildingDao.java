package com.hms.pro.dao;

import java.util.List;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Building;
import com.hms.pro.ui.RoomsUI;

public interface BuildingDao extends AbstractDao<Building, Integer> {

	List<Building> getBuildingsList(QueryResultBySateEnum bySateEnum);

 }
