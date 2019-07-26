import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfissionalCreateComponent } from './profissional-create.component';

describe('ProfissionalCreateComponent', () => {
  let component: ProfissionalCreateComponent;
  let fixture: ComponentFixture<ProfissionalCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfissionalCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfissionalCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
