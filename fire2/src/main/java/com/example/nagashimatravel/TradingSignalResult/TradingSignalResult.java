package com.example.nagashimatravel.TradingSignalResult;

public class TradingSignalResult {
	private final boolean shouldNotify;
	private final String message;

	public TradingSignalResult(boolean shouldNotify, String message) {
		this.shouldNotify = shouldNotify;
		this.message = message;
	}

	public boolean isShouldNotify() {
		return shouldNotify;
	}

	public String getMessage() {
		return message;
	}
}