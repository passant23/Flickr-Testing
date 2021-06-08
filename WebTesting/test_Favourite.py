from msedge.selenium_tools import Edge, EdgeOptions
import time
from Locators import Locators
import pytest
import warnings

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

def test_FavouriteAlready(setup):
    #Locators
    favouriteButton = None
    try:
        favouriteButton = driver.find_element_by_id(Locators.favouritedButton)
    except:
        return

    favouriteButton.click()

    time.sleep(2)

    try:
        driver.find_element_by_id(Locators.favouriteButton)
    except:
        assert False, "Failed to unfavourite"

            

def test_FavouriteImage(setup):
    #Locators
    favouriteButton = driver.find_element_by_id(Locators.favouriteButton)

    #Locators
    favesCountPrev = int(driver.find_element_by_xpath(Locators.favesCount).text)

    #Actions
    favouriteButton.click()

    time.sleep(5)

    #Locators
    favesCountCurrent = int(driver.find_element_by_xpath(Locators.favesCount).text)

    #Check If Button is really pressed
    driver.refresh()
    time.sleep(5) #Doesn't refresh automatically

    assert favesCountCurrent > favesCountPrev

    time.sleep(1)
    assert driver.find_element_by_id("photo-like-filled-btn") != None, "photo is already favourited but css is bugged"