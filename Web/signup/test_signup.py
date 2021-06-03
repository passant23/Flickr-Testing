import time
import pytest
from selenium import webdriver
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from locators import Locators


@pytest.fixture()
def setup():
    global driver
    driver = webdriver.Chrome(r'../chromedriver.exe')
    driver.get("https://www.flickrclone.tech/")
    driver.maximize_window()
    wait = WebDriverWait(driver, 10)
    signUpButton1 = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, Locators.signUpButtonSelector)))
    signUpButton1.click();
    yield
    driver.close()
    driver.quit()

def test_verifysignuppagelinks(setup):
    logInURL = driver.current_url
    main_window = driver.current_window_handle
    assert  driver.current_url == "https://www.flickrclone.tech/signup"
    assert (driver.find_element(By.CSS_SELECTOR,"#root > div > main > div > div > form > h5").text)== "Create your account"

    expectedURL = "https://www.flickrclone.tech/login"
    driver.find_element(By.CSS_SELECTOR, Locators.logInLinkSignUpPageSelector).click()
    driver.implicitly_wait(10)

    assert (driver.find_element(By.CSS_SELECTOR,"#root > div > main > div > div > form > h5").text) == "Login to flickr"
    assert driver.current_url == expectedURL

    # LINKS THAT WERE PRESENT ON ORIGINAL FLICKR WEBSITE
    # expectedURL = "https://help.flickr.com/"
    # driver.find_element_by_xpath(Locators.helpLinkSignUpPageXpath).click()
    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Flickr Help"))
    # assert driver.current_url == expectedURL
    # # time.sleep(3)
    # driver.close()
    # driver.switch_to.window(main_window)

    # expectedURL = "https://www.flickr.com/help/privacy"
    # driver.find_element_by_xpath(Locators.privacyLinkSignUpPageXpath).click()
    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Help | Flickr"))
    # assert driver.current_url == expectedURL
    # # time.sleep(3)
    # driver.close()
    # driver.switch_to.window(main_window)

    # expectedURL = "https://www.flickr.com/help/privacy"
    # driver.find_element_by_xpath(Locators.privacyPolicyLinkXpath).click()
    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Help | Flickr"))
    # assert driver.current_url == expectedURL
    # # time.sleep(3)
    # driver.close()
    # driver.switch_to.window(main_window)
    #
    # expectedURL = "https://www.flickr.com/help/terms"
    # driver.find_element_by_xpath(Locators.termsLinkSignUpPageXpath).click()
    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Help | Flickr"))
    # assert driver.current_url == expectedURL
    # time.sleep(3)
    # driver.close()
    # driver.switch_to.window(main_window)

    # expectedURL = "https://www.flickr.com/help/terms"
    # driver.find_element_by_xpath(Locators.termsOfServiceLinkXpath).click()
    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Help | Flickr"))
    # assert driver.current_url == expectedURL
    # # time.sleep(3)
    # driver.close()
    # driver.switch_to.window(main_window)


    # driver.switch_to.window(driver.window_handles[+1])
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.title_is("Flickr Login"))

def test_verifysignuppagelements(setup):

    driver.find_element_by_id(Locators.firstNameFieldId).is_displayed()
    driver.find_element_by_id(Locators.lastNameFieldId).is_displayed()
    driver.find_element_by_id(Locators.ageFieldId).is_displayed()
    driver.find_element_by_id(Locators.emailAdressField2Id).is_displayed()
    driver.find_element_by_id(Locators.passwordField2Id).is_displayed()
    # driver.find_element_by_id(Locators.recaptchaCheckboxId).is_displayed()
    driver.find_element_by_id(Locators.signUpButton2Id).is_displayed()

def test_wrongpasswordsignup(setup):
    signUpURL = driver.current_url
    wait = WebDriverWait(driver, 10)
    wait.until(EC.element_to_be_clickable((By.ID, Locators.firstNameFieldId))).send_keys(" 1passant")
    driver.find_element_by_id(Locators.lastNameFieldId).send_keys("ahmed! ")
    driver.find_element_by_id(Locators.ageFieldId).send_keys(14)
    driver.find_element_by_id(Locators.emailAdressField2Id).send_keys("pas@h.com")
    driver.find_element_by_id(Locators.passwordField2Id).send_keys("       1")
    signUpButton2 = driver.find_element_by_id(Locators.signUpButton2Id)
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located( (By.CSS_SELECTOR, "#root > div > main > div > div > form > div:nth-child(6) > p")))

    signUpButton2.click()
    passwordMesage = driver.find_element(By.CSS_SELECTOR,"#root > div > main > div > div > form > div:nth-child(6) > p")

    assert passwordMesage.text == "Password should be 12 characters or more"



    assert driver.current_url == signUpURL

    # driver.find_element_by_id(Locators.passwordField2Id).send_keys(u'\ue009' + u'\ue003')
    # passwordField.send_keys("123457891")

    # assert ageMessage.is_displayed()

    # time.sleep(2)

    assert driver.current_url == signUpURL

