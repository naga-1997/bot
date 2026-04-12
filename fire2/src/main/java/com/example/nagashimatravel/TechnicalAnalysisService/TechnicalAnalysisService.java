package com.example.nagashimatravel.TechnicalAnalysisService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nagashimatravel.SignalCandle.SignalCandle;

@Service
public class TechnicalAnalysisService {

	public double calculateSMA(List<SignalCandle> candles, int period) {
		if (candles == null || candles.size() < period) {
			throw new IllegalArgumentException("SMA計算に必要なデータが不足しています。");
		}

		double sum = 0.0;
		for (int i = candles.size() - period; i < candles.size(); i++) {
			sum += candles.get(i).getClose();
		}
		return sum / period;
	}

	public double calculateAverageVolume(List<SignalCandle> candles, int period) {
		if (candles == null || candles.size() < period) {
			throw new IllegalArgumentException("平均出来高計算に必要なデータが不足しています。");
		}

		double sum = 0.0;
		for (int i = candles.size() - period; i < candles.size(); i++) {
			sum += candles.get(i).getVolume();
		}
		return sum / period;
	}

	public double calculateRSI(List<SignalCandle> candles, int period) {
		if (candles == null || candles.size() <= period) {
			throw new IllegalArgumentException("RSI計算に必要なデータが不足しています。");
		}

		double gain = 0.0;
		double loss = 0.0;

		for (int i = candles.size() - period; i < candles.size(); i++) {
			double change = candles.get(i).getClose() - candles.get(i - 1).getClose();

			if (change > 0) {
				gain += change;
			} else {
				loss += Math.abs(change);
			}
		}

		double averageGain = gain / period;
		double averageLoss = loss / period;

		if (averageLoss == 0) {
			return 100.0;
		}

		double rs = averageGain / averageLoss;
		return 100 - (100 / (1 + rs));
	}
}