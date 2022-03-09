import { isNull } from '@angular/compiler/src/output/output_ast';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-mini-tabela',
  templateUrl: './mini-tabela.component.html',
  styleUrls: ['./mini-tabela.component.css']
})
export class MiniTabelaComponent implements OnInit {

  @Input() data: any;
  @Input() columsName: any;
  show: boolean = true;

  constructor() { }

  ngOnInit(): void {
    /* if (isNull(this.data)) {
      this.show = true;
    } */
  }

}
