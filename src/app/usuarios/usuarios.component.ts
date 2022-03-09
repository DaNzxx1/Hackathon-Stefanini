import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuarios } from '../Objetos/Usuarios';
import { UsuariosService } from '../service/usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  usuarios: Array<Usuarios> = [];
  carregarLoading: boolean = false;

  constructor(private usuarioServico: UsuariosService , private router: Router) { }

  ngOnInit(): void {
    this.listarUsuarios();
  }

  listarUsuarios() {
    this.usuarioServico.listar().subscribe(usuarios => {
      setTimeout(() => {
        this.usuarios = usuarios;
        this.carregarLoading = true
        console.log(usuarios);
        

      }, 1000);
    });
  }

  editarUsuario = (id: any) => {
    this.router.navigate(['/usuarios', id]);
  }

  excluirUsuario = (id: any) => {
    this.usuarioServico.excluir(id).subscribe(
      success => this.ngOnInit(),
      error => console.log("Usuário não foi excluído"),
      () => console.log()
    );
  }

}
