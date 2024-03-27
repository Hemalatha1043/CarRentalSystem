package com.carrentalsystem.controller;

import com.carrentalsystem.dao.ICarLeaseRepositoryImpl;
import com.carrentalsystem.entity.Payment;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PaymentService {
	private ICarLeaseRepositoryImpl paymentDao;

	public PaymentService() {
		this.paymentDao = new ICarLeaseRepositoryImpl();
	}

	public void recordPayment(int paymentID, int leaseID, float amount, Date paymentDate) {
		try {
			paymentDao.recordPayment(paymentID, leaseID, amount, paymentDate);
			System.out.println("Payment recorded successfully.");
		} catch (SQLException e) {
			System.err.println("Error recording payment: " + e.getMessage());
		}
	}

	public void retrievePaymentHistory(int customerID) {
		try {
			List<Payment> paymentHistory = paymentDao.retrievePaymentHistory(customerID);
			System.out.println("Payment History for Customer ID: " + customerID);
			for (Payment payment : paymentHistory) {
				System.out.println(payment.toString());
			}
		} catch (SQLException e) {
			System.err.println("Error retrieving payment history: " + e.getMessage());
		}
	}

	public double calculateTotalRevenue() {
		try {
			double totalRevenue = paymentDao.calculateTotalRevenue();
			System.out.println("Total Revenue from Payments: $" + totalRevenue);
			return totalRevenue;
		} catch (SQLException e) {
			System.err.println("Error calculating total revenue: " + e.getMessage());
			return 0.0;
		}
	}
}
