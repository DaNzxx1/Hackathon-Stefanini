import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuarios } from '../Objetos/Usuarios';
import { UsuariosService } from '../service/usuarios.service';

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
