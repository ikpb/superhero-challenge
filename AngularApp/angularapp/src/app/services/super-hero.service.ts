import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

import { SuperHero } from '../models/Superhero'
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class SuperHeroService {
  allHumansUrl: string = 'http://localhost:8080/super-human/super-human';
  constructor(private http: HttpClient) { }

  getSuperHumans() : Observable<SuperHero[]>{
    return this.http.get<SuperHero[]>(this.allHumansUrl);
}

}
