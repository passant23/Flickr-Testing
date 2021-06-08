from selenium.webdriver.common.keys import Keys
from msedge.selenium_tools import Edge, EdgeOptions
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import time
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
    global newDescription
    newDescription = "Very Noice, Right??"

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

def test_EditDescription(setup):
    #Locators
    editDescriptionArea = driver.find_element_by_xpath(Locators.editDescriptionArea)

    #Actions
    editDescriptionArea.click();

    #Locators
    editDescriptionTextField = driver.find_element_by_xpath(Locators.editDescriptionTextField)

    #Actions
    editDescriptionTextField.clear()
    editDescriptionTextField.send_keys(newDescription)

    #Locator and Action
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.ID, Locators.doneButton))).click()

    driver.refresh()

    time.sleep(5)

    descriptionField = driver.find_element_by_xpath(Locators.descriptionField)
    description = descriptionField.text

    assert description == newDescription