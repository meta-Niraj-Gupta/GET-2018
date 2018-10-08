import {
    sayHello
} from './modules/greeting';
import {
    sum,
    product
} from './modules/math-functions';
import {
    add
} from './modules/show-sum';

const resultGreeting = document.getElementById('resultGreeting');
const resultSum = document.getElementById('resultSum');
const resultProduct = document.getElementById('resultProduct');
const showSumOnButtonClick = document.getElementById('show-sum');

const a = 3;
const b = 7;

resultGreeting.textContent = sayHello('Nice to see you! 🙂');
resultSum.textContent = `The sum of ${a} and ${b} is ${sum(a, b)}. ✨`;
resultProduct.textContent = `The product of ${a} and ${b} is ${product(a, b)}. 🚀`;

document.getElementById("myButton").addEventListener("click", displaySum);

function displaySum() {
    if (showSumOnButtonClick.style.display === 'none') {
        showSumOnButtonClick.style.display = 'block';
        showSumOnButtonClick.textContent = `The sum of ${a} and ${b} is ${add(a, b)}`;
    }
}
