package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {

	private BigDecimal ammount;
	private LocalDateTime from;
	private LocalDateTime to;
	private boolean active;
	private boolean processed;
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
	
	
}
