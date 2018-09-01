/*
Method to validate form if all fields in the form are correct than it will submit, otherwise not
*/
var error;
function validateForm(){
    window.error = [];
    if(validateFirstName() && validateLastName() && validateEmail() && 
        validatePassword() && validateConfirmPassword() && validateContactNumber()){
        return true;
    }
    alert(error.join("\n"));
    error = []
    return false;
}

/*
Method to validate the firstName by ensuring that it contain atleast 2 character and it must not 
contain any numeric character
*/
function validateFirstName(){
    var firstName = document.getElementById('firstName');
    if(/^[a-zA-Z]{2,}$/.test(firstName.value)){
        firstName.style.border = "2px solid green";
        return true;
    }else{
        firstName.style.border = "2px solid red";
        error.push("Invalid First Name");
        return false;
    }
}

/*
Method to validate the lastName by ensuring that it contain atleast 2 character and it must not 
contain any numeric character
*/
function validateLastName(){
    var lastName = document.getElementById('lastName');
    if(/^[a-zA-Z]{2,}$/.test(lastName.value)){
        lastName.style.border = "2px solid green";
        return true;
    }else{
        lastName.style.border = "2px solid red";
        error.push("Invalid Last Name");
        return false;
    }
}

/*
Method to validate the email should contains @ ., length etc.
*/
function validateEmail(){
    var email = document.getElementById('email');
    if(/^([a-zA-Z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]+)$/.test(email.value)){
        email.style.border = "2px solid green";
        return true;
    }else{
        email.style.border = "2px solid red";
        error.push("Invalid Email");
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
        error.push("Invalid Password");
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
        error.push("Password is not matching");
        return false;
    }
}

/*
Method to validate contact number Numbers only, length > 8
*/
function validateContactNumber(){
   var contactNumber = document.getElementById('contactNumber');
    if(/^[0-9]{10}$/.test(contactNumber.value)){
        contactNumber.style.border = "2px solid green";
        return true;
    }else{
        contactNumber.style.border = "2px solid red";
        error.push("Invalid Contact Number");
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

function redirectToProfile(){
    window.location.replace("profile.html");
    return false;
}

function changeToTextBox(){
    var firstName = document.getElementById('profileFirstName').innerHTML = '<input type = "text" id = "firstName" onkeyup = "validateFirstName()" required/>';
    var lastName = document.getElementById('profileLastName').innerHTML = '<input type = "text" id = "lastName" onkeyup = "validateLastName()" required/>';
    var email = document.getElementById('profileEmail').innerHTML = '<input type = "email" id = "email" onkeyup = "validateEmail()" required/>';
    var contactNumber = document.getElementById('profileContactNumber').innerHTML = '<input type = "tel" id = "contactNumber" onkeyup = "validateContactNumber()" required/>';
    var company = document.getElementById('profileCompany').innerHTML = '<select required>' +
							                                            '<option> Appcino </option>' +
                                                                        '<option> Infosys </option>' +
                                                                        '<option> Metacube Software </option>' +
                                                                        '<option> Mindtree </option>' +
                                                                        '<option> TCS </option>' +
						                                          '</select>';
    var createSubmitButtom = document.getElementById('button').innerHTML = '<input type = "button" value = "Submit" onclick = "return redirectToProfile()">';
}