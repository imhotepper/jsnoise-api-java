webpackJsonp([1],{NHnr:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});s("qb6w");var r=s("7+uW"),a={name:"App",data:function(){return{isAuthenticated:!1}},methods:{logedin:function(){this.isAuthenticated=!0,localStorage.setItem("isAuthenticated",this.isAuthenticated),this.$router.push({name:"producers"})},logout:function(){console.log("logging out ...."),this.isAuthenticated=!1,this.$router.push({name:"podcasts"})},update:function(){this.axios.get("/producers/update").then(function(t){return console.log("done: "+t.data)}).catch(function(t){return console.log(t)}),this.$router.push({name:"podcasts"})}},created:function(){this.isAuthenticated=localStorage.getItem("isAuthenticated"),this.$eventHub.$on("logged-in",this.logedin)}},n={render:function(){var t=this.$createElement,e=this._self._c||t;return e("section",{staticClass:"mw7 center",attrs:{id:"app"}},[e("h2",{staticClass:"athelas ph3 ph0-l "},[e("router-link",{attrs:{to:"/"}},[this._v("JsNoise ")])],1),this._v(" "),e("router-view")],1)},staticRenderFns:[]};var i=s("VU/8")(a,n,!1,function(t){s("ctwx")},null,null).exports,o=s("/ocq"),c={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("article",{staticClass:"pv4 bt bb b--black-10 ph3 ph0-l"},[s("div",{staticClass:"flex flex-column flex-row-ns"},[s("div",{staticClass:"w-100 w-60-ns pr3-ns order-2 order-1-ns"},[s("h1",{staticClass:"f3 athelas mt0 lh-title"},[s("router-link",{staticClass:"no-underline",attrs:{to:"/podcasts/"+t.slug(t.p)}},[t._v(t._s(t.p.title))])],1),t._v(" "),s("p",{staticClass:"f5 f4-l lh-copy athelas"})]),t._v(" "),s("div",{staticClass:"pl3-ns order-1 order-2-ns mb4 mb0-ns w-100 w-40-ns"})]),t._v(" "),s("p",{staticClass:"f6 lh-copy gray mv0"},[t._v("By "),s("span",{staticClass:"ttu"},[t._v(" "+t._s(t.p.producerName))]),t._v(" "),s("time",{staticClass:"f6 db gray"},[t._v(t._s(t._f("date")(t.p.pubDate)))])])])},staticRenderFns:[]},l={name:"Podcasts",components:{PodcastListItem:s("VU/8")({name:"PodcastsListItem",props:["p"],methods:{slug:function(t){return t.id+"-"+this.$options.filters.slugify(t.title)}}},c,!1,null,null,null).exports},data:function(){return{currentPage:1,totalPages:0,search:"",podcasts:[]}},computed:{hasNext:function(){return this.currentPage<this.totalPages-1},hasPrev:function(){return this.currentPage>1}},methods:{submit:function(){this.currentPage=1,this.doSearch()},next:function(){this.hasNext&&(this.currentPage++,this.doSearch())},prev:function(){this.hasPrev&&(this.currentPage--,this.doSearch())},doSearch:function(){var t={p:this.currentPage};this.search&&(t.q=this.search),this.$router.push({path:"/",query:t})},getUrlParameter:function(t){t=t.replace(/[\[]/,"\\[").replace(/[\]]/,"\\]");var e=new RegExp("[\\?&]"+t+"=([^&#]*)").exec(location.search);return null===e?"":decodeURIComponent(e[1].replace(/\+/g," "))},load:function(){var t=this,e="/api/showslist?page="+this.currentPage;this.search&&(e+="&q="+this.search),this.axios.get(e).then(function(e){t.totalPages=e.data.totalPages,t.podcasts=e.data.content}).catch(function(t){return console.log(t)})}},watch:{$route:{imediate:!0,handler:function(t,e){this.search=t.query.q,t.params.p&&(this.currentPage=t.params.p),this.load()}}},created:function(){this.getUrlParameter("p")&&(this.currentPage=this.getUrlParameter("p")),this.getUrlParameter("q")&&(this.search=this.getUrlParameter("q")),this.load()}},u={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",{staticClass:"pa4-l"},[s("form",{staticClass:"bg-light-red mw7 center pa4 br2-ns ba b--black-10",on:{submit:function(e){return e.preventDefault(),t.submit(e)}}},[s("fieldset",{staticClass:"cf bn ma0 pa0"},[s("div",{staticClass:"cf"},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.search,expression:"search"}],staticClass:"f6 f5-l input-reset bn fl black-80 bg-white pa3 lh-solid w-100 w-75-m w-80-l br2-ns br--left-ns",attrs:{placeholder:"What are you looking for today ?",type:"text"},domProps:{value:t.search},on:{input:function(e){e.target.composing||(t.search=e.target.value)}}})])])])]),t._v(" "),t._l(t.podcasts,function(t){return s("PodcastListItem",{key:t.id,attrs:{p:t}})}),t._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:0==t.podcasts.length,expression:"podcasts.length == 0 "}],staticClass:"m8 tc v-mid top-40"},[s("h2",[t._v("Nothing found !")])]),t._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:t.totalPages>1,expression:"totalPages > 1"}],staticClass:"mw8 center"},[s("nav",{staticClass:"cf pa3 pa4-ns",attrs:{"data-name":"pagination-next-prev"}},[s("a",{staticClass:"fl dib link dim black f6 f5-ns b pa2",attrs:{disabled:!t.hasPrev,title:"Previous"},on:{click:t.prev}},[t._v("← Previous")]),t._v(" "),s("a",{staticClass:"fr dib link dim black f6 f5-ns b pa2",attrs:{disabled:!t.hasNext,title:"Next"},on:{click:t.next}},[t._v("Next →")])])])],2)},staticRenderFns:[]};var d=s("VU/8")(l,u,!1,function(t){s("ps+l")},null,null).exports,p=s("mvHQ"),h=s.n(p),v={data:function(){return{producer:{name:"",website:"",feedUrl:""},producers:[]}},methods:{add:function(){var t=this;this.axios.post("/api/producers",this.producer).then(function(e){t.producer={name:"",website:"",feedUrl:""},t.load()}).catch(function(t){return console.log(t)})},getEmptyPriducer:function(){return{name:"",url:"",feedUrl:""}},saveProducers:function(){localStorage.setItem("producers",h()(this.producers))},load:function(){var t=this;this.axios.get("/api/producers").then(function(e){return t.producers=e.data}).catch(function(t){return console.log(t)})}},created:function(){this.load()}},f={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("div",[t._v("Producers")]),t._v(" "),s("form",{on:{submit:function(e){return e.preventDefault(),t.add(e)}}},[s("input",{directives:[{name:"model",rawName:"v-model",value:t.producer.name,expression:"producer.name"}],attrs:{type:"text",required:"",placeholder:"producer name"},domProps:{value:t.producer.name},on:{input:function(e){e.target.composing||t.$set(t.producer,"name",e.target.value)}}}),t._v(" "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.producer.website,expression:"producer.website"}],attrs:{type:"url",required:"",placeholder:"producer url"},domProps:{value:t.producer.website},on:{input:function(e){e.target.composing||t.$set(t.producer,"website",e.target.value)}}}),t._v(" "),s("input",{directives:[{name:"model",rawName:"v-model",value:t.producer.feedUrl,expression:"producer.feedUrl"}],attrs:{type:"url",required:"",placeholder:"feeds url"},domProps:{value:t.producer.feedUrl},on:{input:function(e){e.target.composing||t.$set(t.producer,"feedUrl",e.target.value)}}}),t._v(" "),s("button",[t._v("add")])]),t._v(" "),s("br"),t._v(" "),s("div",t._l(t.producers,function(e){return s("div",{key:e.feedUrl},[t._v(" "+t._s(e.name)+" ")])}))])},staticRenderFns:[]},m=s("VU/8")(v,f,!1,null,null,null).exports,g={methods:{test:function(t){t.target&&this.axios.get("http://rssfeedvalidator.herokuapp.com/api/testrss?url="+t.target.value).then(function(t){console.log(t.data)})}}},_={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("h2",[this._v("Tester")]),this._v(" "),e("div",[e("input",{attrs:{type:"text",placeholder:"feed url"}}),this._v(" "),e("button",{on:{click:this.test}},[this._v("Test")])]),this._v(" "),this._m(0)])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("h3",[this._v("What do we get back?")])])}]},b=s("VU/8")(g,_,!1,null,null,null).exports,w={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("div",[this._v("Login here")]),this._v(" "),e("div",[e("input",{attrs:{type:"text",placeholder:"user"}}),this._v(" "),e("input",{attrs:{type:"password"}}),this._v(" "),e("button",{on:{click:this.login}},[this._v("login")])])])},staticRenderFns:[]},x=s("VU/8")({name:"login",methods:{login:function(){this.$eventHub.$emit("logged-in")}}},w,!1,null,null,null).exports,P={props:["id"],data:function(){return{podcast:{}}},methods:{load:function(){var t=this;if(this.id){var e=this.id.split("-")[0];this.axios.get("/api/shows/"+e).then(function(e){return t.podcast=e.data}).catch(function(t){return console.log(t)})}}},created:function(){this.load()}},C={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("article",{staticClass:"pv4 bt bb b--black-10 ph3 ph0-l"},[s("div",{staticClass:"flex flex-column flex-row-ns"},[s("div",{staticClass:"w-100 w-60-ns pr3-ns order-2 order-1-ns"},[s("h1",{staticClass:"f3 athelas mt0 lh-title"},[t._v("\n            "+t._s(t.podcast.title)+"      \n        ")]),t._v(" "),s("p",{staticClass:"f5 f4-l lh-copy athelas"},[t._v("  \n        ")])]),t._v(" "),s("div",{staticClass:"pl3-ns order-1 order-2-ns mb4 mb0-ns w-100 w-40-ns"},[s("p",[s("audio",{attrs:{controls:"",src:t.podcast.mp3}},[t._v("\n                Your browser does not support the "),s("code",[t._v("audio")]),t._v(" element.\n                ")])])])]),t._v(" "),s("p",{staticClass:"f6 lh-copy gray mv0"},[t._v("By "),s("span",{staticClass:"ttu"},[t._v(" "+t._s(t.podcast.producerName))])]),t._v(" "),s("time",{staticClass:"f6 db gray"},[t._v(t._s(t._f("date")(t.podcast.pubDate)))])])},staticRenderFns:[]},y=s("VU/8")(P,C,!1,null,null,null).exports;r.a.use(o.a);var $=new o.a({mode:"history",scrollBehavior:function(t,e,s){return{x:0,y:0}},routes:[{path:"/",name:"root",component:d},{path:"/p=:p?&q=:q?",name:"podcasts",component:d,props:!0},{path:"/podcasts/:id",component:y,props:!0},{path:"/admin/producers",name:"producers",component:m},{path:"/admin/test",name:"feedTester",component:b},{path:"/login",name:"Login",component:x},{path:"*",component:d}]}),U=s("mtWM"),k=s.n(U),N=s("Rf8U"),q=s.n(N),A=s("ijY1");r.a.use(q.a,k.a),r.a.use(A),r.a.config.productionTip=!1,r.a.prototype.$eventHub=new r.a,r.a.filter("date",function(t){if(!t)return"";var e=new Date(t);return e.getFullYear()+"-"+(e.getMonth()+1)+"-"+e.getDay()}),r.a.filter("slugify",function(t){return t.toString().toLowerCase().replace(/\s+/g,"-").replace(/[^\w\-]+/g,"").replace(/\-\-+/g,"-").replace(/^-+/,"").replace(/-+$/,"")}),new r.a({el:"#app",router:$,components:{App:i},template:"<App/>"})},ctwx:function(t,e){},"ps+l":function(t,e){},qb6w:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.3b98e929e9482dc13574.js.map