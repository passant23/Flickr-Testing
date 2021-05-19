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
    driver.implicitly_wait(60) # seconds
    driver.get("https://identity.flickr.com/")
    #driver.maximize_window()

    #Variables
    email = "ossyahya60@gmail.com"
    password = "32233750Yhaya"
    username = "Osama Yahya"
    global commentText
    commentText = "Nice Photo!"
    global commentFormatFlicker1
    global commentFormatFlicker2
    commentFormatFlicker1 = username + "\n" + "1s" + "\n" + commentText
    commentFormatFlicker2 = username + " " + "1s" + "\n" + commentText

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
    driver.get("https://www.flickr.com/photos/192752737@N07/51159264190/in/dateposted/")
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
    commentsCount = driver.find_element_by_class_name(Locators.commentsCount)
    prevCount = int(commentsCount.text)

    #Actions
    commentButton.click()

    time.sleep(5)

    #Locators
    comments = driver.find_elements_by_xpath(Locators.comments)
    commentsText = [commentText.text for commentText in comments]

    commentedSuccessfully = False
    for oneComment in commentsText:
        if oneComment == commentFormatFlicker1 or oneComment == commentFormatFlicker2:
            commentedSuccessfully = True
            break

    assert commentedSuccessfully == True

    commentsCount = driver.find_element_by_class_name(Locators.commentsCount)
    currentCount = int(commentsCount.text)

    assert currentCount > prevCount