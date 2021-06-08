import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color
from selenium.webdriver.support.wait import WebDriverWait
from locators import Locators
from py.xml import html



@pytest.fixture()
def setup():
    global driver
    driver = webdriver.Chrome(r'C:\Program Files (x86)\chromedriver.exe')
    driver.get("https://www.flickrclone.tech/")
    driver.maximize_window()
    yield
    driver.close()
    driver.quit()

def test_forgetpassword(setup):
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.ID, Locators.forgotPasswordId)))


    driver.find_element_by_id(Locators.forgotPasswordId).click()

    assert driver.find_element_by_css_selector(Locators.forgetPasswordTitleSelector).is_displayed()

    emailAddressField = driver.find_element_by_id(Locators.emailId);
    #
    emailAddressField.clear()

    driver.find_element_by_id(Locators.forgetPasswordButtonId).click()

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "#root > div > main > div > form > div:nth-child(4) > p")))

    assert driver.find_element_by_css_selector("#root > div > main > div > form > div:nth-child(4) > p").text == "Email is required"


    emailAddressField.send_keys("passantahmedmSaher@gmail.com");

    driver.find_element_by_id(Locators.forgetPasswordButtonId).click()

    assert (driver.find_element_by_css_selector(Locators.forgetPasswordTitleSelector)).text == "Check your inbox", "BUG: Message didn't appear, meaning no account found, meaning the feature is not implemented"




