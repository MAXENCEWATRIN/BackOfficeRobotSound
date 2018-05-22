var URL = "http://localhost:8080/BackOfficeRobotSound/rest";
var URL_MUSICIAN = URL + "/musicians/";
var URL_PREFERENCE = URL + "/preferences/";



var robotSoundApp = new Vue({
  el: '#robotSoundApp',
  data: {
    musicians: [],
    preferences: [],
    error: '',
    message: '',
    musician: {},
    selectedMusicianForPreference: {},
    ok:'',
    preference: {}
  },
  mounted() {
    var vm = this
    this.getMusicians();
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

  },
  methods: {
    resetView(){
      musicians = []
      preferences = []
      error = ''
      message = ''
      musician = {}
      selectedMusicianForPreference = {}
      ok = ''
      preference = {}
    },
    updateMusician(musician) { updateMusician(this,musician) },
    editMusician() { editMusician(this) },
    deleteMusician(idMusician) { deleteMusician(this,idMusician) },
    getMusicians() { getMusicians(this) },

    selectPreferences(musician) { selectPreferences(this,musician) },
    getPreferences(musician) { getPreferences(this,musician) },
    updatePreference(preference) { updatePreference(this,preference) },
    editPreference() { editPreference(this) },
    deletePreference(idPreference) { deletePreference(this,idPreference)  },
  }
});
