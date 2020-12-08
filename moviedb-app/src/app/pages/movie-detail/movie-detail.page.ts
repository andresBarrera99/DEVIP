import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api/api.service';
import { ParametersService } from 'src/app/services/parameters/parameters.service';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.page.html',
  styleUrls: ['./movie-detail.page.scss'],
})
export class MovieDetailPage implements OnInit {
  movie : any;

  constructor(private router: Router,
    private parameters: ParametersService,
    private api: ApiService) { 

    let localMovie =JSON.parse(parameters.getParameters('movie'));
    let action = environment.detailAction + localMovie.id;
     this.api.doPetition({ action: action, method: 'GET'}) 
     .then((serviceResponse: any) => {
      this.movie = serviceResponse.responseBody;
      this.setupValues();
    }).catch(() => { 
      this.router.navigate(['home']);});
    parameters.dropParameters('movie');
  }
  setupValues() {
    this.movie.genres = this.getNameValues(this.movie.genres);
    this.movie.production_companies =  this.getNameValues(this.movie.production_companies);
    this.movie.spoken_languages =  this.getNameValues(this.movie.spoken_languages);
    this.movie.production_countries =  this.getNameValues(this.movie.production_countries);
  }

  private getNameValues(list : any) {
    let fullData = '';
    for (let i = 0; i < list.length; i++) {
      let data = list[i];
      fullData = fullData + data.name +(i == list.length - 1 ? '' : ',');
    }
    return fullData;
  }

  ngOnInit() {
  }

}
