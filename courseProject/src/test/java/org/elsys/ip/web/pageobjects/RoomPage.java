package org.elsys.ip.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RoomPage extends AbstractPage {
    @FindBy(how = How.CLASS_NAME, using = "button-lv")
    private WebElement leaveButton;

    @FindBy(how = How.CLASS_NAME, using = "button-jn")
    private WebElement joinButton;

    @FindBy(how = How.ID, using = "roomsButton")
    private WebElement roomsButton;

    public RoomPage(WebDriver driver) {
        super(driver);
    }

    public boolean isExistant(){
        return driver.findElements(By.className("button-lv")).size() == 1;
    }

    public RoomsPage rooms(){
        this.roomsButton.click();
        return PageFactory.initElements(driver, RoomsPage.class);
    }
}
