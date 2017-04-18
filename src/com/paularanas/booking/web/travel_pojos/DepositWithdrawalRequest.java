package com.paularanas.booking.web.travel_pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class DepositWithdrawalRequest {
	
	private String accountId;
	
	private MonetaryAmount monetaryAmount;
	
	public DepositWithdrawalRequest(String accountId, MonetaryAmount monetaryAmount) {
		this.accountId = accountId;
		this.monetaryAmount = monetaryAmount;
	}

	public DepositWithdrawalRequest() {
		super();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public MonetaryAmount getMonetaryAmount() {
		return monetaryAmount;
	}

	public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
		this.monetaryAmount = monetaryAmount;
	}

	@Override
	public String toString() {
		return "DepositWithdrawalRequest [accountId=" + accountId + ", monetaryAmount=" + monetaryAmount + "]";
	}

	
	
	

}
