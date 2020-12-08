import { Content } from '@angular/compiler/src/render3/r3_ast';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IonContent } from '@ionic/angular';
import { ApiService } from 'src/app/services/api/api.service';
import { ParametersService } from 'src/app/services/parameters/parameters.service';
import { UtilService } from 'src/app/services/util/util.service';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {
  searchMoviesForm: FormGroup;
  response: any;
  lastAction : string;
  lastMethod: string;
  lastParameters: any;
  @ViewChild(IonContent) content: IonContent;

  constructor(private router: Router,
    private util: UtilService,
    private parameters: ParametersService,
    private api: ApiService) { 
    this.searchMoviesForm = new FormGroup({
      query: new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
  }

  onMovieClick(movie){
    this.parameters.saveParameters('movie',JSON.stringify(movie));
    this.router.navigate(['movie-detail']);
  }

  searchMovies(formValues){
    formValues.page =1;
    this.doPetition(environment.searchAction,'POST',formValues);
  }

  getMostPopular(){    
    this.searchMoviesForm.reset();
    this.doPetition(environment.popularAction,'GET');
  }

  getTopRanked(){    
    this.searchMoviesForm.reset();
    this.doPetition( environment.topRatedAction,'GET');
  }

  private doPetition(action: string,method:string, postData?: any) {
    this.lastAction = action;
    this.lastMethod = method;
    this.lastParameters = postData;
    if(method == 'GET'){
      action = action + '?page=1';
    }
    this.api.doPetition({ action: action, method: method ,postData: postData})
      .then((serviceResponse: any) => {
        this.response =  serviceResponse.responseBody;
      }).catch(() => { });
  }

  nextPage(){
    if(this.response.page == this.response.total_pages ){
      this.util.showSimpleMessage('Información', 'Se encuentra en la última pagina');
    }else{
      let action = this.lastAction;
      if(this.lastMethod == 'GET'){
        action = action +'?page='+ (Number(this.response.page) + 1);
      }else{
        this.lastParameters.page = (Number(this.response.page) + 1);
      }
      this.api.doPetition({ action: action, method: this.lastMethod,postData:this.lastParameters})
    .then((serviceResponse: any) => {
      this.response = serviceResponse.responseBody;
    }).catch(() => { });
    }
  }

  backPage(){
    if(this.response.page == 1 ){
      this.util.showSimpleMessage('Información', 'Se encuentra en la primera pagina');
    }else{
      let action = this.lastAction;
      if(this.lastMethod == 'GET'){
        action = action +'?page='+ (Number(this.response.page) -1);
      }else{
        this.lastParameters.page = (Number(this.response.page) -1);
      }
      this.api.doPetition({ action: action, method: this.lastMethod,postData:this.lastParameters})
      .then((serviceResponse: any) => {
        this.response = serviceResponse.responseBody;
      }).catch(() => { });
    }
  }

}
