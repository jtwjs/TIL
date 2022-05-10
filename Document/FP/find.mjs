import { go, filter, L, take, curry } from "./FxJS.mjs";

const arr = [
  { age: 10 },
  { age: 20 },
  { age: 22 },
  { age: 24 },
  { age: 31 },
  { age: 32 },
];

const find = curry((f, iter) =>
  go(
    iter,
    L.filter(f),
    take(1),
    (a) => (console.log(a), a),
    ([a]) => a
  )
);

console.log(find((a) => a.age > 9)(arr));

const it = go(
  arr,
  L.map((v) => v.age),
  find((v) => v > 10)
);

console.log("it", it);
