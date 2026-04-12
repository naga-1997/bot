package com.example.nagashimatravel.controller;

/*
 * 手動確認用。
 * ブラウザや Postman で叩いて、通知前に動作確認できる。
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.nagashimatravel.Service.LineMessagingService;
import com.example.nagashimatravel.Service.MarketDataService;
import com.example.nagashimatravel.Service.SignalService;
import com.example.nagashimatravel.dto.SignalCandle;
import com.example.nagashimatravel.dto.TradingSignalResult;

@RestController
public class TradingSignalController {

    private final MarketDataService marketDataService;
    private final SignalService signalService;
    private final LineMessagingService lineMessagingService;

    public TradingSignalController(MarketDataService marketDataService,
                                   SignalService signalService,
                                   LineMessagingService lineMessagingService) {
        this.marketDataService = marketDataService;
        this.signalService = signalService;
        this.lineMessagingService = lineMessagingService;
    }

    @GetMapping("/signal/{symbol}")
    public TradingSignalResult checkSignal(@PathVariable String symbol) {
        List<SignalCandle> candles = marketDataService.getRecentCandles(symbol);
        return signalService.analyzeBuySignal(symbol, candles);
    }

    @GetMapping("/signal/{symbol}/notify")
    public String checkSignalAndNotify(@PathVariable String symbol) {
        List<SignalCandle> candles = marketDataService.getRecentCandles(symbol);
        TradingSignalResult result = signalService.analyzeBuySignal(symbol, candles);

        if (result.isShouldNotify()) {
            lineMessagingService.pushMessage(result.getMessage());
            return "LINE通知を送信しました";
        }

        return "シグナル条件未達のため通知なし";
    }
}