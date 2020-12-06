package co.com.moviedb.moviedb.framework.model;

import java.util.ArrayList;
import java.util.List;

public class BaseListModel <B extends Object> {
	List<B> list = new ArrayList<>();

	/**
	 * @return the list
	 */
	public List<B> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<B> list) {
		this.list = list;
	}
	
	public void add(B obj) {
		list.add(obj);
	}

	@Override
	public String toString() {
		return "BaseListModel [list=" + list + "]";
	}
	
}
