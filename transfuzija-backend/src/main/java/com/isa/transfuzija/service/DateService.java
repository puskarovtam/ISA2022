package com.isa.transfuzija.service;

import java.time.LocalDateTime;

public interface DateService {

	Boolean doDatesOverlap(LocalDateTime date1, LocalDateTime date2);

}
