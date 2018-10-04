function validateForm() {
    if (validateFirstName() && validateLastName() && validateEmail() && validatePhoneNumber() && validateAddress() && validateCityName()) {
        var state = document.getElementById('state');
        if (state.value === 'none') {
            document.getElementById('stateErrorField').innerHTML = 'Selection of state is mandatory';
            state.style.border = "1px solid red";
            return false;
        }else{
            localStorage.setItem('state', state.value);
            document.getElementById('stateErrorField').innerHTML = '';
            state.style.border = "1px solid green";
            if (state.value === 'rajasthan' && validateWebsite() && validateProject()) {
                return true;
            } else if (state.value === 'haryana' && validateZipCode()) {
                if (document.getElementById('yes').checked) {
                    localStorage.setItem('hosting', 'yes');
                } else {
                    localStorage.setItem('hosting', 'no');
                }
                return true;
            } else if (state.value === 'maharashtra' && validateZipCode() && validateProject()) {
                return true;
            }
            return false;
        }
    } else {
            return false;
    }
}

function redirectToProfile(){
    window.location.replace("profile.html");
    return false;
}

function validateZipCode() {
    var zipCode = document.getElementById('zip');
    if (zipCode.value === '') {
        document.getElementById('zipCodeErrorField').innerHTML = 'The Zip Code cannot be empty';
        zipCode.style.border = "1px solid red";
        return false;
    } else {
        if (/^[0-9]{6}$/.test(zipCode.value)) {
            document.getElementById('zipCodeErrorField').innerHTML = '';
            zipCode.style.border = "1px solid green";
            localStorage.setItem('zipCode', zipCode.value);
            return true;
        } else if (zipCode.value.length > 6) {
            document.getElementById('zipCodeErrorField').innerHTML = 'The zip code contains more than 6 numbers';
            zipCode.style.border = "1px solid red";
            return false;
        } else {
            document.getElementById('zipCodeErrorField').innerHTML = 'The zip code contains less than 6 numbers';
            zipCode.style.border = "1px solid red";
            return false;
        }
    }
}

function validateProject() {
    var project = document.getElementById('project');
    if (project.value === '') {
        document.getElementById('projectErrorField').innerHTML = 'The project description cannot be empty';
        project.style.border = "1px solid red";
        return false;
    } else if (/^[\s]+$/.test(project.value)) {
        document.getElementById('projectErrorField').innerHTML = 'The project description must have some data instead of multiple spaces';
        project.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('projectErrorField').innerHTML = '';
        project.style.border = "1px solid green";
        localStorage.setItem('projectDescription', project.value);
        return true;
    }
}

function validateWebsite() {
    var website = document.getElementById('website');
    if (/^[\s]+$/.test(website.value)) {
        document.getElementById('websiteErrorField').innerHTML = 'The website field must contain values instead of spaces';
        website.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('websiteErrorField').innerHTML = '';
        website.style.border = "1px solid green";
        localStorage.setItem('website', website.value);
        return true;
    }
}

function validateFirstName() {
    var firstName = document.getElementById('firstname');
    if (firstName.value.length >= 2) {
        if (/^[a-zA-Z]{2,}$/.test(firstName.value)) {
            document.getElementById('firstNameErrorField').innerHTML = '';
            firstName.style.border = "1px solid green";
            localStorage.setItem('firstName', firstName.value);
            return true;
        } else {
            document.getElementById('firstNameErrorField').innerHTML = 'The first name must have characters only no spaces,numbers or special symbols are allowed in between';
            firstName.style.border = "1px solid red";
            return false;
        }
    } else if (firstName.value === '') {
        document.getElementById('firstNameErrorField').innerHTML = 'The first Name cannot be empty';
        firstName.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('firstNameErrorField').innerHTML = 'The first Name should contain atleast 2 character';
        firstName.style.border = "1px solid red";
        return false;
    }
}

function validateLastName() {
    var lastName = document.getElementById('lastname');
    if (lastName.value.length >= 2) {
        if (/^[a-zA-Z]{2,}$/.test(lastName.value)) {
            document.getElementById('lastNameErrorField').innerHTML = '';
            lastName.style.border = "1px solid green";
            localStorage.setItem('lastName', lastName.value);
            return true;
        } else {
            document.getElementById('lastNameErrorField').innerHTML = 'The last name must have characters only no spaces, numbers or special symbols are allowed in between';
            lastName.style.border = "1px solid red";
            return false;
        }
    } else if (lastName.value === '') {
        document.getElementById('lastNameErrorField').innerHTML = 'The last Name cannot be empty';
        lastName.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('lastNameErrorField').innerHTML = 'The last Name should contain atleast 2 character';
        lastName.style.border = "1px solid red";
        return false;
    }
}

