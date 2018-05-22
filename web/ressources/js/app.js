function initSlider(app){
  var vm = app;
  $("#flat-slider-vertical-3")
  .slider({
    max: 100,
    min: 0,
    range: "min",
    value: vm.preference.x,
    change: function(event, ui) {
        vm.preference.x = ui.value
    },
    orientation: "vertical"
  });
  $("#flat-slider-vertical-2")
  .slider({
    max: 100,
    min: 0,
    range: "min",
    value: vm.preference.y,
    change: function(event, ui) {
        vm.preference.y = ui.value
    },
    orientation: "horizontal"
  });
  $("#flat-slider-vertical-2, #flat-slider-vertical-3")
  .slider("pips", {
    first: "pip",
    last: "pip"
  })
  .slider("float");
}
