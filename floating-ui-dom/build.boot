(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [dev.gethop/cljsjs.floating-ui-core "1.2.6-0"]]
 :wagons       '[[s3-wagon-private "1.3.4"]]
 :repositories #(conj % ["private-repo"
                         {:url "s3p://mvn-private-repository/releases"
                          :no-auth true}]))

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "1.2.9")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'dev.gethop/cljsjs.floating-ui-dom
       :version     +version+
       :description "Floating UI DOM library"
       :url         "https://github.com/floating-ui/floating-ui"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (download :url (str "https://unpkg.com/@floating-ui/dom@" +lib-version+ "/dist/floating-ui.dom.umd.js")
             :target "cljsjs/floating-ui-dom/development/floating-ui-dom.inc.js")
   (download :url (str "https://unpkg.com/@floating-ui/dom@" +lib-version+ "/dist/floating-ui.dom.umd.min.js")
             :target "cljsjs/floating-ui-dom/production/floating-ui-dom.min.inc.js")
   (deps-cljs :foreign-libs [{:file #"cljsjs/floating-ui-dom/development/floating-ui-dom.inc.js"
                              :file-min #"cljsjs/floating-ui-dom/production/floating-ui-dom.min.inc.js"
                              :provides ["@floating-ui/dom"]
                              :requires ["@floating-ui/core"]
                              :global-exports '{"@floating-ui/dom" FloatingUIDOM}}])
   (pom)
   (jar)
   (validate)))
