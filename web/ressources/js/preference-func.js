function selectPreferences(app,musician) {
  app.selectedMusicianForPreference = musician
  app.preference.musician = app.selectedMusicianForPreference
  app.getPreferences(musician);
}

function getPreferences(app,musician){
  axios.get(URL_PREFERENCE + musician.idMusician)
  .then(response =>
    app.preferences = response.data
  )
  .catch(error =>
    (app.error = "Some issues with the server !")
  )
}
function updatePreference(app,preference) {
  app.preference = preference
}
function editPreference(app) {
  if (app.preference.idPreference) {
    axios.put(URL_PREFERENCE, app.preference)
    .then(response => (
      app.response = response
    )
    .then(
      app.getPreferences(app.selectedMusicianForPreference)
    )
  ).then(
    app.preference = {
      musician: app.selectedMusicianForPreference
    }
  )
  .catch(error => (
    app.error = error
  ))
} else {
  axios.post(URL_PREFERENCE, app.preference)
  .then(response =>
    (app.response = response).then(app.getPreferences(app.selectedMusicianForPreference))
  ).then(

    app.preference = {
      musician: app.selectedMusicianForPreference
    }

  )
  .catch(error => (
    app.error = error
  ))
}
}
function deletePreference(app,idPreference) {
  axios.delete(URL_PREFERENCE + idPreference)
  .then(response => (app.response = response)
  .then(app.getPreferences(app.selectedMusicianForPreference))
)
.catch(error => (
  app.error = error
))
}
