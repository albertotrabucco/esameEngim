import { Component, OnInit } from '@angular/core';
import { ITariffa } from 'src/app/models/tariffeModel';
import { AppService } from 'src/app/services/app.service';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-tariffe',
  templateUrl: './tariffe.component.html',
  styleUrls: ['./tariffe.component.scss']
})
export class TariffeComponent implements OnInit {



  tariffe: ITariffa[] = [];
  title: string = "Lista di Tariffe";

  constructor(private appService: AppService) {
  }

  ngOnInit(): void {
    this.appService.getTariffe().subscribe(data =>
        this.tariffe = data)
  }

  Aggiungi(tariffaForm: NgForm, $event: Event){
    var form = document.getElementsByClassName('needs-validation')[0] as HTMLFormElement;
    if (form.checkValidity() === false) {
      $event.stopPropagation()
      $event.preventDefault()
    } else {
      form.classList.add('was-validated');
      this.appService.addTariffa(tariffaForm.value).subscribe(
        (resp) => {
          alert("Aggiunta nuova Tariffa");
          tariffaForm.reset();
          window.location.reload();
        }
      );
    }
    
  }

  Delete(tariffa: ITariffa){
    this.appService.deleteTariffa(tariffa.id).subscribe();
    this.tariffe = this.tariffe.filter(x => x.id != tariffa.id);
  }

}
