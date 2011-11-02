package net.thucydides.core.pages.scheduling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.Sleeper;

public class FluentWaitWithRefresh<T> extends ThucydidesFluentWait<T> {

    public FluentWaitWithRefresh(T input, Clock clock, Sleeper sleeper) {
        super(input, clock, sleeper);
    }

    @Override
    public void doWait() throws InterruptedException {
        getSleeper().sleep(interval);
        if (WebDriver.class.isAssignableFrom(getInput().getClass())) {
            ((WebDriver) getInput()).navigate().refresh();
        }
    }
}