import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfissionalDetailComponent } from './profissional-detail.component';

describe('ProfissionalDetailComponent', () => {
  let component: ProfissionalDetailComponent;
  let fixture: ComponentFixture<ProfissionalDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfissionalDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfissionalDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
