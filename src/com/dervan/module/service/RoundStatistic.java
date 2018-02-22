package com.dervan.module.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundStatistic {

	public final static Map<Integer,ArrayList<Integer>> partTeam2inSize = new HashMap<>();
	public final static Map<Integer,ArrayList<Integer>> partTeam4inSize = new HashMap<>();
	public final static Map<Integer,ArrayList<Integer>> partTeam8inSize = new HashMap<>();
	public final static Map<Integer,ArrayList<Integer>> partTeam16inSize = new HashMap<>();
	public final static Map<Integer,ArrayList<Integer>> partTeam32inSize = new HashMap<>();
	public final static Map<Integer,ArrayList<Integer>> partTeam64inSize = new HashMap<>();
	
	private static ArrayList<Integer> getMatchList(int player1 , int player2){
		ArrayList<Integer> match = new ArrayList<Integer>();
		match.add(player1);
		match.add(player2);
		return match;
	}
	
	static{
		partTeam2inSize.put(1, getMatchList(1,2));
		
		partTeam4inSize.put(1, getMatchList(1,4));
		partTeam4inSize.put(2, getMatchList(2,3));
		
		partTeam8inSize.put(1, getMatchList(1,8));
		partTeam8inSize.put(2, getMatchList(4,5));
		partTeam8inSize.put(3, getMatchList(2,7));
		partTeam8inSize.put(4, getMatchList(3,6));
		
		partTeam16inSize.put(1, getMatchList(1,16));
		partTeam16inSize.put(2, getMatchList(8,9));
		partTeam16inSize.put(3, getMatchList(4,13));
		partTeam16inSize.put(4, getMatchList(5,12));
		partTeam16inSize.put(5, getMatchList(2,15));		
		partTeam16inSize.put(6, getMatchList(7,10));		
		partTeam16inSize.put(7, getMatchList(3,14));
		partTeam16inSize.put(8, getMatchList(6,11));
		
		
		partTeam32inSize.put(1,  getMatchList(1, 32));
		partTeam32inSize.put(2,  getMatchList(16,17));
		partTeam32inSize.put(3,  getMatchList(9,24));
		partTeam32inSize.put(4,  getMatchList(8,25));
		partTeam32inSize.put(5,  getMatchList(4,29));
		partTeam32inSize.put(6,  getMatchList(13,20));
		partTeam32inSize.put(7,  getMatchList(12,21));
		partTeam32inSize.put(8,  getMatchList(5,28));
		partTeam32inSize.put(9,  getMatchList(2,31));
		partTeam32inSize.put(10, getMatchList(15,18));
		partTeam32inSize.put(11, getMatchList(10,23));
		partTeam32inSize.put(12, getMatchList(7,26));
		partTeam32inSize.put(13, getMatchList(3,30));
		partTeam32inSize.put(14, getMatchList(14,19));
		partTeam32inSize.put(15, getMatchList(11,22));
		partTeam32inSize.put(16, getMatchList(6,27));
		
		
		partTeam64inSize.put(1, getMatchList(1,64));
		partTeam64inSize.put(2, getMatchList(32,33));
		partTeam64inSize.put(3, getMatchList(17,48));
		partTeam64inSize.put(4, getMatchList(16,49));
		partTeam64inSize.put(5, getMatchList(9,56));
		partTeam64inSize.put(6, getMatchList(24,41));
		partTeam64inSize.put(7, getMatchList(25,40));
		partTeam64inSize.put(8, getMatchList(8,57));
		partTeam64inSize.put(9, getMatchList(4,61));
		partTeam64inSize.put(10, getMatchList(29,36));
		partTeam64inSize.put(11, getMatchList(20,45));
		partTeam64inSize.put(12, getMatchList(13,52));
		partTeam64inSize.put(13, getMatchList(12,53));
		partTeam64inSize.put(14, getMatchList(21,44));
		partTeam64inSize.put(15, getMatchList(28,37));
		partTeam64inSize.put(16, getMatchList(5,60));
		partTeam64inSize.put(17, getMatchList(2,63));
		partTeam64inSize.put(18, getMatchList(31,34));
		partTeam64inSize.put(19, getMatchList(18,47));
		partTeam64inSize.put(20, getMatchList(15,50));
		partTeam64inSize.put(21, getMatchList(10,55));
		partTeam64inSize.put(22, getMatchList(23,42));
		partTeam64inSize.put(23, getMatchList(26,39));
		partTeam64inSize.put(24, getMatchList(7,58));
		partTeam64inSize.put(25, getMatchList(3,62));
		partTeam64inSize.put(26, getMatchList(30,35));
		partTeam64inSize.put(27, getMatchList(19,46));
		partTeam64inSize.put(28, getMatchList(14,51));
		partTeam64inSize.put(29, getMatchList(11,54));
		partTeam64inSize.put(30, getMatchList(22,43));
		partTeam64inSize.put(31, getMatchList(27,38));
		partTeam64inSize.put(32, getMatchList(6,59));
		
		
		
	}
			
}
