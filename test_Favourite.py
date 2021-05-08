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

#Variables
email = "ossyahya60@gmail.com"
password = "32233750Yhaya"

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
time.sleep(5)
driver.get("https://www.flickr.com/photos/116685283@N05/51140140914/in/dateposted/")
time.sleep(10)

#Locators
FavouriteButton = driver.find_element_by_xpath(LocatorS.FavouriteButton)

#Locators
FavesCountPrev = int(driver.find_element_by_class_name(LocatorS.FavesCount).text)

#Actions
FavouriteButton.click()

time.sleep(5)

#Locators
FavesCountCurrent = int(driver.find_element_by_class_name(LocatorS.FavesCount).text)

#Check If Button is really pressed
assert FavesCountCurrent > FavesCountPrev
assert FavouriteButton.get_attribute("class") == "fave-star animated is-faved"

time.sleep(5)

driver.quit()