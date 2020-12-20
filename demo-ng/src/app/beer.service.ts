import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beer } from './beer';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  url: string;

  constructor(private http:HttpClient) {
    this.url = environment.api;
   }

   public findAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.url + '/all');
  }
}
