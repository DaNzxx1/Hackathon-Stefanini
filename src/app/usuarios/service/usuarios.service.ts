import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { usuarioLogin } from 'src/app/login/usuarioLogin';
import { environment } from 'src/environments/environment';
import { Usuarios } from '../objetos/usuarios';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private readonly API = `${environment.API}usuarios`;

  constructor(private $http: HttpClient) { }

  listar() {
    console.log(this.$http.get<Usuarios[]>(`${this.API}`));
    
    return this.$http.get<Usuarios[]>(`${this.API}`);
  }

  buscarPorId(id: any) {
    return this.$http.get<Usuarios>(`${this.API}/${id}`);
  }

  adicionar(usuario: Usuarios) {
    return this.$http.post(this.API, usuario);
  }

  editar(usuario: Usuarios) {
    return this.$http.put(`${this.API}`, usuario);
  }

  excluir(id: any) {
    return this.$http.delete(`${this.API}/${id}`);
  }

  login(usuarioLogin: usuarioLogin): any {
    return this.$http.post<Usuarios>(`${this.API}/login`, usuarioLogin);
  }

  aniversariantesMes() {
    return this.$http.get<Usuarios[]>(`${this.API}/aniversariantes`);
  }

}
