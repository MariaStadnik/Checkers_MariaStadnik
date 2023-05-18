package com.checkers.pages;

import com.checkers.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckersPage {

    public CheckersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="message")
    public WebElement message;

    @FindBy(id ="board")
    public WebElement board;

    @FindBy(xpath = "//a[.='Restart...']")
    public WebElement restartButton;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    public boolean isEmptyCell(WebElement cell){
        boolean isValid = false;
        if(cell.getAttribute("src").contains("gray")){
            isValid = true;
        }
        return isValid;
    }

    public void clickOnCell(int rowNumber, int cellNumber){
        String locator = "//img[@name='space"+ cellNumber + rowNumber +"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    // method that can help us check if cell has orange piece
    public boolean hasOrange(WebElement cell){
        boolean isOrange = false;
        if(cell.getAttribute("src").contains("you")){
            isOrange = true;
        }
        return isOrange;
    }


    //method that can help us to pass any row number and cell number and get that cell as web element
    public WebElement getCellAsWebElement(int rowNumber, int cellNumber){
        if(rowNumber<0||rowNumber>7){
            throw new RuntimeException("Invalid row number provided :"+rowNumber);
        }else if(cellNumber<0||cellNumber>7){
            throw new RuntimeException("Invalid cell number provided :"+rowNumber);
        }
        String locator = "//img[@name='space"+ cellNumber + rowNumber +"']";
        return Driver.getDriver().findElement(By.xpath(locator));
    }

    public boolean isMyTurn(){
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Make a move."));
        return message.getText().equals("Make a move.");
    }




}
