package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Hit {
	//プレイヤーのhit
	public static List<Integer> doHit(List<Integer> playerCardList, List<Integer> dealerCardList, List<Integer> deck, Integer nextCard, List<Integer> noHitList) throws IOException {
		//入力が1ならhit,2ならstand,それ以外の入力はもう一度入力させる
		System.out.println("1:hit or 2:stand");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String hitJudge = br.readLine();
		if (hitJudge.equals("1")) {
			playerCardList.add(Card.toRank(deck.get(nextCard)));
			System.out.println("Player's next card is \"" + Card.toSuit(deck.get(nextCard)) + Card.toCardName(playerCardList.get(playerCardList.size() - 1)) + "\"");
			Point.countPoint(playerCardList);
			System.out.println("Player's total point is " + Point.countPoint(playerCardList));
			Judge.judgeBurst(Point.countPoint(playerCardList), "you", dealerCardList);
			return playerCardList;
		} else if (hitJudge.equals("2")) {
			noHitList = null;
			return noHitList;
		} else {
			System.out.println("Only 1 or 2, please!");
			return playerCardList;
		}
	}
	
	//ディーラーのhit
	public static List<Integer> doDealerHit(List<Integer> dealerCardList, List<Integer> deck, Integer nextCard) {
		dealerCardList.add(Card.toRank(deck.get(nextCard)));
		System.out.println("Dealer's next card is secret");
//		System.out.println("Dealer's next card is \"" + Card.toSuit(deck.get(nextCard)) + Card.toCardName(dealerCardList.get(dealerCardList.size() - 1)) + "\"");
//		System.out.println("Dealer's total point is " + Point.countPoint(dealerCardList));
		return dealerCardList;
	}

}
