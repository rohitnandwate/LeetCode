package com.rhn.algorithms.util;

import java.util.HashSet;
import java.util.Set;

public class Triple {

	private int i;
	private int j;
	private int k;
	
	public Triple(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triple other = (Triple) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (k != other.k)
			return false;
		return true;
	}
	
	
}
