
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ubicacion } from '../model/ubicacion';
@Injectable({
  providedIn: 'root',
})

export class UbicacionService {

url=`${environment.API_BASE}/api/v1/ubicacion`


  private readonly http= inject(HttpClient)


  public findAll():Observable<Ubicacion[]>{
    return this.http.get<Ubicacion[]>(this.url);
  }

 public save(ubicacion:Ubicacion):Observable<any>{
    return this.http.post<any>(this.url,ubicacion);
  }


 public delete(id?:number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id}`);
  }
public findByNombre(nombre:string):Observable<Ubicacion[]>{
    return this.http.get<Ubicacion[]>(`${this.url}/by-nombre?nombre=${nombre}`);
  }


}
