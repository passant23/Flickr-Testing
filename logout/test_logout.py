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

def test_logout(setup):
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
    driver.find_element_by_css_selector(
        "#root > div > main > div.PostDetail_main__content__1_eQQ > div > div > div.PostDetail_sub__photo__left__view__3P59u > div.PostDetail_user__header__20T0N > p").click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains("https://www.flickrclone.tech/user/60b7498a62eaf5001f315589"))
    time.sleep(10)
    assert (driver.find_element_by_css_selector(
        "#root > div > main > div > div:nth-child(1) > div > h2")).text == "p aa"
    assert (driver.find_element_by_css_selector(
        "#root > div > main > div > div:nth-child(1) > div > h6.youPageUserName")).text == "passantahmedmSaher"

    driver.find_element_by_css_selector("#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.gn-tools > li:nth-child(5) > a").click()

    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_to_be("https://www.flickrclone.tech/"))

    assert driver.current_url == "https://www.flickrclone.tech/"

    driver.back()

    time.sleep(10)



    assert (driver.find_element_by_css_selector("#about-edit-btn > img").is_displayed()) == False , "BUG: Logout is not successful, user can edit profile after log out"


    driver.find_element_by_css_selector("#scrollable-auto-tab-6 > span.MuiTab-wrapper").click()

    assert (driver.find_element_by_css_selector("#root > div > main > div > div:nth-child(4) > div > button").is_displayed())== False ,"BUG: Logout is not successful, user can upload after log out"