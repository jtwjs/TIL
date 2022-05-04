import { reduce } from "./FxJS.mjs";

// #range
const range = (l) => {
  let i = -1;
  const res = [];

  while (++i < l) {
    res.push(i);
  }

  return res;
};

const add = (a, b) => a + b;

const list = range(4); // range()를 실행했을 때 즉시 평가된 값이 list 변수에 담기게됨

console.log(list); // [0, 1, 2, 3];
console.log(reduce(add, list)); // 6

// #lazy range [지연평가]
const L = {};
L.range = function* (l) {
  let i = -1;

  while (++i < l) {
    yield i;
  }
};

// iterator의 값을 순회할 때  그 때 값이 평가됨, 즉 L_list.next()를 실행하기 전까지는 L.range()안의 로직 실행 X -> 지연평가
const L_list = L.range(4); // L_range()를 실행해도 값이 평가되지 않은 상태, 즉 Array 상태가 아님

console.log(L_list); // Object [Generator] {}
console.log(reduce(add, L_list)); // 6
/* reduce가 iterable을 받기 때문에 모두 같은 결과값이 나옴, 배열도 iterable, geneartor도 iterable*/

// #효율성 테스트 range VS L.range

function test(name, time, f) {
  console.time(name);
  while (time--) f();
  console.timeEnd(name);
}

test("range", 10, () => reduce(add, range(10000000))); // 3.572s
test("L.range", 10, () => reduce(add, L.range(10000000))); // 1.919s

// #conclusion
/* 
  전자는 range(), 즉시평가로 배열을 만들고나서 순회, 즉 배열을 만든 처음부터 다시 순회
  후자는 L.range(), 지연평가된 iterator 즉, 배열을 만들지 않고 순회

  지연 평가의 중요성 아직 실감이 나지 않는다...🥲
*/
