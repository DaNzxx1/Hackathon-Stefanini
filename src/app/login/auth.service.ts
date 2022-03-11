import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { usuarioLogin } from './usuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly API = `${environment.API}login`;

  private usuarioAutenticado: boolean = false;

  mosrtrarMenuEmitter = new EventEmitter<boolean>();

  constructor(private $http: HttpClient, private router: Router) { }

  login(usuarioLogin: usuarioLogin) {
    if (usuarioLogin.login === 'teste' && usuarioLogin.senha === 'teste') {

      this.usuarioAutenticado = true;
      this.mosrtrarMenuEmitter.emit(true);
      console.log(this.mosrtrarMenuEmitter);
      
      this.router.navigate(['']);      

    } else {
      this.usuarioAutenticado = false;
      this.mosrtrarMenuEmitter.emit(false);
    }
  }

  usuarioEstaAutenticado() {
    return this.usuarioAutenticado;
  }

}
