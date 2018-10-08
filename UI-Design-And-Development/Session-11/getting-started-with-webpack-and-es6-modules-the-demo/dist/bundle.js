/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no exports provided */
/*! all exports used */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("Object.defineProperty(__webpack_exports__, \"__esModule\", { value: true });\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__modules_greeting__ = __webpack_require__(/*! ./modules/greeting */ 1);\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__modules_math_functions__ = __webpack_require__(/*! ./modules/math-functions */ 2);\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__modules_show_sum__ = __webpack_require__(/*! ./modules/show-sum */ 3);\n\r\n\r\n\r\n\r\nconst resultGreeting = document.getElementById('resultGreeting');\r\nconst resultSum = document.getElementById('resultSum');\r\nconst resultProduct = document.getElementById('resultProduct');\r\nconst showSumOnButtonClick = document.getElementById('show-sum');\r\n\r\nconst a = 3;\r\nconst b = 7;\r\n\r\nresultGreeting.textContent = Object(__WEBPACK_IMPORTED_MODULE_0__modules_greeting__[\"a\" /* sayHello */])('Nice to see you! 🙂');\r\nresultSum.textContent = `The sum of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"b\" /* sum */])(a, b)}. ✨`;\r\nresultProduct.textContent = `The product of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"a\" /* product */])(a, b)}. 🚀`;\r\n\r\ndocument.getElementById(\"myButton\").addEventListener(\"click\", displaySum);\r\n\r\nfunction displaySum() {\r\n    if (showSumOnButtonClick.style.display === 'none') {\r\n        showSumOnButtonClick.style.display = 'block';\r\n        showSumOnButtonClick.textContent = `The sum of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_2__modules_show_sum__[\"a\" /* add */])(a, b)}`;\r\n    }\r\n}\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMC5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9hcHAuanM/N2FjOSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge1xyXG4gICAgc2F5SGVsbG9cclxufSBmcm9tICcuL21vZHVsZXMvZ3JlZXRpbmcnO1xyXG5pbXBvcnQge1xyXG4gICAgc3VtLFxyXG4gICAgcHJvZHVjdFxyXG59IGZyb20gJy4vbW9kdWxlcy9tYXRoLWZ1bmN0aW9ucyc7XHJcbmltcG9ydCB7XHJcbiAgICBhZGRcclxufSBmcm9tICcuL21vZHVsZXMvc2hvdy1zdW0nO1xyXG5cclxuY29uc3QgcmVzdWx0R3JlZXRpbmcgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgncmVzdWx0R3JlZXRpbmcnKTtcclxuY29uc3QgcmVzdWx0U3VtID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3Jlc3VsdFN1bScpO1xyXG5jb25zdCByZXN1bHRQcm9kdWN0ID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3Jlc3VsdFByb2R1Y3QnKTtcclxuY29uc3Qgc2hvd1N1bU9uQnV0dG9uQ2xpY2sgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZCgnc2hvdy1zdW0nKTtcclxuXHJcbmNvbnN0IGEgPSAzO1xyXG5jb25zdCBiID0gNztcclxuXHJcbnJlc3VsdEdyZWV0aW5nLnRleHRDb250ZW50ID0gc2F5SGVsbG8oJ05pY2UgdG8gc2VlIHlvdSEg8J+ZgicpO1xyXG5yZXN1bHRTdW0udGV4dENvbnRlbnQgPSBgVGhlIHN1bSBvZiAke2F9IGFuZCAke2J9IGlzICR7c3VtKGEsIGIpfS4g4pyoYDtcclxucmVzdWx0UHJvZHVjdC50ZXh0Q29udGVudCA9IGBUaGUgcHJvZHVjdCBvZiAke2F9IGFuZCAke2J9IGlzICR7cHJvZHVjdChhLCBiKX0uIPCfmoBgO1xyXG5cclxuZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJteUJ1dHRvblwiKS5hZGRFdmVudExpc3RlbmVyKFwiY2xpY2tcIiwgZGlzcGxheVN1bSk7XHJcblxyXG5mdW5jdGlvbiBkaXNwbGF5U3VtKCkge1xyXG4gICAgaWYgKHNob3dTdW1PbkJ1dHRvbkNsaWNrLnN0eWxlLmRpc3BsYXkgPT09ICdub25lJykge1xyXG4gICAgICAgIHNob3dTdW1PbkJ1dHRvbkNsaWNrLnN0eWxlLmRpc3BsYXkgPSAnYmxvY2snO1xyXG4gICAgICAgIHNob3dTdW1PbkJ1dHRvbkNsaWNrLnRleHRDb250ZW50ID0gYFRoZSBzdW0gb2YgJHthfSBhbmQgJHtifSBpcyAke2FkZChhLCBiKX1gO1xyXG4gICAgfVxyXG59XHJcblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vc3JjL2FwcC5qc1xuLy8gbW9kdWxlIGlkID0gMFxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFBQTtBQUFBO0FBRUE7QUFJQTtBQUdBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOyIsInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///0\n");

