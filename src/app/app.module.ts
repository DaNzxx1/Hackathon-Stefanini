import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ProdutoService } from './service/produto.service';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { CadastrarUsuarioComponent } from './usuarios/cadastrar-usuario/cadastrar-usuario.component';
import { EditarUsuarioComponent } from './usuarios/editar-usuario/editar-usuario.component';
import { UsuariosService } from './service/usuarios.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CadastroComponent,
    UsuariosComponent,
    CadastrarUsuarioComponent,
    EditarUsuarioComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ProdutoService,
    UsuariosService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
