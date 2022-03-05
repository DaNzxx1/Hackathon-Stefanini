import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { Produto } from '../Objetos/Produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private readonly API = `${environment.API}produtos`;

  constructor(private $http: HttpClient) { }

  listar() {
    return this.$http.get<Produto[]>(`${this.API}`);
  }

  buscarPorId(id: any) {
    return this.$http.get<Produto>(`${this.API}/${id}`);
  }

  adicionarItem(produto: Produto) {
    return this.$http.post(this.API, produto);
  }
  
  editarItem(produto: Produto) {
    return this.$http.put(`${this.API}/${produto.id}`, produto);
  }

  excluirItem(id: any) {
    return this.$http.delete(`${this.API}/${id}`);
  }
}
