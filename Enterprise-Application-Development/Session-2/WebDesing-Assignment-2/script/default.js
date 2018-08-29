/*
Method to validate form if all fields in the form are correct than it will submit, otherwise not
*/
function validateForm(){
    if(validateFirstName() && validateLastName() && validateEmail() && 
        validatePassword() && validateConfirmPassword() && validateContactNumber()){
        return true;
    }
    alert('Invalid Input');
    return false;
}

/*
Helper method to validate firstName and lastName.
*/
function validateName(name){
    if(/^[a-zA-Z]{2,}$/.test(name.value)){
        name.style.border = "2px solid green";
        return true;
    }else{
        name.style.border = "2px solid red";
        return false;
    }
}
/*
Method to validate the firstName by ensuring that it contain atleast 2 character and it must not 
contain any numeric character
*/
function validateFirstName(){
    var firstName = document.getElementById('firstName');
    validateName(firstName);
}

/*
Method to validate the lastName by ensuring that it contain atleast 2 character and it must not 
contain any numeric character
*/
function validateLastName(){
   var lastName = document.getElementById('lastName');
    validateName(lastName);
}

/*
Method to validate the email should contains @ ., length etc.
*/
function validateEmail(){
    var email = document.getElementById('email');
    if(/^([a-z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]+)$/.test(email.value)){
        email.style.border = "2px solid green";
        return true;
    }else{
        email.style.border = "2px solid red";
        return false;
    }
}

/*
Method to validate password should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8
*/
function validatePassword(){
    var password = document.getElementById('password');
    if(/[a-zA-Z0-9]+/.test(password.value) && /[^a-zA-Z0-9]+/.test(password.value) &&
        password.value.length >= 8){
        password.style.border = "2px solid green";
        return true;
    }else{
        password.style.border = "2px solid red";
        return false;
    }
}

/*
Method to validate whether the password is same as above password field
*/
function validateConfirmPassword(){
    var password = document.getElementById('password');
    var confirmPassword = document.getElementById('confirmPassword');
    if(confirmPassword.value == password.value){
        confirmPassword.style.border = "2px solid green";
        return true;
    }else{
        confirmPassword.style.border = "2px solid red";
        return false;
    }
}

/*
Method to validate contact number Numbers only, length > 8
*/
function validateContactNumber(){
   var contactNumber = document.getElementById('contactNumber');
    if(/^[0-9]{9,}$/.test(contactNumber.value)){
        contactNumber.style.border = "2px solid green";
        return true;
    }else{
        contactNumber.style.border = "2px solid red";
        return false;
    }
}

/*
Method to redirect to the profile page after successful login
*/
function redirect(){
  window.location.replace("profile.html");
  return false;
}

/*
Method to redirect to the login page after successful registration
*/
function redirectToLogin(){
  window.location.replace("login.html");
  return false;
}