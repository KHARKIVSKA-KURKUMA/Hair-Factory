var $owl=$(".carousel-2");$owl.children().each((function(o){$(this).attr("data-position",o)})),$(document).on("click",".owl-item>div",(function(){$owl.trigger("to.owl.carousel",[$(this).data("position"),300])})),$owl.owlCarousel({loop:!0,center:!0,stagePadding:70,nav:!0,dots:!1,navText:["&lsaquo;","&rsaquo;"],responsive:{0:{items:1},800:{items:2},1200:{items:3}}}),$(".owl-carousel").owlCarousel({margin:20,loop:!0,autoWidth:!0,items:4});
//# sourceMappingURL=ua.82c9b041.js.map
