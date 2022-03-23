package org.elsys.ip.web.pageobjects;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class RoomsPage extends AbstractPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement newRoomName;

    @FindBy(how = How.CLASS_NAME, using = "button-rg-room")
    private WebElement registerRoomButton;

    public RoomsPage(WebDriver driver) {
        super(driver);
    }

    public RoomPage registerRoom(String roomName){
        this.newRoomName.clear();
        this.newRoomName.sendKeys(roomName);
        this.registerRoomButton.click();
        return PageFactory.initElements(driver, RoomPage.class);
    }

    public void registerRoomWithErrors(String roomName){
        this.newRoomName.clear();
        this.newRoomName.sendKeys(roomName);
        this.registerRoomButton.click();
    }

    public List<String> getCreateRoomErrors() {
        return driver.findElements(By.cssSelector("#name ~ p.error"))
                .stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}
