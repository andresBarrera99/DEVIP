import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ParametersService {

  constructor() { }
  
  saveParameters(name,values){
    sessionStorage.setItem(name,values);
  }

  getParameters(name){
    return sessionStorage.getItem(name);
  }

  dropParameters(name){
    sessionStorage.removeItem(name);
  }
}
