import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Usuarios } from '../usuarios/objetos/usuarios';
import { UsuariosService } from '../usuarios/service/usuarios.service';
import { usuarioLogin } from './usuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: boolean = false;

  mosrtrarMenuEmitter = new EventEmitter<boolean>();

  constructor(private router: Router, private usuarioService: UsuariosService) { }

  login(usuarioLogin: usuarioLogin) {

    this.usuarioService.login(usuarioLogin).subscribe(
      (response: Usuarios) => {
        console.log("Deu certo: ");
        console.log(response);

        if (response) {

          this.usuarioAutenticado = true;
          this.mosrtrarMenuEmitter.emit(true);
          console.log(this.mosrtrarMenuEmitter);
          
          this.router.navigate(['']);      
    
        } else {
          this.usuarioAutenticado = false;
          this.mosrtrarMenuEmitter.emit(false);
        }
      },
      (error: any) => {
        console.error("Login ou Senha incorreta(s)!");
      });
  }

  usuarioEstaAutenticado() {
    return this.usuarioAutenticado;
  }


  /* 
  (response: Usuarios) => {
      console.log("Deu certo: ");
      console.log(response);

      if (response) {

        this.usuarioAutenticado = true;
        this.mosrtrarMenuEmitter.emit(true);
        console.log(this.mosrtrarMenuEmitter);
        
        this.router.navigate(['']);      
  
      } else {
        this.usuarioAutenticado = false;
        this.mosrtrarMenuEmitter.emit(false);
      }
    }, 
    success => {console.log("a");},
      error => {console.log("a");},
      () => {console.log("a");}
    */
}
