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
	public final static Map<Integer,ArrayList<Integer>> partTeam128inSize = new HashMap<>();
	
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
		
		
		partTeam128inSize.put(1, getMatchList(1,128));
		partTeam128inSize.put(2, getMatchList(64,65));
		partTeam128inSize.put(3, getMatchList(32,97));
		partTeam128inSize.put(4, getMatchList(33,96));
		partTeam128inSize.put(5, getMatchList(16,113));
		partTeam128inSize.put(6, getMatchList(49,80));
		partTeam128inSize.put(7, getMatchList(17,112));
		partTeam128inSize.put(8, getMatchList(48,81));
		partTeam128inSize.put(9, getMatchList(8,121));
		partTeam128inSize.put(10, getMatchList(57,72));
		partTeam128inSize.put(11, getMatchList(25,104));
		partTeam128inSize.put(12, getMatchList(40,89));
		partTeam128inSize.put(13, getMatchList(9,120));
		partTeam128inSize.put(14, getMatchList(56,73));
		partTeam128inSize.put(15, getMatchList(24,105));
		partTeam128inSize.put(16, getMatchList(41,88));
		partTeam128inSize.put(17, getMatchList(4,125));
		partTeam128inSize.put(18, getMatchList(61,68));
		partTeam128inSize.put(19, getMatchList(29,100));
		partTeam128inSize.put(20, getMatchList(36,93));
		partTeam128inSize.put(21, getMatchList(13,116));
		partTeam128inSize.put(22, getMatchList(52,77));
		partTeam128inSize.put(23, getMatchList(20,109));
		partTeam128inSize.put(24, getMatchList(45,84));
		partTeam128inSize.put(25, getMatchList(5,124));
		partTeam128inSize.put(26, getMatchList(60,69));
		partTeam128inSize.put(27, getMatchList(28,101));
		partTeam128inSize.put(28, getMatchList(37,92));
		partTeam128inSize.put(29, getMatchList(12,117));
		partTeam128inSize.put(30, getMatchList(53,76));
		partTeam128inSize.put(31, getMatchList(21,108));
		partTeam128inSize.put(32, getMatchList(44,85));
		partTeam128inSize.put(33, getMatchList(2,127));
		partTeam128inSize.put(34, getMatchList(63,66));
		partTeam128inSize.put(35, getMatchList(31,98));
		partTeam128inSize.put(36, getMatchList(34,95));
		partTeam128inSize.put(37, getMatchList(15,114));
		partTeam128inSize.put(38, getMatchList(50,79));
		partTeam128inSize.put(39, getMatchList(18,111));
		partTeam128inSize.put(40, getMatchList(47,82));
		partTeam128inSize.put(41, getMatchList(7,122));
		partTeam128inSize.put(42, getMatchList(58,71));
		partTeam128inSize.put(43, getMatchList(26,103));
		partTeam128inSize.put(44, getMatchList(39,90));
		partTeam128inSize.put(45, getMatchList(10,119));
		partTeam128inSize.put(46, getMatchList(55,74));
		partTeam128inSize.put(47, getMatchList(23,106));
		partTeam128inSize.put(48, getMatchList(42,87));
		partTeam128inSize.put(49, getMatchList(3,126));
		partTeam128inSize.put(50, getMatchList(62,67));
		partTeam128inSize.put(51, getMatchList(30,99));
		partTeam128inSize.put(52, getMatchList(35,94));
		partTeam128inSize.put(53, getMatchList(14,115));
		partTeam128inSize.put(54, getMatchList(51,78));
		partTeam128inSize.put(55, getMatchList(19,110));
		partTeam128inSize.put(56, getMatchList(46,83));
		partTeam128inSize.put(57, getMatchList(6,123));
		partTeam128inSize.put(58, getMatchList(59,70));
		partTeam128inSize.put(59, getMatchList(27,102));
		partTeam128inSize.put(60, getMatchList(38,91));
		partTeam128inSize.put(61, getMatchList(11,118));
		partTeam128inSize.put(62, getMatchList(54,75));
		partTeam128inSize.put(63, getMatchList(22,107));
		partTeam128inSize.put(64, getMatchList(43,86));
		
	}
			
}
