var myApp = angular.module('userManagementApp', []);
myApp.controller('userDetailController', userDetailController);

function userDetailController($scope, $http) {
    $http.get('user-data.json').then(function (response) {
        $scope.users = response.data;
    });
    $scope.totalUser = 5;
    $scope.addUser = function () {
        if (/^[a-zA-Z\s]+$/.test($scope.userName)) {
            $scope.userNameError = '';
            if (/^[0-9]{10}$/.test($scope.userPhone)) {
                $scope.userPhoneError = '';
                if (/^[a-zA-z\s]+$/.test($scope.userCity)) {
                    $scope.userCityError = '';
                    $scope.users.push({
                        'id': $scope.totalUser + 1,
                        'name': $scope.userName,
                        'phone': $scope.userPhone,
                        'city': $scope.userCity
                    });

                } else {
                    $scope.userCityError = 'Enter a valid city name';
                }
            } else {
                $scope.userPhoneError = 'Enter a valid Phone number of length exactly 10'
            }
        } else {
            $scope.userNameError = 'Enter a valid name without any special character and digits'
        }
    };

    $scope.clearAll = function () {
        $scope.userName = '';
        $scope.userPhone = '';
        $scope.userCity = '';
    }

    $scope.setUserId = function (key) {
        $scope.users.forEach(element => {
            if (key === element.id) {
                $scope.id = element.id;
                $scope.editedName = element.name;
                $scope.editedPhone = element.phone;
                $scope.editedCity = element.city;
            }
        });
    }

    $scope.editUser = function () {
        $scope.users.forEach(element => {
            if (element.id == $scope.id) {
                element.name = $scope.editedName;
                element.phone = $scope.editedPhone;
                element.city = $scope.editedCity;
            }
        });
    }

}
