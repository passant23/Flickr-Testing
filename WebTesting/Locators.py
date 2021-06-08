class Locators():
    #General
    email = "login-email-field"
    nextButton = '//*[@id="login-form"]/button'
    password = "login-psswrd-field"
    loginButton = "/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[3]/div/ul[2]/li[2]/a"
    signIn = '/html/body/div[1]/div/main/div/div/form/div[4]/button'

    #Favourite
    favouriteButton = 'photo-like-unfilled-btn'
    favouritedButton = 'photo-like-filled-btn'
    favesCount = "/html/body/div/div/main/div[2]/div/div/div[2]/div[1]/div/div[1]/div[2]/span[1]"

    #Comment
    commentField = '/html/body/div/div/main/div[2]/div/div/div[1]/div[3]/div/div[2]/textarea'
    commentButton = '/html/body/div/div/main/div[2]/div/div/div[1]/div[3]/div/button'
    commentsCount = "/html/body/div/div/main/div[2]/div/div/div[2]/div[1]/div/div[1]/div[3]/span[1]"
    comments = "/html/body/div/div/main/div[2]/div/div/div[1]/div[3]/ul"

    #Edit Description
    editDescriptionArea = '/html/body/div/div/main/div[2]/div/div/div[1]/div[2]/div'
    editDescriptionTextField = '/html/body/div/div/main/div[2]/div/div/div[1]/div[2]/div/textarea'
    doneButton = 'photo-detail-done-btn'
    descriptionField = '/html/body/div/div/main/div[2]/div/div/div[1]/div[2]/div/p'

    #Add Tags
    addTagsButton = '/html/body/div/div/main/div[2]/div/div/div[2]/div[5]/div/p'
    tagTextField = '/html/body/div/div/main/div[2]/div/div/div[2]/div[5]/div/input'
    tagsList = "/html/body/div/div/main/div[2]/div/div/div[2]/div[5]/div/ul"

    #Delete Comment
    deleteCommentButton = "photodetail-delete-btn"
    confirmDeleteButton = "/html/body/div[2]/div[2]/div/div[4]/div/div[2]/button[2]"