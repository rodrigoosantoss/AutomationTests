package core;

import org.openqa.selenium.Dimension;
import utils.Utils;


public class BasePage {

        /**
         * This class contains the method that makes all Object classes to have access to utils class and it's methods.
         */

        protected Utils utils;

        /**
         * This method recieves parameters to control the behavior from Selenium.
         */
        public BasePage() {
            utils = new Utils();
            DriverFactory.getDriver().manage().window().setSize(new Dimension(1024, 768));
        }

    }

