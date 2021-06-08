from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from locators import Locators

Path = "C:\Program Files (x86)\chromedriver.exe";
driver = webdriver.Chrome(Path);

driver.get("https://flickr.com/");
driver.maximize_window()

loginButton = driver.find_element_by_xpath(Locators.logInButtonXpath)
loginButton.click()

driver.implicitly_wait(20)

emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
emailAddressField.send_keys("passantahmed562@yahoo.com");

nextButton = driver.find_element_by_xpath(Locators.nextButtonXpath);
nextButton.click()

driver.implicitly_wait(20)

passwordField = driver.find_element_by_id(Locators.passwordFieldId);
passwordField.send_keys("123456789101112m");


signInButton = driver.find_element_by_xpath(Locators.signInButtonXpath);
signInButton.click()

wait = WebDriverWait(driver, 20)
wait.until(EC.element_to_be_clickable((By.XPATH,Locators.profileIconXpath)))

assert driver.current_url == "https://flickr.com/", "Invalid URL"

assert driver.title == "Home | Flickr" , "Invalid Title"


profileIcon = driver.find_element_by_xpath(Locators.profileIconXpath)
profileIcon.click()
wait = WebDriverWait(driver, 20)
wait.until(EC.element_to_be_clickable((By.XPATH,Locators.settingsLinkXpath)))

driver.find_element_by_xpath(Locators.settingsLinkXpath).click();

driver.implicitly_wait(20)
settingsURL = "https://flickr.com/account"

assert driver.current_url == settingsURL, "Invalid URL"
# wait = WebDriverWait(driver, 5)
# wait.until(driver.find_element_by_id(Locators.accountSettingsId))

driver.find_element_by_xpath(Locators.deleteAccountXpath).click();

deleteAccountURL ="https://www.flickr.com/account/delete"
print(driver.current_url)
wait = WebDriverWait(driver, 10)
wait.until(EC.title_is("Flickr: Delete your account"))
assert  driver.current_url == deleteAccountURL, "Invalid URL"


expectedURL = "https://www.flickr.com/account/prefs/screenname/"
screenNameURL = driver.find_element_by_xpath(Locators.changeYourScreenNameXpath).get_property("href")
driver.get(screenNameURL)
wait = WebDriverWait(driver, 10)
wait.until(EC.title_is("Flickr: Change your screen name"))

assert driver.current_url == expectedURL

driver.back()



expectedURL = "https://identity.flickr.com/change-email"
editEmailURL = driver.find_element_by_xpath(Locators.editYourEmailAddressXpath).get_property("href")
driver.get(editEmailURL)
wait = WebDriverWait(driver, 10)
wait.until(EC.title_is("Flickr Login"))

assert driver.current_url == expectedURL

driver.back()

expectedURL = "https://www.flickr.com/account/"
goBackToAccountURL = driver.find_element_by_xpath(Locators.goBackToYourAccountPageXpath).get_property("href")
driver.get(goBackToAccountURL)
wait = WebDriverWait(driver, 10)
wait.until(EC.title_is("Account settings | Flickr"))

assert driver.current_url == expectedURL
driver.find_element_by_xpath(Locators.accountSettingsXpath).is_displayed()
driver.back()

accountLinkInDeletePage = driver.find_element_by_xpath(Locators.accountLinkInDeletePageXpath).text
userNameinDeletePage = driver.find_element_by_xpath(Locators.userNameInDeletePageXpath).text

# assert accountLinkInDeletePage == "https://flickr.com/photos/192940881@N02/"
# assert userNameinDeletePage == "passant6"


driver.get(driver.find_element_by_xpath(Locators.okNextButtonXpath).get_property("href"))

##Click delete without checking the box


driver.find_element_by_xpath(Locators.deleteMyAccountButtonXpath).click()


assert driver.title == "Flickr: Delete your account"
assert driver.find_element_by_class_name(Locators.problemClass).text == "Please check the box to confirm that you understand your photos and videos and metadata will be deleted."


 ##Check go back to your account link

accountLinkInDeletePage2 = driver.find_element_by_xpath(Locators.goBackToYourAccountPage2Xpath).get_property("href")

assert accountLinkInDeletePage2 == goBackToAccountURL

 ##Click delete after checking the box

driver.find_element_by_xpath(Locators.checkBoxDeletePageXpath).click()
driver.find_element_by_xpath(Locators.deleteMyAccountButtonXpath).click()


assert driver.find_element_by_xpath(Locators.yourAccountHasBeenDeleted).text == "Your account has been deleted. Goodbye!"
driver.refresh()
# driver.back()
# assert driver.find_element_by_xpath(Locators.userNameInIconXpath) != "passantahmed562"
driver.get("https://flickr.com/")
loginButton = driver.find_element_by_xpath(Locators.logInButtonXpath)
loginButton.click()

driver.implicitly_wait(15)

emailAddressField = driver.find_element_by_id(Locators.emailAddressFieldId);
emailAddressField.send_keys(Locators.myEmail);

nextButton = driver.find_element_by_xpath(Locators.nextButtonXpath);
nextButton.click()

driver.implicitly_wait(15)

passwordField = driver.find_element_by_id(Locators.passwordFieldId);
passwordField.send_keys(Locators.myPassword);

signInButton = driver.find_element_by_xpath(Locators.signInButtonXpath);
signInButton.click()

assert driver.current_url.__contains__("https://identity.flickr.com/")
assert driver.title == "Flickr Login"
assert driver.find_element_by_xpath(Locators.wrongEmailOrPasswordMessageXpath).text == "Invalid email or password."












# time.sleep(5)
#
# driver.close();
# driver.quit();
