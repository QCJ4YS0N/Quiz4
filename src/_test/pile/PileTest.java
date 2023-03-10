/*
420-202 – Quiz 4
Groupe 2 (mardi, vendredi)
Nom : Poirier, Jayson; 2243405
*/

package pile;

import exceptions.PileException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {

    static Pile pile;

    @BeforeAll
    static void init() {
        pile = new Pile();
    }

    @Test
    void empty_retourneVraiSiLaPileEstVide() {
        assertTrue(pile.empty());

        pile.push("object");
        assertFalse(pile.empty());
    }

    @Test
    void peek_retourneLObjetAuDessusDeLaPileSansLeRetirer_lanceUnePileException_SiLaPileEstVide() throws PileException {
        assertThrows(PileException.class, () -> pile.peek());

        pile.push("objectA");

        assertEquals("objectA", pile.peek());
        assertDoesNotThrow(() -> pile.peek());
        assertEquals(1, pile.size());

        pile.push("objectB");

        assertNotEquals("objectA", pile.peek());
        assertEquals("objectB", pile.peek());
        assertDoesNotThrow(() -> pile.peek());
        assertEquals(2, pile.size());
    }

    @Test
    void pop_RetourneLObjetAuDessusDeLaPileEnLeRetirant_lanceUnePileException_SiLaPileEstVide() throws PileException {
        pile.push("objectA");
        pile.push("objectB");
        pile.push("objectC");
        pile.push("objectD");

        assertDoesNotThrow(() -> pile.pop());
        assertEquals(3, pile.size());
        assertEquals("objectC", pile.pop());
        assertEquals("objectB", pile.pop());
        assertEquals("objectA", pile.pop());
        assertTrue(pile.empty());
        assertThrows(PileException.class, () -> pile.pop());
    }

    @Test
    void push_ajouteLObjetRecusEnArgumentAuDessusDeLaPile() throws PileException {
        pile.push("objectA");
        assertFalse(pile.empty());

        pile.push("objectB");
        pile.push("objectC");
        assertEquals("objectC", pile.peek());
        pile.push("objectD");
        assertNotEquals("objectC", pile.peek());
        assertEquals(4, pile.size());
    }

    @Test
    void size_retourneLeNombreDElementsDansLaPile() throws PileException {
        assertEquals(0, pile.size());

        pile.push("objectA");
        pile.push("objectB");
        pile.push("objectC");
        pile.push("objectD");
        assertEquals(4, pile.size());

        pile.pop();
        pile.pop();
        assertEquals(2, pile.size());
    }
}