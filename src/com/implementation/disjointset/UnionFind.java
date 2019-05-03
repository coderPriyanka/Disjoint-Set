package com.implementation.disjointset;

/**
 * 
 * @author Priyanka_Sarkar
 *
 */

public class UnionFind {
	
	private int size;
	private int numSets;
	private int[] id;
	private int[] rank;
	
	public UnionFind(int size) {
		this.size = size;
		this.numSets = size;
		this.id = new int[size];
		this.rank = new int[size];
		createSet();
	}
	
	private void createSet() {
		for(int i = 0; i < size; i++) {
			id[i] = i;
		}
	}
	
	public void union(int element1, int element2) {
		int root1 = find(element1);
		int root2 = find(element2);
		if(root1 == root2) {
			return;
		}
		if(rank[root1] < rank[root2]) {
			id[root1] = root2;
		}
		else if(rank[root2] < rank[root1]) {
			id[root2] = root1;
		}
		else {
			id[root2] = root1;
			rank[root1]++;
		}
	}
	
	public int find(int element) {
		if(element != id[element]) {
			id[element] = find(id[element]);
		}
		return id[element];
	}
	
	public boolean isConnected(int element1, int element2) {
		return find(element1) == find(element2);
	}
	
	public int getNumSets() {
		return numSets;
	}
}
