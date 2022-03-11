import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuarioRoutingModule } from './usuario-routing.module';
import { FormsModule } from '@angular/forms';
import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';
import { CadastrarUsuarioComponent } from './cadastrar-usuario/cadastrar-usuario.component';
import { UsuariosComponent } from './usuarios/usuarios.component';


@NgModule({
  declarations: [
    UsuariosComponent,
    CadastrarUsuarioComponent,
    EditarUsuarioComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    UsuarioRoutingModule
  ]
})
export class UsuarioModule { }
