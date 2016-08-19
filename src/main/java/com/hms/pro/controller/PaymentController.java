package com.hms.pro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Candidate;
import com.hms.pro.service.HMSService;


@Controller
public class PaymentController {
	
	@Autowired
	private HMSService hmsService;
	
	@RequestMapping(value="/auth/payments")
	public String showPaymentPage(Model model){
		List<Candidate> payCandidates=hmsService.getPaymentsOfCandidates(QueryResultBySateEnum.ACTIVE,new Date(),false); // today and follwed dates
		List<Candidate> pendingPays=hmsService.getPaymentsOfCandidates(QueryResultBySateEnum.ACTIVE,new Date(),true); // pending pays
		model.addAttribute("todayPayments", payCandidates);
		model.addAttribute("pendingPays", pendingPays);
		return "paymentPage";
	}
}
