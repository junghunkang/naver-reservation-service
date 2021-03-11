package kr.or.connect.reservation.dto;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


import kr.or.connect.reservation.dto.Price;

public class ReservationInfo {
	
	private int id;
	private int userId;
	private int productId;
	private int cancelFlag;
	private int displayInfoId;
	private Date reservationDate;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private List<Price> prices;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int diplayInfoId) {
		this.displayInfoId = diplayInfoId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	@Override
	public String toString() {
		return "ReservationInfo [Id=" +id + ", productId=" + productId + ", cancelFlag=" + cancelFlag
				+ ", displayInfoId=" + displayInfoId + ", reservationDate=" + reservationDate + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", prices=" + prices + "]";
	}
	
	
	
	
	
}
