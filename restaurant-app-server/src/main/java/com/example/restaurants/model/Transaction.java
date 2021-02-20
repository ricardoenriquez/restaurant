package com.example.restaurants.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.restaurants.model.audit.UserDateAudit;

@Entity
@Table(name = "transaction")
public class Transaction extends UserDateAudit {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date transactionDate;
    
    private String transactionDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "transaction_date")
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

    @Column(name = "transaction_descripcion")
	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
    
    
}
