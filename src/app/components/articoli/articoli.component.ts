import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IArticolo } from 'src/app/models/articoloModel';
import { AppService } from 'src/app/services/app.service';

@Component({
  selector: 'app-articoli',
  templateUrl: './articoli.component.html',
  styleUrls: ['./articoli.component.scss']
})
export class ArticoliComponent implements OnInit {

  articoli: IArticolo[] = [];
  title: string = "Lista di Articoli";
  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.appService.getArticoli().subscribe(data => 
        this.articoli = data)    
  }

}
