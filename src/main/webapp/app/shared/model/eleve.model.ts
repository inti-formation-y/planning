import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';
import { Classe } from 'app/shared/model/enumerations/classe.model';

export interface IEleve {
  id?: number;
  photoContentType?: string;
  photo?: any;
  nom?: string;
  prenom?: string;
  adresse?: string;
  email?: string;
  mobile?: string;
  dateNaissance?: Moment;
  classe?: Classe;
  user?: IUser;
}

export class Eleve implements IEleve {
  constructor(
    public id?: number,
    public photoContentType?: string,
    public photo?: any,
    public nom?: string,
    public prenom?: string,
    public adresse?: string,
    public email?: string,
    public mobile?: string,
    public dateNaissance?: Moment,
    public classe?: Classe,
    public user?: IUser
  ) {}
}
