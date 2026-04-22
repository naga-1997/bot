package com.example.nagashimatravel.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "trading_signals")
public class TradingSignal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String symbol;

	@Column(nullable = false, length = 10)
	private String signalType;

	@Column(precision = 18, scale = 8)
	private BigDecimal price;

	@Column(precision = 18, scale = 8)
	private BigDecimal smaShort;

	@Column(precision = 18, scale = 8)
	private BigDecimal smaLong;

	@Column(precision = 10, scale = 4)
	private BigDecimal rsi;

	@Column(precision = 18, scale = 8)
	private BigDecimal currentVolume;

	@Column(precision = 18, scale = 8)
	private BigDecimal avgVolume;

	private Boolean condition1;
	private Boolean condition2;
	private Boolean condition3;

	@Lob
	private String message;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSignalType() {
		return signalType;
	}

	public void setSignalType(String signalType) {
		this.signalType = signalType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSmaShort() {
		return smaShort;
	}

	public void setSmaShort(BigDecimal smaShort) {
		this.smaShort = smaShort;
	}

	public BigDecimal getSmaLong() {
		return smaLong;
	}

	public void setSmaLong(BigDecimal smaLong) {
		this.smaLong = smaLong;
	}

	public BigDecimal getRsi() {
		return rsi;
	}

	public void setRsi(BigDecimal rsi) {
		this.rsi = rsi;
	}

	public BigDecimal getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(BigDecimal currentVolume) {
		this.currentVolume = currentVolume;
	}

	public BigDecimal getAvgVolume() {
		return avgVolume;
	}

	public void setAvgVolume(BigDecimal avgVolume) {
		this.avgVolume = avgVolume;
	}

	public Boolean getCondition1() {
		return condition1;
	}

	public void setCondition1(Boolean condition1) {
		this.condition1 = condition1;
	}

	public Boolean getCondition2() {
		return condition2;
	}

	public void setCondition2(Boolean condition2) {
		this.condition2 = condition2;
	}

	public Boolean getCondition3() {
		return condition3;
	}

	public void setCondition3(Boolean condition3) {
		this.condition3 = condition3;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
