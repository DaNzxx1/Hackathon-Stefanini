import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  mostrarMenu: boolean = false;

  constructor(private authService: AuthService) {
    
  }

  ngOnInit() {
    this.authService.mosrtrarMenuEmitter.subscribe(
      mostrar => this.mostrarMenu = mostrar,
    );
  }

}
