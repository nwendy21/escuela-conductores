import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLinkWithHref, RouterLink } from '@angular/router';
import { UbicacionListadoComponent } from "./features/ubicacion/components/ubicacion-listado/ubicacion-listado.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
    standalone: true,
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('app-conductores');
}
