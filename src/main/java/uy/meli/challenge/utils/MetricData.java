package uy.meli.challenge.utils;

public enum MetricData {
	API_REQUEST_DATE("API_REQUEST_DATE"),
	API_START_TIME("API_START_TIME"),
	API_STOP_TIME("API_STOP_TIME"),
	API_ITEM_INFO("API_ITEM_INFO"),
	CLIENT_ITEM_START_TIME("CLIENT_ITEM_START_TIME"),
	CLIENT_ITEM_STOP_TIME("CLIENT_ITEM_STOP_TIME"),
	CLIENT_ITEM_STATUS_CODE("CLIENT_ITEM_STATUS_CODE"),
	CLIENT_CHILD_START_TIME("CLIENT_CHILD_START_TIME"),
	CLIENT_CHILD_STOP_TIME("CLIENT_CHILD_STOP_TIME"),
	CLIENT_CHILD_STATUS_CODE("CLIENT_CHILD_STATUS_CODE");
	
	private String value;
	
	private MetricData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}