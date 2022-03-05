import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from '../Objetos/Produto';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produtos: Array<Produto> = [];
  carregarLoading: boolean = false;

  constructor(private produtoService: ProdutoService, private router: Router) { }

  ngOnInit(): void {
    this.listar();
    
  }

  listar() {
    this.produtoService.listar().subscribe(produtos => {
      setTimeout(() => {
        this.produtos = produtos;
        this.carregarLoading = true
  
      }, 1000);
    });
  }

  excluirItem = (id: any) => {
    this.produtoService.excluirItem(id).subscribe(
      success => console.log("Deletado com sucesso!"),
      error => console.log("Não excluiu!"),
      () => console.log("Requisição completa!")
      )
      
      this.ngOnInit();
  }

  editarItem = (id: any) => {
    this.router.navigate(['/usuarios', id]);
  }

}
