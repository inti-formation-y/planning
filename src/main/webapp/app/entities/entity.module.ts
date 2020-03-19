import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'cours',
        loadChildren: () => import('./cours/cours.module').then(m => m.PlanningCoursModule)
      },
      {
        path: 'video',
        loadChildren: () => import('./video/video.module').then(m => m.PlanningVideoModule)
      },
      {
        path: 'eleve',
        loadChildren: () => import('./eleve/eleve.module').then(m => m.PlanningEleveModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class PlanningEntityModule {}
