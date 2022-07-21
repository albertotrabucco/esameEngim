
import { Component, OnInit } from '@angular/core';
import { IOrdine } from 'src/app/models/ordineModel';
import { ITariffa } from 'src/app/models/tariffeModel';
import { IVoce } from 'src/app/models/voceModel';
import { AppService } from 'src/app/services/app.service';
import { IArticolo } from '../../models/articoloModel';

@Component({
  selector: 'app-ordini',
  templateUrl: './ordini.component.html',
  styleUrls: ['./ordini.component.scss']
})
export class OrdiniComponent implements OnInit {

  title: string = "Lista di Ordini";
  ordini: IOrdine[] = [];
  voci: IVoce[] = [];
  tariffe: ITariffa[] = [];
  articoli: IArticolo[] = [];

  selectedOrder: IOrdine | undefined;
  selectedVoce: IVoce[] = [];
  selectedTariffa: ITariffa | undefined;
  selectedArticolo: IArticolo | undefined;
  pesoTotale: number = 0;


  constructor(private appService: AppService) {
   }

  ngOnInit(): void {
    this.appService.getOrdini().subscribe(data =>
        this.ordini = data)
    this.appService.getVoci().subscribe(data =>
      this.voci = data)
    this.appService.getTariffe().subscribe(data =>
      this.tariffe = data)
    this.appService.getArticoli().subscribe(data =>
      this.articoli = data)
  }

  getTariffaMigliore(id: number) : ITariffa | undefined{
    this.selectedOrder = this.ordini.find(x => x.id == id);
    this.selectedVoce = this.voci.filter(x => x.id_ordine == this.selectedOrder?.id);
    for(let i=0; i<this.selectedVoce.length; i++){
      this.selectedArticolo = this.articoli.find(x => x.id == this.selectedVoce[i].articolo)
      if(this.selectedVoce[i].articolo == this.selectedArticolo?.id){
        this.pesoTotale = this.selectedVoce[i].quantità * this.selectedArticolo.peso;
      }
    }
    this.selectedTariffa = this.tariffe.find(x => x.peso_massimo >= this.pesoTotale);
    let tariffaMigliore = this.selectedTariffa;
    return tariffaMigliore;
  }


}
