import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IArticolo } from '../models/articoloModel';
import { IOrdine } from '../models/ordineModel';
import { ITariffa } from '../models/tariffeModel';
import { IVoce } from '../models/voceModel';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }


  getArticoli(){
    return this.http.get<IArticolo[]>("http://localhost:8081/esame/articoli");
  }

  getOrdini(){
    return this.http.get<IOrdine[]>("http://localhost:8081/esame/ordini");
  }

  getTariffe(){
    return this.http.get<ITariffa[]>("http://localhost:8081/esame/tariffe");
  }
  getVoci(){
    return this.http.get<IVoce[]>("http://localhost:8081/esame/voci");
  }

  deleteTariffa(id: number){
    return this.http.delete(`http://localhost:8081/esame/tariffe/delete?id=${id}`);
  }

  addTariffa(tariffa: any){
    return this.http.post(`http://localhost:8081/esame/tariffe/add`, tariffa);
  }

}
