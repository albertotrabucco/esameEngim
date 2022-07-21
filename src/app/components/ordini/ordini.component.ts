import { Component, OnInit } from '@angular/core';
import { empty } from 'rxjs';
import { IOrdine } from 'src/app/models/ordineModel';
import { ITariffa } from 'src/app/models/tariffeModel';
import { IVoce } from 'src/app/models/voceModel';
import { AppService } from 'src/app/services/app.service';

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
 
  selectedOrder: IOrdine | undefined;
  selectedVoce: IVoce[] = [];
  selectedTariffa: ITariffa | undefined;
  

  constructor(private appService: AppService) {
   }

  ngOnInit(): void {
    this.appService.getOrdini().subscribe(data => 
        this.ordini = data)   
    this.appService.getVoci().subscribe(data => 
      this.voci = data)
    this.appService.getTariffe().subscribe(data => 
      this.tariffe = data)    
  }

  getTariffaMigliore(id: number){
    this.selectedOrder = this.ordini.find(x => x.id == id);
    this.selectedVoce = this.voci.filter(x => x.id_ordine == this.selectedOrder?.id);
    for(let i=0; i<this.selectedVoce.length; i++){
      
    }
  }


}
