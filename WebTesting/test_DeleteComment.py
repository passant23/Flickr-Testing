from msedge.selenium_tools import Edge, EdgeOptions
import time
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.by import By
from Locators import Locators
import pytest

@pytest.fixture()
def setup():
    global driver
    # Change this according to your chosen browser
    options = EdgeOptions()
    options.use_chromium = True

    driver = Edge(options = options)
    driver.implicitly_wait(10) # seconds
    driver.get("https://www.flickrclone.tech/")
    #driver.maximize_window()

    #Variables
    email = "ossyahya60@gmail.com"
    password = "32233750_Yahya"
    username = "Osama Yahya"
    global commentTxt
    commentTxt = "I will delete this comment(I think)"

    #Locators
    loginButton = driver.find_element_by_xpath(Locators.loginButton)

    #Action
    loginButton.click()

    time.sleep(1)

    #Locators
    emailField = driver.find_element_by_id(Locators.email)
    #nextButton = driver.find_element_by_xpath(Locators.nextButton)

    #Actions
    emailField.send_keys(email)
    #nextButton.click()

    #Locators
    passwordField = driver.find_element_by_id(Locators.password)
    signIn = driver.find_element_by_xpath(Locators.signIn)

    #Actions
    passwordField.send_keys(password)
    signIn.click()
    time.sleep(10)
    driver.get("https://www.flickrclone.tech/photos/60be8d3cf3e8b0001fa0c408")
    time.sleep(10)

    yield

    driver.close()
    driver.quit()


def test_DeleteNewComment(setup):
    #Locators
    commentField = driver.find_element_by_xpath(Locators.commentField)

    #Actions
    commentField.send_keys(commentTxt)

    #Locators
    commentButton = driver.find_element_by_xpath(Locators.commentButton)

    #Actions
    commentButton.click()

    time.sleep(5)

    commentsCountPrev = int(driver.find_element_by_xpath(Locators.commentsCount).text)
    
    #Locator
    deleteCommentButton = driver.find_elements_by_id(Locators.deleteCommentButton)
    
    #Action
    deleteCommentButton[0].click()
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, Locators.confirmDeleteButton))).click()

    time.sleep(5)

    commentsCountCurrent = int(driver.find_element_by_xpath(Locators.commentsCount).text)

    assert commentsCountPrev < commentsCountCurrent, "Comments didn't decrease!"