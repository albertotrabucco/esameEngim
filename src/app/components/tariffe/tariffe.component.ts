import { Component, OnInit } from '@angular/core';
import { ITariffa } from 'src/app/models/tariffeModel';
import { AppService } from 'src/app/services/app.service';

@Component({
  selector: 'app-tariffe',
  templateUrl: './tariffe.component.html',
  styleUrls: ['./tariffe.component.scss']
})
export class TariffeComponent implements OnInit {

  tariffe: ITariffa[] = [];
  title: string = "Lista di Tariffe";
  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.appService.getTariffe().subscribe(data => 
        this.tariffe = data)    
  }

}
