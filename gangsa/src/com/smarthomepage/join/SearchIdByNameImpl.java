package com.smarthomepage.join;

public class SearchIdByNameImpl implements SearchIdService{
	private SearchIdByNameImpl() {}
	private static SearchIdByNameImpl instance = new SearchIdByNameImpl();
	public static SearchIdByNameImpl getInstance(){
		return instance;
	}
	@Override
	public String searchIdByName(String name) {
		return SearchIdDAO.getInstance().searchId(name);
	}

}
