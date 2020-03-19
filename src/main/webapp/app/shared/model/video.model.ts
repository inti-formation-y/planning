export interface IVideo {
  id?: number;
  titre?: string;
  contenuContentType?: string;
  contenu?: any;
}

export class Video implements IVideo {
  constructor(public id?: number, public titre?: string, public contenuContentType?: string, public contenu?: any) {}
}
