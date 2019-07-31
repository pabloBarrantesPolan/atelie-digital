import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfissionalUpdateComponent } from './profissional-update.component';

describe('ProfissionalUpdateComponent', () => {
  let component: ProfissionalUpdateComponent;
  let fixture: ComponentFixture<ProfissionalUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfissionalUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfissionalUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
