import time
import pytest
from selenium import webdriver
from selenium.webdriver import ActionChains, chrome
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

def pytest_html_report_title(report):
   report.title = "Login Report"

def test_verifyElementsInLoginPage(setup):

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)


    # driver.find_element_by_css_selector(Locators.logInButtonSelector).click();
    driver.find_element_by_id(Locators.emailAddressFieldId).is_displayed()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.element_to_be_clickable((By.ID, Locators.passwordFieldId)))
    driver.find_element_by_id(Locators.passwordFieldId).is_displayed()
    # driver.find_element_by_xpath(Locators.logInButtonSelector).is_displayed()
    driver.find_element_by_id(Locators.signInButtonId)

def test_verifyLinksInLoginPage(setup):

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)

    logInURL = driver.current_url
    print(driver.find_element_by_id(Locators.forgotPasswordId).get_attribute("href"))
    print(driver.find_element_by_id(Locators.signUpLinkLogInPageId).get_attribute("href"))

    main_window = driver.current_window_handle

    expectedURL = "https://www.flickrclone.tech/forgotpassword"
    driver.find_element_by_id(Locators.forgotPasswordId).click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains("https://www.flickrclone.tech/forgotpassword"))
    assert driver.current_url == expectedURL
    assert driver.find_element_by_css_selector(Locators.forgetPasswordTitleSelector).text =="Forgot your password ?"
    time.sleep(2)

    driver.back()

    expectedURL = "https://www.flickrclone.tech/signup"
    driver.find_element_by_id(Locators.signUpLinkLogInPageId).click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains("https://www.flickrclone.tech/signup"))
    assert driver.current_url == expectedURL
    assert driver.find_element_by_css_selector("#root > div > main > div > div > form > h5").text == "Create your account"

def test_wrongEmail(setup):
    #Invalid Email , Valid Password
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)

    # loginButton = driver.find_element_by_xpath(Locators.logInButtonSelector)
    # loginButton.click()

    # driver.implicitly_wait(10)

    wait = WebDriverWait(driver, 10)
    wait.until(EC.element_to_be_clickable((By.ID, Locators.emailAddressFieldId)))

    emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
    emailAddressField.send_keys("passantahmedmSaher@gmaila.com")

    driver.implicitly_wait(10)
    passwordField = driver.find_element_by_id(Locators.passwordFieldId);
    passwordField.send_keys("As1234567890!");

    signInButton = driver.find_element_by_id(Locators.signInButtonId);
    signInButton.click()

    # wait = WebDriverWait(driver, 60)
    # wait.until(EC.element_to_be_clickable((By.XPATH, Locators.invalidEmailMessageXpath)))

    # requiredColorEmail = driver.find_element_by_xpath(Locators.invalidEmailMessageXpath).value_of_css_property("color")
    # requiredColorPassword = driver.find_element_by_xpath(Locators.passwordRequiredXpath).value_of_css_property("color")


    # assert Color.from_string(requiredColorEmail).hex == "#e2292b"

    # assert Color.from_string(requiredColorPassword).hex == "#e2292b"

    assert (driver.current_url).__contains__("https://www.flickrclone.tech/login"), "Invalid URL"

    assert driver.find_element_by_css_selector(Locators.loginTitleSelector).text == ("Login to flickr"), "Invalid Title"

    wait = WebDriverWait(driver, 5)
    wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, Locators.wrongEmailOrPasswordMessageSelector)))

    assert driver.find_element_by_css_selector(
        Locators.wrongEmailOrPasswordMessageSelector).text == "Incorrect email or password"


