package com.checkers.steps;

import com.checkers.pages.CheckersPage;
import com.checkers.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class CheckersSteDefs {

    CheckersPage checkersPage = new CheckersPage();

    @Given("I am on the Checkers game website")
    public void i_am_on_the_checkers_game_website() {


        //verify the Title
        String expectedTitle = "Checkers - Games for the Brain";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle,actualTitle);

        //verify the message to make a move is displayed and correct
        String expectedMessage = "Select an orange piece to move.";
        String actualMessage = checkersPage.message.getText();
        assertEquals(expectedMessage,actualMessage);
        assertTrue(checkersPage.message.isDisplayed());

        //verify the board is displayed
        assertTrue(checkersPage.board.isDisplayed());

    }

    @When("I make five legal moves as orange and take a blue piece")
    public void i_make_five_legal_moves_as_orange_and_take_a_blue_piece() throws InterruptedException {


        //1st move
        checkersPage.clickOnCell(2,6);
        if(checkersPage.isEmptyCell(checkersPage.getCellAsWebElement(3,7))){
            checkersPage.clickOnCell(3,7);
        }
        Thread.sleep(5);
        //2nd move

        if(checkersPage.isMyTurn()){
            checkersPage.clickOnCell(2,4);
        }
        if(checkersPage.isEmptyCell(checkersPage.getCellAsWebElement(3,3))){
            checkersPage.clickOnCell(3,3);
        }

        Thread.sleep(5);
        //3rd move that takes the blue
        if(checkersPage.isMyTurn()){
            checkersPage.clickOnCell(1,3);
        }
        if(checkersPage.isEmptyCell(checkersPage.getCellAsWebElement(3,5))){
            checkersPage.clickOnCell(3,5);
        }
        Thread.sleep(5);
        //4th move
        if(checkersPage.isMyTurn()){
            checkersPage.clickOnCell(1,5);
        }
        if(checkersPage.isEmptyCell(checkersPage.getCellAsWebElement(2,4))){
            checkersPage.clickOnCell(2,4);
        }
        Thread.sleep(5);
        //5th move
        if(checkersPage.isMyTurn()){
            checkersPage.clickOnCell(2,4);
        }
        if(checkersPage.isEmptyCell(checkersPage.getCellAsWebElement(3,3))){
            checkersPage.clickOnCell(3,3);
        }



    }

    @Then("I restart the game")
    public void i_restart_the_game() {
        checkersPage.restartButton.click();
    }
    @Then("I confirm that the game has been successfully restarted")
    public void i_confirm_that_the_game_has_been_successfully_restarted() {
        //verify the message to make a move is displayed and correct
        String expectedMessage = "Select an orange piece to move.";
        String actualMessage = checkersPage.message.getText();
        assertEquals(expectedMessage,actualMessage);
        assertTrue(checkersPage.message.isDisplayed());
    }


}
