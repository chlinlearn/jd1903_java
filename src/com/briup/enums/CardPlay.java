package com.briup.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardPlay {

	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("Usage:java"+CardPlay.class.getName()+
					"numhands cardperHand");
			System.exit(1);
		}
		int numHands = Integer.parseInt(args[0]);
		int cardPerHand = Integer.parseInt(args[1]);
		//初始化牌
		List<Card> deck = Card.newDeck();
		//模拟洗牌
		Collections.shuffle(deck);
		//模拟发牌
		for(int i=0;i<numHands;i++){
			System.out.println(deal(deck,cardPerHand));
		}
	}
	public static ArrayList<Card> deal(List<Card> deck,int n){
		int deckSize = deck.size();
		List<Card> handView=deck.subList(deckSize-n,deckSize);
		ArrayList<Card> hand = new ArrayList<Card>(handView);
		//清空发出去了的牌
		handView.clear();
		return hand;
	}
}
