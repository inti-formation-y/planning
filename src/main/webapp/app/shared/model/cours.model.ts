import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';

export interface ICours {
  id?: number;
  titre?: string;
  pdfContentType?: string;
  pdf?: any;
  dateAjout?: Moment;
  users?: IUser[];
}

export class Cours implements ICours {
  constructor(
    public id?: number,
    public titre?: string,
    public pdfContentType?: string,
    public pdf?: any,
    public dateAjout?: Moment,
    public users?: IUser[]
  ) {}
}
