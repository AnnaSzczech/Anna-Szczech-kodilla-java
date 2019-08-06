package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_BIRTHDAY = "//div[@class=\"_58mq _5dbb\"]/div/span/span/";
    private static final String XPATH_DAY = XPATH_BIRTHDAY + "select[1]";
    private static final String XPATH_MONTH = XPATH_BIRTHDAY + "select[2]";
    private static final String XPATH_YEAR = XPATH_BIRTHDAY + "select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByValue("20");

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByVisibleText("wrz");

        WebElement selectComboMonthYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(selectComboMonthYear);
        selectYear.selectByValue("1989");
    }
}
