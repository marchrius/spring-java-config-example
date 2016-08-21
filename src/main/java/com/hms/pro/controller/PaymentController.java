package com.hms.pro.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Building;
import com.hms.pro.domain.Candidate;
import com.hms.pro.domain.Payment;
import com.hms.pro.service.HMSService;
import com.hms.pro.ui.CandidateUI;

@Controller
public class PaymentController {
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private HMSService hmsService;

	@RequestMapping(value = "/auth/payments")
	public String showPaymentPage(Model model) {
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("buildings", buildings);
		
		List<Candidate> payCandidates = hmsService.getPaymentsOfCandidates(
				QueryResultBySateEnum.ACTIVE, new Date(), false); // today and
																	// follwed
																	// dates
		List<Candidate> delayed = hmsService.getPaymentsOfCandidates(
				QueryResultBySateEnum.ACTIVE, new Date(), true); // delayed pays
		
		List<Candidate> pendings=hmsService.getPaymentsOfCandidates(QueryResultBySateEnum.ACTIVE,0); // buildingId
		model.addAttribute("todayPayments", payCandidates);
		model.addAttribute("pendingPays", delayed);
		model.addAttribute("pendings", pendings);
		return "paymentPage";
	}

	@RequestMapping(value="/auth/payments/{buildingId}")
	public String showPaymentPage(Model model, @PathVariable int buildingId){
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("buildings", buildings);
		
		List<Candidate> payCandidates = hmsService.getPaymentsOfCandidates(
				QueryResultBySateEnum.ACTIVE, new Date(), false,buildingId); // today and
																	// follwed
																	// dates
		List<Candidate> pendingPays = hmsService.getPaymentsOfCandidates(
				QueryResultBySateEnum.ACTIVE, new Date(), true, buildingId); // pending pays
		model.addAttribute("todayPayments", payCandidates);
		model.addAttribute("pendingPays", pendingPays);
		model.addAttribute("buildingId", buildingId);
		return "paymentPage";
	}
	
	@RequestMapping(value = "/auth/paymentDetails/{candidateId}", method = RequestMethod.GET)
	@ResponseBody
	public CandidateUI getPaymentDetails(@PathVariable int candidateId) {
		return hmsService.getPaymentDetails(candidateId);
	}

	@RequestMapping(value = "/auth/SubmitDue")
	@ResponseBody
	public HttpEntity<String> submitFee(@RequestParam int feeAmount,
			@RequestParam int paidAmount, @RequestParam String dueDate,
			@RequestParam String paymentStatus, @RequestParam int cid) throws ParseException {
		int dueAmount = 0;
		if (feeAmount >= paidAmount) {
			dueAmount = feeAmount - paidAmount;
		}
		Set<Payment> payments=new LinkedHashSet<Payment>();
		Payment payment=new Payment();
		payment.setPaidAmount(paidAmount);
		payment.setPaidDate(new Date());
		Candidate candidate=hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, cid);		
		Calendar c = Calendar.getInstance();
		Date canidatePaymentDate=candidate.getDueDate();
		c.setTime(canidatePaymentDate);
		c.add(Calendar.DATE,30);
		candidate.setDueDate(c.getTime());
		
		if ("DONE".equals(paymentStatus)) {
			candidate.setPaymentStatus("DONE");
			LOGGER.debug("NEXT DUE :"+c.getTime());
			candidate.setDueAmount(candidate.getCandidateFee());
			
		}else{
			candidate.setPaymentStatus("Pending");
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			candidate.setPendingDueDate(dateFormat.parse(dueDate));
			candidate.setDueAmount(dueAmount);
		}
		payment.setCandidate(candidate);
		payments.add(payment);
		candidate.setPayments(payments);
		
		
		hmsService.saveCandidate(candidate);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
