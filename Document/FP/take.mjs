import { range, L, curry, go } from "./FxJS.mjs";

const take = curry((l, iter) => {
  let res = [];
  for (const a of iter) {
    res.push(a);
    if (res.length === l) return res;
  }

  return res;
});

console.log(take(5, range(50))); // 50사이즈의 배열을 만든 후 5개를 뽑는 것은 비효율적
console.log(take(5, L.range(50)));
console.log(take(5, L.range(Infinity)));

go(range(50), take(5), console.log);
go(L.range(50), take(5), console.log);
