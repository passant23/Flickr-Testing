from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from msedge.selenium_tools import Edge, EdgeOptions
import time
from Locators import Locators

# Change this according to your chosen browser
options = EdgeOptions()
options.use_chromium = True

driver = Edge(options = options)
driver.implicitly_wait(10) # seconds
driver.get("https://identity.flickr.com/")

LocatorS = Locators()

#Variables TODO Fill these
email = "ossyahya60@gmail.com"
password = "32233750Yhaya"
Username = "Osama Yahya"
CommentText = "Nice Photo!"
CommentFormatFlicker1 = Username + "\n" + "1s" + "\n" + CommentText
CommentFormatFlicker2 = Username + " " + "1s" + "\n" + CommentText

#Locators
Email = driver.find_element_by_id(LocatorS.Email)
NextButton = driver.find_element_by_xpath(LocatorS.NextButton)

#Actions
Email.send_keys(email)
NextButton.click()

#Locators
Password = driver.find_element_by_id(LocatorS.Password)
SignIN = driver.find_element_by_xpath(LocatorS.SignIN)

#Actions
Password.send_keys(password)
SignIN.click()
time.sleep(10)
driver.get("https://www.flickr.com/photos/37607627@N05/51133618573/in/explore")
time.sleep(10)

#Locators
CommentField = driver.find_element_by_xpath(LocatorS.CommentField)

#Actions
CommentField.send_keys(CommentText)

#Locators
CommentButton = driver.find_element_by_xpath(LocatorS.CommentButton)

#Locators
CommentsCount = driver.find_element_by_class_name(LocatorS.CommentsCount)
PrevCount = int(CommentsCount.text)

#Actions
CommentButton.click()

time.sleep(5)

#Locators
Comments = driver.find_elements_by_xpath(LocatorS.Comments)
CommentsText = [commentText.text for commentText in Comments]

CommentedSuccessfully = False
for OneComment in CommentsText:
    if OneComment == CommentFormatFlicker1 or OneComment == CommentFormatFlicker2:
        CommentedSuccessfully = True
        break

assert CommentedSuccessfully == True

CommentsCount = driver.find_element_by_class_name(LocatorS.CommentsCount)
CurrentCount = int(CommentsCount.text)

assert CurrentCount > PrevCount

time.sleep(5)

driver.quit()