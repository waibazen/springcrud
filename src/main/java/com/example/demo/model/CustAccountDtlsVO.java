package com.example.demo.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import com.ctl.epp.web.authpmt.json.PaymentArrangement;
// import com.ctl.epp.web.common.json.AddressDetails;
// import com.ctl.epp.web.cpi.json.BanMigrationInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity


@Table(name="CustAccountDtlsVO")
public class CustAccountDtlsVO {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
	// Customer Information
	private String firstName;
	public CustAccountDtlsVO() {
    }

    private String lastName;
	private String businessName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	private String email;
	private String mobileNumber;
	private String paymentType;
	private String amountDue;
	private String adjustedAmount;
	private String pendingAmount;
	private String billingAccountId;
	private String billingAccountCd;
	private String billingAccountRegion;
	private String customerType;
	private Boolean isAutopayEnrolled;
	private String autopayEnrollDate;
	private String autoPaymentMethod;
	//private List<EntityVO> entityList;
	private String userId;
	private String convenienceFeeAmt;
	private String accountFound;
	private String orderNumber;
	//private List<PaymentArrangementsVO> paymentArrangementsList;
	//private PaymentArrangement[] paymentArrangementsArray;
	private String totalPmtAmount;
	private String addressType;
	// AccountLookUpResponse vendor customerId
	private String invariantID;
	private String treatmentSystemCd;
	private String accountStatus;
	private boolean achAllowedFlag;
	private boolean cardAllowedFlag;
	private String creditClass;
	private String amountDueDate;
	private String pastDueAmount;
	private String lastBillDate;
	private String lastBillAmount;
	private String lastPaymentAmount;
	private String lastPaymentDate;
	private String currentCharges;
	private String countryCd;
	//private BanMigrationInfo banMigrationInfo;
	// for new pmt args flow
	private String nextCycleStartDate;
	//private AddressDetails serviceAddress;
	String collectionType;

	private String purlDeliveryMethod;
	private String purlDeliveryMethodValue;
	private String currencyCode;
	private String billDeliveryMethod;
	private String cmmcFlag;


	public String getCurrentCharges() {
		return currentCharges;
	}

	public void setCurrentCharges(String currentCharges) {
		this.currentCharges = currentCharges;
	}

	public String getLastPaymentAmount() {
		return lastPaymentAmount;
	}

	public void setLastPaymentAmount(String lastPaymentAmount) {
		this.lastPaymentAmount = lastPaymentAmount;
	}

	public String getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public String getPastDueAmount() {
		return pastDueAmount;
	}

	public void setPastDueAmount(String pastDueAmount) {
		this.pastDueAmount = pastDueAmount;
	}

	public String getLastBillDate() {
		return lastBillDate;
	}

	public void setLastBillDate(String lastBillDate) {
		this.lastBillDate = lastBillDate;
	}

	public String getLastBillAmount() {
		return lastBillAmount;
	}

