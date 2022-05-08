/*
  curry => 함수를 부분적으로 실행 -> 여러인자를 취하는 함수를 단일인자를 취하는 함수로 분리
  1.함수를 받아서 함수를 리턴
  2.리턴된 함수가 실행되고 인자가 2개 이상일 경우 받아둔 함수를 즉시 실행
  3.인자가 2개보다 작다면 함수를 다시 리턴 후에 그 후의 인자들을 합쳐 실행
*/
export const curry =
  (f) =>
  (a, ..._) =>
    _.length ? f(a, ..._) : (..._) => f(a, ..._);

// 보조함수를 통해 iterable 안의 값에 1:1로 매핑되는 어떠한 값을 수집할때 사용
export const map = curry((f, iter) => {
  let res = [];
  for (const a of iter) {
    res.push(f(a));
  }

  return res;
});

// for of 숨겨진 코드
const map = curry((f, iter) => {
  let res = [];
  // for (const a of iter) {
  //   res.push(f(a));
  // }
  // 아래와 같이 동작

  iter = iter[Symbol.iterator]();
  let cur;
  while (!(cur = iter.next()).done) {
    const a = cur.value;
    res.push(f(a));
  }

  return res;
});

// 보조함수를 통해 iterable 안의 조건에 충족하는 어떠한 값을 수집할때 사용
export const filter = curry((f, iter) => {
  let res = [];
  for (const a of iter) {
    if (f(a)) res.push(a);
  }

  return res;
});

// 특정한 값을 순회하면서 하나의 값으로 누적할 때 사용
export const reduce = curry((f, acc, iter) => {
  if (!iter) {
    // 인자 2개 받는경우 -> acc 생략인 경우 (f, iter);
    iter = acc[Symbol.iterator]();
    acc = iter.next().value;
  }

  for (const a of iter) {
    acc = f(acc, a);
  }
  return acc;
});

// 인자로 함수를 받아서 하나의 함수로 축약한 헬퍼 함수
export const go = (...args) => reduce((a, f) => f(a), args);

// go 함수와 다르게 함수를 리턴하는 함수
// 함수가 나열된 합성함수를 만듦
export const pipe =
  (f, ...fs) =>
  (...as) =>
    go(f(...as), ...fs);

export const range = (l) => {
  let i = -1;
  const res = [];

  while (++i < l) {
    res.push(i);
  }

  return res;
};

export const L = {};
L.range = function* (l) {
  let i = -1;

  while (++i < l) {
    yield i;
  }
};

L.map = curry(function* (f, iter) {
  for (const a of iter) yield f(a);
});

L.filter = curry(function* (f, iter) {
  for (const a of iter) {
    if (f(a)) yield a;
  }
});

export const take = curry((l, iter) => {
  let res = [];
  for (const a of iter) {
    res.push(a);
    if (res.length === l) return res;
  }

  return res;
});
