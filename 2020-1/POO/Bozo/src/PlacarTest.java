import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlacarTest {

	Placar pl;
	@Before
	public void setUp() throws Exception {
		pl = new Placar();
	}

	@After
	public void tearDown() throws Exception {
		pl = null;
	}

	@Test
	public void testGetScore() {
		pl = new Placar();
		pl.add(1, new int[] {1,1,1,1,1});
		assertEquals(5, pl.getScore());
		pl.add(2, new int[] {2,2,2,2,2});
		assertEquals(15, pl.getScore());
		pl.add(3, new int[] {3,3,3,3,3});
		assertEquals(30, pl.getScore());
		pl.add(4, new int[] {4,4,4,4,4});
		assertEquals(50, pl.getScore());
		pl.add(5, new int[] {5,5,5,5,5});
		assertEquals(75, pl.getScore());
		pl.add(6, new int[] {6,6,6,6,6});
		assertEquals(105, pl.getScore());
		pl.add(7, new int[] {3,3,2,2,2});
		assertEquals(120, pl.getScore());
		pl.add(8, new int[] {1,2,3,4,5});
		assertEquals(140, pl.getScore());
		pl.add(9, new int[] {1,1,1,1,1});
		assertEquals(170, pl.getScore());
		pl.add(10, new int[] {1,1,1,1,1});
		assertEquals(210, pl.getScore());		
	}

	public void testToStringVazio() {
		pl = new Placar();
		assertEquals("  (01)  |  (07)  |  (04)  \n--------------------------\n  (02)  |  (08)  |  (05)  \n--------------------------\n  (03)  |  (09)  |  (06)  \n--------------------------\n        |  (10)  |        \n        +--------+        ",pl.toString());
	}
	
	public void testToStringCheio() {
		pl = new Placar();
		pl.add(1, new int[] {1,1,1,1,1});
		pl.add(2, new int[] {2,2,2,2,2});
		pl.add(3, new int[] {3,3,3,3,3});
		pl.add(4, new int[] {4,4,4,4,4});
		pl.add(5, new int[] {5,5,5,5,5});
		pl.add(6, new int[] {6,6,6,6,6});
		pl.add(7, new int[] {3,3,2,2,2});
		pl.add(8, new int[] {1,2,3,4,5});
		pl.add(9, new int[] {1,1,1,1,1});
		pl.add(10, new int[] {1,1,1,1,1});
		assertEquals("   05   |   15   |   20   \n--------------------------\n   10   |   20   |   25   \n--------------------------\n   15   |   30   |   30   \n--------------------------\n        |   40   |        \n        +--------+        ",  pl.toString());
	}
	
	@Test
	public void testToString() {
		testToStringVazio();
		testToStringCheio();
	}

}
