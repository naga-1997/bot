package com.example.nagashimatravel.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LineMessagingService {

	@Value("${line.bot.channel-token}")
	private String channelToken;

	@Value("${line.bot.user-id}")
	private String userId;

	private static final String PUSH_API_URL = "https://api.line.me/v2/bot/message/push";

	public void pushMessage(String text) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(channelToken);
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> body = Map.of(
				"to", userId,
				"messages", List.of(
						Map.of(
								"type", "text",
								"text", text)));

		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(PUSH_API_URL, request, String.class);

		System.out.println("LINE送信結果: " + response.getStatusCode());
		System.out.println("LINE送信レスポンス: " + response.getBody());
	}
}