package com.hms.pro.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.RoomTypeDao;
import com.hms.pro.domain.RoomType;
import com.hms.pro.ui.RoomTypeUI;
import com.hms.pro.ui.RoomsUI;

@Repository
public class RoomTypeDaoImpl extends AbstractDaoImpl<RoomType, Integer> implements RoomTypeDao{

	static final Logger LOGGER = LoggerFactory.getLogger(RoomTypeDaoImpl.class);
	
	public RoomTypeDaoImpl() {
		super(RoomType.class);
	}

	public List<RoomType> getRoomTypes(QueryResultBySateEnum roomTypeEnum) {
		Query query=getCurrentSession().createQuery("from RoomType rt where rt.isActive=:isActive");
		query.setParameter("isActive",roomTypeEnum.ordinal());
		LOGGER.debug("Room Type by active flag :"+roomTypeEnum.ordinal());
		return find(query);
	}

	public List<RoomsUI> getRooms(QueryResultBySateEnum bySateEnum,
			int roomType, int buildingId, int floorId) {
		Query query=getCurrentSession().createSQLQuery("SELECT r.room_id as roomId, r.room_name as roomName FROM hms.room r JOIN floor f on f.floor_id=r.floor where  r.room_type=:roomType and r.building=:buildingId and r.floor=:floorId and r.isActive=:active ");
		query.setParameter("roomType", roomType);
		query.setParameter("buildingId", buildingId);
		query.setParameter("floorId", floorId);
		query.setParameter("active", bySateEnum.ordinal());
		return (List<RoomsUI>) excuteQuery(query, RoomsUI.class);
	}

	public List<RoomTypeUI> getRoomTypesOfBuilding(Integer buildingId) {
		
		Query query=getCurrentSession().createSQLQuery("SELECT rt.room_type_id as roomTypeId, rt.room_category as roomCategroy FROM hms.room r join room_type rt on rt.room_type_id = r.room_type where r.building=:buildingId group by r.room_type");
		query.setParameter("buildingId", buildingId);
		return (List<RoomTypeUI>) excuteQuery(query, RoomTypeUI.class);
	}


	
}
