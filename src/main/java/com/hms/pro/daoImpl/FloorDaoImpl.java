package com.hms.pro.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.FloorDao;
import com.hms.pro.domain.Floor;
import com.hms.pro.ui.RoomsUI;

@Repository
public class FloorDaoImpl extends AbstractDaoImpl<Floor, Integer> implements FloorDao{

	public FloorDaoImpl() {
		super(Floor.class);
	}

	public List<Floor> getFloors(QueryResultBySateEnum bySateEnum) {
		Query query=getCurrentSession().createQuery("from Floor f where f.isActive=:active");
		query.setParameter("active", bySateEnum.ordinal());
		return find(query);
	}

	public List<RoomsUI> getFloors(QueryResultBySateEnum bySateEnum,
			int roomType, int buildingId) {
		Query query=getCurrentSession().createSQLQuery("SELECT f.floor_id as floorId, f.floor_name as floorName FROM hms.room r JOIN floor f on f.floor_id=r.floor where  r.room_type=:roomType and r.building=:buildingId and r.isActive=:active group by floor_id");
		query.setParameter("roomType", roomType);
		query.setParameter("buildingId", buildingId);
		query.setParameter("active", bySateEnum.ordinal());
		return (List<RoomsUI>) excuteQuery(query, RoomsUI.class);
	}

}
