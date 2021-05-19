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
    driver.implicitly_wait(60) # seconds
    driver.get("https://identity.flickr.com/")
    #driver.maximize_window()

    #Variables
    email = "ossyahya60@gmail.com"
    password = "32233750Yhaya"

    #Locators
    emailField = driver.find_element_by_id(Locators.email)
    nextButton = driver.find_element_by_xpath(Locators.nextButton)

    #Actions
    emailField.send_keys(email)
    nextButton.click()

    #Locators
    passwordField = driver.find_element_by_id(Locators.password)
    signIn = driver.find_element_by_xpath(Locators.signIn)

    #Actions
    passwordField.send_keys(password)
    signIn.click()
    time.sleep(10)
    driver.get("https://www.flickr.com/photos/cmichel67/51186715430/in/dateposted/")
    time.sleep(10)

    yield

    driver.close()
    driver.quit()

def test_FavouriteAlready(setup):
    #Locators
    try:
        favouriteButton = driver.find_element_by_class_name("fave-star animated")
    except:
        warnings.warn(UserWarning("Image had been already favourited!"))

def test_FavouriteImage(setup):
    #Locators
    favouriteButton = driver.find_element_by_xpath(Locators.favouriteButton)

    #Locators
    favesCountPrev = int(driver.find_element_by_class_name(Locators.favesCount).text)

    #Actions
    favouriteButton.click()

    time.sleep(5)

    #Locators
    favesCountCurrent = int(driver.find_element_by_class_name(Locators.favesCount).text)

    #Check If Button is really pressed
    assert favesCountCurrent > favesCountPrev
    assert favouriteButton.get_attribute("class") == "fave-star animated is-faved"