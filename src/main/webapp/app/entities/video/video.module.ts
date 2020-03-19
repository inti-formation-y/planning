import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlanningSharedModule } from 'app/shared/shared.module';
import { VideoComponent } from './video.component';
import { VideoDetailComponent } from './video-detail.component';
import { VideoUpdateComponent } from './video-update.component';
import { VideoDeleteDialogComponent } from './video-delete-dialog.component';
import { videoRoute } from './video.route';

@NgModule({
  imports: [PlanningSharedModule, RouterModule.forChild(videoRoute)],
  declarations: [VideoComponent, VideoDetailComponent, VideoUpdateComponent, VideoDeleteDialogComponent],
  entryComponents: [VideoDeleteDialogComponent]
})
export class PlanningVideoModule {}
