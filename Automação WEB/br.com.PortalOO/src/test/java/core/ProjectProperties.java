package core;

public class ProjectProperties {

	/**
	 * This option is to set up if browser should close or not after all tests.
	 */
	public static boolean CLOSE_BROWSER = true;

	/**
	 * Here you set which browser Selenium should use.
	 */
	public static Browsers browser = Browsers.CHROME;

	/**
	 * The enumeration of driver types.
	 */
	public enum Browsers {
		CHROME, FIREFOX, EDGE
	}
	
}
