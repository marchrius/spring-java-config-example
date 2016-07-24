package com.hms.pro.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.BuildingDao;
import com.hms.pro.domain.Building;
import com.hms.pro.ui.RoomsUI;

@Repository
public class BuildingDaoImpl extends AbstractDaoImpl<Building, Integer> implements BuildingDao {

	public BuildingDaoImpl() {
		super(Building.class);
	}

	public List<Building> getBuildingsList(QueryResultBySateEnum bySateEnum) {
		Query query=getCurrentSession().createQuery("From Building b where b.isActive=:active");
		query.setParameter("active", bySateEnum.ordinal());
		return find(query);
	}

	
}
