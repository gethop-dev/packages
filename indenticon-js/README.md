# io.github.cljsjs/indenticon-js

[](dependency)
```clojure
[cljsjs/indenticon-js "2.3.3-0"] ;; latest release
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require and use the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.identicon-js))

```

Externs were generated using https://github.com/jmmk/javascript-externs-generator

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps
