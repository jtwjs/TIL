/* # Lazy evaluation 이터러블 중심 프로그래밍에서의 지연 평가
- 제너레이터 / 이터레이터 프로토콜 기반으로 구현
- 느긋한 계산법
- 필요할떄까지 계산을 미루다가 값을 만들어 나가는 기법
- 큰 배열을 미리 만들어 두는 것이 아닌 계산이 필요할때 값을 만들어내면서 계산
*/

import {
  range,
  take,
  map,
  filter,
  reduce,
  go,
  pipe,
  curry,
  L,
} from "./FxJS.mjs";

// # L.map, 새로운 Array를 만들지 않고 순회하면서 yield를 통해 함수가 적용된 값을 전달
L.map = curry(function* (f, iter) {
  for (const a of iter) yield f(a);
});

const it = L.map((a) => a + 1, [1, 2, 3, 4]);

// next()를 할때 평가
// console.log([it.next(), ...it]);

// # L.filter
L.filter = curry(function* (f, iter) {
  for (const a of iter) {
    if (f(a)) yield a;
  }
});

// 즉시평가
go(
  range(10), // 평가 시점 1
  map((n) => n + 10), // 평가 시점 2
  filter((n) => n % 2), // 평가 시점 3
  take(2), // 평가 시점 4
  console.log
);

// 지연평가
go(
  L.range(10), // 평가 시점 4,
  L.map((n) => n + 10), // 평가 시점 3,
  L.filter((n) => n % 2), // 평가 시점 2,
  // 연산은 take 부터 시작됨, 그 전 lazy 함수들에서는 연산하지 않음,
  // take 인자로 array가 아닌 generator가 들어오게됨,
  // genearotr는 well-formed iterator로 iterator이면서 자기자신을 반환하는 [Symbol.iterator]()를 갖는 객체
  // array iterator와 generator를 받아 같은 동작이 실행되게 다형성 높게 구현되어있다. (JS)
  take(2), // 평가 시점 1,
  console.log
);

/* #지연평가 시점이 즉시평가와 반대인 이유
- 각 함수에서 지연평가된 이터레이터를 반환하고
- 해당 이터레이터를 next()로 평가를 하는 시점에서 그제서야 계산이 이루어지기 때문
- 실제로 계산이 필요할때까지 미룬다!! 효율성 UP
- 이터레이터의 next를 처음 실행할 때까지 미뤄지는 컨셉 === 지연평가
- 제너레이터는 그것을 구현하는 하나의 방법 
*/
