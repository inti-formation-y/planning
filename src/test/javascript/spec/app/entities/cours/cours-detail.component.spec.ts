import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { PlanningTestModule } from '../../../test.module';
import { CoursDetailComponent } from 'app/entities/cours/cours-detail.component';
import { Cours } from 'app/shared/model/cours.model';

describe('Component Tests', () => {
  describe('Cours Management Detail Component', () => {
    let comp: CoursDetailComponent;
    let fixture: ComponentFixture<CoursDetailComponent>;
    let dataUtils: JhiDataUtils;
    const route = ({ data: of({ cours: new Cours(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [PlanningTestModule],
        declarations: [CoursDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CoursDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CoursDetailComponent);
      comp = fixture.componentInstance;
      dataUtils = fixture.debugElement.injector.get(JhiDataUtils);
    });

    describe('OnInit', () => {
      it('Should load cours on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.cours).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });

    describe('byteSize', () => {
      it('Should call byteSize from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'byteSize');
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.byteSize(fakeBase64);

        // THEN
        expect(dataUtils.byteSize).toBeCalledWith(fakeBase64);
      });
    });

    describe('openFile', () => {
      it('Should call openFile from JhiDataUtils', () => {
        // GIVEN
        spyOn(dataUtils, 'openFile');
        const fakeContentType = 'fake content type';
        const fakeBase64 = 'fake base64';

        // WHEN
        comp.openFile(fakeContentType, fakeBase64);

        // THEN
        expect(dataUtils.openFile).toBeCalledWith(fakeContentType, fakeBase64);
      });
    });
  });
});
