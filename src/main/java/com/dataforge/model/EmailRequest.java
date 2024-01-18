package com.dataforge.model;

public class EmailRequest {

	
	         private String to;
	         
	         private String body;
	         
	         private String subject;

			public String getTo() {
				return to;
			}

			public void setTo(String to) {
				this.to = to;
			}

			public String getBody() {
				return body;
			}

			public void setBody(String body) {
				this.body = body;
			}

			public String getSubject() {
				return subject;
			}

			public void setSubject(String subject) {
				this.subject = subject;
			}

			@Override
			public String toString() {
				return "EmailRequest [to=" + to + ", body=" + body + ", subject=" + subject + "]";
			}	         
}
