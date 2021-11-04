package com.janboerman.starhunt.common.lingo;

import com.janboerman.starhunt.common.StarLocation;
import com.janboerman.starhunt.common.StarTier;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InterpretationsTest {

    @Test
    public void testCorsairBank() {
        String text = "T2 corsair bank w308";

        assertEquals(StarLocation.CORSAIR_COVE_BANK, StarLingo.interpretLocation(text));
        assertEquals(StarTier.SIZE_2, StarLingo.interpretTier(text));
        assertEquals(308, StarLingo.interpretWorld(text));
    }

    @Test
    public void testLumbridgeSwampEast() {
        String text = "Yea w335 tier 2 lumby east";

        assertEquals(StarLocation.LUMBRIDGE_SWAMP_SOUTH_EAST_MINE, StarLingo.interpretLocation(text));
        assertEquals(StarTier.SIZE_2, StarLingo.interpretTier(text));
        assertEquals(335, StarLingo.interpretWorld(text));
    }

    @Test
    public void testVarrock() {
        String text = "T3 Varrock East W382";

        assertEquals(StarLocation.VARROCK_SOUTH_EAST_MINE, StarLingo.interpretLocation(text));
        assertEquals(StarTier.SIZE_3, StarLingo.interpretTier(text));
        assertEquals(382, StarLingo.interpretWorld(text));
    }
}
