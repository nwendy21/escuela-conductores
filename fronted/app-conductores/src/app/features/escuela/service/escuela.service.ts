import { inject, Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EscuelaResponse } from '../model/escuela.response';
import { EscuelaRequest } from '../model/escuela.request';

@Injectable({
  providedIn: 'root',
})
export class EscuelaService {

  url=`${environment.API_BASE}/api/v1/escuela`

  private readonly http= inject(HttpClient)

  public findAll():Observable<EscuelaResponse[]>{
    return this.http.get<EscuelaResponse[]>(this.url);
  }

  public findByNombre(nombre:string):Observable<EscuelaResponse[]>{
    return this.http.get<EscuelaResponse[]>(`${this.url}/by-nombre?nombre=${nombre}`);
  }

  public save(escuela:EscuelaRequest):Observable<any>{
    console.log(escuela)
    JSON.stringify(escuela)

    return this.http.post<any>(this.url,escuela);
  }

  public delete(id?:number):Observable<any>{
    return this.http.delete<any>(`${this.url}/${id}`);
  }

}
