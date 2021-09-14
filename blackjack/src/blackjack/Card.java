package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
	public static List<Integer> createCard() {
		//トランプ生成
		List<Integer> deck = new ArrayList<Integer>();
		for (int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		//ランダムに並べなおして山札に置く
		Collections.shuffle(deck);
		return deck;
	}

	public static List<Integer> passDealerCard(List<Integer> deck, List<Integer> dealerCardList) {
		//ディーラーに二枚配る
		dealerCardList.add(toRank(deck.get(0)));
		dealerCardList.add(toRank(deck.get(2)));
		//二枚のうち一枚を公開する
		System.out
				.println("Dealer's first card is \"" + toSuit(deck.get(0)) + toCardName(dealerCardList.get(0)) + "\"");
		System.out.println("Dealer's second card is secret.");
		System.out.println("Dealer's total point is " + dealerCardList.get(0));
		return dealerCardList;
	}

	public static List<Integer> passPlayerCard(List<Integer> deck, List<Integer> playerCardList) {
		//プレイヤーに二枚配る
		playerCardList.add(toRank(deck.get(1)));
		playerCardList.add(toRank(deck.get(3)));
		//プレイヤーの二枚を公開する
		System.out.println("Player's first card is \"" + toSuit(deck.get(1)) + toCardName(playerCardList.get(0)) + "\"");
		System.out.println("Player's second card is \"" + toSuit(deck.get(3)) + toCardName(playerCardList.get(1)) + "\"");
		System.out.println("Player's total point is " + Point.countPoint(playerCardList));
		return playerCardList;
	}

	public static String toCardName(int number) {
		//1=A,11=J,12=Q,13=Kと表示する
		Integer cardNumber = number % 13;
		if (cardNumber == 0) {
			cardNumber = 13;
		}
		switch (cardNumber) {
		case 1:
			return "A";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			String cardName = cardNumber.toString();
			return cardName;
		}
	}

	public static Integer toRank(int number) {
		//J,Q,Kは10として数える
		Integer cardNumber = number % 13;
		if (cardNumber == 0) {
			cardNumber = 13;
		}
		switch (cardNumber) {
		case 11:
			return 10;
		case 12:
			return 10;
		case 13:
			return 10;
		default:
			Integer rank = cardNumber;
			return rank;
		}
	}

	public static String toSuit(int number) {
		//1～13ハート、14～26ダイヤ、27～39クラブ、40～52スペード
		if (1 <= number && number <= 13) {
			return "Heart";
		} else if (14 <= number && number <= 26) {
			return "Diamond";
		} else if (27 <= number && number <= 39) {
			return "Clover";
		} else if (40 <= number && number <= 52) {
			return "Spade";
		}
		return "Error";
	}
}
