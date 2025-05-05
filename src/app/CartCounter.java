package app;

public class CartCounter {
    int carCounts = 0;

    void randomCount() {
        this.carCounts = carCounts + (int)(Math.random() * 9) + 2;
    }

    boolean logicTic = false;

    void dealerLogic(CartCounter dealer) {
        if (dealer.carCounts < 18) {
            dealer.randomCount();
            logicTic = true;
            if(dealer.carCounts > 21) {
                System.out.println("Вы победили! Счёт противника " + dealer.carCounts + ".");
                Main.winner = Main.player1;
            } else if(dealer.carCounts == 21) {
                System.out.println("Вы проиграли! Счёт противника " + dealer.carCounts + ".");
                Main.winner = Main.player2;
            }
        } else {
            logicTic = false;
        }
    }
}
