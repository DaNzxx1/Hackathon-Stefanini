import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuarios } from 'src/app/Objetos/Usuarios';
import { UsuariosService } from 'src/app/service/usuarios.service';

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
          
        });
      }
    });
  }

  alterar = () => {
    this.usuarioService.editar(this.usuario).subscribe(
      success => this.navegar('usuarios'),
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
      () => console.log("Requisição editar completa!")
    );
  }

  navegar = (rota: any) => {
    this.router.navigate([rota]);
  }

}
