package com.hms.pro.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.CandidateDao;
import com.hms.pro.domain.Candidate;
import com.hms.pro.ui.CandidateUI;

@Repository
public class CandidateDaoImpl extends AbstractDaoImpl<Candidate, Integer> implements CandidateDao{

	public CandidateDaoImpl() {
		super(Candidate.class);
	}

	public List<CandidateUI> getCandidates(QueryResultBySateEnum bySateEnum, int buildingId) {
		Query query=getCurrentSession().createSQLQuery("SELECT c.candidate_id as candidateId, c.name as fullName, "
				+ "c.mobile_no as mobileNo, c.emergency_contact_no as emergencyContactNo, c.room as room, rt.room_category as "
				+ "roomCategory, c.candidate_fee as candidateFee, c.join_date as joinDate, c.vacation_flag as vacationFlag, "
				+ "c.vacation_date as vacationDate from candidate c join room r on "
				+ "r.room_id = c. room and r.building=:buildingId join room_type rt on rt.room_type_id = r.room_type where c.isActive=:active ");
		query.setParameter("active", bySateEnum.ordinal());
		query.setParameter("buildingId", buildingId);
		return (List<CandidateUI>) excuteQuery(query, CandidateUI.class);
	}
	
	public List<Candidate> getCandidates(QueryResultBySateEnum bySateEnum) {
		Query query=getCurrentSession().createQuery("from Candidate c where c.isActive=:active");
		query.setParameter("active",bySateEnum.ordinal());
		return query.list();
	}
	
	public int updateVacateData (QueryResultBySateEnum bySateEnum, int candidateId, Date vacateDate) {
		Query query = getCurrentSession().createQuery("update Candidate c set c.vacationDate=:vacateDate, c.vacationFlag=:vacateFlag where c.candidateId=:candidateId");
		query.setParameter("vacateDate", vacateDate);
		query.setParameter("candidateId", candidateId);
		query.setParameter("vacateFlag", bySateEnum.ordinal());
		return  query.executeUpdate();
	}
	
	public Candidate getCandidateDetails (QueryResultBySateEnum bySateEnum, int candidateId) {
		Query query = getCurrentSession().createQuery("from Candidate c where c.candidateId=:candidateId and c.isActive=:active");
		query.setParameter("candidateId", candidateId);
		query.setParameter("active", bySateEnum.ordinal());
		if (CollectionUtils.isEmpty(query.list())) {
			return null;
		}
		return (Candidate) query.list().get(0);
	}

}
