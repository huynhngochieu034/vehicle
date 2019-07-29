import { User } from './../../authentication/authentication.service';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs';
import { map, share } from 'rxjs/operators';
import { VehInfo } from '../data-model/VehInfo';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TrafficUrlService {
  public _JsonUrlAll = 'http://35.240.143.66:8081/cpf-media-service/all/getvehicles';
  public _JsonUrlLast = 'http://35.240.143.66:8081/cpf-media-service/last/getvehicles';

  public _JsonUrlVehicleById='http://localhost:8080/api/vehicle/idss?ids=';
  public _JsonUrlAllVehicle ='http://localhost:8080/api/vehicle';
  public _JsonUrlAllVehicleByUser ='http://localhost:8181/api/car';
  public baseUrlLogin = 'http://localhost:8181/api/users/login';
  //`assets/data/data1 - Copy (${id}).json`
  constructor(private jLocal: Http) {}

  public getAllJSON(): Observable<any> {
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlAll).pipe(map((res: Response) => res.json()));
    return observable;
  }
  public getLastJSON(): Observable<any> {
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlLast).pipe(map((res: Response) => res.json()));
    return observable;
  }

  // public getALLVehicle():Observable<VehInfo[]>{
  //   let observable: Observable<any> = this.jLocal.get(this._JsonUrlAllVehicle).pipe(map((res: Response) => res.json()));
  //   return observable;
  // }
  public getALLVehicle():Observable<any>{
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlAllVehicle).pipe(map((res: Response) => res.json()));
    return observable;
  }

  public getVehicleById(ids):Observable<any>{
    console.log(this._JsonUrlVehicleById+ids);
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlVehicleById+ids).pipe(map((res: Response) => res.json()));
    return observable;
  }
//---------------------------VehicleByUser-------------------------------
  public getVehicleByUserId(id):Observable<any>{
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlAllVehicleByUser+"/"+id).pipe(map((res: Response) => res.json()));
    return observable;
  }

  public getVehicleIdByUser(id):Observable<any>{
    let observable: Observable<any> = this.jLocal.get(this._JsonUrlAllVehicleByUser+"/update/"+id).pipe(map((res: Response) => res.json()));
    return observable;
  }

  public createVehicleByUser(vehicle):Observable<any>{
    let observable: Observable<any> = this.jLocal.post(this._JsonUrlAllVehicleByUser,vehicle).pipe(map((res: Response) => res.json()));
    return observable;
  }

  public updateVehicleByUser(vehicle, id) {
    let observable: Observable<any> = this.jLocal.put(this._JsonUrlAllVehicleByUser+"/"+id, vehicle).pipe(map((res: Response) => res.json()));
    return observable;
  }

  public deleteVehicleByUser(ids){
    let observable: Observable<any> = this.jLocal.delete(this._JsonUrlAllVehicleByUser+"?ids="+ids).pipe(map((res: Response) => res.json()));
    return observable;
  }
  //-----------------------------User-------------------------
  
  public login(username, password):Observable<any>{
     const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password), 'Content-Type': 'application/json'});
     //let _options = { headers: new HttpHeaders({'Content-Type': 'application/json',Authorization: 'Basic ' + btoa(username + ':' + password) }) };
    //console.log(headers);
    let observable: Observable<any> = this.jLocal.post(this.baseUrlLogin,{headers}).pipe(map((res: Response) => res.json()));
    return observable;
  }
}
