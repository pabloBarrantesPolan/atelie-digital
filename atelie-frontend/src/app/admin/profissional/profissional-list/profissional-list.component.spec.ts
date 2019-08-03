import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfissionalListComponent } from './profissional-list.component';

describe('ProfissionalListComponent', () => {
  let component: ProfissionalListComponent;
  let fixture: ComponentFixture<ProfissionalListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfissionalListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfissionalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
