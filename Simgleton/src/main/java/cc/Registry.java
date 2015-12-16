
package cc;

import java.util.HashMap;

/**
 * A centralized registry that implements the Singleton pattern. Serves as a
 * target class for Spring IoC instantiation.
 */
public class Registry extends HashMap<String, Object> {
	public Registry() {
		System.out.println("Created Registry....");
	}

	private static Registry INSTANCE = null;

	public static Registry getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Registry();
		return INSTANCE;
	}
}
