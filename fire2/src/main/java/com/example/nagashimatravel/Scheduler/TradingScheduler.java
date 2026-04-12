package com.example.nagashimatravel.Scheduler;

/*
 * 定期実行でスキャンする。
 */

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.nagashimatravel.Service.LineMessagingService;
import com.example.nagashimatravel.Service.SignalService;
import com.example.nagashimatravel.dto.SignalCandle;
import com.example.nagashimatravel.dto.TradingSignalResult;

@Component
public class TradingScheduler {

	private final SignalService signalService;
	private final LineMessagingService lineMessagingService;

	public TradingScheduler(SignalService signalService,
			LineMessagingService lineMessagingService) {
		this.signalService = signalService;
		this.lineMessagingService = lineMessagingService;
	}

	@Scheduled(fixedRate = 60000)
	public void scanMarket() {
		List<SignalCandle> candles = List.of(
				new SignalCandle(100, 1000),
				new SignalCandle(101, 1100),
				new SignalCandle(102, 1200),
				new SignalCandle(103, 1500),
				new SignalCandle(104, 1300),
				new SignalCandle(105, 1600),
				new SignalCandle(106, 1700),
				new SignalCandle(107, 1800),
				new SignalCandle(108, 2200),
				new SignalCandle(109, 2100),
				new SignalCandle(110, 2000),
				new SignalCandle(111, 2300),
				new SignalCandle(112, 2400),
				new SignalCandle(113, 2600),
				new SignalCandle(114, 2500),
				new SignalCandle(115, 2700),
				new SignalCandle(116, 2900),
				new SignalCandle(117, 3000),
				new SignalCandle(118, 3100),
				new SignalCandle(119, 3200),
				new SignalCandle(120, 3300),
				new SignalCandle(121, 3400),
				new SignalCandle(122, 3600),
				new SignalCandle(123, 3700),
				new SignalCandle(124, 4000));

		TradingSignalResult result = signalService.checkBuySignal("BTCUSDT", candles);

		if (result.isShouldNotify()) {
			lineMessagingService.pushMessage(result.getMessage());
		}
	}
}