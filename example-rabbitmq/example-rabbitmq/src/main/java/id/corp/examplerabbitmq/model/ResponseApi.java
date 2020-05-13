package id.corp.examplerabbitmq.model;

import java.util.Date;

public class ResponseApi {

	private Date timestamp;
	private Object data;
	
	public ResponseApi() {
		
	}
	
	public ResponseApi(Date timestamp, Object data) {
		this.timestamp = timestamp;
		this.data = data;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseApi [timestamp=" + timestamp + ", data=" + data + "]";
	}
	
	
}
