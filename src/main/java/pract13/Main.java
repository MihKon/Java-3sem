package pract13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Card card = new Card();
        try {
            card.addCash(600);
            double money = Double.parseDouble(scan.nextLine());
            card.withdrawCash(money);
            card.addCash(-45);
        } catch (MyException me) {
            System.out.println("You can't withdraw this sum, because you haven't got enough money.");
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong enter");
        } catch (Exception ex) {
            System.out.println("You can't add money <= 0. Use another operation.");
        } finally {
            System.out.println(card);
        }

        if (card.getCash() == 600)
            throw new MyRuntimeException();
    }
}
