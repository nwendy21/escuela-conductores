
import { Component, inject, OnInit, TemplateRef } from '@angular/core';
import { UbicacionService } from '../../service/ubicacion.service';
import { Ubicacion } from '../../model/ubicacion';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import Swal from 'sweetalert2';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { BsModalRef, BsModalService, ModalModule } from 'ngx-bootstrap/modal';
import { PageChangedEvent } from 'ngx-bootstrap/pagination';
import { PaginationModule } from 'ngx-bootstrap/pagination';


@Component({
  selector: 'app-ubicacion-listado.component',
  standalone: true,
imports: [
  ModalModule,
    CommonModule,
    ReactiveFormsModule,
    PaginationModule,
  ],
  templateUrl: './ubicacion-listado.component.html',
  styleUrl: './ubicacion-listado.component.css',
})
export class UbicacionListadoComponent implements OnInit {

  private readonly ubicacionService = inject(UbicacionService);
    private readonly router = inject(Router);
     private toastr= inject(ToastrService);
  private frmBuilder = inject(FormBuilder);
  private modalService= inject(BsModalService);

  public modalRef?: BsModalRef;
  constructor(){}



  verDetalle(ubicacion:Ubicacion, template: TemplateRef<void>) {
    this.ubicacionSelected=ubicacion;
    this.modalRef = this.modalService.show(template);
  }

  public ubicacionSelected?:Ubicacion;

 frmUbicacion = this.frmBuilder.group({
   nombre : ['(Departamento/Provincia/Distrito)'],
  });


 public ubicaciones: Ubicacion[] = [];

public ubicacionesPagina: Ubicacion[] = [];


  itemsPerPage: number = 10;




  ngOnInit(): void {
this.findAll();
  }


  public findAll() {
    this.ubicacionService.findAll().subscribe({
      next: (res) => {
        console.log(res);
        this.ubicaciones = res;
          this.ubicacionesPagina=this.ubicaciones.slice(0,this.itemsPerPage);
      },
      error: (err) => {
      console.error(err);
    },
    complete: () => {
      console.log('completado');
    }
  });
}


  nuevo() {
    this.router.navigate(['home/ubicacion/registro']);
  }


delete(ubicacion: Ubicacion) {
const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: "btn btn-success",
    cancelButton: "btn btn-danger"
  },
  buttonsStyling: false
});
swalWithBootstrapButtons.fire({
  title: "¿Estás seguro?",
  text: "No podrás revertir esta acción",
  icon: "warning",
  showCancelButton: true,
 confirmButtonText: "Sí, eliminar",
    cancelButtonText: "Cancelar",
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
    this.ubicacionService.delete(ubicacion.id).subscribe({
          next: (res) => {
            console.log(res);
            this.toastr.success(
              'La ubicacion fue eliminada con éxito',
              'Aviso',
            );
            this.findAll();
          },
          error: (err) => {
            this.toastr.error('Error al eliminar la ubicacion', 'Error');
          },
          complete() {},
        });

    swalWithBootstrapButtons.fire({
       title: "Eliminado",
            text: "La ubicación fue eliminada correctamente",
            icon: "success"
    });

  } else if (
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire({
      title: "Cancelado",
        text: "La ubicación está a salvo 🙂",
        icon: "error"
    });
  }
});
 }




 buscar(){

    const nombre= this.frmUbicacion.controls['nombre'].value||''
    console.log(nombre)
    this.ubicacionService.findByNombre(nombre).subscribe({
          next: (res) => {
          console.log(res);
          this.ubicaciones= res;
          },
          error(err) {},
          complete() {},
        });
  }



limpiar(){

  }


   pageChanged(event: PageChangedEvent): void {
    const startItem = (event.page - 1) * this.itemsPerPage;
    const endItem = event.page * this.itemsPerPage;
    this.ubicacionesPagina = this.ubicaciones.slice(startItem, endItem);
  }




}
