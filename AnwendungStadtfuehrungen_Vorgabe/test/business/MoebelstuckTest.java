package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoebelstuckTest {

	private Moebelstueck moebel;
	
	@BeforeEach
	void setup() throws Exception {
		this.moebel = new Moebelstueck("Schrank", "Kueche", "modern", 449, new String[] {"Holz","Kunststoff"});
	}
	
	@AfterEach
	void destroy() throws Exception {
		this.moebel = null;
	}
	
	@Test
	void checkConstructor() {
		assertTrue(() -> moebel.getName().equals("Schrank"), () -> "Name nicht im Kontruktor übergeben worden!");
	}
	
	@Test
	void checkException() {
		Throwable exc = assertThrows(IllegalArgumentException.class,
				() -> new Moebelstueck("Schrank", "Kueche", "modern",449, null));
		assertEquals("Materialien darf nicht null sein!", exc.getMessage());
	}
	
		

}
