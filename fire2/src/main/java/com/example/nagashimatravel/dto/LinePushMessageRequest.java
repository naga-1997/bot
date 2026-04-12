package com.example.nagashimatravel.dto;


import java.util.List;

public class LinePushMessageRequest {

	private String to;
	private List<LineMessage> messages;

	public LinePushMessageRequest() {
	}

	public LinePushMessageRequest(String to, List<LineMessage> messages) {
		this.to = to;
		this.messages = messages;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<LineMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<LineMessage> messages) {
		this.messages = messages;
	}

	public static class LineMessage {
		private String type;
		private String text;

		public LineMessage() {
		}

		public LineMessage(String type, String text) {
			this.type = type;
			this.text = text;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
}