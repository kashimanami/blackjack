package blackjack;

import java.util.List;

public class Point {
	//点数を数える
	public static Integer countPoint(List<Integer> cardList) {
		Integer cardPoint = 0;
		for (int l = 0; l <= cardList.size() - 1; l++) {
			cardPoint = cardPoint + cardList.get(l);
		}
		return cardPoint;
	}

}
