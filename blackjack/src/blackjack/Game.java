package blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	static List<Integer> deck = new ArrayList<Integer>();
	static List<Integer> noHitList = new ArrayList<Integer>();
	static List<Integer> playerCardList = new ArrayList<Integer>();
	static List<Integer> dealerCardList = new ArrayList<Integer>();
	static Integer nextCard = 4;

	public static void main(String[] args) throws IOException {
		//山札を作る
		deck = Card.createCard();
		//ディーラーとプレイヤーに配る
		Card.passDealerCard(deck, dealerCardList);
		Card.passPlayerCard(deck, playerCardList);
		//プレイヤーにhitするか選ばせる
		while (noHitList != null) {
			noHitList = Hit.doHit(playerCardList, dealerCardList, deck, nextCard, noHitList);
			nextCard++;
		}
		//プレイヤーのバースト判定
		Judge.judgeBurst(Point.countPoint(playerCardList), "you", dealerCardList);
		//ディーラーのカード合計が17以上になるようにhitさせる
		while (Point.countPoint(dealerCardList) < 17) {
			Hit.doDealerHit(dealerCardList, deck, nextCard);
			nextCard++;
		}
		//ディーラーのバースト判定
		Judge.judgeBurst(Point.countPoint(dealerCardList), "dealer", dealerCardList);
		//勝敗判定
		Judge.judgeWin(playerCardList, dealerCardList);
	}


}
