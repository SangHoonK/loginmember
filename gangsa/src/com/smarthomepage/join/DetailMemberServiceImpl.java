package com.smarthomepage.join;

public class DetailMemberServiceImpl implements DetailMemberService{
	private DetailMemberServiceImpl() {}
	private static DetailMemberServiceImpl instance = new DetailMemberServiceImpl();
	public static DetailMemberServiceImpl getInstance(){
		return instance;
	}
	@Override
	public MemberBean getMemberInfo(String id) {
		
		return DetailMemberDAO.getInstance().getMemberInfo(id);
	}

}
