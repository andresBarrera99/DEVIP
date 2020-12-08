let express = require('express');
let http = require('http');
let cors = require('cors');
let app = express();
const MovieDB = require('node-themoviedb');
const bodyParser = require('body-parser');
const mdb = new MovieDB('ca8294722fd46ea0eba12a1818ff205b', {language:'es-ES'});
 
 
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());

let basicResponse = {
	ok: true,
	errorMessage: '',
	errorCode: 0,
	responseBody : {}
}


app.get('/moviedb/movieDetail/:movieID', (req, res) => {  
(async () => {
  try {
    const args = {
      pathParameters: {
        movie_id: req.params.movieID,
      },
    };
    const movie = await mdb.movie.getDetails(args);
	basicResponse.responseBody = movie.data;
    res.status(200).send(basicResponse);
  } catch (error) {
	basicResponse.ok = false;
	basicResponse.errorMessage = error;
    res.status(200).send(basicResponse);
  }
})();
});
app.get('/moviedb/topRatedMovies', (req, res) => {  
(async () => {
  try {
    const args = {
      query: {
		page: req.query.page
	  }
    };
    const movie = await mdb.movie.getTopRated(args);
	basicResponse.responseBody = movie.data;
    res.status(200).json(basicResponse);
  } catch (error) {
	basicResponse.ok = false;
	basicResponse.errorMessage = error;
    res.status(200).send(basicResponse);
  }
})();
});

app.get('/moviedb/popularMovies', (req, res) => {  
(async () => {
  try {
    const args = {
      query: {
		page: req.query.page
	  }
    };
    const movie = await mdb.movie.getPopular(args);
	basicResponse.responseBody = movie.data;
    res.status(200).send(basicResponse);
  } catch (error) {
	basicResponse.ok = false;
	basicResponse.errorMessage = error;
    res.status(200).send(basicResponse);
  }
})();
});
app.get('/', (req, res) => {
  res.status(404).send("Please send an action");
});


app.post('/moviedb/searchMovie', (req, res) => {  
(async () => {
  try {
    const args = {
      query: {
		page: req.body.page,
		query: req.body.query
	  }
    };
    const movie = await mdb.search.movies(args);
	basicResponse.responseBody = movie.data;
    res.status(200).send(basicResponse);
  } catch (error) {
	basicResponse.ok = false;
	basicResponse.errorMessage = error;
    res.status(200).send(basicResponse);
  }
})();
});
app.get('/', (req, res) => {
  res.status(404).send("Please send an action");
});

http.createServer(app).listen(19011, () => {
  console.log('Server started at http://localhost:19011');
});