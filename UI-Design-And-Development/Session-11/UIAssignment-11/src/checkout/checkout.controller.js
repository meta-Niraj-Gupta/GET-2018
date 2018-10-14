require("../cart/cart.service.js");
require("../item/item.service.js");

(function () {
    angular.module("MetaMarket")
        .controller("CheckoutController", ["$scope", "$location", "Cart", "Item", "Order", function ($scope, $location, Cart, Item, Order) {

            $scope.cart = Cart;
            
            Item.getAll().then(function (data) {
                $scope.items = data;
            });

            $scope.placeOrder = function () {
                Order.add(Cart.getCartDelegate(),$scope.userDetail);
                Cart.empty();
                $location.path("/order-success");
            }
       }]);
}());
