package group15.intranet.model_request;

public class PermitStatistics {

	private int totalPermits;
	private int validPermits;
	private int invalidPermits;
	private int activePermits;
	private int inactivePermits;
	private int dailyPermits;
	private int weeklyPermits;
	private int monthlyPermits;
	
	
	public PermitStatistics(int totalPermits, int validPermits, int invalidPermits, int activePermits,
			int inactivePermits, int dailyPermits, int weeklyPermits, int monthlyPermits) {
		super();
		this.totalPermits = totalPermits;
		this.validPermits = validPermits;
		this.invalidPermits = invalidPermits;
		this.activePermits = activePermits;
		this.inactivePermits = inactivePermits;
		this.dailyPermits = dailyPermits;
		this.weeklyPermits = weeklyPermits;
		this.monthlyPermits = monthlyPermits;
	}


	public int getTotalPermits() {
		return totalPermits;
	}


	public void setTotalPermits(int totalPermits) {
		this.totalPermits = totalPermits;
	}


	public int getValidPermits() {
		return validPermits;
	}


	public void setValidPermits(int validPermits) {
		this.validPermits = validPermits;
	}


	public int getInvalidPermits() {
		return invalidPermits;
	}


	public void setInvalidPermits(int invalidPermits) {
		this.invalidPermits = invalidPermits;
	}


	public int getActivePermits() {
		return activePermits;
	}


	public void setActivePermits(int activePermits) {
		this.activePermits = activePermits;
	}


	public int getInactivePermits() {
		return inactivePermits;
	}


	public void setInactivePermits(int inactivePermits) {
		this.inactivePermits = inactivePermits;
	}


	public int getDailyPermits() {
		return dailyPermits;
	}


	public void setDailyPermits(int dailyPermits) {
		this.dailyPermits = dailyPermits;
	}


	public int getWeeklyPermits() {
		return weeklyPermits;
	}


	public void setWeeklyPermits(int weeklyPermits) {
		this.weeklyPermits = weeklyPermits;
	}


	public int getMonthlyPermits() {
		return monthlyPermits;
	}


	public void setMonthlyPermits(int monthlyPermits) {
		this.monthlyPermits = monthlyPermits;
	}
	
	
	
	
}
