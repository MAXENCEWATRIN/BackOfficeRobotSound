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
    initSlider(this);
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
