require("./app.module.js");
require("./item/item.controller.js");
require("./header/header.controller.js");
require("./cart/cart.controller.js");
require("./checkout/checkout.controller.js");
require("./order/order.controller.js");

(function () {

    angular.module("MetaMarket")
        .config(function ($routeProvider) {
            $routeProvider
                .when("/items", {
                    templateUrl: "/src/item/items.template.html",
                    controller: "ItemController"
                }).when("/shopping-cart", {
                    templateUrl: "/src/cart/cart.template.html",
                    controller: "CartController"
                }).when("/check-out", {
                    templateUrl: "/src/checkout/checkout.template.html",
                    controller: "CheckoutController"
                }).when("/order-success", {
                    templateUrl: "/src/order/order-success.template.html"
                }).when("/admin/orders", {
                    templateUrl: "/src/order/orders.template.html",
                    controller: "OrderController"
                }).otherwise({
                    redirectTo: "/items"
                })
        });

}());
