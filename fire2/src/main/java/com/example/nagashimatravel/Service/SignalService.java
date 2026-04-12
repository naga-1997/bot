package com.example.nagashimatravel.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nagashimatravel.SignalCandle.SignalCandle;
import com.example.nagashimatravel.TechnicalAnalysisService.TechnicalAnalysisService;
import com.example.nagashimatravel.TradingSignalResult.TradingSignalResult;

@Service
public class SignalService {

	private final TechnicalAnalysisService technicalAnalysisService;

	public SignalService(TechnicalAnalysisService technicalAnalysisService) {
		this.technicalAnalysisService = technicalAnalysisService;
	}

	public TradingSignalResult checkBuySignal(String symbol, List<SignalCandle> candles) {
		double shortSma = technicalAnalysisService.calculateSMA(candles, 5);
		double longSma = technicalAnalysisService.calculateSMA(candles, 25);
		double rsi = technicalAnalysisService.calculateRSI(candles, 14);
		double avgVolume = technicalAnalysisService.calculateAverageVolume(candles, 20);
		double currentVolume = candles.get(candles.size() - 1).getVolume();
		double currentPrice = candles.get(candles.size() - 1).getClose();

		boolean condition1 = shortSma > longSma;
		boolean condition2 = rsi >= 50 && rsi < 70;
		boolean condition3 = currentVolume > avgVolume;

		if (condition1 && condition2 && condition3) {
			String message = """
					【買いシグナル検知】
					銘柄: %s
					現在価格: %.2f
					5SMA: %.2f
					25SMA: %.2f
					RSI14: %.2f
					現在出来高: %.2f
					平均出来高20: %.2f

					条件:
					① 短期MA > 長期MA
					② RSIが50以上70未満
					③ 出来高が平均超え
					""".formatted(symbol, currentPrice, shortSma, longSma, rsi, currentVolume, avgVolume);

			return new TradingSignalResult(true, message);
		}

		return new TradingSignalResult(false, "条件未達");
	}
}