import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuarios } from 'src/app/usuarios/objetos/usuarios';
import { UsuariosService } from 'src/app/usuarios/service/usuarios.service';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent implements OnInit {

  id: any;
  usuario: Usuarios = new Usuarios();
  erros: Array<String> = [];
  mostrarErros: boolean = false;
  disabled: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private usuarioService: UsuariosService,
  ) { }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(parametros => {
      if (parametros['id']) {
        this.id = parametros['id'];
        this.usuarioService.buscarPorId(this.id).subscribe(usuario => {
          this.usuario = usuario;
        },
        error => {
          this.router.navigate(['usuarios']);
        });
      }
    });
  }

  alterar = () => {
    this.usuarioService.editar(this.usuario).subscribe(
      success => this.navegar('usuarios'),
      error => {
        console.log(error);
        
        error.error.parameterViolations.forEach((usuario: any) => { this.erros.push(usuario.message) });
        this.mostrarErros = true;
        this.disabled = true
        
        setTimeout(() => {
          this.mostrarErros = false
          this.erros = [];
          this.disabled = false
        }, 5000);
      },
      () => console.log("Requisição editar completa!")
    );
  }

  navegar = (rota: any) => {
    this.router.navigate([rota]);
  }

}
