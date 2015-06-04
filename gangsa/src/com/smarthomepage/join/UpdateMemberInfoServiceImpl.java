package com.smarthomepage.join;

public class UpdateMemberInfoServiceImpl implements UpdateMemberInfoService{
	public UpdateMemberInfoServiceImpl() {}
	private static UpdateMemberInfoServiceImpl instance = new UpdateMemberInfoServiceImpl();
	public static UpdateMemberInfoServiceImpl getInstance(){
		return instance;
	}
	@Override
	public void updateMemberInfo(String id, String name, String age) {
		UpdateMemberInfoDAO.getInstance().updateMemberInfo(id, name, age);
		
	}

}
