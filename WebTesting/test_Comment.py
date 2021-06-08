from msedge.selenium_tools import Edge, EdgeOptions
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
    username = "Osama Yahya"
    global commentText
    commentText = "Nice Photo, Yay V3"
    global commentFormatFlicker
    commentFormatFlicker = username + "just now\n" + commentText

    #Locators
    loginButton = driver.find_element_by_xpath(Locators.loginButton)

    #Action
    loginButton.click()

    time.sleep(1)

    #Locators
    emailField = driver.find_element_by_id(Locators.email)

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


def test_CommentNormal(setup):
    #Locators
    commentField = driver.find_element_by_xpath(Locators.commentField)

    #Actions
    commentField.send_keys(commentText)

    #Locators
    commentButton = driver.find_element_by_xpath(Locators.commentButton)

    #Locators
    commentsCount = driver.find_element_by_xpath(Locators.commentsCount)
    prevCount = int(commentsCount.text)

    #Actions
    commentButton.click()
    time.sleep(1)

    driver.refresh()

    time.sleep(5)

    #Locators
    comments = driver.find_elements_by_xpath(Locators.comments)
    commentsText = [commentText.text for commentText in comments]
    commentsAllText = commentsText[0].split('\n')

    commentedSuccessfully = False
    for i in range(0, len(commentsAllText), 2):
        if commentsAllText[i] + "\n" + commentsAllText[i+1] == commentFormatFlicker:
            commentedSuccessfully = True
            break

    assert commentedSuccessfully == True, "Couldn't comment or it's duplicate!"

    commentsCount = driver.find_element_by_xpath(Locators.commentsCount)
    currentCount = int(commentsCount.text)

    assert currentCount > prevCount, "Comments didn't increase!"