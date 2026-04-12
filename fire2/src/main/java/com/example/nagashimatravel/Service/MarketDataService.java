package com.example.nagashimatravel.Service;

/*
 * 今はダミーデータを返す。
 * あとでここだけ API 接続に差し替えればいい。
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nagashimatravel.dto.SignalCandle;

@Service
public class MarketDataService {

	public List<SignalCandle> getRecentCandles(String symbol) {
		List<SignalCandle> candles = new ArrayList<>();

		candles.add(new SignalCandle(100, 1000));
		candles.add(new SignalCandle(101, 1100));
		candles.add(new SignalCandle(102, 1200));
		candles.add(new SignalCandle(103, 1300));
		candles.add(new SignalCandle(104, 1250));
		candles.add(new SignalCandle(105, 1400));
		candles.add(new SignalCandle(106, 1500));
		candles.add(new SignalCandle(107, 1450));
		candles.add(new SignalCandle(108, 1600));
		candles.add(new SignalCandle(109, 1700));
		candles.add(new SignalCandle(110, 1800));
		candles.add(new SignalCandle(111, 1750));
		candles.add(new SignalCandle(112, 1900));
		candles.add(new SignalCandle(113, 2100));
		candles.add(new SignalCandle(114, 2200));
		candles.add(new SignalCandle(115, 2300));
		candles.add(new SignalCandle(116, 2400));
		candles.add(new SignalCandle(117, 2350));
		candles.add(new SignalCandle(118, 2500));
		candles.add(new SignalCandle(119, 2600));
		candles.add(new SignalCandle(120, 2700));
		candles.add(new SignalCandle(121, 2800));
		candles.add(new SignalCandle(122, 2900));
		candles.add(new SignalCandle(123, 3000));
		candles.add(new SignalCandle(124, 3600));

		return candles;
	}
}