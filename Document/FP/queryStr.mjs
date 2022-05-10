import { go, map, reduce, pipe, curry } from "./FxJS.mjs";

// const queryStr = (obj) =>
//   go(
//     obj,
//     Object.entries,
//     map(([k, v]) => `${k}=${v}`),
//     reduce((a, b) => `${a}&${b}`) // reduce로 계산을 마무리~
//   );

const queryStr = pipe(
  Object.entries,
  map(([k, v]) => `${k}=${v}`),
  reduce((a, b) => `${a}&${b}`) // reduce로 계산을 마무리~
);

const join = curry((sep = ",", iter) =>
  reduce((a, b) => `${a}${sep}${b}`, iter)
);

const queryStr2 = pipe(
  Object.entries,
  map(([k, v]) => `${k}=${v}`),
  join("&")
);

console.log(queryStr({ name: "정태웅", old: 28, job: "frontend" }));
console.log(queryStr2({ name: "정태웅", old: 28, job: "frontend" }));
