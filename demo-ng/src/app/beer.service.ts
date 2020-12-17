import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beer } from './beer';

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  url: string;

  constructor(private http:HttpClient) {
    this.url = 'http://localhost:8080/';
   }

   public findAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.url + 'all');
  }
}
