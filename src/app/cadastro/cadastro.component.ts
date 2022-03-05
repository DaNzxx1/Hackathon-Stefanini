import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Produto } from '../Objetos/Produto';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  id: any;
  produto: Produto = new Produto(0, '', 0);
  textoBotao: String = "Novo";

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private produtoService: ProdutoService,
  ) { }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(parametros => {
      if (parametros['id']) {
        this.textoBotao = "Salvar"
        this.id = parametros['id'];
        this.produtoService.buscarPorId(this.id).subscribe(produto => {
          this.produto = produto;
        });
        //console.log(`Id enviado: ${this.id}`);
      }
    })
  }

  adicionar = () => {
    if (this.textoBotao == 'Novo') {
      console.log(this.produto);
      
      this.produtoService.adicionarItem(this.produto).subscribe(
        success => this.navegar('home'),
        error => console.log("Não salvou!"),
        () => console.log("Requisição completa!")
      );

    } else {
      this.editar();
    }
  }

  editar = () => {
    this.produtoService.editarItem(this.produto).subscribe(
      success => this.navegar('home'),
      error => console.log("Não editou!"),
      () => console.log("Requisição completa!")
    );
  }
  
  navegar = (rota: any) => {
    this.router.navigate([rota]);
  } 
}
