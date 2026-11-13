import { UbicacionRegistroComponent } from './../ubicacion/components/ubicacion-registro/ubicacion-registro.component';
import { Routes } from '@angular/router';
import { UbicacionListadoComponent } from '../ubicacion/components/ubicacion-listado/ubicacion-listado.component';
import { HomeComponent } from '../home/home.component/home.component';
import { EscuelaListadoComponent } from '../escuela/components/escuela-listado.component/escuela-listado.component';
import { EscuelaRegistroComponent } from '../escuela/components/escuela-registro.component/escuela-registro.component';

export const FEATURES_ROUTER: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: 'ubicacion',
        component: UbicacionListadoComponent,
      },
      {
        path: 'ubicacion/registro',
        component: UbicacionRegistroComponent,
      },

      {
        path: 'escuela',
        component: EscuelaListadoComponent,
      },
      {
        path: 'escuela/registro',
        component: EscuelaRegistroComponent,
      }
    ]
  }
];