def test_wrongPassword(setup):
    #Invalid Password, Valid Email
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)
    wait = WebDriverWait(driver, 10)
    wait.until(EC.element_to_be_clickable((By.ID, Locators.emailAddressFieldId)))

    emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
    emailAddressField.send_keys("passantahmedmSaher@gmail.com");


    passwordField = driver.find_element_by_id(Locators.passwordFieldId);
    passwordField.send_keys("123456789111210");

    signInButton = driver.find_element_by_id(Locators.signInButtonId);
    signInButton.click()

    assert (driver.current_url).__contains__("https://www.flickrclone.tech/login"), "Invalid URL"

    assert driver.find_element_by_css_selector(Locators.loginTitleSelector).text ==("Login to flickr"), "Invalid Title"

    wait = WebDriverWait(driver, 5)
    wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, Locators.wrongEmailOrPasswordMessageSelector)))

    assert driver.find_element_by_css_selector(Locators.wrongEmailOrPasswordMessageSelector).text == "Incorrect email or password"

def test_wrongEmailAndPassword(setup):
    # Empty fields
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.logInButtonSelector)))
    linkLogIn = driver.find_element_by_css_selector(Locators.logInButtonSelector).get_property("href")

    driver.get(linkLogIn)
    wait = WebDriverWait(driver, 10)
    wait.until(EC.element_to_be_clickable((By.ID, Locators.emailAddressFieldId)))

    emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);

    passwordField = driver.find_element_by_id(Locators.passwordFieldId);

    signInButton = driver.find_element_by_id(Locators.signInButtonId);
    signInButton.click()


    assert (driver.current_url).__contains__("https://www.flickrclone.tech/login"), "Invalid URL"

    assert driver.find_element_by_css_selector(Locators.loginTitleSelector).text == ("Login to flickr"), "Invalid Title"

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.requiredEmailMessageSelector)))

    # assert driver.find_element_by_css_selector(Locators.wrongEmailOrPasswordMessageSelector).text == "Incorrect email or password"


    reqEmail = driver.find_element_by_css_selector(Locators.requiredEmailMessageSelector).text
    reqPassword = driver.find_element_by_css_selector(Locators.requiredPasswordMessageSelector).text

    # requiredColorEmail = driver.find_element_by_xpath(Locators.requiredEmailMessageXpath).value_of_css_property("color")
    # requiredColorPassword = driver.find_element_by_xpath(Locators.requiredPasswordMessageXpath).value_of_css_property("color")

    assert reqEmail== "Email is required"

    assert reqPassword== "Password is required"

    #Wrong both email and password
    emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
    emailAddressField.send_keys("passantahmedmSaKher@gmail.com");

    passwordField = driver.find_element_by_id(Locators.passwordFieldId);
    passwordField.send_keys("123456789111210");

    driver.find_element_by_id(Locators.signInButtonId).click()
    assert (driver.current_url).__contains__("https://www.flickrclone.tech/login"), "Invalid URL"

    assert driver.find_element_by_css_selector(Locators.loginTitleSelector).text == ("Login to flickr"), "Invalid Title"

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.wrongEmailOrPasswordMessageSelector)))
    time.sleep(10)
    assert (driver.find_element_by_css_selector(Locators.wrongEmailOrPasswordMessageSelector)).text == "Incorrect email or password"

def test_validLogin(setup):
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

    assert logOutLink.__contains__ ("/welcome")

    aboutButton = driver.find_elements_by_css_selector("#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.nav-menu.desktop-only > li:nth-child(1) > a")[0]
    # driver.get(aboutButton)
    aboutButton.click()

    # driver.find_element_by_css_selector("#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.nav-menu.desktop-only > li:nth-child(1) > ul > li:nth-child(1) > a").click()

    driver.implicitly_wait(10)
    driver.find_element_by_css_selector("#root > div > main > div.PostDetail_main__content__1_eQQ > div > div > div.PostDetail_sub__photo__left__view__3P59u > div.PostDetail_user__header__20T0N > p").click()
    wait = WebDriverWait(driver, 10)
    wait.until(EC.url_contains("https://www.flickrclone.tech/user/60b7498a62eaf5001f315589"))
    time.sleep(10)
    assert (driver.find_element_by_css_selector("#root > div > main > div > div:nth-child(1) > div > h2")).text == "p aa"
    assert (driver.find_element_by_css_selector("#root > div > main > div > div:nth-child(1) > div > h6.youPageUserName")).text == "passantahmedmSaher"

