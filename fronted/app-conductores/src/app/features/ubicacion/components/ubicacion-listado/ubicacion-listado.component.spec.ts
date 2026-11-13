import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UbicacionListadoComponent } from './ubicacion-listado.component';

describe('UbicacionListadoComponent', () => {
  let component: UbicacionListadoComponent;
  let fixture: ComponentFixture<UbicacionListadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UbicacionListadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UbicacionListadoComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
