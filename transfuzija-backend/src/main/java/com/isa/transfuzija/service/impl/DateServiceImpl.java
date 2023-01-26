package com.isa.transfuzija.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.isa.transfuzija.service.DateService;

@Service
public class DateServiceImpl implements DateService {

	@Override
	public Boolean doDatesOverlap(LocalDateTime date1, LocalDateTime date2) {
		return !(date1.isBefore(date2) || date2.isBefore(date1));
	}

}
