import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { UbicacionListadoComponent } from './features/ubicacion/components/ubicacion-listado/ubicacion-listado.component';
import { UbicacionRegistroComponent } from './features/ubicacion/components/ubicacion-registro/ubicacion-registro.component';
import { EscuelaListadoComponent } from './features/escuela/components/escuela-listado.component/escuela-listado.component';
import { EscuelaRegistroComponent } from './features/escuela/components/escuela-registro.component/escuela-registro.component';
import { LoginComponent } from './security/login.component/login.component';

export const routes: Routes = [

 {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'home',
    loadChildren: () =>
      import('../app/features/router/features.router').then(
        (r) => r.FEATURES_ROUTER,
      ),
  },

  { path: '', redirectTo: 'login', pathMatch: 'full' },

  {
    path: '**',
    redirectTo: '/pageNotFound',
    pathMatch: 'full',
  },
];
