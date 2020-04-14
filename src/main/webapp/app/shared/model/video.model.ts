import { ICours } from 'app/shared/model/cours.model';

export interface IVideo {
  id?: number;
  titre?: string;
  contenuContentType?: string;
  contenu?: any;
  cours?: ICours;
}

export class Video implements IVideo {
  constructor(public id?: number, public titre?: string, public contenuContentType?: string, public contenu?: any, public cours?: ICours) {}
}
