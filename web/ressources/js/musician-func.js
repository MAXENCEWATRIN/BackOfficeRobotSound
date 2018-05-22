function updateMusician(app,musician) {
  app.musician = musician
  app.selectedMusicianForPreference = {}
}

function editMusician(app) {
  if (app.musician.idMusician) {
    axios.put(URL_MUSICIAN, app.musician)
    .then(response => (
      app.response = response
    )
    .then(
      app.getMusicians()
    )
  ).then(app.musician = {})
  .catch(error => (
    app.error = error
  ));
} else {
  axios.post(URL_MUSICIAN, app.musician)
  .then(response => (
    app.response = response
  ).then(app.musicians = app.getMusicians())
).then(app.musician = {})
.catch(error => (
  app.error = error
));
}
}

function deleteMusician(app,idMusician) {
  axios.delete(URL_MUSICIAN + idMusician)
  .then(response => (
    app.response = response
  ).then(
    app.getMusicians()
  )).then(app.selectedMusicianForPreference = {}).then(app.preferences = [])
  .catch(error => (
    app.error = error
  ));
}

function getMusicians(app) {
  axios.get(URL_MUSICIAN)
  .then(response =>
    (app.musicians = response.data)
  )
  .catch(error =>
    (app.error = "Some issues with the server !")
  )
}
