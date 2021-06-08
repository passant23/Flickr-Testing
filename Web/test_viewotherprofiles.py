from selenium import webdriver
import unittest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver import ActionChains
from selenium.common.exceptions import NoSuchElementException
from locators import Locators


import pytest
import time

@pytest.fixture()
def setup():
    global driver
    driver = webdriver.Chrome(r'C:\Program Files (x86)\chromedriver.exe')
    driver.get("https://www.flickrclone.tech/")
    driver.maximize_window()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)

    emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
    emailAddressField.send_keys("passantahmedmSaher@gmail.com");

    passwordField = driver.find_element_by_id(Locators.passwordFieldId);
    passwordField.send_keys("As1234567890!");

    signInButton = driver.find_element_by_id(Locators.signInButtonId);
    signInButton.click()

    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains(("https://www.flickrclone.tech/home")))

    assert driver.current_url == "https://www.flickrclone.tech/home", "Invalid URL"

    logOutLink = driver.find_element_by_css_selector(Locators.logOutSelector).get_attribute("href")

    assert logOutLink.__contains__("/welcome")

    aboutButton = driver.find_elements_by_css_selector(
        "#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.nav-menu.desktop-only > li:nth-child(1) > a")[
        0]
    # driver.get(aboutButton)
    aboutButton.click()

    # driver.find_element_by_css_selector("#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.nav-menu.desktop-only > li:nth-child(1) > ul > li:nth-child(1) > a").click()

    driver.implicitly_wait(10)
    # driver.find_element_by_css_selector("#root > div > main > div.PostDetail_main__content__1_eQQ > div > div > div.PostDetail_sub__photo__left__view__3P59u > div.PostDetail_user__header__20T0N > p").click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains("https://www.flickrclone.tech/user/60bf38eef3e8b0001fa0c428"))
    time.sleep(10)
    assert (driver.find_element_by_css_selector(
        "#root > div > main > div > div:nth-child(1) > div > h2")).text == "p aa"
    assert (driver.find_element_by_css_selector(
        "#root > div > main > div > div:nth-child(1) > div > h6.youPageUserName")).text == "passantahmedmSaher"

    yield
    driver.close()
    driver.quit()

def test_viewOtherProfiles(setup):
    searchInput = driver.find_element_by_xpath(Locators.searchInputXpath);
    searchWord = "maria maximus"
    searchInput.send_keys(searchWord);
    time.sleep(2)
    searchInput.click()
    searchPeople = driver.find_element_by_xpath(Locators.searchPeopleXpath);
    searchPeople.click()

    try : assert driver.find_element_by_id(searchWord).is_displayed()
    finally: "The profile is not found"

    driver.find_element_by_id(searchWord).click()

    assert (driver.find_element_by_xpath(Locators.profileNameXpath)) ==searchWord,"Couldnt click on proile"





