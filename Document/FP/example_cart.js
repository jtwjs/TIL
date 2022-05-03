import { map, filter, reduce, go, pipe, curry } from "./FxJS.js";

const products = [
  { name: "옷1", price: 10000, quantity: 1, is_selected: true },
  { name: "옷2", price: 50000, quantity: 3, is_selected: false },
  { name: "신발", price: 80000, quantity: 1, is_selected: false },
  { name: "바지1", price: 30000, quantity: 2, is_selected: false },
  { name: "바지2", price: 40000, quantity: 1, is_selected: true },
];

const add = (a, b) => a + b;

const sum = curry((f, iter) => go(iter, map(f), reduce(add)));
// const sum = (f) => (iter) => go(iter, map(f), reduce(add));
// const sum = (f) => pipe(map(f), reduce(add));

// const total_quantity = pipe(
//   map((p) => p.quantity),
//   reduce(add)
// );

// const total_price = pipe(
//   map((p) => p.quantity * p.price),
//   reduce(add)
// );

// const total_quantity = (products) => sum((p) => p.quantity, products);
// const total_price = (products) => sum((p) => p.quantity * p.price, products);

// Curring 활용 / Tip: 인자를 고대로 첫번째 인자로 넘겨 받는다면 축약 가능
// const total_quantity = (products) => sum((p) => p.quantity)(products);
// const total_price = (products) => sum((p) => p.quantity * p.price)(products);
const total_quantity = sum((p) => p.quantity);
const total_price = sum((p) => p.quantity * p.price);

console.log(total_quantity(products));
console.log(total_price(products));

document.querySelector("#cart").innerHTML = `
<table>
  <tr>
    <th>선택</th>
    <th>상품 이름</th>
    <th>상품 가격</th>
    <th>상품 수량</th>
    <th>총 가격</th>
  </tr>
  ${go(
    products,
    sum(
      (p) => `
    <tr>
      <td><input type="checkbox" ${p.is_selected ? "checked" : ""}/></td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td><input type="number" value=${p.quantity} /></td>
      <td>${p.quantity * p.price}</td>
    </tr>
  `
    )
    // map(
    //   (p) => `
    //   <tr>
    //     <td>${p.name}</td>
    //     <td>${p.price}</td>
    //     <td><input type="number" value=${p.quantity} /></td>
    //     <td>${p.quantity * p.price}</td>
    //   </tr>
    // `
    // ),
    // reduce(add)
  )}
  <tr>
    <td colspan="3">합계</td>
    <td>${total_quantity(filter((p) => p.is_selected, products))}</td>
    <td>${total_price(filter((p) => p.is_selected, products))}</td>
  </tr>
</table>`;

// 위와 같이 함수형 프로그래밍은 다형성이 굉장히 높다. but 어렵다...😂
