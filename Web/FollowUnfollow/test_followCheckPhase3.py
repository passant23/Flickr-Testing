from selenium import webdriver
import unittest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver import ActionChains
from selenium.common.exceptions import NoSuchElementException
from locators import Locators
from locators_phase3 import locatorsPhase3

import pytest
import time

@pytest.fixture()
def setup():
    global driver
    driver=webdriver.Chrome(executable_path="C:\webdrivers\chromedriver.exe")
    driver.maximize_window();
    driver.get("https://www.flickrclone.tech/login");
    myEmail = "max@gmail.com";
    myPassword = "Mm$123456789";

    emailAddressField = driver.find_element_by_id("login-email-field");
    emailAddressField.send_keys(myEmail);
    driver.implicitly_wait(30)
    passwordField = driver.find_element_by_id("login-psswrd-field");
    passwordField.send_keys(myPassword);
    signInButton = driver.find_element_by_xpath(locatorsPhase3.signInButtonXpath);
    signInButton.click();
    driver.implicitly_wait(100)
    pageURL = driver.current_url;
    expectedPageURL="https://www.flickrclone.tech/home"
    #assert pageURL==expectedPageURL , "Login failed"
    headerYou=driver.find_element_by_xpath(locatorsPhase3.headerYouXpath);
    hoverYou = ActionChains(driver).move_to_element(headerYou)
    hoverYou.perform()
    yield
    driver.close()
    driver.quit()



def test_followCheck(setup):
    searchInput = driver.find_element_by_xpath(locatorsPhase3.searchInputXpath);
    profile = "maria maximus"
    searchInput.send_keys(profile);
    time.sleep(2)
    searchInput.click()
    searchPeople = driver.find_element_by_xpath(locatorsPhase3.searchPeopleXpath);
    searchPeople.click()
    profileFound = False
    try:
        profileFound = driver.find_element_by_id(profile).is_displayed()
    except NoSuchElementException:
        profileFound = False

    assert profileFound == True, "found the profile"
    #press follow button
    followButton = driver.find_element_by_xpath(Locators.followButtonXpath)
    print(followButton.text)
    # assert followButton.text == 'Following';
    time.sleep(2);
    #go to my profile
    ProfileButton = driver.find_element_by_xpath(Locators.profileButtonXpath);
    ProfileButton.click();
    time.sleep(3);
    ProfileNameButton=driver.find_element_by_xpath(Locators.profileNameButtonXpath);
    ProfileNameButton.click();


    followersButton=driver.find_element_by_xpath(Locators.followingButtonXpath);
    followersButton.click();


    searchFollowingInput=driver.find_element_by_xpath(Locators.searchFollowingInputXpath);
    searchFollowingInput.send_keys(profile)
    try:
        searchProfile = driver.find_element_by_xpath(Locators.searchProfileXpath);
        print("found")
        profileName=searchProfile.text;
        time.sleep(3);
        # print(profileName)
        # print(profile)
        assert profile == profileName, "Failed to follow this user"


    except NoSuchElementException:
        print("not found")





