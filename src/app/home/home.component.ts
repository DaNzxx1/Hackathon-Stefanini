import { Component, OnInit } from '@angular/core';
import { Usuarios } from '../usuarios/objetos/Usuarios';
import { UsuariosService } from '../usuarios/service/usuarios.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuarios: Array<Usuarios> = [];
  

  constructor(private usuarioService: UsuariosService) { }

  ngOnInit(): void {
    this.listaUsuario();
  }

  listaUsuario = () => {
    this.usuarioService.listar().subscribe((response) => {
      this.usuarios = response;
    });
  } 

}
