import { Moment } from 'moment';
import { IEleve } from 'app/shared/model/eleve.model';

export interface ICours {
  id?: number;
  titre?: string;
  dateAjout?: Moment;
  eleves?: IEleve[];
}

export class Cours implements ICours {
  constructor(public id?: number, public titre?: string, public dateAjout?: Moment, public eleves?: IEleve[]) {}
}
