package kr.spring.ch13;

import java.util.Properties;

public class VideoClient {
	private Properties prop;

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "VideoClient [prop=" + prop + "]";
	}
}
