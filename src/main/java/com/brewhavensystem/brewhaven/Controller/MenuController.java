package com.brewhavensystem.brewhaven.Controller;

import com.brewhavensystem.brewhaven.Model.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String menuPage(Model model) {

        List<String> categories = List.of("Hot Coffee", "Iced Coffee", "Non-Coffee", "Pastries");

        // Last value = photo file name inside static/images (use "" to show the emoji instead)
        List<MenuItem> items = List.of(
                // Hot Coffee
                new MenuItem(1, "Espresso", "Rich, bold single shot", 85.00, "Hot Coffee", "Espresso.jpg"),
                new MenuItem(2, "Americano", "Espresso with hot water, smooth and clean", 95.00, "Hot Coffee", "Amerikano.jpg"),
                new MenuItem(3, "Cappuccino", "Espresso with steamed milk and thick foam", 115.00, "Hot Coffee", "Cappuccino.jpg"),
                new MenuItem(4, "Café Latte", "Creamy steamed milk over espresso", 120.00, "Hot Coffee", "CafeLatte.jpg"),

                // Iced Coffee
                new MenuItem(5, "Iced Americano", "Chilled espresso over ice", 105.00, "Iced Coffee", "IceAmerikano.jpg"),
                new MenuItem(6, "Iced Latte", "Espresso and cold milk over ice", 130.00, "Iced Coffee",  "IceLatte.jpg"),
                new MenuItem(7, "Spanish Latte", "Sweet condensed milk with espresso", 145.00, "Iced Coffee", "SpanishLatte.jpg"),
                new MenuItem(8, "Cold Brew", "Slow-steeped for 18 hours, super smooth", 125.00, "Iced Coffee", "ColdBrew.jpg"),

                // Non-Coffee
                new MenuItem(9, "Matcha Latte", "Ceremonial matcha with creamy milk", 140.00, "Non-Coffee", "MatchaLatte.jpg"),
                new MenuItem(10, "Hot Chocolate", "Rich cocoa topped with whipped cream", 110.00, "Non-Coffee", "HotChocolate.jpg"),
                new MenuItem(11, "Chai Latte", "Spiced tea with steamed milk", 125.00, "Non-Coffee", "ChaiLatte.jpg"),

                // Pastries
                new MenuItem(12, "Butter Croissant", "Flaky, buttery, baked fresh daily", 85.00, "Pastries", "ButterCroissant.jpg"),
                new MenuItem(13, "Blueberry Muffin", "Soft muffin bursting with blueberries", 75.00, "Pastries", "BlueberryMuffin.jpg"),
                new MenuItem(14, "Cinnamon Roll", "Warm roll with cream cheese glaze", 95.00, "Pastries", "CinnamonRoll.jpg"),
                new MenuItem(15, "Chocolate Cake", "Moist chocolate cake slice", 120.00, "Pastries", "ChocolateCake.jpg")
        );

        model.addAttribute("categories", categories);
        model.addAttribute("items", items);
        return "menu";
    }
}