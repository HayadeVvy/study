package kr.spring.ch12;

import java.util.Set;

public class BookClient {
	private Set<Integer> subSet;

	public void setSubSet(Set<Integer> subSet) {
		this.subSet = subSet;
	}

	@Override
	public String toString() {
		return "BookClient [subSet=" + subSet + "]";
	}
}