def test_wrongemailsignup(setup):
    signUpURL = driver.current_url
    wait = WebDriverWait(driver, 10)
    firstNameField = wait.until(EC.element_to_be_clickable((By.ID, Locators.firstNameFieldId))).send_keys(" 1passant")
    lastNameField = driver.find_element_by_id(Locators.lastNameFieldId).send_keys("ahmed! ")
    ageField = driver.find_element_by_id(Locators.ageFieldId).send_keys(14)
    emailField = driver.find_element_by_id(Locators.emailAdressField2Id).send_keys("pas@h.")
    passwordField = driver.find_element_by_id(Locators.passwordField2Id).send_keys(Locators.myPassword)
    signUpButton2 = driver.find_element_by_id(Locators.signUpButton2Id)
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR,"#root > div > main > div > div > form > div:nth-child(5) > p")))
    signUpButton2.click()
    # wait = WebDriverWait(driver, 30)
    # wait.until(EC.element_to_be_clickable((By.XPATH, Locators.invalidEmailMessageXpath)))

    assert driver.find_element(By.CSS_SELECTOR,"#root > div > main > div > div > form > div:nth-child(5) > p").text == "Email address is invalid"

    time.sleep(5)

    assert driver.current_url == signUpURL

    driver.find_element_by_id(Locators.emailAdressField2Id).clear()
    driver.find_element_by_id(Locators.emailAdressField2Id).send_keys("AGtest@mailserver.com")

    assert driver.current_url == signUpURL


def test_wrongagesignup(setup):
    signUpURL = driver.current_url
    wait = WebDriverWait(driver, 10)
    firstNameField = wait.until(EC.element_to_be_clickable((By.ID, Locators.firstNameFieldId)))
    lastNameField = driver.find_element_by_id(Locators.lastNameFieldId)
    ageField = driver.find_element_by_id(Locators.ageFieldId)
    emailField = driver.find_element_by_id(Locators.emailAdressField2Id)
    passwordField = driver.find_element_by_id(Locators.passwordField2Id)
    signUpButton2 = driver.find_element_by_id(Locators.signUpButton2Id)
    firstNameField.send_keys(" 1passant")
    lastNameField.send_keys("ahmed! ")
    emailField.send_keys(Locators.myEmail)
    passwordField.send_keys(Locators.myPassword)

    ageField.send_keys(10)
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.ageErrorMessageSelector)))
    ageMessage = driver.find_element(By.CSS_SELECTOR,Locators.ageErrorMessageSelector).text

    assert ageMessage == "Your age should be 13+"

    ageField.clear()

    ageField.send_keys("wrong password")

    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.ageErrorMessageSelector)))

    ageMessage = driver.find_element(By.CSS_SELECTOR, Locators.ageErrorMessageSelector).text

    assert ageMessage == "Age should be inputted as number"

    ageField.clear()

    ageField.send_keys("7!@&*haA")
    wait = WebDriverWait(driver, 10)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, Locators.ageErrorMessageSelector)))
    ageMessage = driver.find_element(By.CSS_SELECTOR, Locators.ageErrorMessageSelector).text


    assert ageMessage == "Age should be inputted as number", "BUG: Age error message didn't appear given invalid age = 7!@&*haA, but sign up wasn't successful as expected"
    # signUpButton2.click()
    assert driver.current_url == "signUpURL","BUG: Age error message didn't appear given invalid age = 7!@&*haA, and sign up was successful which wasn't expected"

def test_emptyfieldssignup(setup):
    signUpURL = driver.current_url
    time.sleep(5)
    driver.find_element_by_id("signup-btn").click()
    wait =WebDriverWait(driver,20)
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR,"#root > div > main > div > div > form > div:nth-child(4) > p")))

    assert (driver.find_element(By.CSS_SELECTOR , "#root > div > main > div > div > form > div:nth-child(4) > p")).text == "Age is required"
    assert (driver.find_element(By.CSS_SELECTOR ,"#root > div > main > div > div > form > div:nth-child(2) > p")).text == "First name is required"
    assert (driver.find_element(By.CSS_SELECTOR ,"#root > div > main > div > div > form > div:nth-child(3) > p")).text == "Last name is required"
    assert (driver.find_element(By.CSS_SELECTOR ,"#root > div > main > div > div > form > div:nth-child(6) > p")).text == "Password is required"
    assert (driver.find_element(By.CSS_SELECTOR ,"#root > div > main > div > div > form > div:nth-child(5) > p")).text == "Email is required"
    assert driver.current_url == signUpURL

# def test_validsignup(setup):
#     # wait = WebDriverWait(driver, 30)
#     driver.find_element(By.ID, Locators.firstNameFieldId).send_keys(" 1passant")
#     driver.find_element_by_id(Locators.lastNameFieldId).send_keys("ahmed! ")
#     driver.find_element_by_id(Locators.ageFieldId).send_keys(14)
#     driver.find_element_by_id(Locators.emailAdressField2Id).send_keys("passantahmed562@yahoo.com")
#     driver.find_element_by_id(Locators.passwordField2Id).send_keys("AHAHAHHAhahaha122")
#     signUpButton2 = driver.find_element_by_id(Locators.signUpButton2Id)
#     time.sleep(30)
#     signUpButton2.click()
#     wait = WebDriverWait(driver, 5)
#     # checkInboxMessage = wait.until(EC.presence_of_element_located((By.XPATH, Locators.checkYourInboxMesssageXpath)))
#     # assert checkInboxMessage.is_displayed()
#     # time.sleep(2)
#     wait.until((EC.url_changes))
#     # assert driver.current_url == "https://identity.flickr.com/check-email/sign-up"
#     #print("Get Confirmation Email")
#
#
#     assert driver.current_url == "https://www.flickrclone.tech/account"
#    # print("SIGN UP DONE")