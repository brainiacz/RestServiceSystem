package com.dervan.module.model.dao;

import java.util.List;

public class PaymentRecord {
	private List<PartiGame> partiGame;
	private PayRepDtl payDetails;
	private Participant participant;
	
	public List<PartiGame> getPartiGame() {
		return partiGame;
	}
	public void setPartiGame(List<PartiGame> partiGame) {
		this.partiGame = partiGame;
	}
	public PayRepDtl getPayDetails() {
		return payDetails;
	}
	public void setPayDetails(PayRepDtl payDetails) {
		this.payDetails = payDetails;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	
}
