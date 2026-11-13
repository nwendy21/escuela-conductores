import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { AbstractControl, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { EscuelaService } from '../../service/escuela.service';
import { UbicacionService } from '../../../ubicacion/service/ubicacion.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Ubicacion } from '../../../ubicacion/model/ubicacion';
import { EscuelaRequest } from '../../model/escuela.request';

@Component({
  selector: 'app-escuela-registro.component',
standalone: true,
 imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './escuela-registro.component.html',
  styleUrl: './escuela-registro.component.css',
})
export class EscuelaRegistroComponent {

 private frmBuilder = inject(FormBuilder);
  private readonly escuelaService= inject(EscuelaService);
  private readonly ubicacionService= inject(UbicacionService);
  private readonly router= inject(Router);
  private toastr= inject(ToastrService);
  public submitted=false;

  public ubicacion:Ubicacion[]=[];

  frmEscuela = this.frmBuilder.group({
     nombre: [
        'Ingresar Escuela',
        [Validators.required, Validators.minLength(2), Validators.maxLength(50)]
      ],
      ruc: [
        'Ingrese su Ruc',
        [Validators.required, Validators.minLength(11), Validators.maxLength(11)]
      ],
      direccion: [
        'Direccion',
        [Validators.required, Validators.minLength(5), Validators.maxLength(100)]
      ],

      ubicacionId: [
        'Elegir Ubicacion', [Validators.required]]
    });



 ngOnInit(): void {
    this.loadUbicacion()
   }



 loadUbicacion(){
    this.ubicacionService.findAll().subscribe({
          next: (res) => {
            console.log(res);
            this.ubicacion= res;
          },
          error(err) {},
          complete() {},
        });
  }


cancelar(){
  this.router.navigate(['escuela'])
}

save(){
   this.submitted = true;
  if(!this.frmEscuela.valid){
    return;
  }
    const nombre= this.frmEscuela.controls['nombre'].value|| '';
    const  ruc= this.frmEscuela.controls['ruc'].value|| '';
     const direccion= this.frmEscuela.controls['direccion'].value|| '';
 const ubicacion_id= this.frmEscuela.controls['ubicacionId'].value|| '';

const escuela: EscuelaRequest = {
    nombre: this.frmEscuela.controls['nombre'].value || '',
    ruc: this.frmEscuela.controls['ruc'].value || '',
    direccion: this.frmEscuela.controls['direccion'].value || '',
    ubicacionId: Number(this.frmEscuela.controls['ubicacionId'].value) || 1
};

    console.log(escuela)

   this.escuelaService.save(escuela).subscribe({
     next: (res) => {
          console.log(res)
          if(res){
            const id= res["id"]
            this.toastr.success('La escuela fue registrada con éxito','Aviso')
          }
      },
      error:(err) =>{
         this.toastr.error('Error al regigrar la escuela ','Error')
      },
      complete() {

      },
    })
}
  get fp(): { [key: string]: AbstractControl } {
    return this.frmEscuela.controls;
  }
}
