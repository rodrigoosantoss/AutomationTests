package core;

import org.openqa.selenium.remote.BrowserType;

public class ProjectProperties {
    public static boolean CLOSE_BROWSER = true;

    public static String browser = BrowserType.CHROME;

    public enum Browser{
        CHROME, FIREFOX;
    }

}
