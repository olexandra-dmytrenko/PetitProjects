package flowershop;

import lombok.Builder;

@Builder
public class Bouquet {
    Flower[] flowers;
    String wrapping;
    String addons;
}
