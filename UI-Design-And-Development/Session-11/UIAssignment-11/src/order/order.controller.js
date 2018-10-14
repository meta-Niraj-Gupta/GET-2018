require("./order.service.js");
require("../cart/cart.service.js");
require("../item/item.service.js");

(function () {
    angular.module("MetaMarket").controller(
        "OrderController",
        ["$scope", "Order", "Cart", "Item", function ($scope, Order, Cart, Item) {
            $scope.orders = Order.getAll();
            $scope.cart = Cart;

            Item.getAll().then(function (data) {
                $scope.items = data;
            });
            
            $scope.showSummary = function (order) {
                $scope.modalCart = Cart.createCartFromDelegate(order.cart);
                $("#summary").modal("show");
            }
        }]
    );
}());
