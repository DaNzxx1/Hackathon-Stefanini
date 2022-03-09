import { Component, Input, OnInit } from '@angular/core';
import { Usuarios } from '../Objetos/Usuarios';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  
  @Input() quantidade: any;
  @Input() icone: any;
  @Input() nome: any;
  
  
  constructor() { }
  
  ngOnInit(): void {
  }

}
