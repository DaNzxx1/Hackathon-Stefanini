import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import * as moment from 'moment';
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
  data: any;

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
          
          this.data = moment(usuario.dataNascimento).add(-1, 'months').format('yyyy-MM-DD');
        });
      }
    });
  }

  alterar = () => {
    this.usuario.dataNascimento = this.data;
    
    this.usuarioService.editar(this.usuario).subscribe(
      success => this.navegar('usuarios'),
      error => console.log("Não editou!"),
      () => console.log("Requisição editar completa!")
    );
  }

  navegar = (rota: any) => {
    this.router.navigate([rota]);
  }

}
