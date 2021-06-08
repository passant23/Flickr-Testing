class Locators():
    # Welcome Page Locators

    logInButtonSelector = "#content > div > div.view.global-nav-view.requiredToShowOnServer > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.gn-tools > li.gn-signin.tablet-and-desktop-only > a"
    signUpButtonSelector = "#content > div > div.view.global-nav-view.requiredToShowOnServer > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.gn-tools > li.gn-signup > a"

    # Login Page Locators

    myEmail = "mariamaximus1012@gmail.com"
    myPassword = "1234567891011m";
    passantsEmail = "passantahmedmaher@gmail.com"
    passantsPassword = "123456789123"
    emailAddressFieldId = "login-email-field";
    passwordFieldId = "login-psswrd-field";
    rememberPasswordCheckBoxXpath = "/html/body/div/div/div[2]/div/div[2]/form/div[3]/label/span[1]/span/span"
    # nextButtonXpath = "/html/body/div/div/div[2]/div/div[2]/form/button";
    signInButtonId = "login-signin-btn";
    chooseAnAccountXpath = "/html/body/div/div/div[2]/div/div[1]/h6"
    wrongEmailOrPasswordMessageSelector = "#root > div > main > div > div > form > div.Login_div__usererror__OfBjA > p"
    wrongPasswordMessageXpath = "/html/body/div/div/div[2]/div/div[2]/form/div[3]/div/div[2]/p"
    requiredEmailMessageSelector = "#root > div > main > div > div > form > div:nth-child(2) > p"
    requiredPasswordMessageSelector = "#root > div > main > div > div > form > div:nth-child(3) > p"
    helpLinkLogInPageXpath = "/html/body/div/div/div[2]/div/div[4]/div[2]/a[1]"
    privacyLinkLogInPageXpath = "/html/body/div/div/div[2]/div/div[4]/div[2]/a[2]"
    termsLinkLogInPageXpath = "/html/body/div/div/div[2]/div/div[4]/div[2]/a[3]"
    signUpLinkLogInPageId = "signup-here-link"
    loginTitleSelector = "#root > div > main > div > div > form > h5"
    forgotPasswordId = "forgot-psswrd-link"

    # Home Page
    settingsLinkXpath = "/html/body/div[5]/div/div[2]/div/div/div/section[3]/ul/li[2]/a"
    profileIconXpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/ul[2]/li[4]/div/div/div/a/div"
    userNameXpath = "/html/body/div[4]/div/div[2]/div/div/div/section[1]/h4/a"
    userName = "mariamaximus1012"
    logOutSelector = "#content > div > div > div > div.global-nav-content.styleguide-global-nav.fluid.sohp-mobile-navable > div > ul.gn-tools > li:nth-child(5) > a"

    # Sign Up

    firstNameFieldId = "signup-first-name-field"
    lastNameFieldId = "signup-last-name-field"
    ageFieldId = "signup-age-field"
    emailAdressField2Id = "signup-email-field"
    passwordField2Id = "signup-pssword-field"
    signUpButton2Id = "signup-btn"

    ageErrorMessageSelector = "#root > div > main > div > div > form > div:nth-child(4) > p"
    invalidPasswordMessageXpath = "/html/body/div[1]/div/div[2]/div/div[1]/form/div[5]/div/div[2]/p"
    invalidEmailMessageXpath = "/html/body/div[1]/div/div[2]/div/div[1]/form/div[4]/div[2]/p"
    recaptchaCheckboxSelector = "#recaptcha-anchor > div.recaptcha-checkbox-border"
    recaptchaCheckMarkXpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]"
    privacyPolicyLinkXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/p/a[2]"
    termsOfServiceLinkXpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/p/a[1]"
    logInLinkSignUpPageSelector = "#login-here-link"
    helpLinkSignUpPageXpath = "/html/body/div[1]/div/div[2]/div/div[3]/div[2]/a[1]"
    privacyLinkSignUpPageXpath = "/html/body/div[1]/div/div[2]/div/div[3]/div[2]/a[2]"
    termsLinkSignUpPageXpath = "/html/body/div[1]/div/div[2]/div/div[3]/div[2]/a[3]"
    checkYourInboxMesssageXpath = "/html/body/div[1]/div/div[2]/div/div[1]/h6"
    firstNameRequiredSelector = "#root > div > main > div > div > form > div:nth-child(2) > p"
    lastNameRequiredSelector = "#root > div > main > div > div > form > div:nth-child(3) > p"
    ageRequiredSelector = "#root > div > main > div > div > form > div:nth-child(4) > p"
    passwordRequiredSelector = "#root > div > main > div > div > form > div:nth-child(6) > p"
    emailRequiredSelector = "#root > div > main > div > div > form > div:nth-child(5) > p"
    recaptchaRequiredSelector = "#root > div > main > div > div > form > div.Signup_div__usererror__kP4D7 > p"

    # Account Page
    deleteAccountXpath = "/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div[2]/div[2]/p/a[2]"
    accountSettingsId = "yui_3_16_0_1_1620183990975_669"

    # Change Screen Name Page
    changeScreenNameH1Id = "yui_3_11_0_1_1620184219577_325"
    saveButtonXpath = "/html/body/div[2]/table/tbody/tr/td[2]/form/p[2]/input"
    screenNameFieldId = "yui_3_11_0_1_1620184219577_336"
    yourProfilePageLinkId = "yui_3_11_0_1_1620184219577_355"

    # Delete Account Page
    okNextButtonXpath = "/html/body/div[2]/div/a"
    changeYourScreenNameXpath = "/html/body/div[2]/div/p[3]/a[1]"
    editYourEmailAddressXpath = "/html/body/div[2]/div/p[3]/a[2]"
    goBackToYourAccountPage = "/html/body/div[2]/div/p[4]/a"

    # Forget Password Page
    forgetPasswordTitleSelector = "#root > div > main > div > form > h4"
    emailId = "email"
    forgetPasswordButtonId = "forgotpassword-button"



    #Search

    searchInputXpath = "/html/body/div/div/div/div/div/div/div/div/div[3]/div/ul[2]/li[1]/div/form/input"
    searchPeopleXpath = "/html/body/div/div/main/div/button[2]"
    profileNameXpath = "/html/body/div/div/main/div/div[1]/div/h2"
