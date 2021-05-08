from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from msedge.selenium_tools import Edge, EdgeOptions
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import time
from Locators import Locators

# Change this according to your chosen browser
options = EdgeOptions()
options.use_chromium = True

driver = Edge(options = options)
driver.implicitly_wait(10) # seconds
driver.get("https://identity.flickr.com/")

#Variables
email = "ossyahya60@gmail.com"
password = "32233750Yhaya"
NewDescription = "Very Noice"

LocatorS = Locators()

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
time.sleep(6)
driver.get("https://www.flickr.com/photos/192752737@N07/51159264190/in/dateposted/")
time.sleep(10)

#CookieClose = driver.find_element_by_xpath('/html/body/div[1]/div/div[4]/div/div/div/div/div/div[2]/a').click()

#Locators
EditDescriptionArea = driver.find_element_by_xpath(LocatorS.EditDescriptionArea)

#Actions
EditDescriptionArea.send_keys(Keys.ENTER)

#Locators
EditDescriptionTextField = driver.find_element_by_xpath(LocatorS.EditDescriptionTextField)

#Actions
EditDescriptionTextField.clear()
EditDescriptionTextField.send_keys(NewDescription)

#Locator and Action
WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, LocatorS.DoneButton))).click()

driver.refresh()

time.sleep(5)

DescriptionField = driver.find_element_by_xpath(LocatorS.DescriptionField)
Description = DescriptionField.text

assert Description == NewDescription

time.sleep(5)

driver.quit()