require("../cart/cart.service.js");

(function () {
    angular.module("MetaMarket").controller("HeaderController", ["$scope", "Cart", function ($scope, Cart) {

        $scope.cart = Cart;

    }]);
}());