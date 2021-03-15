package flowershop;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GiveFlowersServiceOnLandTest {

    @Test
    void whenCreateBouquetOf2Flowers_thenReturnBouquet() {
        //GIVEN
        final GiveFlowersServiceOnLand giveFlowersServiceOnLand = new GiveFlowersServiceOnLand();

        //WHEN
        final Bouquet actual = giveFlowersServiceOnLand.createBouquet(2 , new Flower("Rose", Color.YELLOW));

        //THEN
        assertNotNull(actual);
    }

    @Test
    void whenCreateBouquetOf1Flowers_thenReturnBouquet() {
        //GIVEN
        final GiveFlowersServiceOnLand giveFlowersServiceOnLand = new GiveFlowersServiceOnLand();

        //WHEN
        final Bouquet actual = giveFlowersServiceOnLand.createBouquet(1, new Flower("Rose", Color.YELLOW));

        //THEN
        assertNotNull(actual);
    }

    @Test
    void whenCreateBouquetOf0Flowers_thenReturnBouquet() {
        //GIVEN
        final GiveFlowersServiceOnLand giveFlowersServiceOnLand = new GiveFlowersServiceOnLand();

        //WHEN
        //THEN
        assertThrows(FlowersAmountException.class, () ->
                giveFlowersServiceOnLand.createBouquet(0, new Flower("Rose", Color.YELLOW)));
    }

    @Test
    void whenCreateBouquetOfMinusOneFlowers_thenReturnBouquet() {
        //GIVEN
        final GiveFlowersServiceOnLand giveFlowersServiceOnLand = new GiveFlowersServiceOnLand();

        //WHEN
        //THEN
        assertThrows(FlowersAmountException.class, () ->
                giveFlowersServiceOnLand.createBouquet(-1, new Flower("Rose", Color.YELLOW)));
    }

    @Test
    void giveFlowers() {
    }
}