package screens;

import components.Game;
import components.Screen;
import helper.Helper;

import java.util.ArrayList;
import java.util.Collections;

public class DiscountScreen extends Screen {
    public DiscountScreen() {
    }

    public DiscountScreen(String notification) {
        super(notification);
    }

    @Override
    public void showScreen() {
        System.out.println("[Kortingen]");

        ArrayList<Game> discount = new ArrayList<>();

        // voeg games toe aan discount
        for (Game game : Game.getAllGames())
            if (game.inSale()) discount.add(game);

        // filter van hoogste naar laagste
        discount.sort((dis1, dis2) -> Integer.compare(dis2.getGrade(), dis1.getGrade()));

        Helper.clearScreen();

        // print items
        int counter = 1;
        for (Game game : discount) {
            double price = game.inSale() ? game.getPrice() / 100 * 80 : game.getPrice();
            System.out.print(STR."\{counter}. \{game.getName()}, prijs: €\{Helper.formatToEuro(price)}");
            if (game.inSale()) System.out.print(" (KORTING)");
            System.out.println();
            counter++;
        }

        if (discount.isEmpty()) new StartScreen("Er zijn geen kortingen.").showScreen();

        new StartScreen("\nBoven u staan de resultaten").showScreen();
    }
}


