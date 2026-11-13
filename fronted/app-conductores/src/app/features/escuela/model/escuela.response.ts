import { Ubicacion } from "../../ubicacion/model/ubicacion";

export interface EscuelaResponse {

 id: number;
  nombre: string;
  ruc: string;
  direccion: string;
  estado: string;
  ubicacion: Ubicacion;
}
