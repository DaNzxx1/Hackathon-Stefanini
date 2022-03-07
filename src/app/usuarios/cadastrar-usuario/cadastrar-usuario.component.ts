import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuarios } from 'src/app/Objetos/Usuarios';
import { UsuariosService } from 'src/app/service/usuarios.service';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastrar-usuario.component.html',
  styleUrls: ['./cadastrar-usuario.component.css']
})
export class CadastrarUsuarioComponent implements OnInit {

  usuario: Usuarios = new Usuarios();

  constructor(
    private router: Router,
    private usuarioService: UsuariosService,
  ) { }

  ngOnInit(): void {

  }

  adicionar = () => {
    this.usuarioService.adicionar(this.usuario).subscribe(
      /* success => this.navegar('usuarios'),
      error => console.log("Usuário não criou!"), */
      (response) => {
        console.log("Requisição usuário novo completa!")
      }
    );
  }

  navegar = (rota: any) => {
    this.router.navigate([rota]);
  } 

}
