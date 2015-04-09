package com.tesco.retail.domain.entites;

public class PoolDetails {
	private int poolId;
	private String poolName;
	private String Description;
	private PoolType poolType;

	public int getPoolId() {
		return poolId;
	}
	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}
	public String getPoolName() {
		return poolName;
	}
	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public PoolType getPoolType() {
		return poolType;
	}
	public void setPoolType(PoolType poolType) {
		this.poolType = poolType;
	}



}
