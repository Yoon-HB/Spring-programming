package chapter11;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ResponseObject {
	private Date lastBuildDate;
	private int display;
	private int total;
	private List items;
	
	public ResponseObject() {
		this.lastBuildDate = new Date();
	}
}
