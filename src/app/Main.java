package app;

import java.util.Scanner;

public class Main {
    public static String winner = "";
    public static String player1 = "Игрок";
    public static String player2 = "Диллер";

    public static void main(String[] args) {
        System.out.println("Игрок и диллер получают по две карты!");
        CartCounter player = new CartCounter();
        CartCounter dealer = new CartCounter();

        player.randomCount();
        player.randomCount();

        dealer.randomCount();
        dealer.randomCount();

        while (winner.isEmpty()) {
            System.out.print("Сейчас у вас " + player.carCounts + ". будете брать ещё? ");
            Scanner scn = new Scanner(System.in);
            String answer = scn.nextLine();
            if(answer.equals("Yes")) {
                player.randomCount();
                if(player.carCounts > 21) {
                    System.out.println("Вы проиграли! Ваш счёт " + player.carCounts + "!");
                    winner = player2;
                } else if(player.carCounts == 21) {
                    System.out.println("Вы победили! Ваш счёт 21!");
                    winner = player1;
                }
            } else if(answer.equals("No")){
                System.out.println("Вы пропускаете ход.");
                dealer.dealerLogic(dealer);
                if(dealer.logicTic == false) {
                    if(player.carCounts > dealer.carCounts) {
                        System.out.println("Вы победили! Ваш счёт " + player.carCounts + ". Счёт противника " + dealer.carCounts + ".");
                        winner = player1;
                    } else if (player.carCounts == dealer.carCounts){
                        System.out.println("Ничья!");
                        winner = player1;
                    } else {
                        System.out.println("Вы проиграли! Ваш счёт " + player.carCounts + ". Счёт противника " + dealer.carCounts + ".");
                        winner = player2;
                    }
                }
            } else {
                System.out.println("Вы балабол. Введите Yes или No");
            }
        }
    }
}