function validateEmail() {
    var email = document.getElementById('email');
    if (email.value !== '') {
        if (/^([a-zA-Z0-9_\-\.]+)@([a-z0-9_\-\.]+)\.([a-z]+)$/.test(email.value)) {
            document.getElementById('emailErrorField').innerHTML = '';
            email.style.border = "1px solid green";
            localStorage.setItem('email', email.value);
            return true;
        } else {
            document.getElementById('emailErrorField').innerHTML = 'The email id is not upto the mark';
            email.style.border = "1px solid red";
            return false;
        }
    } else {
        document.getElementById('emailErrorField').innerHTML = 'The email id cannot be empty';
        email.style.border = "1px solid red";
        return false;
    }
}

function validatePhoneNumber() {
    var phone = document.getElementById('phone');
    if (/^[0-9]{10}$/.test(phone.value)) {
        document.getElementById('phoneErrorField').innerHTML = '';
        phone.style.border = "1px solid green";
        localStorage.setItem('phoneNumber', phone.value);
        return true;
    } else if (phone.value.length > 10) {
        document.getElementById('phoneErrorField').innerHTML = 'The phone number contains more than 10 number';
        phone.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('phoneErrorField').innerHTML = 'The phone number contains less than 10 number';
        phone.style.border = "1px solid red";
        return false;
    }
}

function validateAddress() {
    var address = document.getElementById('address');
    if (/^[\s]+$/.test(address.value)) {
        document.getElementById('addressErrorField').innerHTML = 'The address must have some value instead of spaces or it can be empty';
        address.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('addressErrorField').innerHTML = '';
        address.style.border = "1px solid green";
        localStorage.setItem('address', address.value);
        return true;
    }
}

function validateCityName() {
    var cityName = document.getElementById('city');
    if (/^[\s]+$/.test(cityName.value)) {
        document.getElementById('cityErrorField').innerHTML = 'The city name must have some value instead of spaces or it can be empty';
        cityName.style.border = "1px solid red";
        return false;
    } else {
        document.getElementById('cityErrorField').innerHTML = '';
        cityName.style.border = "1px solid green";
        localStorage.setItem('cityName', cityName.value);
        return true;
    }
}

function validateState() {
    var state = document.getElementById('state');
    if (state.value === 'haryana') {
        deleteElement();
        showZipCode();
        showDoYouHaveHosting();
    } else if (state.value === 'rajasthan') {
        deleteElement();
        showWebsite();
        showProjectDescription();
    } else if (state.value === 'maharashtra') {
        deleteElement();
        showZipCode();
        showProjectDescription();
    }
}

function deleteElement() {
    var element = document.getElementsByClassName('dynamic');
    while (element.length > 0) {
        element[0].parentNode.removeChild(element[0]);
    }
}

function showZipCode() {
    var div = document.createElement('div');
    div.setAttribute('class', 'form-group dynamic');
    var location = document.body.firstElementChild.firstElementChild.firstElementChild;
    location.insertBefore(div, location.lastElementChild);
    var label = document.createElement('label');
    label.setAttribute('class', 'col-md-4 control-label');
    label.textContent = 'Zip Code';
    div.appendChild(label);
    var innerDiv = document.createElement('div');
    innerDiv.setAttribute('class', 'col-md-4 inputGroupContainer');
    div.appendChild(innerDiv);
    var innerInnerDiv = document.createElement('div');
    innerInnerDiv.setAttribute('class', 'input-group');
    innerDiv.appendChild(innerInnerDiv);
    var span = document.createElement('span');
    span.setAttribute('class', 'input-group-addon');
    innerInnerDiv.appendChild(span);
    var i = document.createElement('i');
    i.setAttribute('class', 'glyphicon glyphicon-home');
    span.appendChild(i);
    var input = document.createElement('input');
    input.setAttribute('class', 'form-control');
    input.setAttribute('id', 'zip');
    input.setAttribute('placeholder', 'Zip Code');
    input.setAttribute('type', 'text');
    input.setAttribute('onblur', 'validateZipCode()');
    innerInnerDiv.appendChild(input);
    var p = document.createElement('p');
    p.setAttribute('id', 'zipCodeErrorField')
    innerDiv.appendChild(p);
}

