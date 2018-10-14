require("../cart/cart.service.js");
require("../item/item.service.js");

(function () {
    angular.module("MetaMarket").controller("CartController", ["$scope", "Cart", "Item", function ($scope, Cart, Item) {

        $scope.cart = Cart;

        Item.getAll().then(function (data) {
            $scope.items = data;
        });
    }]);
}());