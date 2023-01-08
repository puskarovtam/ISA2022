package com.isa.transfuzija.enums;

import java.time.format.DateTimeFormatter;

public enum FormatDateTime {

	DD_MM_YYYY(DateTimeFormatter.ofPattern("dd.MM.uuuu hh:mm"), "DD.MM.YYYY HH:MM");

	private DateTimeFormatter formatter;
	private String displayName;

	FormatDateTime(DateTimeFormatter formatter, String displayName) {
		this.formatter = formatter;
		this.displayName = displayName;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "LocalDateFormat{" + "displayName='" + this.displayName + '\'' + '}';
	}

}
