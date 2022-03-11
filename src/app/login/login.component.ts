import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { usuarioLogin } from './usuarioLogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuarioLogin: usuarioLogin = new usuarioLogin()

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  login = () => {
    this.authService.login(this.usuarioLogin);
  }

}
