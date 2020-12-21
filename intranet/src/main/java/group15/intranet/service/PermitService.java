package group15.intranet.service;

import java.util.Date;
import java.util.List;

import group15.intranet.entity.Permit;

public interface PermitService {
	
	public abstract List<Permit> getAllPermits();
	public abstract List<Permit> getPermits(int id, int status, Date startDate, String type, String adress);
}
