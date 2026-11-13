import { EscuelaResponse } from './../../model/escuela.response';
import { Component, inject, OnInit, TemplateRef } from '@angular/core';
import { EscuelaService } from '../../service/escuela.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { UbicacionService } from '../../../ubicacion/service/ubicacion.service';
import { PageChangedEvent, PaginationModule } from 'ngx-bootstrap/pagination';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
@Component({
  selector: 'app-escuela-listado.component',
     standalone: true,
 imports: [
    CommonModule,
    ReactiveFormsModule,
      PaginationModule,

  ],
  templateUrl: './escuela-listado.component.html',
  styleUrl: './escuela-listado.component.css',
})
export class EscuelaListadoComponent implements OnInit {

  private readonly escuelaService = inject(EscuelaService);
  private readonly router = inject(Router);
  private toastr = inject(ToastrService);
  private frmBuilder = inject(FormBuilder);

    private modalService= inject(BsModalService);

  public modalRef?: BsModalRef;
  constructor(){}



  public escuela: EscuelaResponse[] = [];




  verDetalle(escuelaResponse:EscuelaResponse, template: TemplateRef<void>) {
    this.escuelaSelected=escuelaResponse;
    this.modalRef = this.modalService.show(template);
  }

    public escuelaSelected?:EscuelaResponse;

  frmEscuela = this.frmBuilder.group({
    nombre: ['Escribe la escuela']
  });


  ngOnInit(): void {
    this.findAll();
  }


  public escuelasPagina: EscuelaResponse[] = [];
    itemsPerPage: number = 10;


  public findAll() {
    this.escuelaService.findAll().subscribe({
      next: (res) => {
        console.log(res);
        this.escuela = res;
         this.escuelasPagina=this.escuela.slice(0,this.itemsPerPage);
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
    this.router.navigate(['home/escuela/registro']);
  }


  limpiar(){}


  buscar(){
   const nombre= this.frmEscuela.controls['nombre'].value||''
    console.log(nombre)
    this.escuelaService.findByNombre(nombre).subscribe({
          next: (res) => {
            console.log(res);
            this.escuela = res;
          },
          error(err) {},
          complete() {},
        });
       }


  delete(escuela: EscuelaResponse){
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: "btn btn-success",
      cancelButton: "btn btn-danger"
    },
    buttonsStyling: false
  });
  swalWithBootstrapButtons.fire({
    title: "¿Estás seguro de eliminar la escuela?",
    text: "No podrás revertir esta acción",
    icon: "warning",
    showCancelButton: true,
   confirmButtonText: "Sí, eliminar",
      cancelButtonText: "Cancelar",
    reverseButtons: true
  }).then((result) => {
    if (result.isConfirmed) {
      this.escuelaService.delete(escuela.id).subscribe({
            next: (res) => {
              console.log(res);
              this.toastr.success(
                'La escuela fue eliminada con éxito',
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
      }); }
    else if (
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





   pageChanged(event: PageChangedEvent): void {
    const startItem = (event.page - 1) * this.itemsPerPage;
    const endItem = event.page * this.itemsPerPage;
    this.escuelasPagina = this.escuela.slice(startItem, endItem);
  }








}



































