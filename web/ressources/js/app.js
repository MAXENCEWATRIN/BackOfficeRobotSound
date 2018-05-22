function initSlider(app){
  $("#flat-slider-vertical-3")
  .slider({
    max: 100,
    min: 0,
    range: "min",
    value: app.preference.y,
    change: function(event, ui) {
        app.preference.y = ui.value
    },
    orientation: "vertical"
  });
  $("#flat-slider-vertical-2")
  .slider({
    max: 100,
    min: 0,
    range: "min",
    value: app.preference.x,
    change: function(event, ui) {
        app.preference.x = ui.value
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
