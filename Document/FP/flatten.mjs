import { L, pipe, take } from "./FxJS.mjs";

/* 
# L.flat
- Array.prototype.flat과 비슷한 기능
- 배열을 풀어서 열거 (1 deps)
*/

const isIterable = (a) => a && a[Symbol.iterator];

L.flatten = function* (iter) {
  for (const a of iter) {
    if (isIterable(a)) for (const b of a) yield b;
    else yield a;
  }
};

const it = L.flatten([[1, 2, 3], 4, 5, [6, [7, 8, 9, [95, 44], 2], 3], 1]);
console.log("it", it);
for (const a of it) {
  console.log(a);
}

// L.flatten + take 조합으로 즉시평가 함수를 만들 수 있음
const flatten = pipe(L.flatten, take(Infinity));

const it2 = flatten([[1, 2, 3], 4, 5, [6, [7, 8, 9, [95, 44], 2], 3], 1]);
console.log("it2", it2);

/* 
  아래 코드를 더 간단히 만들 수 있다.
  yield *iterable은 for (const a of iterable) yield a 와 같다.
*/
L.flatten = function* (iter) {
  for (const a of iter) {
    if (isIterable(a)) for (const b of a) yield b;
    else yield a;
  }
};

L.flatten = function* (iter) {
  for (const a of iter) {
    if (isIterable(a)) yield* a;
    else yield a;
  }
};

/* 
# L.deepFlat 
- 모든 배열을 풀어서 열거 Array.prototype.flat(Infinity) 와 같다.
- 유명함수(기명함수)를 활용한 재귀함수
- 익명함수와 반대대는 개념?
- 함수 내부에서 함수 자기 자신을 참조할때 사용
*/

L.deepFlat = function* f(iter) {
  for (const a of iter) {
    if (isIterable(a)) yield* f(a);
    else yield a;
  }
};

const it3 = L.deepFlat([[1, 2, 3], 4, 5, [6, [7, 8, 9, [95, 44], 2], 3], 1]);
console.log(it3);

for (const a of it3) {
  console.log("a", a);
}

console.clear();

let func = function f() {
  console.log("기명함수", f);
};

func();
console.log(func.name);
