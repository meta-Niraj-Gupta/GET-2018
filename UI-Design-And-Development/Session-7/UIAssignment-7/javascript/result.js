document.getElementById('firstName').innerHTML = localStorage.getItem('firstName');

document.getElementById('lastName').innerHTML = localStorage.getItem('lastName');

document.getElementById('email').innerHTML = localStorage.getItem('email');

document.getElementById('phoneNumber').innerHTML = localStorage.getItem('phoneNumber');

document.getElementById('address').innerHTML = localStorage.getItem('address');

document.getElementById('cityName').innerHTML = localStorage.getItem('cityName');

document.getElementById('state').innerHTML = localStorage.getItem('state');

var state = localStorage.getItem('state');
var formWebsite = document.getElementById('form-website');
var formProject = document.getElementById('form-project');
var formZipcode = document.getElementById('form-zipcode');
var formHosting = document.getElementById('form-hosting');
if (state === 'rajasthan') {
    formWebsite.style.display = 'block';
    document.getElementById('website').innerHTML = localStorage.getItem('website');

    formProject.style.display = 'block';
    document.getElementById('project').innerHTML = localStorage.getItem('projectDescription');
} else if (state === 'haryana') {
    formZipcode.style.display = 'block';
    document.getElementById('zipCode').innerHTML = localStorage.getItem('zipCode');

    formHosting.style.display = 'block';
    document.getElementById('hosting').innerHTML = localStorage.getItem('hosting');
} else {
    formZipcode.style.display = 'block';
    document.getElementById('zipCode').innerHTML = localStorage.getItem('zipCode');

    formProject.style.display = 'block';
    document.getElementById('project').innerHTML = localStorage.getItem('projectDescription');
}
