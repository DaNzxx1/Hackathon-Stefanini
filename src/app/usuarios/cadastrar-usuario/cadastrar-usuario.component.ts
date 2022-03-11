import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuarios } from 'src/app/usuarios/objetos/usuarios';
import { UsuariosService } from 'src/app/usuarios/service/usuarios.service';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  usuario: Usuarios = new Usuarios();
  erros: Array<String> = [];
  mostrarErros: boolean = false;
  disabled: boolean = false;

  constructor(
    private router: Router,
    private usuarioService: UsuariosService,
  ) { }

  ngOnInit(): void {

  }

  adicionar = () => {
    this.usuarioService.adicionar(this.usuario).subscribe(
      success => this.navegar('usuarios'),
      error => {
        error.error.parameterViolations.forEach((usuario: any) => { this.erros.push(usuario.message) });
        this.mostrarErros = true;
        this.disabled = true
        
        setTimeout(() => {
          this.mostrarErros = false
          this.erros = [];
          this.disabled = false
        }, 5000);
      },
      () => console.log("Requisição usuário novo completa!")
    );
  }

  navegar = (rota: any) => {
    this.router.navigate([rota]);
  } 

}