	public void setLastBillAmount(String lastBillAmount) {
		this.lastBillAmount = lastBillAmount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAccountFound() {
		return accountFound;
	}

	public void setAccountFound(String accountFound) {
		this.accountFound = accountFound;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}

	public String getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(String adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	public String getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(String pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public String getBillingAccountId() {
		return billingAccountId;
	}

	public void setBillingAccountId(String billingAccountId) {
		this.billingAccountId = billingAccountId;
	}

	public String getBillingAccountCd() {
		return billingAccountCd;
	}

	public void setBillingAccountCd(String billingAccountCd) {
		this.billingAccountCd = billingAccountCd;
	}

	public String getAutopayEnrollDate() {
		return autopayEnrollDate;
	}

	public void setAutopayEnrollDate(String autopayEnrollDate) {
		this.autopayEnrollDate = autopayEnrollDate;
	}

	public String getAutoPaymentMethod() {
		return autoPaymentMethod;
	}

	public void setAutoPaymentMethod(String autoPaymentMethod) {
		this.autoPaymentMethod = autoPaymentMethod;
	}

	public String getBillingAccountRegion() {
		return billingAccountRegion;
	}

	public void setBillingAccountRegion(String billingAccountRegion) {
		this.billingAccountRegion = billingAccountRegion;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Boolean getIsAutopayEnrolled() {
		return isAutopayEnrolled;
	}

	public void setIsAutopayEnrolled(Boolean isAutopayEnrolled) {
		this.isAutopayEnrolled = isAutopayEnrolled;
	}

	// public List<EntityVO> getEntityList() {
	// 	return entityList;
	// }

	// public void setEntityList(List<EntityVO> entityList) {
	// 	this.entityList = entityList;
	// }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConvenienceFeeAmt() {
		return convenienceFeeAmt;
	}

	public void setConvenienceFeeAmt(String convenienceFeeAmt) {
		this.convenienceFeeAmt = convenienceFeeAmt;
	}

	// public List<PaymentArrangementsVO> getPaymentArrangementsList() {
	// 	return paymentArrangementsList;
	// }

	// public void setPaymentArrangementsList(List<PaymentArrangementsVO> paymentArrangementsList) {
	// 	this.paymentArrangementsList = paymentArrangementsList;
	// }

	public String getTotalPmtAmount() {
		return totalPmtAmount;
	}

	public void setTotalPmtAmount(String totalPmtAmount) {
		this.totalPmtAmount = totalPmtAmount;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getInvariantID() {
		return invariantID;
	}

	public void setInvariantID(String invariantID) {
		this.invariantID = invariantID;
	}

	public String getTreatmentSystemCd() {
		return treatmentSystemCd;
	}

	public void setTreatmentSystemCd(String treatmentSystemCd) {
		this.treatmentSystemCd = treatmentSystemCd;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public boolean isAchAllowedFlag() {
		return achAllowedFlag;
	}

	public void setAchAllowedFlag(boolean achAllowedFlag) {
		this.achAllowedFlag = achAllowedFlag;
	}

	public boolean isCardAllowedFlag() {
		return cardAllowedFlag;
	}

	public void setCardAllowedFlag(boolean cardAllowedFlag) {
		this.cardAllowedFlag = cardAllowedFlag;
	}

	public String getCreditClass() {
		return creditClass;
	}

	public void setCreditClass(String creditClass) {
		this.creditClass = creditClass;
	}

	public String getAmountDueDate() {
		return amountDueDate;
	}

	public void setAmountDueDate(String amountDueDate) {
		this.amountDueDate = amountDueDate;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	// public BanMigrationInfo getBanMigrationInfo() {
	// 	return banMigrationInfo;
	// }

	// public void setBanMigrationInfo(BanMigrationInfo banMigrationInfo) {
	// 	this.banMigrationInfo = banMigrationInfo;
	// }

	// public PaymentArrangement[] getPaymentArrangementsArray() {
	// 	return paymentArrangementsArray;
	// }

	// public void setPaymentArrangementsArray(PaymentArrangement[] paymentArrangementsArray) {
	// 	this.paymentArrangementsArray = paymentArrangementsArray;
	// }

	public String getNextCycleStartDate() {
		return nextCycleStartDate;
	}

	public void setNextCycleStartDate(String nextCycleStartDate) {
		this.nextCycleStartDate = nextCycleStartDate;
	}

	// public AddressDetails getServiceAddress() {
	// 	return serviceAddress;
	// }

	// public void setServiceAddress(AddressDetails serviceAddress) {
	// 	this.serviceAddress = serviceAddress;
	// }

	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	
	public String getPurlDeliveryMethod() {
		return purlDeliveryMethod;
	}

	public void setPurlDeliveryMethod(String purlDeliveryMethod) {
		this.purlDeliveryMethod = purlDeliveryMethod;
	}

	public String getPurlDeliveryMethodValue() {
		return purlDeliveryMethodValue;
	}

	public void setPurlDeliveryMethodValue(String purlDeliveryMethodValue) {
		this.purlDeliveryMethodValue = purlDeliveryMethodValue;
	}
	

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBillDeliveryMethod() {
		return billDeliveryMethod;
	}

	public void setBillDeliveryMethod(String billDeliveryMethod) {
		this.billDeliveryMethod = billDeliveryMethod;
	}

	public String getCmmcFlag() {
		return cmmcFlag;
	}

	public void setCmmcFlag(String cmmcFlag) {
		this.cmmcFlag = cmmcFlag;
	}
}


