import { UbicacionService } from './../../service/ubicacion.service';
import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AbstractControl, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Ubicacion } from '../../model/ubicacion';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-ubicacion-registro.component',
    standalone: true,
 imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './ubicacion-registro.component.html',
  styleUrl: './ubicacion-registro.component.css',
})
export class UbicacionRegistroComponent {

  private frmBuilder = inject(FormBuilder);
  private readonly ubicacionService= inject(UbicacionService);
  private readonly router= inject(Router);
  private toastr= inject(ToastrService);
  public submitted=false;

  frmUbicacion = this.frmBuilder.group({
      departamento: [
        'Departamento 1',
        [Validators.required, Validators.minLength(5), Validators.maxLength(20)],
      ],
      provincia:[
        'Provincia 1',
        [Validators.required, Validators.minLength(5), Validators.maxLength(20)],
      ],
      distrito: [
        'Distrito 1',
        [Validators.required, Validators.minLength(5), Validators.maxLength(20)],
      ],
  });


save(){
 this.submitted = true;
  if(!this.frmUbicacion.valid){
    return;
  }
    const departamento = this.frmUbicacion.controls['departamento'].value || '';
const provincia = this.frmUbicacion.controls['provincia'].value || '';
const distrito = this.frmUbicacion.controls['distrito'].value || '';

    const ubicacion:Ubicacion={
      departamento:departamento,
   provincia:provincia,
   distrito:distrito
    }
    console.log(ubicacion)

   this.ubicacionService.save(ubicacion).subscribe({
     next: (res) => {
          console.log(res)
          if(res){
            const id= res["id"]
            this.toastr.success('La ubicacion fue registrada con éxito','Aviso')
          }
      },
      error:(err) =>{
         this.toastr.error('Error al registrar la ubicacion','Error')
      },
      complete() { },
      })
}


cancelar(){
  this.router.navigate(['ubicacion'])
}


  get fc(): { [key: string]: AbstractControl } {
    return this.frmUbicacion.controls;
  }




}