function showDoYouHaveHosting() {
    var div = document.createElement('div');
    div.setAttribute('class', 'form-group dynamic');
    var location = document.body.firstElementChild.firstElementChild.firstElementChild;
    location.insertBefore(div, location.lastElementChild);
    var label = document.createElement('label');
    label.setAttribute('class', 'col-md-4 control-label');
    label.textContent = 'Do you have hosting?';
    div.appendChild(label);
    var innerDiv = document.createElement('div');
    innerDiv.setAttribute('class', 'col-md-4');
    div.appendChild(innerDiv);
    var innerInnerDiv1 = document.createElement('div');
    innerInnerDiv1.setAttribute('class', 'radio');
    innerDiv.appendChild(innerInnerDiv1);
    var innerInnerDiv1Label = document.createElement('label');
    innerInnerDiv1.appendChild(innerInnerDiv1Label);
    var innerInnerDiv1Input = document.createElement('input');
    innerInnerDiv1Input.setAttribute('type', 'radio');
    innerInnerDiv1Input.setAttribute('id', 'yes');
    innerInnerDiv1Input.setAttribute('value', 'yes');
    innerInnerDiv1Input.setAttribute('name', 'hosting');
    innerInnerDiv1Label.appendChild(innerInnerDiv1Input);
    var labelYes = document.createElement('label');
    labelYes.textContent = 'Yes';
    innerInnerDiv1Label.appendChild(labelYes);
    var innerInnerDiv1 = document.createElement('div');
    innerInnerDiv1.setAttribute('class', 'radio');
    innerDiv.appendChild(innerInnerDiv1);
    var innerInnerDiv1Label = document.createElement('label');
    innerInnerDiv1.appendChild(innerInnerDiv1Label);
    var innerInnerDiv1Input = document.createElement('input');
    innerInnerDiv1Input.setAttribute('type', 'radio');
    innerInnerDiv1Input.setAttribute('id', 'no');
    innerInnerDiv1Input.setAttribute('value', 'no');
    innerInnerDiv1Input.setAttribute('name', 'hosting');
    innerInnerDiv1Input.setAttribute('checked', 'checked');
    innerInnerDiv1Label.appendChild(innerInnerDiv1Input);
    var labelNo = document.createElement('label');
    labelNo.textContent = 'No';
    innerInnerDiv1Label.appendChild(labelNo);
}

function showWebsite() {
    var div = document.createElement('div');
    div.setAttribute('class', 'form-group dynamic');
    var location = document.body.firstElementChild.firstElementChild.firstElementChild;
    location.insertBefore(div, location.lastElementChild);
    var label = document.createElement('label');
    label.setAttribute('class', 'col-md-4 control-label');
    label.textContent = 'Website or domain name';
    div.appendChild(label);
    var innerDiv = document.createElement('div');
    innerDiv.setAttribute('class', 'col-md-4 inputGroupContainer');
    div.appendChild(innerDiv);
    var innerInnerDiv = document.createElement('div');
    innerInnerDiv.setAttribute('class', 'input-group');
    innerDiv.appendChild(innerInnerDiv);
    var span = document.createElement('span');
    span.setAttribute('class', 'input-group-addon');
    innerInnerDiv.appendChild(span);
    var i = document.createElement('i');
    i.setAttribute('class', 'glyphicon glyphicon-globe');
    span.appendChild(i);
    var input = document.createElement('input');
    input.setAttribute('class', 'form-control');
    input.setAttribute('id', 'website');
    input.setAttribute('placeholder', 'Website or domain name');
    input.setAttribute('type', 'text');
    input.setAttribute('onblur', 'validateWebsite()');
    innerInnerDiv.appendChild(input);
    var p = document.createElement('p');
    p.setAttribute('id', 'websiteErrorField')
    innerDiv.appendChild(p);
}

function showProjectDescription() {
    var div = document.createElement('div');
    div.setAttribute('class', 'form-group dynamic');
    var location = document.body.firstElementChild.firstElementChild.firstElementChild;
    location.insertBefore(div, location.lastElementChild);
    var label = document.createElement('label');
    label.setAttribute('class', 'col-md-4 control-label');
    label.textContent = 'Project Description';
    div.appendChild(label);
    var innerDiv = document.createElement('div');
    innerDiv.setAttribute('class', 'col-md-4 inputGroupContainer');
    div.appendChild(innerDiv);
    var innerInnerDiv = document.createElement('div');
    innerInnerDiv.setAttribute('class', 'input-group');
    innerDiv.appendChild(innerInnerDiv);
    var span = document.createElement('span');
    span.setAttribute('class', 'input-group-addon');
    innerInnerDiv.appendChild(span);
    var i = document.createElement('i');
    i.setAttribute('class', 'glyphicon glyphicon-pencil');
    span.appendChild(i);
    var textarea = document.createElement('textarea');
    textarea.setAttribute('class', 'form-control');
    textarea.setAttribute('id', 'project');
    textarea.setAttribute('placeholder', 'Project Description');
    textarea.setAttribute('onblur', 'validateProject()');
    innerInnerDiv.appendChild(textarea);
    var p = document.createElement('p');
    p.setAttribute('id', 'projectErrorField')
    innerDiv.appendChild(p);
}
