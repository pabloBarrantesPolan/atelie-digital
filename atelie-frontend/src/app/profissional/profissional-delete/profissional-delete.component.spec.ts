import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfissionalDeleteComponent } from './profissional-delete.component';

describe('ProfissionalDeleteComponent', () => {
  let component: ProfissionalDeleteComponent;
  let fixture: ComponentFixture<ProfissionalDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfissionalDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfissionalDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
