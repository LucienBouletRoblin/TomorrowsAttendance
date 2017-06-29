import { Component }          from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'my-app',
  template: `
    <h1>Money bank manager</h1>
    <nav>
      <a routerLink="/dashboard" routerLinkActive="active">Dashboard</a>
    </nav>
   <alert></alert>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {

}
