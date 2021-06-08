from selenium.webdriver.common import keys
from msedge.selenium_tools import Edge, EdgeOptions
from selenium.webdriver.common.by import By
import time
from Locators import Locators
import warnings
import pytest

@pytest.fixture()
def setup():
    global driver
    # Change this according to your chosen browser
    options = EdgeOptions()
    options.use_chromium = True

    driver = Edge(options = options)
    driver.implicitly_wait(60) # seconds
    driver.get("https://www.flickrclone.tech/")
    #driver.maximize_window()

    #Variables
    email = "ossyahya60@gmail.com"
    password = "32233750_Yahya"
    global newTag
    newTag = "Finally!!"

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

#CookieClose = driver.find_element_by_xpath('/html/body/div[1]/div/div[4]/div/div/div/div/div/div[2]/a').click()

def test_IfDuplicate(setup):    
    #Locators
    addTagsButton = driver.find_element_by_xpath(Locators.addTagsButton)

    #Actions
    addTagsButton.click()

    #Locator
    tagsList = driver.find_element_by_xpath(Locators.tagsList)

    #Action
    tags = tagsList.text.split('\n')
    for tag in tags:
        if tag == newTag:
            warnings.warn(UserWarning("Duplicate Tag!"))


def test_TagRegistered(setup):
    #Locator
    addTagButton = driver.find_element_by_xpath(Locators.addTagsButton)

    #Action
    addTagButton.click()

    #Locator
    tagTextField = driver.find_element_by_xpath(Locators.tagTextField)

    #Locator
    tagsList = driver.find_element_by_xpath(Locators.tagsList)

    #Action
    tagTextField.send_keys(newTag)
    tagTextField.send_keys(keys.Keys.ENTER)

    time.sleep(2)

    assert newTag in tagsList.text.split('\n'), "Failed to find the tag in the tags list!"