/***/ }),
/* 1 */
/*!*********************************!*\
  !*** ./src/modules/greeting.js ***!
  \*********************************/
/*! exports provided: sayHello */
/*! exports used: sayHello */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return sayHello; });\nconst sayHello = (greeting) => {\r\n    const currentHour = new Date().getHours();\r\n    let timeGreeting = 'Good morning!';\r\n\r\n    if (currentHour >= 12 && currentHour <= 17) {\r\n        timeGreeting = 'Good afternoon!';\r\n    } else if (currentHour >= 17) {\r\n        timeGreeting = 'Good evening!';\r\n    }\r\n\r\n    return `${timeGreeting} ${greeting}`;\r\n}\r\n\r\n\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMS5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL2dyZWV0aW5nLmpzP2RiOTUiXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3Qgc2F5SGVsbG8gPSAoZ3JlZXRpbmcpID0+IHtcclxuICAgIGNvbnN0IGN1cnJlbnRIb3VyID0gbmV3IERhdGUoKS5nZXRIb3VycygpO1xyXG4gICAgbGV0IHRpbWVHcmVldGluZyA9ICdHb29kIG1vcm5pbmchJztcclxuXHJcbiAgICBpZiAoY3VycmVudEhvdXIgPj0gMTIgJiYgY3VycmVudEhvdXIgPD0gMTcpIHtcclxuICAgICAgICB0aW1lR3JlZXRpbmcgPSAnR29vZCBhZnRlcm5vb24hJztcclxuICAgIH0gZWxzZSBpZiAoY3VycmVudEhvdXIgPj0gMTcpIHtcclxuICAgICAgICB0aW1lR3JlZXRpbmcgPSAnR29vZCBldmVuaW5nISc7XHJcbiAgICB9XHJcblxyXG4gICAgcmV0dXJuIGAke3RpbWVHcmVldGluZ30gJHtncmVldGluZ31gO1xyXG59XHJcblxyXG5leHBvcnQge3NheUhlbGxvfTtcclxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9ncmVldGluZy5qc1xuLy8gbW9kdWxlIGlkID0gMVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///1\n");

/***/ }),
/* 2 */
/*!***************************************!*\
  !*** ./src/modules/math-functions.js ***!
  \***************************************/
/*! exports provided: sum, product */
/*! exports used: product, sum */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"b\", function() { return sum; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return product; });\nconst sum = (a, b) => {\r\n    return a + b;\r\n};\r\n\r\nconst product = (a, b) => {\r\n    return a * b;\r\n};\r\n\r\n\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMi5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL21hdGgtZnVuY3Rpb25zLmpzP2VlOTciXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3Qgc3VtID0gKGEsIGIpID0+IHtcclxuICAgIHJldHVybiBhICsgYjtcclxufTtcclxuXHJcbmNvbnN0IHByb2R1Y3QgPSAoYSwgYikgPT4ge1xyXG4gICAgcmV0dXJuIGEgKiBiO1xyXG59O1xyXG5cclxuZXhwb3J0IHtzdW0sIHByb2R1Y3R9O1xyXG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9tb2R1bGVzL21hdGgtZnVuY3Rpb25zLmpzXG4vLyBtb2R1bGUgaWQgPSAyXG4vLyBtb2R1bGUgY2h1bmtzID0gMCJdLCJtYXBwaW5ncyI6IkFBQUE7QUFBQTtBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///2\n");

/***/ }),
/* 3 */
/*!*********************************!*\
  !*** ./src/modules/show-sum.js ***!
  \*********************************/
/*! exports provided: add */
/*! exports used: add */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return add; });\nconst add = (a, b) => (b || b === 0) ? a + b : (b) => a + b;\r\n\r\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMy5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL3Nob3ctc3VtLmpzPzQ5NTIiXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3QgYWRkID0gKGEsIGIpID0+IChiIHx8IGIgPT09IDApID8gYSArIGIgOiAoYikgPT4gYSArIGI7XHJcblxyXG5leHBvcnQge2FkZH07XG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9zaG93LXN1bS5qc1xuLy8gbW9kdWxlIGlkID0gM1xuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFDQTsiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///3\n");

/***/ })
/******/ ]);