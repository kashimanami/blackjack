package blackjack;

import java.util.List;

public class Judge {
	//バースト判定
	public static void judgeBurst(int cardPoint, String who, List<Integer>dealerCardList) {
		if (22 <= cardPoint) {
			System.out.println(who + " Burst!!");
			if(who=="dealer") {
				System.out.println("Dealer's total point is " + Point.countPoint(dealerCardList));
				System.out.println("you win");
			}else {
				System.out.println(who + " lose");
			}
			System.exit(0);
		}
	}
	
	//勝敗判定
	public static void judgeWin(List<Integer> playerCardList, List<Integer> dealerCardList){
			if (Point.countPoint(playerCardList) == Point.countPoint(dealerCardList)) {
				System.out.println("Dealer's total point is " + Point.countPoint(dealerCardList));
				System.out.println("draw");
				System.exit(0);
			} else if (21 < Point.countPoint(playerCardList)
					|| Point.countPoint(dealerCardList) > Point.countPoint(playerCardList)) {
				System.out.println("Dealer's total point is " + Point.countPoint(dealerCardList));
				System.out.println("you lose");
				System.exit(0);
			} else if (21 < Point.countPoint(dealerCardList)
					|| Point.countPoint(dealerCardList) < Point.countPoint(playerCardList)) {
				System.out.println("Dealer's total point is " + Point.countPoint(dealerCardList));
				System.out.println("you win");
				System.exit(0);
			}
	}

}
