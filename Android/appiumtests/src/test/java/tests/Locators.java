package tests;

public class Locators {
	
	//Log in
	String logInTitleAccessibilityId = "Log in to Flickr";
	String emailAddressLogInXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText";
	String nextId = "Next";
	String emailReqId = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]";
	String popUpMessageId = "Hmm... that's not an email address";
	String tryAgainPopUpId = "Try Again";
	String toYahooId = "Continue to Yahoo";
	String passwordLoginXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]";
	String signInButtonId = "Sign in";
	String forgetPasswordId = "	Forgot password?";
	String requiredPassword = "(//android.view.View[@content-desc=\"Required\"])[2]";
	String aboutPageData = "p test 0 Followers — 0 Following";
	String invalidPasswordMessageId = "Invalid password";
	String invalidEmailOrPasswordId = "Invalid email or password.";
	String reqEmailXpath = "(//android.view.View[@content-desc=\"Required\"])[1]";
	String reqPasswordXpath = "(//android.view.View[@content-desc=\"Required\"])[2]";
	String moreXpath = "//android.view.View[@content-desc=\"p test 0 Followers — 0 Following\"]/android.widget.Button";
	String signOutId = "Sign Out";
	
	//Sign up
	String firstName = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]";
	String lastName = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]";
	String age = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]";
	String emailAddressSignUp = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]";
	String passwordSignUp = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]";
	String signUpButtonSignUpPageAccessibilityId = "Sign up";
	String logInHereSignUpPageAccessibilityId = "Log in here";
	String ageErrorAccessibilityId ="In order to sign up you must be 13 or older";
	String signUpTitleAccessibilityId = "Sign up for Flickr";
	String requiredFirstNameXpath = "(//android.view.View[@content-desc=\"Required\"])[1]";
	String requiredLastNameXpath = "(//android.view.View[@content-desc=\"Required\"])[2]";
	String requiredEmailSignUpXpath = "(//android.view.View[@content-desc=\"Required\"])[4]";
	String requiredPasswordSignUpXpath = "(//android.view.View[@content-desc=\"Required\"])[5]";
	String requiredAgeSignUpXpath = "(//android.view.View[@content-desc=\"Required\"])[3]";
	String duplicatedEmailMessageXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]";
	String invalidEmailMessageSignUpId = "Invalid input data. Invalid email address";
}
