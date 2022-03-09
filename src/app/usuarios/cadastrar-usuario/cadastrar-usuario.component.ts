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
      success => this.navegar('Sucesso usuarios'),
      error => {
        for (let index = 0; index < error.error.parameterViolations.length; index++) {
          this.erros.push(error.error.parameterViolations[index].message);
        }
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